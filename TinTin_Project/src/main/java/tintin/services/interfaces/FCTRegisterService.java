package tintin.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import tintin.model.FCTRegister;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;

public interface FCTRegisterService {
	
	public List<FCTRegister> getRegisterDates(Long idStudent,String filtro , LocalDate desde, LocalDate hasta) throws RegisterNotFoundException, UserException, StudentNotFoundException;
	
	public void deleteRegister(Long idRegister) throws RegisterNotFoundException, UserException;
	
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException, UserException;
	
	public FCTRegister getRegister(Long idRegister) throws RegisterNotFoundException, UserException;
}
