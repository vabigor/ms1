package com.example.ms1.dao.repository;

import com.example.ms1.dao.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
