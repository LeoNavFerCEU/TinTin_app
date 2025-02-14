package tintin.dto;

import lombok.Data;

@Data
public class StudentDto {
	private String fullName;
	private String course;
	private String internshipPeriod;
	private String courseYear;
	private String tutorName;
	private String companyName;
	private Integer hoursTotal;
	private Integer hoursWorked;
	private Integer hoursLeft;
}
