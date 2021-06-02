package hrms.northwind.core.imageService;

import org.springframework.web.multipart.MultipartFile;

import hrms.northwind.core.utilities.results.DataResult;

public interface ImageService {
	
	 DataResult<?> save(MultipartFile file);

}
