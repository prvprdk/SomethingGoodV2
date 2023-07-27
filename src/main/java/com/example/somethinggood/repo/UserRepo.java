package com.example.somethinggood.repo;

import com.example.somethinggood.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserRepo extends JpaRepository <User, String> {

}
