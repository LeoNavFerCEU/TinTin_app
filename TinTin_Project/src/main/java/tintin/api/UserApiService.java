package tintin.api;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tintin.model.User;
import tintin.services.UserService;
import tintin.services.UserUnauthorizedException;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserNotFoundException;


@RestController
@RequestMapping("user")
public class UserApiService {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public StudentDTO login(@RequestParam String username, @RequestParam String pswd) throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException {
		User user = userService.login(username, pswd);
		ModelMapper mapper = new ModelMapper();
		
		return null; //new String();
	}
	
	@PutMapping("path/{id}")
	public String putMethodName(@RequestBody String entity) {
		//TODO: process PUT request
		
		return entity;
	}
	

}
