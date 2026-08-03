package interview.service;

import java.util.List;

import interview.entity.Candidate;

public interface CandidateService {

    Candidate saveCandidate(Candidate candidate);

    Candidate updateCandidate(Candidate candidate);

    void deleteCandidate(Integer id);

    Candidate getCandidateById(Integer id);

    List<Candidate> getAllCandidates();
    
    Candidate getCandidateByUsername(String username);

}
