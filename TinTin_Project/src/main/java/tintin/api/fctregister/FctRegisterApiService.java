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

import io.swagger.v3.oas.annotations.Operation;
import tintin.model.FCTRegister;

import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.FCTRegisterService;

@RestController
@RequestMapping("register")
public class FctRegisterApiService {

	@Autowired
	private FCTRegisterService fctRegisterService;
	
	//FALTA DATETIMEFORMAT
	@Operation(summary = "Gets registers of a student by ID",description = "Returns a list of registers concurred between specified dates (It may be empty)")
	@GetMapping("filter/{idStudent}")
	public List<FCTRegister> getRegisterDates(@PathVariable Long idStudent, @RequestParam String filtro,
			@RequestParam LocalDate since,@RequestParam LocalDate until) throws UserException, StudentNotFoundException, RegisterNotFoundException {
		return fctRegisterService.getRegisterDates(idStudent, filtro, since, until);
	}
	
	@Operation(summary = "Get register by ID",description = "Returns a single register")
	@GetMapping("{idRegister}")
	public FCTRegister getRegister(@PathVariable Long idRegister) throws UserException, RegisterNotFoundException{
		return fctRegisterService.getRegister(idRegister);
	}
	
	@Operation(summary = "Delete register by ID")
	@DeleteMapping("{idRegister}")
	public void deleteRegister(@PathVariable Long idRegister) throws RegisterNotFoundException, UserException{
		fctRegisterService.deleteRegister(idRegister);
	}
	
	@Operation(summary = "Add register",description = "Returns added register")
	@PostMapping
	public FCTRegister createRegister(@RequestBody FCTRegister register) throws DuplicateRegisterException, UserException {
		return fctRegisterService.createRegister(register);
	}

}
