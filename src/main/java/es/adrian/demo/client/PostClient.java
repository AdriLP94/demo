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

import es.adrian.demo.model.Post;

@FeignClient(name="posts", url = "https://jsonplaceholder.typicode.com")
public interface PostClient {

	@GetMapping("/posts")
	public List<Post> getAll();
	
	@GetMapping("/posts/{id}")
	public Post getById(@PathVariable Integer id);
	
	@GetMapping("/posts")
	public List<Post> getByCriteria(@RequestParam(required = false) Integer id, 
			@RequestParam(required = false) Integer userId, 
			@RequestParam(required = false) String title, 
			@RequestParam(required = false) String body);
	
	@PostMapping("/posts")
	public Post addPost(@RequestBody Post post);
	
	@PutMapping("/posts/{id}")
	public Post updatePost(@PathVariable Integer id, @RequestBody Post post);
	
	@DeleteMapping("/posts/{id}")
	public Post deletePost(@PathVariable Integer id);
}
