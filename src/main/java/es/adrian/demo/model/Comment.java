package es.adrian.demo.model;

import lombok.Data;

@Data
public class Comment {
	private Integer id;
	private Integer postId;
	private String name;
	private String email;
	private String body;
}
