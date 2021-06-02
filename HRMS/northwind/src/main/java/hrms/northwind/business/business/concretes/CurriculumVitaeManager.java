package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.CurriculumVitaeService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.dataAccess.abstracts.CurriculumVitaeDao;
import hrms.northwind.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{
	
	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		super();
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll());
	}

	@Override
	public DataResult<CurriculumVitae> add(CurriculumVitae curriculumVitae) {
		
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.save(curriculumVitae), "Vitaes have been added.");
	}

}
