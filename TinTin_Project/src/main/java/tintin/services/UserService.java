package tintin.api.server.services;

import tintin.api.server.model.User;
import tintin.api.server.services.exceptions.NotActiveUserException;
import tintin.api.server.services.exceptions.StudentNotFoundException;
import tintin.api.server.services.exceptions.UserNotFoundException;

public interface UserService {
	
	public User login(String username, String password) throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException;
	
	public void changePassword(Long idUser, String oldPassword, String newPassword) throws UserNotFoundException, UserUnauthorizedException, UserEcxeption;
	
	
	
	
}
