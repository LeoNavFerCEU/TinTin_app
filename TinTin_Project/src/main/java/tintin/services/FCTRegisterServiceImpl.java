package tintin.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
import tintin.repositories.StudentRepository;
import tintin.services.exceptions.DuplicateRegisterException;
import tintin.services.exceptions.RegisterNotFoundException;
import tintin.services.exceptions.StudentNotFoundException;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.FCTRegisterService;

@Service
public class FCTRegisterServiceImpl implements FCTRegisterService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private FCTRegisterRepository registerRepo;

	@Autowired
	private DatesRepository datesRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<FCTRegister> getRegisterDates(Long idStudent, String filtro, LocalDate desde, LocalDate hasta)
			throws RegisterNotFoundException, StudentNotFoundException, UserException {
		log.debug("Looking for register dates...");
		try {
			// Obtener estudiante y manejar si no existe
			Student student = studentRepo.findById(idStudent)
					.orElseThrow(() -> new StudentNotFoundException("Student not found"));
			// Determinar fechas si no se proporcionan
			if (desde == null || hasta == null) {
				int year = Integer.parseInt(student.getCourseYear());
				if ("SEPTIEMBRE".equalsIgnoreCase(student.getInternshipPeriod())) {
					desde = LocalDate.of(year, 9, 17);
					hasta = LocalDate.of(year, 12, 17);
				} else {
					desde = LocalDate.of(year, 3, 17);
					hasta = LocalDate.of(year, 6, 17);
				}
			}
			// Obtener todas las fechas del período
			List<Dates> dates = datesRepo.findAllByDateBetween(desde, hasta);

			// Obtener registros existentes de una sola consulta
			Map<LocalDate, FCTRegister> registersMap = registerRepo.findAllByAssociatedStudent_Id(idStudent).stream()
					.collect(Collectors.toMap(r -> r.getAssociatedDate().getDate(), r -> r));

			List<FCTRegister> registers = new ArrayList<>();
			for (Dates date : dates) {
				FCTRegister register = registersMap.get(date.getDate());
				if ("TODAS".equalsIgnoreCase(filtro) || ("COMPLETAS".equalsIgnoreCase(filtro) && register != null)
						|| ("INCOMPLETAS".equalsIgnoreCase(filtro) && register == null)) {
					if (register == null) {
						register = new FCTRegister();
						register.setAssociatedDate(date);
						register.setNumHours(0);
						register.setDescription("");
					}
					registers.add(register);
				}
			}

			return registers;
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
			registerRepo.delete(registerConsulted.get());
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}

	}

	@Override
	public FCTRegister createRegister(FCTRegister register) throws DuplicateRegisterException, UserException {
		log.debug("Creating new Register: " + register);
		try {
			FCTRegister registerConsulted = registerRepo.findOneByAssociatedDate_Date(register.getAssociatedDate().getDate());
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
	public FCTRegister getRegister(Long idRegister) throws RegisterNotFoundException, UserException {
		log.debug("deleting new Register with id: " + idRegister);
		try {
			Optional<FCTRegister> registerConsulted = registerRepo.findById(idRegister);
			if (!registerConsulted.isPresent()) {
				log.warn("Register isn't exist.");
				throw new RegisterNotFoundException("Register isn't exists.");
			}
			return registerConsulted.get();
		} catch (DataAccessException e) {
			log.error("Something went wrong with the consult", e);
			throw new UserException("Something went wrong with the consult", e);
		}
	}

}
