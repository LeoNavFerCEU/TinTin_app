package tintin.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tintin.api.user.request.ChangePasswordRequest;
import tintin.model.User;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.exceptions.UserNotFoundException;
import tintin.services.exceptions.UserUnauthorizedException;
import tintin.services.interfaces.UserService;

@RestController
@RequestMapping("user")
public class UserApiService {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public User login(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException, UserException {
		return userService.login(username, password);
	}
	
	@PutMapping
	public void changePassword(@RequestBody ChangePasswordRequest request) throws UserNotFoundException, UserUnauthorizedException, UserException {
		userService.changePassword(request.getId(),
				request.getCurrentPassword(), request.getNewPassword());
	}

}