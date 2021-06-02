package hrms.northwind.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import hrms.northwind.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_postings")
@PrimaryKeyJoinColumn(name="id")
public class JobPosting implements Entities{
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	 	
	 	@Column(name = "description")
		private String description;
	 	
	 	@Column(name = "min_salary")
		private int minSalary;
	 	
	 	@Column(name = "max_salary")
		private int maxSalary;
	 	
	 	@Column(name = "open_position_count")
		private int openPositionCount;
	 	
	 	@Column(name = "deadline")
	 	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate deadline;
	 	
	 	@Column(name = "published_at")
	 	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate publishedAt;
	 	
	 	@ManyToOne()
	 	@JoinColumn(name="jobs_id")
	 	private Jobs jobs;
	 	
	 	@ManyToOne()
	    @JoinColumn(name = "employer_id")
	    private Employer employer;
	 	
	 	@ManyToOne()
	    @JoinColumn(name = "city_id")
	 	private City city;

}
