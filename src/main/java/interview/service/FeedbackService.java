package interview.service;

import java.util.List;

import interview.entity.Feedback;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);

    Feedback updateFeedback(Feedback feedback);

    void deleteFeedback(Integer id);

    Feedback getFeedbackById(Integer id);

    List<Feedback> getAllFeedback();

}
