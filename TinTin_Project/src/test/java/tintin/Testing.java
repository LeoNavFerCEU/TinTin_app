package tintin;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tintin.dto.StudentDto;
import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.model.User;
import tintin.repositories.DatesRepository;
import tintin.repositories.FCTRegisterRepository;
import tintin.repositories.StudentRepository;
import tintin.repositories.UserRepository;
import tintin.services.FCTRegisterServiceImpl;
import tintin.services.StudentServiceImpl;
import tintin.services.UserServiceImpl;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserNotFoundException;
import tintin.services.exceptions.UserUnauthorizedException;

public class Testing {

	@Autowired
	private FCTRegisterRepository registerRepo;

	@Autowired
	private DatesRepository datesRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FCTRegisterServiceImpl registerService;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private StudentServiceImpl studentService;

	private Student student;
	private FCTRegister register;
	private Dates date;
	private User user;

	@BeforeEach
	void setUp() {
		// Configura objetos de prueba antes de cada test
		student = new Student();
		student.setId(1L);
		student.setCourseYear("2023");
		student.setInternshipPeriod("SEPTIEMBRE");

		user = new User();
		user.setId(1L);
		user.setUsername("testuser");
		user.setPassword("password");
		user.setActive(true);
		user.setLinkedProfile(student);

		date = new Dates();
		date.setDate(LocalDate.of(2023, 9, 18));

		register = new FCTRegister();
		register.setAssociatedDate(date);
		register.setNumHours(5);
	}

	@Test
	void testGetRegisterDates_Success() throws Exception {
		// Prueba obtener registros cuando existen en la base de datos
		studentRepo.save(student);
		datesRepo.save(date);
		registerRepo.save(register);

		List<FCTRegister> result = registerService.getRegisterDates(1L, "TODAS", null, null);
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	void testGetRegisterDates_StudentNotFound() {
		// Prueba cuando el estudiante no existe
		assertThrows(StudentNotFoundException.class, () -> registerService.getRegisterDates(1L, "TODAS", null, null));
	}

	@Test
	void testGetRegisterDates_FilterComplete() throws Exception {
		// Prueba obtener registros completos
		studentRepo.save(student);
		datesRepo.save(date);
		registerRepo.save(register);

		List<FCTRegister> result = registerService.getRegisterDates(1L, "COMPLETAS", null, null);
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testGetRegisterDates_FilterIncomplete() throws Exception {
		// Prueba obtener registros incompletos
		studentRepo.save(student);
		datesRepo.save(date);

		List<FCTRegister> result = registerService.getRegisterDates(1L, "INCOMPLETAS", null, null);
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	void testCreateRegister_Success() throws Exception {
		// Prueba la creación exitosa de un registro
		FCTRegister result = registerService.createRegister(register);
		assertNotNull(result);
		assertEquals(5, result.getNumHours());
	}

	@Test
	void testCreateRegister_DuplicateException() {
		// Prueba intentar crear un registro duplicado
		registerRepo.save(register);
		assertThrows(DuplicateRegisterException.class, () -> registerService.createRegister(register));
	}

	@Test
	void testDeleteRegister_Success() throws Exception {
		// Prueba eliminar un registro exitosamente
		registerRepo.save(register);
		assertDoesNotThrow(() -> registerService.deleteRegister(1L));
	}

	@Test
	void testDeleteRegister_NotFound() {
		// Prueba eliminar un registro que no existe
		assertThrows(RegisterNotFoundException.class, () -> registerService.deleteRegister(1L));
	}

	@Test
	void testGetRegister_Success() throws Exception {
		// Prueba obtener un registro existente
		registerRepo.save(register);
		FCTRegister result = registerService.getRegister(1L);
		assertNotNull(result);
	}

	@Test
	void testGetRegister_NotFound() {
		// Prueba obtener un registro que no existe
		assertThrows(RegisterNotFoundException.class, () -> registerService.getRegister(1L));
	}

	@Test
	void testGetStudent_Success() throws Exception {
		// Prueba obtener un estudiante exitosamente
		studentRepo.save(student);
		registerRepo.save(register);

		StudentDto result = studentService.getStudent(1L);
		assertNotNull(result);
		assertEquals("370", result.getHoursTotal().toString());
	}

	@Test
	void testGetStudent_NotFound() {
		// Prueba obtener un estudiante que no existe
		assertThrows(StudentNotFoundException.class, () -> studentService.getStudent(1L));
	}

	@Test
	void testLogin_Success() throws Exception {
		// Prueba iniciar sesión correctamente
		userRepo.save(user);
		User result = userService.login("testuser", "password");
		assertNotNull(result);
	}

	@Test
	void testLogin_UserNotFound() {
		// Prueba iniciar sesión con un usuario inexistente
		assertThrows(UserNotFoundException.class, () -> userService.login("wronguser", "password"));
	}

	@Test
	void testLogin_UserNotActive() {
		// Prueba iniciar sesión con un usuario inactivo
		user.setActive(false);
		userRepo.save(user);
		assertThrows(NotActiveUserException.class, () -> userService.login("testuser", "password"));
	}

	@Test
	void testLogin_UserNotLinkedToStudent() {
		// Prueba iniciar sesión con un usuario sin perfil de estudiante
		user.setLinkedProfile(null);
		userRepo.save(user);
		assertThrows(StudentNotFoundException.class, () -> userService.login("testuser", "password"));
	}

	@Test
	void testLogin_IncorrectPassword() {
		// Prueba iniciar sesión con una contraseña incorrecta
		userRepo.save(user);
		assertThrows(UserUnauthorizedException.class, () -> userService.login("testuser", "wrongpassword"));
	}

	@Test
	void testChangePassword_Success() throws Exception {
		// Prueba cambiar la contraseña exitosamente
		userRepo.save(user);
		assertDoesNotThrow(() -> userService.changePassword(1L, "password", "newpassword"));
	}

	@Test
	void testChangePassword_SamePassword() {
		// Prueba intentar cambiar a la misma contraseña
		userRepo.save(user);
		assertThrows(UserUnauthorizedException.class, () -> userService.changePassword(1L, "password", "password"));
	}

	@Test
	void testChangePassword_UserNotFound() {
		// Prueba cambiar contraseña de un usuario inexistente
		assertThrows(UserNotFoundException.class, () -> userService.changePassword(2L, "password", "newpassword"));
	}

	@Test
	void testChangePassword_IncorrectOldPassword() {
		// Prueba cambiar contraseña con la contraseña antigua incorrecta
		userRepo.save(user);
		assertThrows(UserUnauthorizedException.class,
				() -> userService.changePassword(1L, "wrongpassword", "newpassword"));
	}
}
