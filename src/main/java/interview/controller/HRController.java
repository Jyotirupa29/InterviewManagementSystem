//package interview.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import interview.entity.Candidate;
//import interview.entity.Interview;
//import interview.enums.InterviewStatus;
//import interview.service.CandidateService;
//import interview.service.InterviewService;
//
//@Controller
//@RequestMapping("/hr")
//public class HRController {
//
//    @Autowired
//    private CandidateService candidateService;
//    
//    @Autowired
//    private InterviewService interviewService;
//
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "hr/dashboard";
//    }
//
//    @GetMapping("/candidates")
//    public String candidateList(Model model) {
//
//        model.addAttribute("candidateList",
//                candidateService.getAllCandidates());
//
//        return "hr/candidate-list";
//    }
//
//    @GetMapping("/addCandidate")
//    public String addCandidate(Model model) {
//
//        model.addAttribute("candidate", new Candidate());
//
//        return "hr/candidate-form";
//    }
//
//    @PostMapping("/saveCandidate")
//    public String saveCandidate(@ModelAttribute Candidate candidate) {
//
//        candidateService.saveCandidate(candidate);
//
//        return "redirect:/hr/candidates";
//    }
//    
//    @GetMapping("/editCandidate/{id}")
//    public String editCandidate(@PathVariable Integer id, Model model) {
//
//        model.addAttribute("candidate",
//                candidateService.getCandidateById(id));
//
//        return "hr/candidate-form";
//    }
//    
//    @GetMapping("/deleteCandidate/{id}")
//    public String deleteCandidate(@PathVariable Integer id) {
//
//        candidateService.deleteCandidate(id);
//
//        return "redirect:/hr/candidates";
//    }
//    
//    @GetMapping("/interview/status/{id}")
//    public String interviewStatus(@PathVariable Integer id,
//                                  Model model) {
//
//        model.addAttribute("interview",
//                interviewService.getInterviewById(id));
//
//        model.addAttribute("statuses",
//                java.util.List.of(
//                        InterviewStatus.SELECTED,
//                        InterviewStatus.REJECTED,
//                        InterviewStatus.ON_HOLD));
//
//        return "hr/status-form";
//    }
//
//    @PostMapping("/interview/updateStatus")
//    public String updateStatus(@ModelAttribute Interview interview) {
//
//        interviewService.updateStatus(interview);
//
//        return "redirect:/hr/interviews";
//    }
//}



package interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import interview.entity.Candidate;
import interview.entity.Interview;
import interview.enums.InterviewStatus;
import interview.service.CandidateService;
import interview.service.InterviewService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/hr")
public class HRController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/dashboard")
    public String dashboard() {
        return "hr/dashboard";
    }

    @GetMapping("/candidates")
    public String candidateList(Model model) {

        model.addAttribute("candidateList",
                candidateService.getAllCandidates());

        return "hr/candidate-list";
    }

    @GetMapping("/addCandidate")
    public String addCandidate(Model model) {

        model.addAttribute("candidate", new Candidate());

        return "hr/candidate-form";
    }

    @PostMapping("/saveCandidate")
    public String saveCandidate(@Valid @ModelAttribute Candidate candidate,
                                BindingResult result) {

        if (result.hasErrors()) {
            return "hr/candidate-form";
        }

        candidateService.saveCandidate(candidate);

        return "redirect:/hr/candidates";
    }

    @GetMapping("/editCandidate/{id}")
    public String editCandidate(@PathVariable Integer id, Model model) {

        model.addAttribute("candidate",
                candidateService.getCandidateById(id));

        return "hr/candidate-form";
    }

    @GetMapping("/deleteCandidate/{id}")
    public String deleteCandidate(@PathVariable Integer id) {

        candidateService.deleteCandidate(id);

        return "redirect:/hr/candidates";
    }

    @GetMapping("/interview/status/{id}")
    public String interviewStatus(@PathVariable Integer id,
                                  Model model) {

        model.addAttribute("interview",
                interviewService.getInterviewById(id));

        model.addAttribute("statuses",
                java.util.List.of(
                        InterviewStatus.SELECTED,
                        InterviewStatus.REJECTED,
                        InterviewStatus.ON_HOLD));

        return "hr/status-form";
    }

    @PostMapping("/interview/updateStatus")
    public String updateStatus(@ModelAttribute Interview interview) {

        interviewService.updateStatus(interview);

        return "redirect:/interview/list";
    }
}
