package interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}