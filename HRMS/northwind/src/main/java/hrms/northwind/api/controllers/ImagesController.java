package hrms.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import hrms.northwind.business.abstracts.CandidateImageService;
import hrms.northwind.entities.concretes.Candidate;
import hrms.northwind.entities.concretes.Image;

@RestController
@RequestMapping(value = "/api/images")
public class ImagesController {
	
	private CandidateImageService candidateImageService;
	
	@Autowired
	public ImagesController(CandidateImageService candidateImageService) {
		super();
		this.candidateImageService = candidateImageService;
	}
	
	@GetMapping(value = "/getall")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(this.candidateImageService.getAll());
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId){
		
		Image image = new Image();
		Candidate candidate = new Candidate();
		candidate.setId(candidateId);
		image.setCandidate(candidate);
		return ResponseEntity.ok(this.candidateImageService.add(image,file));
	}
	

}
