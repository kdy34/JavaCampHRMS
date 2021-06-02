package hrms.northwind.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.JobPosting;

public interface JobPostingService {
	
	 	Result add(JobPosting jobPosting);
	    DataResult<List<JobPosting>> getAll();
	    DataResult<List<JobPosting>> getAllByApplicationDeadline(LocalDate date);
	    DataResult<List<JobPosting>> getAllByEmployer(int employerId);
	    Result delete(JobPosting jobPosting);

}
