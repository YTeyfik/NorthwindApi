package com.example.northwind.corre.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.northwind.corre.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}
