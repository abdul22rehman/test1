package com.pankaj.pr2.repository;

import com.pankaj.pr2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}