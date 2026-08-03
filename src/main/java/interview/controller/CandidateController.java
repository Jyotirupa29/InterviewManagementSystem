package interview.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import interview.entity.Candidate;
import interview.entity.Interview;
import interview.service.CandidateService;
import interview.service.InterviewService;

@Controller
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        Candidate candidate =
                candidateService.getCandidateByUsername(principal.getName());

        model.addAttribute("candidate", candidate);

        return "candidate/dashboard";
    }

    @GetMapping("/profile")
    public String profile(Model model, Principal principal) {

    	    System.out.println("Username = " + principal.getName());

        Candidate candidate =
                candidateService.getCandidateByUsername(principal.getName());

        System.out.println("Candidate = " + candidate);

        if (candidate == null) {
            System.out.println("Candidate not found!");
        }
        
        model.addAttribute("candidate", candidate);

        return "candidate/profile";
    }

    @PostMapping("/update")
    public String updateCandidate(@ModelAttribute Candidate candidate) {

        candidateService.updateCandidate(candidate);

        return "redirect:/candidate/dashboard";
    }

    @GetMapping("/uploadResume")
    public String uploadResume(Model model, Principal principal) {

        Candidate candidate =
                candidateService.getCandidateByUsername(principal.getName());

        model.addAttribute("candidate", candidate);

        return "candidate/upload-resume";
    }

    @GetMapping("/interviewStatus")
    public String interviewStatus(Model model, Principal principal) {

        Candidate candidate =
                candidateService.getCandidateByUsername(principal.getName());

        List<Interview> interviews =
                interviewService.getInterviewByCandidateId(candidate.getId());

        model.addAttribute("candidate", candidate);
        model.addAttribute("interviews", interviews);

        return "candidate/interview-status";
    }
}
