package interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {

    List<Interview> findByCandidateId(Integer candidateId);

    List<Interview> findByHrId(Integer hrId);
    

}
