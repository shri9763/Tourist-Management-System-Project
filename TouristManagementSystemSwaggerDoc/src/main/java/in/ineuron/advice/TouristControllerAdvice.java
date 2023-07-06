package in.ineuron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.ineuron.error.ErrorDetails;
import in.ineuron.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice {
	//swagger doc link for this project
	//http://localhost:8080//restMiniProject/swagger-ui.html
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlingTnfException(TouristNotFoundException tnf){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),tnf.getMessage(),"404-Error");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handlingAllException(Exception e){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"All Excetion Handling");
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
