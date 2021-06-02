package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.entities.concretes.Jobs;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;

public interface JobsService {
	
	DataResult<List<Jobs>> getAll();
	Result add(Jobs jobs);

}
