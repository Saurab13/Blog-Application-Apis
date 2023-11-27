package com.blogging.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.app.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
