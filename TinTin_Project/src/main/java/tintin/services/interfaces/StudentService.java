package tintin.services.interfaces;

import tintin.dto.StudentDto;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;

public interface StudentService {
	
	public StudentDto getStudent(Long idStudent) throws StudentNotFoundException, UserException;

	
}
