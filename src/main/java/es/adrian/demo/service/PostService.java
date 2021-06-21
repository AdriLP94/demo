package es.adrian.demo.service;

import java.util.List;

import es.adrian.demo.model.Post;

public interface PostService {
	public List<Post> getAll();
	public Post getById(Integer id);
	public List<Post> getByCriteria(Integer id, Integer userId, String title, String body);
	public Post addPost(Post post);
	public Post updatePost(Integer id, Post post);
	public Post deletePost( Integer id);
}
