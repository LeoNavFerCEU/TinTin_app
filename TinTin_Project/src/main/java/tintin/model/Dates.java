package tintin.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Dates {
	private LocalDate date;
	private String courseYear;
	private String internshipPeriod;
}
