package interview.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import interview.entity.Candidate;
import interview.service.CandidateService;
import interview.util.FileUploadUtil;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/upload/{id}")
    public String uploadResume(@PathVariable Integer id,
                               @RequestParam("file") MultipartFile file)
            throws IOException {

        String fileName = FileUploadUtil.uploadFile(file);

        Candidate candidate = candidateService.getCandidateById(id);

        candidate.setResumePath(fileName);

        candidateService.updateCandidate(candidate);

        return "redirect:/candidate/profile";
    }

}
