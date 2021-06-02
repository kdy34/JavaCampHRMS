package hrms.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.northwind.business.abstracts.JobsService;
import hrms.northwind.entities.concretes.Jobs;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobs")
public class JobsControllers {
	
	private JobsService jobsService;
	
	
	@Autowired
	public JobsControllers(JobsService jobsService) {
		super();
		this.jobsService = jobsService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Jobs>> getAll(){
		return this.jobsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Jobs jobs) {
		
		return this.jobsService.add(jobs);
		
	}

}
