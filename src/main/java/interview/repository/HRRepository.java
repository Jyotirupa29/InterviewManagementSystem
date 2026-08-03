package interview.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import interview.entity.HR;

public interface HRRepository extends JpaRepository<HR, Integer> {

    Optional<HR> findByEmail(String email);
    
    Optional<HR> findByUserUsername(String username);

}
