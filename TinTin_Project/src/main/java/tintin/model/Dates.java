package tintin.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Dates {
	@Id
	private LocalDate date;
	private String courseYear;
	private String internshipPeriod;
}
