package interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import interview.entity.HR;
import interview.service.HRService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private HRService hrService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/hrList")
    public String hrList(Model model) {

        model.addAttribute("hrList",
                hrService.getAllHR());

        return "admin/hr-list";
    }

    @GetMapping("/addHR")
    public String addHR(Model model) {

        model.addAttribute("hr", new HR());

        return "admin/hr-form";
    }

    @PostMapping("/saveHR")
    public String saveHR(@Valid @ModelAttribute("hr") HR hr,
                         BindingResult result,
                         @RequestParam String username,
                         @RequestParam String password) {

        if (result.hasErrors()) {
            return "admin/hr-form";
        }

        hrService.saveHR(hr, username, password);

        return "redirect:/admin/hrList";
    }

    @GetMapping("/editHR/{id}")
    public String editHR(@PathVariable Integer id, Model model) {

        model.addAttribute("hr", hrService.getHRById(id));

        return "admin/hr-form";
    }
    
    @GetMapping("/deleteHR/{id}")
    public String deleteHR(@PathVariable Integer id) {

        hrService.deleteHR(id);

        return "redirect:/admin/hrList";
    }
}
