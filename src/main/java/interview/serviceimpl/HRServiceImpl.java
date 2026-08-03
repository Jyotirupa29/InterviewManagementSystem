package interview.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import interview.entity.HR;
import interview.entity.User;
import interview.enums.Role;
import interview.repository.HRRepository;
import interview.repository.UserRepository;
import interview.service.HRService;

@Service
public class HRServiceImpl implements HRService {

    @Autowired
    private HRRepository hrRepository;

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveHR(HR hr, String username, String password) {
    	
    	if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.HR);

        userRepository.save(user);

        hr.setUser(user);

        hrRepository.save(hr);
    }
    

    @Override
    public HR updateHR(HR hr) {
        return hrRepository.save(hr);
    }

    @Override
    public void deleteHR(Integer id) {
        hrRepository.deleteById(id);
    }

    @Override
    public HR getHRById(Integer id) {
        return hrRepository.findById(id).orElse(null);
    }

    @Override
    public List<HR> getAllHR() {
        return hrRepository.findAll();
    }
}
