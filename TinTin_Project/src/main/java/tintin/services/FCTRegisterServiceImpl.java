package tintin.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.interfaces.FCTRegisterService;

@Service
public class FCTRegisterServiceImpl implements FCTRegisterService{

	@Override
	public List<FCTRegister> getRegisterDates(Long idStudent) throws StudentNotFoundException {
		return null;
	}

	@Override
	public List<Dates> getNotRegisterDates(Long idStudent) throws StudentNotFoundException {
		return null;
	}

	@Override
	public void deleteRegister(Long idRegister) throws RegisterNotFoundException {
		
	}

	@Override
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException {
		return null;
	}

	@Override
	public FCTRegister getRegisterByDate(Long date) throws RegisterNotFoundException {
		return null;
	}
	
	
}
