package hrms.northwind;

import org.springframework.context.annotation.Bean;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hrms.northwind.core.imageService.ImageService;
import hrms.northwind.core.imageService.cloudinary.CloudinaryImageManager;

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	 @Bean
	    public Cloudinary cloudinaryService(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "ddn7vrrzf ",
	                "api_key", "844763272762364",
	                "api_secret", "L_4K-SDG88jcgNE7yyTffBygHPg"));
	    }

	    @Bean
	    public ImageService imageService(){
	        return new CloudinaryImageManager(cloudinaryService());
	    }

}
