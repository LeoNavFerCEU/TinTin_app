package tintin.dto;

import lombok.Data;

@Data
public class StudentDto {
	private String fullName;
	private String course;
	private String internshipPeriod;
	private String courseYear;
	private String SchoolTutorName;
	private String companyTutorName;
	private String companyName;
	private Integer hoursTotal;
	private String hoursWorked;
	private Double hoursLeft;
}
