package com.vti.examwebsise.examonline.service;


import com.vti.examwebsise.examonline.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepo extends JpaRepository<Topic,Integer> {
}
