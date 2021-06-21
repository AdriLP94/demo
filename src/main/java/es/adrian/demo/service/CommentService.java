package es.adrian.demo.service;

import java.util.List;

import es.adrian.demo.model.Comment;

public interface CommentService {
	public List<Comment> getAll();
	public Comment getById(Integer id);
	public List<Comment> getByPostId(Integer postId);
	public List<Comment> getByCriteria(Integer id, Integer postId, String name, String email, String body);
	public Comment addComment(Comment comment);
	public Comment updateComment(Integer id, Comment comment);
	public Comment deleteComment(Integer id);
}
