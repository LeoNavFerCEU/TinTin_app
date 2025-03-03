package tintin;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.CoderMalfunctionError;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import tintin.api.handler.UserUnauthorizedExceptionHandler;
import tintin.dto.StudentDto;
import tintin.model.Company;
import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.SchoolTutor;
import tintin.model.Student;
import tintin.model.User;
import tintin.repositories.DatesRepository;
import tintin.repositories.FCTRegisterRepository;
import tintin.repositories.StudentRepository;
import tintin.repositories.UserRepository;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.NotActiveUserException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserNotFoundException;
import tintin.services.exceptions.UserUnauthorizedException;
import tintin.services.interfaces.FCTRegisterService;
import tintin.services.interfaces.StudentService;
import tintin.services.interfaces.UserService;

@ActiveProfiles("application")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppTests {

	@Autowired
	private FCTRegisterRepository registerRepo;

	@Autowired
	private DatesRepository datesRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private FCTRegisterService registerService;

	@Autowired
	private UserService userService;

	@Autowired
	private StudentService studentService;

	private Company company;
	private Dates date;
	private FCTRegister register;
	private SchoolTutor tutor;
	private Student student;
	private User user;

	@BeforeEach
	void initAll() {
		tutor = new SchoolTutor();
		company = new Company();
		student = new Student();
		user = new User();
		date = new Dates();
		register = new FCTRegister();

		student.setCourseYear("2024/2025");
		student.setInternshipPeriod("SEPTIEMBRE");
		student.setCourse("");
		student.setAssignedCompany(company);
		student.setSchoolTutor(tutor);

		user.setUsername("test");
		user.setPassword("password");
		user.setActive(true);
		user.setLinkedProfile(student);

		date.setDate(LocalDate.of(2025, 05, 01));
		date.setCourseYear("2024/2025");

		register.setAssociatedDate(date);
		register.setNumHours(5.0);
		register.setAssociatedStudent(student);
		register.setDescription("");

		company.setId(1L);
		company.setActive(true);
		company.setName("");
		company.setTutorMail("");
		company.setTutorName("");
		company.setTutorTlfno("");

		tutor.setId(1L);
		tutor.setActive(true);
		tutor.setFullName("");
	}

	@Test
	@Order(1)
	void testGetRegisterDates_Success() throws Exception {

		List<FCTRegister> result = registerService.getRegisterDates(1L, "TODAS", LocalDate.of(2025, 05, 01),
				LocalDate.of(2025, 05, 30));
		assertNotNull(result);
		assertEquals(22, result.size());
	}

	@Test
	@Order(2)
	void testGetRegisterDates_StudentNotFound() {
		assertThrows(StudentNotFoundException.class, () -> registerService.getRegisterDates(3L, "TODAS",
				LocalDate.of(2025, 05, 01), LocalDate.of(2025, 05, 30)));
	}

	@Test
	@Order(3)
	void testGetRegisterDates_FilterComplete() throws Exception {
		List<FCTRegister> result = registerService.getRegisterDates(1L, "TODAS", LocalDate.of(2025, 05, 01),
				LocalDate.of(2025, 05, 30));
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	@Order(4)
	void testGetRegisterDates_FilterIncomplete() throws Exception {

		List<FCTRegister> result = registerService.getRegisterDates(1L, "INCOMPLETAS", LocalDate.of(2025, 05, 01),
				LocalDate.of(2025, 05, 30));
		assertNotNull(result);
		assertFalse(result.isEmpty());
	}

	@Test
	@Order(5)
	void testCreateRegister_Success() throws Exception {
		register.setAssociatedStudent(student);
		FCTRegister result = registerService.createRegister(register);
		assertNotNull(result);
		assertEquals(5, result.getNumHours());
	}

	@Test
	@Order(6)
	void testCreateRegister_DuplicateException() {

		assertThrows(DuplicateRegisterException.class, () -> registerService.createRegister(register));
	}

	@Test
	@Order(7)
	void testGetRegister_Success() throws Exception {

		FCTRegister result = registerService.getRegister(1L);
		assertNotNull(result);
	}

	@Test
	@Order(8)
	void testGetRegister_NotFound() {
		assertThrows(RegisterNotFoundException.class, () -> registerService.getRegister(4L));
	}

	//FUNCIONAN PERO LOS COMENTOS PORQUE SINO LOS BORRA DE LA BASE DE DATOS
//	@Test
//	@Order(9)
//	void testDeleteRegister_Success() throws Exception {
//
//		assertDoesNotThrow(() -> registerService.deleteRegister(1L));
//	}
//
//	@Test
//	@Order(10)
//	void testDeleteRegister_NotFound() {
//		// Prueba eliminar un registro que no existe
//		assertThrows(RegisterNotFoundException.class, () -> registerService.deleteRegister(3L));
//	}

	@Test
	@Order(11)
	void testGetStudent_Success() throws Exception {

		StudentDto result = studentService.getStudent(1L);
		assertNotNull(result);
		assertEquals("370", result.getHoursTotal().toString());
	}

	@Test
	@Order(12)
	void testGetStudent_NotFound() {
		assertThrows(StudentNotFoundException.class, () -> studentService.getStudent(3L));
	}

	@Test
	@Order(13)
	void testLogin_Success() throws Exception {
		
		User result = userService.login("test", "pass");
		assertNotNull(result);
	}

	@Test
	@Order(14)
	void testLogin_UserNotFound() {
		assertThrows(UserNotFoundException.class, () -> userService.login("wronguser", "password"));
	}

	@Test
	@Order(15)
	void testLogin_UserNotActive() {
		user.setActive(false);
		assertThrows(UserUnauthorizedException.class, () -> userService.login("test", "password"));
	}

	@Test
	@Order(16)
	void testLogin_UserNotLinkedToStudent() {
		user.setLinkedProfile(null);
		user.setActive(false);
		assertThrows(UserUnauthorizedException.class, () -> userService.login("test", "password"));
	}

	@Test
	@Order(17)
	void testLogin_IncorrectPassword() {
		assertThrows(UserUnauthorizedException.class, () -> userService.login("test", "wrongpassword"));
	}

	//FUNCIONA PERO ES PARA QUE O ME CAMBIE LA PASS SIEMPRE
//	@Test
//	@Order(18)
//	void testChangePassword_Success() throws Exception {
//		assertDoesNotThrow(() -> userService.changePassword(1L, "pass", "newpassword"));
//	}

	@Test
	@Order(19)
	void testChangePassword_SamePassword() {
		assertThrows(UserUnauthorizedException.class, () -> userService.changePassword(1L, "test", "password"));
	}

	@Test
	@Order(20)
	void testChangePassword_UserNotFound() {
		assertThrows(UserNotFoundException.class, () -> userService.changePassword(2L, "password", "newpassword"));
	}

	@Test
	@Order(21)
	void testChangePassword_IncorrectOldPassword() {
		assertThrows(UserUnauthorizedException.class,
				() -> userService.changePassword(1L, "wrongpassword", "newpassword"));
	}
}
