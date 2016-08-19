package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.core.User;

public interface UserRepository extends JpaRepository<User, String> {
}
