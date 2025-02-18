package tintin.services.interfaces;

import java.time.LocalDate;
import java.util.List;

import tintin.model.Dates;
import tintin.services.exceptions.UserException;

public interface DatesService {
	
	public List<Dates> getDates(LocalDate since, LocalDate till) throws UserException;
	
}
