package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {

}
