package hrms.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import hrms.northwind.business.abstracts.CurriculumVitaeService;
import hrms.northwind.core.utilities.results.ErrorDataResult;
import hrms.northwind.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping(value = "/api/curriculumVitaes")
public class CurriculumVitaesController {
	
	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		super();
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<?> getAll(){
		
		return ResponseEntity.ok(this.curriculumVitaeService.getAll());
	}
	
	public ResponseEntity<?> add(@Valid @RequestBody CurriculumVitae curriculumVitae){
		
		return ResponseEntity.ok(this.curriculumVitaeService.add(curriculumVitae));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors, "Some errors");
        return errors;
    }

}
