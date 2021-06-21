package es.adrian.demo.service;

import java.util.List;

import es.adrian.demo.model.Publication;

public interface PublicationService {

	public List<Publication> getAll();
	public Publication getPublicationByPostId(Integer id);
	public Publication addPublication(Publication publication);
	public Publication updatePublicationByPostId(Integer id, Publication publication);
	public Publication deletePublicationByPostId(Integer id);

}
