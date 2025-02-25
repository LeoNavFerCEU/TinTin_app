package tintin.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tintin.services.exceptions.DuplicateRegisterException;

@ControllerAdvice
public class DuplicateRegisterExceptionHandler {

	@ExceptionHandler(DuplicateRegisterException.class)
	public ResponseEntity<String> handle(DuplicateRegisterException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
		
	}
}
