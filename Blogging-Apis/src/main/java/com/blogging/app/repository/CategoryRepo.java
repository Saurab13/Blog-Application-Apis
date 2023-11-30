package com.blogging.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.app.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
