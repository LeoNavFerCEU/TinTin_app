package model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FCTRegister {
	private Long id;
	private Student associatedStudent;
	private LocalDate fechaAsociada;
	private Integer numHours;
	private String description;
	
}
