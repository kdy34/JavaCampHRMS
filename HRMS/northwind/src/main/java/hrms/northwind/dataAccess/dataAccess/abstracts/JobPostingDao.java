package hrms.northwind.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	
	List<JobPosting> getAllByDeadlineLessThanEqual(LocalDate date);
	List<JobPosting> getAllByEmployer(int employerId);

}
