package interview.service;

import interview.entity.User;

public interface UserService {

    User saveUser(User user);

    User getUserById(Integer id);

    User getUserByUsername(String username);

}
