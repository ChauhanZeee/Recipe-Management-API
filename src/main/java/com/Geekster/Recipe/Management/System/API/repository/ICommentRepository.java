package com.Geekster.Recipe.Management.System.API.repository;

import com.Geekster.Recipe.Management.System.API.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
