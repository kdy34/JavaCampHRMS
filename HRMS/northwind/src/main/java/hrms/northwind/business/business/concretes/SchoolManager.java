package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.SchoolService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.dataAccess.abstracts.SchoolDao;
import hrms.northwind.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAllSorted() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "finishDate");
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(sort), "Successful.");
	}

	@Override
	public DataResult<School> add(School school) {
		
		return new SuccessDataResult<School>(this.schoolDao.save(school), "Successful.");
	}
	
	

}
