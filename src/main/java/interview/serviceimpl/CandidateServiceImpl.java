package interview.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import interview.entity.Candidate;
import interview.repository.CandidateRepository;
import interview.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public void deleteCandidate(Integer id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public Candidate getCandidateById(Integer id) {
        return candidateRepository.findById(id).orElse(null);
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
    
    @Override
    public Candidate getCandidateByUsername(String username) {

        return candidateRepository
                .findByUserUsername(username)
                .orElse(null);
    }
}