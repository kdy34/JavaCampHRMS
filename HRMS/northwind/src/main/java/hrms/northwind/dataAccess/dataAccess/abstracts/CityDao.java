package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
