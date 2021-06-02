package hrms.northwind.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.northwind.business.abstracts.JobPostingService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobpostings")
public class JobPostingControllers {
	
	 	private JobPostingService jobPostingService;

	    @Autowired
	    public JobPostingControllers(JobPostingService jobPostingService) {
	        this.jobPostingService = jobPostingService;
	    }

	    @PostMapping("/add")
	    public Result add(@RequestBody JobPosting jobPosting){
	        return this.jobPostingService.add(jobPosting);
	    }
	    
	    @GetMapping("/getall")
	    public DataResult<List<JobPosting>> getAll(){
	        return this.jobPostingService.getAll();
	    }

	    @GetMapping("/getallbyapplicationdeadline")
	    public DataResult<List<JobPosting>> getAllByApplicationDeadline(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
	        return this.jobPostingService.getAllByApplicationDeadline(date);
	    }

	    @GetMapping("/getallbyemployer")
	    public DataResult<List<JobPosting>> getAllByEmployer(@RequestParam int employerId){
	        return this.jobPostingService.getAllByEmployer(employerId);
	    }
	    
	    @DeleteMapping("/delete")
	    public Result delete(@RequestBody JobPosting jobPosting) {
	    	
	    	return this.jobPostingService.delete(jobPosting);
	    }
	    

}
