package studentplatform.student_platform.exception;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exce {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException ex)
	{
		Map<String,String> errors = new HashMap<>();
		   ex.getBindingResult().getFieldErrors().forEach(error -> {
	            errors.put(error.getField(), error.getDefaultMessage());
	        });
		   return  new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler( messagenotfound.class)
	public ResponseEntity<String> handle(messagenotfound ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
			
	}
	  @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGlobalException(Exception ex) {
	        return new ResponseEntity<>("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }

}
