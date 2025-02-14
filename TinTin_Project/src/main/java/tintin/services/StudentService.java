package tintin.services;

import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.services.exceptions.StudentNotFoundException;

public interface StudentService {
	

	public Student getStudent(Long idStudent) throws StudentNotFoundException;
	
	public FCTRegister getStudentRegister(Student student);
	
}