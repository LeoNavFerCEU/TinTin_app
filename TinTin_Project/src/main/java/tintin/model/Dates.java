package tintin.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Dates {
	@Id
	@NotNull(message = "The date of the register is required")
	private LocalDate date;
	private String courseYear;
	private String internshipPeriod;
}
