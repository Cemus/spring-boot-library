package com.kev.springrest.service.user;

import com.kev.springrest.model.User;
import com.kev.springrest.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final long id){
        return Optional.of(userRepository.findById(id).orElse(new User()));
    }

    public Iterable<User> getAllUsers() {
        if (userRepository.count() == 0) {
            return null;
        }
        return userRepository.findAll();
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public User updateUser(final User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()){
            return userRepository.save(user);
        }
        return user;
    }

    public boolean deleteUser(final long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
