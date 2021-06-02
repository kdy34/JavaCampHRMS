package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.School;

public interface SchoolService {
	
    DataResult<List<School>> getAllSorted();
    DataResult<School> add(School school);

}
