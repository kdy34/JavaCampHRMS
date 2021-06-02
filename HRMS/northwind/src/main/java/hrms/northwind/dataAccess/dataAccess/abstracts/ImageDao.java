package hrms.northwind.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{
	
	List<Image> getAllByCandidateId(int candidateId);

}
