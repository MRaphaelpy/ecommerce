package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.DTOs.UserDTO;
import com.mraphaelpy.ecommerce.Entities.User;
import com.mraphaelpy.ecommerce.Mappers.UserMapper;
import com.mraphaelpy.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public UserDTO getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return userMapper.toDTO(user);
        }
        return null;
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .toList();
    }

    public UserDTO store(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public void updatePassword(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null ? userMapper.toDTO(user) : null;
    }
}
