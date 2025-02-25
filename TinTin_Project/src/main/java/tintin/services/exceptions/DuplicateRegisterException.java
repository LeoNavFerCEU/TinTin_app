package tintin.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateRegisterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5021415989501895085L;

	public DuplicateRegisterException() {
	}

	public DuplicateRegisterException(String message) {
		super(message);
	}

	public DuplicateRegisterException(Throwable cause) {
		super(cause);
	}

	public DuplicateRegisterException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateRegisterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
