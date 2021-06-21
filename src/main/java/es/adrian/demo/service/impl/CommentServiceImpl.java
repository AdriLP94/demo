package es.adrian.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.adrian.demo.client.CommentClient;
import es.adrian.demo.model.Comment;
import es.adrian.demo.service.CommentService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentClient commentClient;
	
	@Override
	public List<Comment> getAll() {
		return commentClient.getAll();
	}

	@Override
	public Comment getById(Integer id) {
		return commentClient.getById(id);
	}

	@Override
	public List<Comment> getByPostId(Integer postId) {
		return commentClient.getByPostId(postId);
	}
	
	@Override
	public List<Comment> getByCriteria(Integer id, Integer postId, String name, String email, String body) {
		return commentClient.getByCriteria(id, postId, body, email, body);
	}

	@Override
	public Comment addComment(Comment comment) {
		return commentClient.addComment(comment);
	}

	@Override
	public Comment updateComment(Integer id, Comment comment) {
		return commentClient.updateComment(id, comment);
	}

	@Override
	public void deleteComment(Integer id) {
		commentClient.deleteComment(id);
	}

}
