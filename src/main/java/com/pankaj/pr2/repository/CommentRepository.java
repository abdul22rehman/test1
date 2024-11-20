package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  }