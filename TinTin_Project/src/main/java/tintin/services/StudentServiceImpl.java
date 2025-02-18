package tintin.services;

import org.springframework.stereotype.Service;

import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Override
	public Student getStudent(Long idStudent) throws StudentNotFoundException {
		return null;
	}

	@Override
	public FCTRegister getStudentRegister(Student student) {
		return null;
	}

	
}
