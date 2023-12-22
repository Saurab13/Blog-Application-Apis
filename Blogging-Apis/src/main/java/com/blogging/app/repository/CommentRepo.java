package com.blogging.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.app.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
