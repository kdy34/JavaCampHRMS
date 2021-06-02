package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

}
