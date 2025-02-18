package tintin.services.interfaces;

import tintin.model.Student;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;

public interface StudentService {
	
	public Student getStudent(Long idStudent) throws StudentNotFoundException, UserException;

	
}
