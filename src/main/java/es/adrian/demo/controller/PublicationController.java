package es.adrian.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.adrian.demo.model.Publication;
import es.adrian.demo.service.PublicationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PublicationController {
	
	@Autowired
	private final PublicationService publicationService;
	
	
	@GetMapping("/publications")
	public List<Publication> getAll() {
		return publicationService.getAll();
	}
	
	@GetMapping("/posts/{id}/publications")
	public Publication getPublicationByPostId(@PathVariable int id) {
		return publicationService.getPublicationByPostId(id);
	}
	
	@PostMapping("/publications")
	public Publication addPublication(@RequestBody Publication publication) {
		return publicationService.addPublication(publication);
	}
	
	@PutMapping("/posts/{id}/publications")
	public Publication updatePublication(@PathVariable Integer id, @RequestBody Publication publication) {
		return publicationService.updatePublicationByPostId(id, publication);
	}
	
	@DeleteMapping("/publications/{id}")
	public Publication deletePublication(@PathVariable Integer id) {
		return publicationService.deletePublicationByPostId(id);
	}
}
