package es.adrian.demo.model;

import java.util.List;

import lombok.Data;

@Data
public class Publication {

	private Post post;
	private List<Comment> comments;
	
} 
