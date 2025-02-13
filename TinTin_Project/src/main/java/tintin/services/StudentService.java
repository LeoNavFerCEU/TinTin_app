package tintin.services;

import tintin.dto.StudentDto;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.services.exceptions.StudentNotFoundException;

public interface StudentService {
	
	public StudentDto getStudent(Long idStudent) throws StudentNotFoundException;
	
	public FCTRegister getRegisters(Student student);
}
