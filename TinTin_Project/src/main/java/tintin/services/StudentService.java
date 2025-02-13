package tintin.services;

import java.time.LocalDate;

import tintin.dto.StudentDto;
import tintin.model.FCTRegister;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;

public interface StudentService {
	
	public StudentDto getStudent(Long idStudent) throws StudentNotFoundException;
	
	public FCTRegister getRegisters(String filter, LocalDate since, LocalDate till) throws StudentNotFoundException;
	
	public void deleteRegister(Long idFCTRegister) throws RegisterNotFoundException;
	
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException;
}
