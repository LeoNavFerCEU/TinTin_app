package model;

import lombok.Data;

@Data
public class FCTRegister {
	private Long id;
	private Student associatedStudent;
	private Dates associatedDatePeriod;
	private Integer numHours;
	private String description;
	
}
