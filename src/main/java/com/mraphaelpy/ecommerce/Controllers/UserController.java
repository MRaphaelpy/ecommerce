package com.mraphaelpy.ecommerce.Controllers;

import com.mraphaelpy.ecommerce.DTOs.UserDTO;
import com.mraphaelpy.ecommerce.Entities.User;
import com.mraphaelpy.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO userDTO = userService.store(user);
        return ResponseEntity.status(201).body(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody User user) {
        UserDTO userDTO = userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
        if (userDTO != null) {
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteByEmail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userService.getUserByEmail(email);
        return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userDTOs = userService.getAll();
        return ResponseEntity.ok(userDTOs);
    }

    @PatchMapping("/update-password/{email}")
    public ResponseEntity<Void> updatePassword(@PathVariable String email, @RequestParam String password) {
        userService.updatePassword(email, password);
        return ResponseEntity.ok().build();
    }
}
