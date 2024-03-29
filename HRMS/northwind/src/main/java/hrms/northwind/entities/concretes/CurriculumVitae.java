package hrms.northwind.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hrms.northwind.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="curriculum_vitaes")
@NoArgsConstructor
@AllArgsConstructor
public class CurriculumVitae implements Entities{
	
	 	@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 	
	 	@Column(name="id")
		private int id;
	 	
	 	@Column(name="github_address")
		private String githubAddress;
	 	
	 	@Column(name="linkedin_address")
		private String linkedinAddress;
	 	
	 	@Column(name="abilities")
		private String abilities;
	 	
	 	@Column(name="about")
		private String about;
	 	
	 	@OneToMany(mappedBy = "curriculumVitae")
	    @JsonIgnore
	    private List<JobExperience> jobExperiences;

	    @OneToMany(mappedBy = "curriculumVitae")
	    @JsonIgnore
	    private List<School> schools;

	    @OneToMany(mappedBy = "curriculumVitae")
	    @JsonIgnore
	    private List<Language> languages;

}
