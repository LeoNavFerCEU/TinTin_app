package tintin.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import tintin.services.exceptions.NotActiveUserException;

@ControllerAdvice
public class NotActiveUserExceptionHandler {

	@ExceptionHandler(NotActiveUserException.class)
	public ResponseEntity<String> handle(NotActiveUserException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
	}
}
