package hrms.northwind.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hrms.northwind.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_experience")
@NoArgsConstructor
@AllArgsConstructor
public class JobExperience implements Entities{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	 @Column(name="id")
	 private int id;
	 
	 @Column(name="workplace_name")
	 private String workplaceName;
	 
	 @Column(name="posititon")
	 private String position;
	 
	 @Column(name = "start_date")
	 private LocalDate startDate;

	 @Column(name = "finish_date")
	 private LocalDate finishDate;

	 @JsonIgnore
	 @Column(name = "created_date")
	 private LocalDate createdDate = LocalDate.now();
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="curriculum_vitae_id")
	 private CurriculumVitae curriculumVitae;

}
