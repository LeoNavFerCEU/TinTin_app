package tintin.api.server.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Dates {
	private LocalDate date;
	private String courseYear;
	private String internshipPeriod;
}
