package tintin.dev.user;

import lombok.Data;

@Data
public class StudentDTO {

	private String fullName;
	private String course;
	private String internshipPeriod;
	private String courseYear;
	private String tutorName;
	private String companyName;
	private Integer totalHours;
	private Integer hoursWorked;
	private Integer hoursLeft;
	
}
