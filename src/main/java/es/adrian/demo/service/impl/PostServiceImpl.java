package es.adrian.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.adrian.demo.client.PostClient;
import es.adrian.demo.model.Post;
import es.adrian.demo.service.PostService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

	@Autowired
	private PostClient postClient;
	
	@Override
	public List<Post> getAll() {
		return postClient.getAll();
	}

	@Override
	public Post getById(Integer id) {
		return postClient.getById(id);
	}

	@Override
	public List<Post> getByCriteria(Integer id, Integer userId, String title, String body) {
		return postClient.getByCriteria(id, userId, title, body);
	}

	@Override
	public Post addPost(Post post) {
		return postClient.addPost(post);
	}

	@Override
	public Post updatePost(Integer id, Post post) {
		return postClient.updatePost(id, post);
	}

	@Override
	public Post deletePost(Integer id) {
		return postClient.deletePost(id);
	}

}
