package es.adrian.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.adrian.demo.model.Comment;
import es.adrian.demo.service.CommentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/comments/{id}")
	public Comment getById(@PathVariable Integer id) {
		return commentService.getById(id);
	}
	
	@GetMapping("/comments")
	public List<Comment> getByCriteria(@RequestParam(required = false) Integer id, 
			@RequestParam(required = false) Integer postId, 
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String email, 
			@RequestParam(required = false) String body) {
		return commentService.getByCriteria(id, postId, name, email, body);
	}
	
	@PostMapping("/comments")
	public Comment addPost(@RequestBody Comment comment) {
		return commentService.addComment(comment);
	}
	
	@PutMapping("/comments/{id}")
	public Comment updatePost(@PathVariable Integer id, @RequestBody Comment comment) {
		return commentService.updateComment(id, comment);
	}
	
	@DeleteMapping("/comments/{id}")
	public Comment DeletePost(@PathVariable Integer id) {
		return commentService.deleteComment(id);
	}
	
}
