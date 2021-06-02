package hrms.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.northwind.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
