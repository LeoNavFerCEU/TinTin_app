package tintin.api.fctregister;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tintin.model.Dates;
import tintin.model.FCTRegister;

import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.FCTRegisterService;

@RestController
@RequestMapping("registers")
public class FctRegisterApiService {

	@Autowired
	private FCTRegisterService fctRegisterService;
	
	@GetMapping("registered/{id}")
	public List<Dates> getRegisterDates(@PathVariable Long id, @RequestParam LocalDate since,@RequestParam LocalDate until) throws RegisterNotFoundException, UserException {
		return fctRegisterService.getRegisterDates(id, since, until);
	}
	
	@GetMapping("notregistered/{idStudent}")
	public List<Dates> getNotRegisterDates(@PathVariable Long idStudent,@RequestParam LocalDate since,@RequestParam LocalDate until) throws UserException, RegisterNotFoundException{
		return fctRegisterService.getNotRegisterDates(idStudent, since, until);
	}
	
	@DeleteMapping("{idRegister}")
	public void deleteRegister(@PathVariable Long idRegister) throws RegisterNotFoundException, UserException{
		fctRegisterService.deleteRegister(idRegister);
	}
	
	@PostMapping
	public FCTRegister createRegister(@RequestBody FCTRegister register) throws DuplicateRegisterException, UserException {
		return fctRegisterService.createRegister(register);
	}

}
