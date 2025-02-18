package tintin.services;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tintin.model.Dates;
import tintin.repositories.DatesRepository;
import tintin.services.exceptions.UserException;
import tintin.services.interfaces.DatesService;

@Service
public class DatesServiceImpl implements DatesService{
		
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private DatesRepository datesRepo;
	
	@Override
	public List<Dates> getDates(LocalDate since, LocalDate till) throws UserException {
		try {
			log.debug("Consulting dates...");
		return datesRepo.findByDateBetween(since, till);
		} catch (DataAccessException e) {
			log.error("Something went worng with the consult", e);
			throw new UserException("Something went worng with the consult", e);
		}
		
	}

	
}
