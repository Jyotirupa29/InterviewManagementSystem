package interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import interview.entity.Candidate;
import interview.entity.User;
import interview.enums.Role;
import interview.service.CandidateService;
import interview.service.UserService;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private CandidateService candidateService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("candidate", new Candidate());
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("candidate") Candidate candidate,
                           BindingResult result,
                           @RequestParam String username,
                           @RequestParam String password,
                           Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        User user = new User();

        user.setUsername(username);
        user.setRole(Role.CANDIDATE);
        user.setPassword(passwordEncoder.encode(password));

        userService.saveUser(user);

        candidate.setUser(user);

        candidateService.saveCandidate(candidate);

        return "redirect:/login";
    }

}
