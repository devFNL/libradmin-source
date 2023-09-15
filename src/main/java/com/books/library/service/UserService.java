package com.books.library.service;

import com.books.library.entity.User;
import com.books.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User editUserById(long id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found."));

        existingUser.setUser_name(user.getUser_name());
        existingUser.setUser_last(user.getUser_last());
        existingUser.setPhone(user.getPhone());
        existingUser.setEmail(user.getEmail());
        existingUser.setPass(user.getPass());
        existingUser.setIs_active(user.isIs_active());

        return userRepository.save(existingUser);
    }

    public void deleteUserById(long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found."));

        userRepository.delete(existingUser);
    }

}
