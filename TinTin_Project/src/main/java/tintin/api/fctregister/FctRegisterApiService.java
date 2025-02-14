package tintin.api.fctregister;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.services.FCTRegisterService;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;

@RestController
@RequestMapping("registers")
public class FctRegisterApiService {

	@Autowired
	private FCTRegisterService fctRegisterService;
	
	@GetMapping("registered/{id}")
	public List<FCTRegister> getRegisterDates(@PathVariable Long id) throws StudentNotFoundException {
		return fctRegisterService.getRegisterDates(id);
	}
	
	@GetMapping("notregistered/{idStudent}")
	public List<Dates> getNotRegisterDates(@PathVariable Long idStudent) throws StudentNotFoundException{
		return fctRegisterService.getNotRegisterDates(idStudent);
	}
	
	@DeleteMapping("{idRegister}")
	public void deleteRegister(@PathVariable Long idRegister) throws RegisterNotFoundException{
		fctRegisterService.deleteRegister(idRegister);
	}
	
	@PostMapping
	public FCTRegister createRegister(@RequestBody FCTRegister register) throws DuplicateRegisterException {
		return fctRegisterService.createRegister(register);
	}

}
