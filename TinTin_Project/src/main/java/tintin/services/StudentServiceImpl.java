package tintin.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tintin.model.Student;
import tintin.repositories.StudentRepository;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public Student getStudent(Long idStudent) throws StudentNotFoundException, UserException {
		log.debug("Consulting student with id: " + idStudent);
		try {
			Optional<Student> student = studentRepo.findById(idStudent);
		if (!student.isPresent()) {
			log.warn("The student doesn't exist.");
			throw new StudentNotFoundException("The student doesn't exist.");
		}
		return student.get();
		} catch (DataAccessException e) {
			log.error("Something went worng with the consult", e);
			throw new UserException("Something went worng with the consult", e);
		}
		
	}

	
}
