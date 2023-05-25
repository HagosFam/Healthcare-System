package com.healthcare.identitymanagement.repository;

import com.healthcare.identitymanagement.domain.Role;
import com.healthcare.identitymanagement.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);
}
