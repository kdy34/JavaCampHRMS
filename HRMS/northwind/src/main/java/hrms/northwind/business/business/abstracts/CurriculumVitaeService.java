package hrms.northwind.business.abstracts;

import java.util.List;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	
	DataResult<List<CurriculumVitae>> getAll();
    DataResult<CurriculumVitae> add(CurriculumVitae curriculumVitae);

}
