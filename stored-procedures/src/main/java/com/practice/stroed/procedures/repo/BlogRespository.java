package com.practice.stroed.procedures.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.practice.stroed.procedures.entity.Blog;

public interface BlogRespository extends JpaRepository<Blog, Integer> {

	// custom query to search to blog post by title or content
	List<Blog> findByTitleContainingOrContentContaining(String text, String textAgain);

	@Procedure(name = "Blog.getTitleById")
	List<String> getTitileByIdEntiy(@Param("id") int id);
}
