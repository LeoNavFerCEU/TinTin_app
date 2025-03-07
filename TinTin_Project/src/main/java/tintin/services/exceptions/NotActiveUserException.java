package tintin.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotActiveUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4672684456070285771L;

	public NotActiveUserException() {
	}

	public NotActiveUserException(String message) {
		super(message);
	}

	public NotActiveUserException(Throwable cause) {
		super(cause);
	}

	public NotActiveUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotActiveUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
