package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.JobsService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.JobsDao;
import hrms.northwind.entities.concretes.Jobs;

@Service
public class JobsManager implements JobsService {
	
	private JobsDao jobsDao;
	
	@Autowired
	public JobsManager(JobsDao jobsDao) {
		super();
		this.jobsDao = jobsDao;
	}

	@Override
	public DataResult<List<Jobs>> getAll() {
		
		return new SuccessDataResult<List<Jobs>>(this.jobsDao.findAll(), "The jobs have been listed.");
	}

	@Override
	public Result add(Jobs jobs) {
		
		this.jobsDao.save(jobs);
		return new SuccessResult("Job has been added.");
	}

}
