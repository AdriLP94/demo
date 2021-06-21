package es.adrian.demo.client.test;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.adrian.demo.client.PostClient;
import es.adrian.demo.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostClientTest {
 
	@Autowired
	private PostClient postClient;
	
	@Test
	public void getAll_test() {
		List<Post> posts = postClient.getAll();
		Assert.assertNotNull(posts);
		Assert.assertFalse(posts.isEmpty());
	}
	
	@Test
	public void getById_test() {
		Post posts = postClient.getById(1);
		Assert.assertNotNull(posts);
	}
	
	@Test
	public void getByCriteria_test() {
		
		List<Post> posts = postClient.getByCriteria(1,null,null,null);
		Assert.assertNotNull(posts);
		Assert.assertFalse(posts.isEmpty());
		
		posts = postClient.getByCriteria(null,1,null,null);
		Assert.assertNotNull(posts);
		Assert.assertFalse(posts.isEmpty());
	}
	
	@Test
	public void addPost_test() {
		
		Post post = new Post();
		post.setUserId(1);
		post.setTitle("foo");
		post.setBody("bar");
		
		Post newPost = postClient.addPost(post);
		
		Assert.assertNotNull(newPost);
		Assert.assertNotNull(newPost.getId());
		Assert.assertEquals(newPost.getUserId(), post.getUserId());
		Assert.assertEquals(newPost.getTitle(), post.getTitle());
		Assert.assertEquals(newPost.getBody(), post.getBody());
	}
	
	@Test
	public void updatePost_test() {
		
		Post post = new Post();
		post.setId(1);
		post.setUserId(1);
		post.setTitle("foo");
		post.setBody("bar");
		
		Post newPost = postClient.updatePost(post.getId(), post);
		
		Assert.assertNotNull(newPost);
		Assert.assertEquals(newPost.getId(), post.getId());
		Assert.assertEquals(newPost.getUserId(), post.getUserId());
		Assert.assertEquals(newPost.getTitle(), post.getTitle());
		Assert.assertEquals(newPost.getBody(), post.getBody());
	}
	
 
}
