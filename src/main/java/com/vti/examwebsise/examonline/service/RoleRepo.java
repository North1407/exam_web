package com.vti.examwebsise.examonline.service;

import com.vti.examwebsise.examonline.entity.Answer;
import com.vti.examwebsise.examonline.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Integer> {
}
