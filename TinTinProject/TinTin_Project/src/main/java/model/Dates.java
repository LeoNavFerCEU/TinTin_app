package model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Dates {
	private Long id;
	private LocalDate date;
	private String courseYear;
	private String evaluation;
}
