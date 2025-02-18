package tintin.services.interfaces;

import tintin.model.User;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.exceptions.UserNotFoundException;
import tintin.services.exceptions.UserUnauthorizedException;

public interface UserService {
	
	public User login(String username, String password) throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException, UserException;
	
	public void changePassword(Long idUser, String oldPassword, String newPassword) throws UserNotFoundException, UserUnauthorizedException, UserException;
	
	
	
}
