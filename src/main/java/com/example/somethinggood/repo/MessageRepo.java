package com.example.somethinggood.repo;

import com.example.somethinggood.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  MessageRepo extends JpaRepository<Message, Long> {
}
