package es.adrian.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.adrian.demo.model.Comment;
import es.adrian.demo.model.Post;
import es.adrian.demo.model.Publication;
import es.adrian.demo.service.CommentService;
import es.adrian.demo.service.PostService;
import es.adrian.demo.service.PublicationService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService{
	
	@Autowired
	private final PostService postService;

	@Autowired
	private final CommentService commentService;
	
	@Override
	public List<Publication> getAll() {
		List<Publication> publications = new ArrayList<Publication>();
		
		List<Post> posts = postService.getAll();
		for (Post post: posts) {

			List<Comment> comments = commentService.getByPostId(post.getId());
			
			Publication publication = new Publication();
			publication.setPost(post);
			publication.setComments(comments);
			publications.add(publication);
		}
		
		return publications;
	}
	
	@Override
	public Publication getPublicationByPostId(Integer id) {
		
		Publication publication = new Publication();
		
		Post post = postService.getById(id);
		List<Comment> comments = commentService.getByPostId(id);
		
		publication.setPost(post);
		publication.setComments(comments);
		
		return publication;
	}

	@Override
	public Publication addPublication(Publication publication) {
		postService.addPost(publication.getPost());
		for (Comment comment : publication.getComments()) {
			commentService.addComment(comment);
		}
		return publication;
	}

	@Override
	public Publication updatePublicationByPostId(Integer id, Publication publication) {
		
		for (Comment comment : publication.getComments()) {
			commentService.updateComment(comment.getId(), comment);
		}
		postService.updatePost(publication.getPost().getId(), publication.getPost());
		return publication;
	}

	@Override
	public void deletePublicationByPostId(Integer id) {
		
		for (Comment comment : commentService.getByPostId(id)) {
			commentService.deleteComment(comment.getId());
		}
		
		postService.deletePost(id);
		
	}
	
}
