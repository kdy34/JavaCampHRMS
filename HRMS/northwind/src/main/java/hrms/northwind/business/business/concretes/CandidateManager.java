package hrms.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.northwind.business.abstracts.CandidateService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.CandidateDao;
import hrms.northwind.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{
	
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "The candidates have been listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		
		this.candidateDao.save(candidate);
		return new SuccessResult("candidate has been added.");
	}

	@Override
	public Result delete(Candidate candidate) {
		
		candidateDao.delete(candidate);
        return new SuccessResult("Candidate has been deleted.");
	}

	@Override
	public DataResult<Candidate> update(Candidate candidate) {
		
		return new SuccessDataResult<>(this.candidateDao.save(candidate)," Candidate has been updated.");
	}

}
