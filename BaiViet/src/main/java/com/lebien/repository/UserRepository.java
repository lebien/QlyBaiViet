package com.lebien.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lebien.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	UserEntity findByUsername(String username);
}
