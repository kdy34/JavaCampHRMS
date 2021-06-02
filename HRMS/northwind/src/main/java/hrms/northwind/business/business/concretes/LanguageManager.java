package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.LanguageService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.dataAccess.abstracts.LanguageDao;
import hrms.northwind.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> add(Language language) {
		
		return new SuccessDataResult<Language>(this.languageDao.save(language));
	}

}
