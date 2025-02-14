package tintin.api.student;

import tintin.dto.StudentDto;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.services.StudentService;
import tintin.services.exceptions.StudentNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("student")
public class StudentApiSevice {

	@Autowired
	private StudentService studentService;

	@GetMapping("{id}")
	public StudentDto getStudent(@PathVariable Long id) throws StudentNotFoundException {
		Student student = studentService.getStudent(id);
		StudentDto dto = new StudentDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(student, dto);
		return dto;
	}
	
	@GetMapping("registers/{id}")
	public FCTRegister getRegisters(@PathVariable Long id) {
//		return studentService.getRegisters(studentService.getStudent(id));
		return null;
	}

}
