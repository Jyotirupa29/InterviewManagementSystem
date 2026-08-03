package interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import interview.entity.Feedback;
import interview.service.FeedbackService;
import interview.service.InterviewService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private InterviewService interviewService;

    // Display all feedback
    @GetMapping("/list")
    public String feedbackList(Model model) {

        model.addAttribute("feedbackList",
                feedbackService.getAllFeedback());

        return "hr/feedback-list";
    }

    // Open Add Feedback Form
    @GetMapping("/add/{interviewId}")
    public String addFeedback(@PathVariable Integer interviewId,
                              Model model) {

        Feedback feedback = new Feedback();

        feedback.setInterview(
                interviewService.getInterviewById(interviewId));

        model.addAttribute("feedback", feedback);

        return "hr/feedback-form";
    }

    // Save Feedback
//    @PostMapping("/save")
//    public String saveFeedback(@ModelAttribute Feedback feedback) {
//
//        feedbackService.saveFeedback(feedback);
//
//        return "redirect:/feedback/list";
//    }
    
    @PostMapping("/save")
    public String saveFeedback(@Valid @ModelAttribute("feedback") Feedback feedback,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) {
            return "hr/feedback-form";
        }

        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback/list";
    }

    // Edit Feedback
    @GetMapping("/edit/{id}")
    public String editFeedback(@PathVariable Integer id,
                               Model model) {

        model.addAttribute("feedback",
                feedbackService.getFeedbackById(id));

        return "hr/feedback-form";
    }

    // Update Feedback
    @PostMapping("/update")
    public String updateFeedback(@ModelAttribute Feedback feedback) {

        feedbackService.updateFeedback(feedback);

        return "redirect:/feedback/list";
    }

    // Delete Feedback
    @GetMapping("/delete/{id}")
    public String deleteFeedback(@PathVariable Integer id) {

        feedbackService.deleteFeedback(id);

        return "redirect:/feedback/list";
    }

}
