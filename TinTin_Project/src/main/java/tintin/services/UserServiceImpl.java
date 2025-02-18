package tintin.services;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tintin.model.User;
import tintin.repositories.UserRepository;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.exceptions.UserNotFoundException;
import tintin.services.exceptions.UserUnauthorizedException;
import tintin.services.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User login(String username, String password)
			throws UserNotFoundException, StudentNotFoundException, NotActiveUserException, UserUnauthorizedException, UserException {
		try {
			log.debug("Login with user " + username);
			Optional<User> userOpt = userRepo.findOneByUsername(username);
			// 1. Comprobar si existe login como username
			if (!userOpt.isPresent()) {
				log.debug("There is no user with that username...");
				throw new UserNotFoundException("Username not found.");
			}
			User user = userOpt.get();
			// 2. Comprobar si el usuario está activo
			if (!user.getActive()) {
				log.debug("The user isn't active...");
				throw new NotActiveUserException("The user isn't active.");
			}
			// 3. Comprobar si el usuario tiene un alumno asociado
			if (user.getAssociatedProfile()==null) {
				log.debug("The user is not associated with a student...");
				throw new StudentNotFoundException("The user is not associated with a student.");
			}
			// 4. Comprobar password cifrándola previamente
			String passwordCipher = DigestUtils.sha256Hex(password);
			if (!user.getPassword().equals(passwordCipher)) {
				log.warn("Incorrect password");
				throw new UserUnauthorizedException("Incorrect user password");
			}
			log.debug("Login correcto");
			return user;
		} catch (DataAccessException e) {
			log.error("Error while updating user pass", e);
			throw new UserException("Error while updating user", e);
		}
	}

	@Override
	public void changePassword(Long idUser, String oldPassword, String newPassword)
			throws UserNotFoundException, UserUnauthorizedException, UserException {
		try {	
			// 1. Comprobar que password sean diferentes
			if (newPassword.equals(oldPassword)) {
				log.debug("Old pass equal to the new one, the change will not be made");
				throw new UserUnauthorizedException("The new password cannot be the same as the old one");
			}
			// 2. Comprobar si usuario existe
			Optional<User> userOpt = userRepo.findById(idUser);
			if (userOpt.isEmpty()) {
				log.warn("The indicated user does not exist. ID: " + idUser);
				throw new UserNotFoundException("There is no user with id " + idUser);
			}
			User user = userOpt.get();
			// 3. Comprobamos password antigua
			String passwordCipherOld = DigestUtils.sha256Hex(oldPassword);
			if (!user.getPassword().equals(passwordCipherOld)) {
				log.debug("The old password indicated is incorrect");
				throw new UserUnauthorizedException("The old password is incorrect");
			}
			//Ciframos y asignamos la nueva password
			String passwordCipherNew = DigestUtils.sha256Hex(newPassword);
			user.setPassword(passwordCipherNew);
			userRepo.save(user);
			log.debug("Password changed succesfully");
		} catch (DataAccessException e) {
			log.error("Error while updating user pass", e);
			throw new UserException("Error while updating user", e);
		}
	}

}
