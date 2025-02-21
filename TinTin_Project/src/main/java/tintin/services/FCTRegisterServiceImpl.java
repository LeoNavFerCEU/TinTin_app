package tintin.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;
import tintin.repositories.DatesRepository;
import tintin.repositories.FCTRegisterRepository;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.FCTRegisterService;

@Service
public class FCTRegisterServiceImpl implements FCTRegisterService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private FCTRegisterRepository registerRepo;

	@Autowired
	private DatesRepository datesRepo;

	@Override
	public List<Dates> getRegisterDates(Long idStudent, LocalDate desde, LocalDate hasta) throws RegisterNotFoundException, UserException {
		log.debug("Looking for register dates...");
		try {
			List<Dates> dates = datesRepo.findAllByDateBetween(desde, hasta);
			List<FCTRegister> registers = registerRepo.findAllByAssociatedStudent(idStudent);
			for (FCTRegister register : registers) {
				dates.stream().filter(date -> date.getDate() == register.getAssociatedDate().getDate());
			}
			if (dates.isEmpty()) {
				log.warn("Not register were found in table register");
				throw new RegisterNotFoundException("Not register were found in table register");
			}
			return dates;
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}
	}

	@Override
	public List<Dates> getNotRegisterDates(Long idStudent, LocalDate desde, LocalDate hasta) throws UserException, RegisterNotFoundException {
		log.debug("Looking for unregister dates...");
		try {
			List<FCTRegister> registers = registerRepo.findAllByAssociatedStudent(idStudent);
			List<Dates> dates = datesRepo.findAllByDateBetween(desde, hasta);
			
			for (FCTRegister register : registers) {
				dates.stream().filter(date -> date.getDate() != register.getAssociatedDate().getDate());
			}
			if (dates.isEmpty()) {
				log.warn("Not register were found in table register");
				throw new RegisterNotFoundException("Not register were found in table register");
			}
			return dates;
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}
	}

	@Override
	public void deleteRegister(Long idRegister) throws RegisterNotFoundException, UserException {
		log.debug("deleting new Register with id: " + idRegister);
		try {
			Optional<FCTRegister> registerConsulted = registerRepo.findById(idRegister);
			if (!registerConsulted.isPresent()) {
				log.warn("Register isn't exist.");
				throw new RegisterNotFoundException("Register isn't exists.");
			}
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}

	}

	@Override
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException, UserException {
		log.debug("Creating new Register: " + register);
		try {
			FCTRegister registerConsulted = registerRepo.findOneByAssociatedDate(register.getAssociatedDate());
			if (registerConsulted != null) {
				log.warn("Register already exists.");
				throw new DuplicateRegisterException("Register already exists.");
			}
			return registerRepo.save(register);
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}
	}

	@Override
	public List<FCTRegister> getStudentRegister(Student student) throws RegisterNotFoundException, UserException {
		log.debug("Looking for" + student.getFullName() + "'s Registers: ");
		try {
			List<FCTRegister> registers = registerRepo.findByAssociatedStudent(student);
			if (registers.isEmpty()) {
				log.warn("There aren't any register for this student");
				throw new RegisterNotFoundException("There aren't any register for this student");
			}
			return registers;
		} catch (DataAccessException e) {
			log.error("Something went worng with the consult", e);
			throw new UserException("Something went worng with the consult", e);
		}
	}

}
