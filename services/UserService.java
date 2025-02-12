package services;

import model.User;
import services.exceptions.NotActiveUserException;
import services.exceptions.StudentNotFoundException;
import services.exceptions.UserNotFoundException;

public interface UserService {
	
	public User login(String username, String password) throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException;
	
	public void changePassword(Long idUser, String oldPassword, String newPassword) throws UserNotFoundException, UserUnauthorizedException, UserEcxeption;
	
	
	
	
}
