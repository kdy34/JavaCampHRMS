package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobExperienceService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.dataAccess.abstracts.JobExperienceDao;
import hrms.northwind.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{
	
	private JobExperienceDao jobExperienceDao;
	
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		super();
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public DataResult<List<JobExperience>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
		return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(sort), "Successful.");
	}

	@Override
	public DataResult<JobExperience> add(JobExperience jobExperience) {
		
		return new SuccessDataResult<JobExperience>(this.jobExperienceDao.save(jobExperience), "Job Experience has been added.");
	}

}
