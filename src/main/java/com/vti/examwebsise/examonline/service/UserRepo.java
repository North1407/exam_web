package com.vti.examwebsise.examonline.service;

import com.vti.examwebsise.examonline.entity.Answer;
import com.vti.examwebsise.examonline.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
