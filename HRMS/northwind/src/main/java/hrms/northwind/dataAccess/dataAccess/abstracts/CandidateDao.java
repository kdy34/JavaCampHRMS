package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Candidate;
import hrms.northwind.entities.concretes.User;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	User getById(int id);
	
	Candidate getByIdentityNumber(String identityNumber);

}
