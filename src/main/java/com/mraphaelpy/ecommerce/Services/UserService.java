package com.mraphaelpy.ecommerce.Services;

import com.mraphaelpy.ecommerce.Entites.User;
import com.mraphaelpy.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public java.util.List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User store(User user) {
        userRepository.save(user);
        return user;
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

   public void updatePassword(Long id, String password) {
       User user = userRepository.findById(id).orElse(null);
       if (user != null) {
           user.setPassword(password);
           userRepository.save(user);
       }
   }

   public void updateEmail(Long id, String email) {
       User user = userRepository.findById(id).orElse(null);
       if (user != null) {
           user.setEmail(email);
           userRepository.save(user);
       }
   }
}
