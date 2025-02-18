package tintin.services.interfaces;

import java.util.List;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;

public interface FCTRegisterService {
	
	public List<FCTRegister> getRegisterDates(Long idStudent) throws StudentNotFoundException, UserException;
	
	public List<Dates> getNotRegisterDates(Long idStudent) throws StudentNotFoundException, UserException;
	
	public void deleteRegister(Long idRegister) throws RegisterNotFoundException, UserException;
	
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException, UserException;
	
	public List<FCTRegister> getStudentRegister(Student student) throws RegisterNotFoundException, UserException;

}
