package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.Language;

public interface LanguageService {
	
	DataResult<List<Language>> getAll();
	DataResult<Language> add(Language language);

}
