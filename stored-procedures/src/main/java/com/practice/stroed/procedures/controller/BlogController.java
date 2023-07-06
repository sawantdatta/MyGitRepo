package com.practice.stroed.procedures.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.stroed.procedures.entity.Blog;
import com.practice.stroed.procedures.repo.BlogRespository;
import com.practice.stroed.procedures.service.BlogService;

@RestController
@RequestMapping("/api/v1")
public class BlogController {
	@Autowired
	BlogRespository blogRespository;
	
	@Autowired
	BlogService blogService;
	

	@GetMapping("/blog")
	public List<Blog> index() {
		return blogRespository.findAll();
	}

	@GetMapping("/blog/{id}")
	public Optional<Blog> show(@PathVariable String id) {
		int blogId = Integer.parseInt(id);
		return blogRespository.findById(blogId);
	}

	@PostMapping("/blog/search")
	public List<Blog> search(@RequestBody Map<String, String> body) {
		String searchTerm = body.get("text");
		return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
	}

	@PostMapping("/blog")
	public Blog create(@RequestBody Map<String, String> body) {
		String title = body.get("title");
		String content = body.get("content");
		return blogRespository.save(new Blog(title, content));
	}

	@PutMapping("/blog/{id}")
	public Blog update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int blogId = Integer.parseInt(id);
		// getting blog
		Optional<Blog> blog = blogRespository.findById(blogId);
		blog.get().setTitle(body.get("title"));
		blog.get().setContent(body.get("content"));
		return blogRespository.save(blog.get());
	}

	@DeleteMapping("blog/{id}")
	public boolean delete(@PathVariable String id) {
		int blogId = Integer.parseInt(id);
		blogRespository.deleteById(blogId);
		return true;
	}

	@GetMapping(path = "/getTitileByIdEntiy/{id}")
	public List<String> getTitileByIdEntiy(@RequestParam("id") Integer id) {
		return blogService.getTitileByIdEntiy(id);
	}

}