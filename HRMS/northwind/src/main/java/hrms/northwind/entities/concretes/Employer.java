package hrms.northwind.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import hrms.northwind.entities.abstracts.Entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User implements Entities {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_adress")
	private String webAddress;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	public Employer(int id, String email, String password, boolean isActive) {
		
		super(id, email, password, isActive);
	}
	
	 @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	 @NotFound(action=NotFoundAction.IGNORE)
	 private List<JobPosting> jobPostings;

}
