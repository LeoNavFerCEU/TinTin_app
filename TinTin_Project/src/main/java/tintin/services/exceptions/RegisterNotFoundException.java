package tintin.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2809724175829278142L;

	public RegisterNotFoundException() {
	}

	public RegisterNotFoundException(String message) {
		super(message);
	}

	public RegisterNotFoundException(Throwable cause) {
		super(cause);
	}

	public RegisterNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RegisterNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
