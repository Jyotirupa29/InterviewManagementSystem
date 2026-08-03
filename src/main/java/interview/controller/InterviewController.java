package interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import interview.entity.Interview;
import interview.service.CandidateService;
import interview.service.HRService;
import interview.service.InterviewService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;
    
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private HRService hrService;

    @GetMapping("/list")
    public String interviewList(Model model) {

        model.addAttribute("interviews",
                interviewService.getAllInterviews());

        return "hr/interview-list";
    }

//    @PostMapping("/save")
//    public String saveInterview(@ModelAttribute Interview interview) {
//
//        interviewService.scheduleInterview(interview);
//
//        return "redirect:/interview/list";
//    }
    
    @PostMapping("/save")
    public String saveInterview(@Valid @ModelAttribute("interview") Interview interview,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("candidateList", candidateService.getAllCandidates());
            model.addAttribute("hrList", hrService.getAllHR());
            return "hr/schedule-interview";
        }

        interviewService.scheduleInterview(interview);
        return "redirect:/interview/list";
    }
    
    @GetMapping("/schedule")
    public String scheduleInterview(Model model) {

        model.addAttribute("interview", new Interview());

        model.addAttribute("candidateList",
                candidateService.getAllCandidates());

        model.addAttribute("hrList",
                hrService.getAllHR());

        return "hr/schedule-interview";
    }
    
    
    @GetMapping("/schedule/{id}")
    public String scheduleInterview(@PathVariable Integer id, Model model) {

        Interview interview = new Interview();

        // Automatically select the clicked candidate
        interview.setCandidate(candidateService.getCandidateById(id));

        model.addAttribute("interview", interview);
        model.addAttribute("candidateList", candidateService.getAllCandidates());
        model.addAttribute("hrList", hrService.getAllHR());

        return "hr/schedule-interview";
    }
    
    
    @GetMapping("/edit/{id}")
    public String editInterview(@PathVariable Integer id, Model model) {

        model.addAttribute("interview",
                interviewService.getInterviewById(id));

        model.addAttribute("candidateList",
                candidateService.getAllCandidates());

        model.addAttribute("hrList",
                hrService.getAllHR());

        return "hr/schedule-interview";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteInterview(@PathVariable Integer id) {

        interviewService.deleteInterview(id);

        return "redirect:/interview/list";
    }
    
    @GetMapping("/updateStatus/{id}")
    public String updateStatusPage(@PathVariable Integer id, Model model) {

        model.addAttribute("interview",
                interviewService.getInterviewById(id));

        model.addAttribute("statuses",
                interview.enums.InterviewStatus.values());

        return "hr/update-status";
    }

    @PostMapping("/updateStatus")
    public String updateStatus(@ModelAttribute Interview interview) {

        interviewService.updateStatus(interview);

        return "redirect:/interview/list";
    }
}
