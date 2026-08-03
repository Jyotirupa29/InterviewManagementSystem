package interview.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interview.entity.Interview;
import interview.enums.InterviewStatus;
import interview.repository.InterviewRepository;
import interview.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public Interview updateInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public void deleteInterview(Integer id) {
        interviewRepository.deleteById(id);
    }

    @Override
    public Interview getInterviewById(Integer id) {
        return interviewRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Interview> getInterviewByCandidateId(Integer id) {

        return interviewRepository.findByCandidateId(id);

    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }
    
    @Override
    public void updateStatus(Interview interview) {

        Interview oldInterview = interviewRepository.findById(interview.getId())
                .orElseThrow(() -> new RuntimeException("Interview not found"));

        oldInterview.setStatus(interview.getStatus());

        interviewRepository.save(oldInterview);
    }
}