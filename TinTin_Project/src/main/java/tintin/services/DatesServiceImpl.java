package tintin.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import tintin.model.Dates;
import tintin.services.interfaces.DatesService;

@Service
public class DatesServiceImpl implements DatesService{

	@Override
	public List<Dates> getDates(LocalDate since, LocalDate till) {
		return null;
	}

	
}
