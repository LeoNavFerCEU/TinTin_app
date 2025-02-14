package tintin.dev.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tintin.services.interfaces.UserService;


@RestController
@RequestMapping("user")
public class UserApiService {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login")
	public StudentDTO login(@RequestParam String username, @RequestParam String pswd) {
		//User user = userService.login(username, pswd);
		
		return null; //new String();
	}
	
	@PutMapping("path/{id}")
	public String putMethodName(@RequestBody String entity) {
		//TODO: process PUT request
		
		return entity;
	}
	

}
