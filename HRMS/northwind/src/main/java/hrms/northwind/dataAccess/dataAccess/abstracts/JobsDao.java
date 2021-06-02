package hrms.northwind.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Jobs;

public interface JobsDao extends JpaRepository<Jobs, Integer>{

    Jobs getById(int id);

}
