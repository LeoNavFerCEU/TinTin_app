package tintin.api.dates;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tintin.model.Dates;
import tintin.services.interfaces.DatesService;


@RestController
@RequestMapping("dates")
public class DatesApiService {

	@Autowired
	private DatesService datesService;
	
	@GetMapping
	public List<Dates> getDates(@RequestParam LocalDate since,@RequestParam LocalDate until) {
		return datesService.getDates(since, until);
	}
	
	

}
