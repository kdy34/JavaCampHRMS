package hrms.northwind.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobPostingService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.JobPostingDao;
import hrms.northwind.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{
	
	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		
		jobPosting.setPublishedAt(LocalDate.now());
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("Job posting has been added!");
	}
	

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<>(this.jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getAllByApplicationDeadline(LocalDate date) {
		
		return new SuccessDataResult<>(this.jobPostingDao.getAllByDeadlineLessThanEqual(date));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByEmployer(int employerId) {
		
		 return new SuccessDataResult<>(this.jobPostingDao.getAllByEmployer(employerId));
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Job posting has been deleted successfully");
	}
	

}
