package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.JobExperience;

public interface JobExperienceService {
	
	DataResult<List<JobExperience>> getAllSorted();

    DataResult<JobExperience> add(JobExperience jobExperience);

}
