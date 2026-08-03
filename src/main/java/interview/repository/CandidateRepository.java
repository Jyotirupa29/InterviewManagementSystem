package interview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Optional<Candidate> findByEmail(String email);
    
    Optional<Candidate> findByUserUsername(String username);

}