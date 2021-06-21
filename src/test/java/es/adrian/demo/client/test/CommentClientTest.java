package es.adrian.demo.client.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.adrian.demo.client.CommentClient;
import es.adrian.demo.model.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentClientTest {

	@Autowired
	private CommentClient commentClient;
	
	@Test
	public void getAll_test() {
		List<Comment> comments = commentClient.getAll();
		Assert.assertNotNull(comments);
		Assert.assertFalse(comments.isEmpty());
	}
	
	@Test
	public void getById_test() {
		Comment comment = commentClient.getById(1);
		Assert.assertNotNull(comment);
	}
	
	@Test
	public void getByCriteria_test() {
		
		List<Comment> comments = commentClient.getByCriteria(1,null,null,null, null);
		Assert.assertNotNull(comments);
		Assert.assertFalse(comments.isEmpty());
		
		comments = commentClient.getByCriteria(null,1,null,null, null);
		Assert.assertNotNull(comments);
		Assert.assertFalse(comments.isEmpty());
	}
	
	@Test
	public void addComment_test() {
		
		Comment comment = new Comment();
		comment.setPostId(1);
		comment.setName("foo");
		comment.setEmail("foo@bar");
		comment.setBody("bar");
		
		Comment newComment = commentClient.addComment(comment);
		
		Assert.assertNotNull(newComment);
		Assert.assertNotNull(newComment.getId());
		Assert.assertEquals(newComment.getPostId(), comment.getPostId());
		Assert.assertEquals(newComment.getName(), comment.getName());
		Assert.assertEquals(newComment.getEmail(), comment.getEmail());
		Assert.assertEquals(newComment.getBody(), comment.getBody());
	}
	
	@Test
	public void updateComment_test() {
		
		Comment comment = new Comment();
		comment.setId(1);
		comment.setPostId(1);
		comment.setName("foo");
		comment.setEmail("foo@bar");
		comment.setBody("bar");
		
		Comment newComment = commentClient.updateComment(comment.getId(), comment);
		
		Assert.assertNotNull(newComment);
		Assert.assertEquals(newComment.getId(), comment.getId());
		Assert.assertEquals(newComment.getPostId(), comment.getPostId());
		Assert.assertEquals(newComment.getName(), comment.getName());
		Assert.assertEquals(newComment.getEmail(), comment.getEmail());
		Assert.assertEquals(newComment.getBody(), comment.getBody());
	}
}
