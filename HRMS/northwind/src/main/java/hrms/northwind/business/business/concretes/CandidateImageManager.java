package hrms.northwind.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hrms.northwind.business.abstracts.CandidateImageService;
import hrms.northwind.core.imageService.ImageService;
import hrms.northwind.core.utilities.results.DataResult;
import hrms.northwind.core.utilities.results.Result;
import hrms.northwind.core.utilities.results.SuccessDataResult;
import hrms.northwind.core.utilities.results.SuccessResult;
import hrms.northwind.dataAccess.abstracts.ImageDao;
import hrms.northwind.entities.concretes.Image;

@Service
public class CandidateImageManager implements CandidateImageService{
	
	private ImageDao imageDao;
	private ImageService imageService;
	
	@Autowired
	public CandidateImageManager(ImageDao imageDao, ImageService imageService) {
		super();
		this.imageDao = imageDao;
		this.imageService = imageService;
	}

	@Override
	public Result add(Image image) {
		
		this.imageDao.save(image);
		return new SuccessResult("The image has been added.");
	}

	@Override
	public Result add(Image image, MultipartFile file) {
		
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
        String url = result.get("url");
        image.setUrl(url);
        return add(image);
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<List<Image>> getAllByCandidateId(int candidateId) {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.getAllByCandidateId(candidateId));
	}

}
