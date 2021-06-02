package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
