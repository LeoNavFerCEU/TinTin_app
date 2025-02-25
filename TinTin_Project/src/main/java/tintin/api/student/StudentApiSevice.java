package tintin.api.student;

import tintin.dto.StudentDto;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("student")
public class StudentApiSevice {

	@Autowired
	private StudentService studentService;

	@Operation(summary = "Get student by ID",description = "Returns a single student")
	@GetMapping("{idStudent}")
	public StudentDto getStudent(@PathVariable Long idStudent) throws StudentNotFoundException, UserException {
		return studentService.getStudent(idStudent);
	}

}
