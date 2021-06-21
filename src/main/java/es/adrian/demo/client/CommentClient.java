package es.adrian.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import es.adrian.demo.model.Comment;

@FeignClient(name="comments", url = "https://jsonplaceholder.typicode.com")
public interface CommentClient {

	@GetMapping("/comments")
	public List<Comment> getAll();
	
	@GetMapping("/comments/{id}")
	public Comment getById(@PathVariable Integer id);
	
	@GetMapping("/posts/{postId}/comments")
	public List<Comment> getByPostId(@PathVariable Integer postId);

	@GetMapping("/comments")
	public List<Comment> getByCriteria(@RequestParam(required = false) Integer id, 
			@RequestParam(required = false) Integer postId, 
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String email, 
			@RequestParam(required = false) String body);
	
	@PostMapping("/comments")
	public Comment addComment(@RequestBody Comment comments);
	
	@PutMapping("/comments/{id}")
	public Comment updateComment(@PathVariable Integer id, @RequestBody Comment comments);
	
	@DeleteMapping("/comments/{id}")
	public Comment deleteComment(@PathVariable Integer id); 
}
