package tintin.model;

import lombok.Data;

@Data
public class Student {
	private Long id;
	private String fullName;
	private String course;
	private String internshipPeriod;
	private String courseYear;
	private SchoolTutor tutor;
	private Company company;
}
