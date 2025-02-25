package tintin.services;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tintin.dto.StudentDto;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.repositories.FCTRegisterRepository;
import tintin.repositories.StudentRepository;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private FCTRegisterRepository registerRepo;
	
	@Override
	public StudentDto getStudent(Long idStudent) throws StudentNotFoundException, UserException {
		log.debug("Consulting student with id: " + idStudent);
		try {
			Optional<Student> studentConsulted = studentRepo.findById(idStudent);
		if (!studentConsulted.isPresent()) {
			log.warn("The student doesn't exist.");
			throw new StudentNotFoundException("The student doesn't exist.");
		}
		List<FCTRegister> registers = registerRepo.findAllByAssociatedStudent_Id(idStudent);
		Integer hoursWorked = 0;
		for (FCTRegister fctRegister : registers) {
			hoursWorked += fctRegister.getNumHours();
		}
		Integer hoursLeft = 370-hoursWorked;
		Float percentage = (float) ((hoursWorked*100)/370);
		DecimalFormat df = new DecimalFormat("#");
		StudentDto student = new StudentDto();
		ModelMapper mapper = new ModelMapper();
		mapper.map(studentConsulted.get(), student);
		student.setHoursTotal(370);
		student.setHoursWorked(hoursWorked + "(" + df.format(percentage) + "%)");
		student.setHoursLeft(hoursLeft);
		return student;
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went worng with the consult", e);
		}
		
	}

	
}
