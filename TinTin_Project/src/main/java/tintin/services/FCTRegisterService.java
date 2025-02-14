package tintin.services;

import java.util.List;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;

public interface FCTRegisterService {
	
	public List<FCTRegister> getRegisterDates(Long idStudent) throws StudentNotFoundException;
	
	public List<Dates> getNotRegisterDates(Long idStudent) throws StudentNotFoundException;
	
	public void deleteRegister(Long idRegister) throws RegisterNotFoundException;
	
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException;
}
