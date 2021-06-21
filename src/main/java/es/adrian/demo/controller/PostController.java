package es.adrian.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.adrian.demo.model.Post;
import es.adrian.demo.service.PostService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/posts/{id}")
	public Post getById(@PathVariable Integer id) {
		return postService.getById(id);
	}
	
	@GetMapping("/posts")
	public List<Post> getByCriteria(@RequestParam(required = false) Integer id, 
			@RequestParam(required = false) Integer userId, 
			@RequestParam(required = false) String title, 
			@RequestParam(required = false) String body) {
		return postService.getByCriteria(id, userId, title, body);
	}
	
	@PostMapping("/posts")
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable Integer id, @RequestBody Post post) {
		return postService.updatePost(id, post);
	}
	
}
