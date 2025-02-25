package tintin.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tintin.services.exceptions.RegisterNotFoundException;

@ControllerAdvice
public class RegisterNotFoundExceptionHandler {

	@ExceptionHandler(RegisterNotFoundException.class)
	public ResponseEntity<String> handle(RegisterNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		
	}
}
