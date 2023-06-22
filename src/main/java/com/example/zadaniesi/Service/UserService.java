
package com.example.zadaniesi.Service;
import com.example.zadaniesi.model.User;
import com.example.zadaniesi.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByLogin(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateUserEmail(String username, String newEmail) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            user.setEmail(newEmail);
            return userRepository.save(user);
        }
        return null;
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}