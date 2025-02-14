package tintin.services;

import tintin.model.FCTRegister;
import tintin.model.Student;
import java.time.LocalDate;

import tintin.dto.StudentDto;
import tintin.model.FCTRegister;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;

public interface StudentService {
	

	public Student getStudent(Long idStudent) throws StudentNotFoundException;
	
	public FCTRegister getStudentRegister(Student student);
	
}