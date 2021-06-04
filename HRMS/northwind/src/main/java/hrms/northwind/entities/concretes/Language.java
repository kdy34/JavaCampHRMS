package hrms.northwind.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import hrms.northwind.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="languages")
@NoArgsConstructor
@AllArgsConstructor
public class Language implements Entities{
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  	
	  	
	    @Column(name="id",  unique = true, nullable = false)
	    private int id;

	    @Column(name = "language")
	    private String language;

	    @Min(1)
	    @Max(5)
	    @Column(name = "level")
	    private int level;
	    
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name="curriculum_vitae_id")
	    private CurriculumVitae curriculumVitae;


}
