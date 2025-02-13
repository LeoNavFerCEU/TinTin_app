package tintin.services;

import tintin.dev.user.StudentDTO;
import tintin.services.exceptions.StudentNotFoundException;

public interface StudentService {
	
	public StudentDTO getStudent(Long idStudent) throws StudentNotFoundException;
	
	public void getStudentRegister();
	
}
