package com.mraphaelpy.ecommerce.Repository;

import com.mraphaelpy.ecommerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User deleteByEmail(String email);
    Optional<User> findById(Long id);
    User findByEmailAndPassword(String email, String password);
}
