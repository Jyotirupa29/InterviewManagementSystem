package interview.service;

import java.util.List;

import interview.entity.Interview;
import interview.enums.InterviewStatus;

public interface InterviewService {

    Interview scheduleInterview(Interview interview);

    Interview updateInterview(Interview interview);

    void deleteInterview(Integer id);

    Interview getInterviewById(Integer id);
    
    List<Interview> getInterviewByCandidateId(Integer id);

    List<Interview> getAllInterviews();
    
    void updateStatus(Interview interview);
    

}