package hrms.northwind.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.entities.concretes.Image;

public interface CandidateImageService {

	 	Result add(Image image);
	    Result add(Image image, MultipartFile file);
	    DataResult<List<Image>> getAll();
	    DataResult<List<Image>> getAllByCandidateId(int candidateId);
}
