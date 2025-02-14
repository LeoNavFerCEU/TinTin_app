package tintin.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Student ID. Autogenerate on POST requests")
	@Column(name = "student_id")
	private Long id;
	private String fullName;
	private String course;
	private String internshipPeriod;
	private String courseYear;
	@ManyToOne
	@JoinColumn(name = "school_tutor_id")
	@Column(name = "school_tutor")
	private SchoolTutor tutor;
	@ManyToOne
	@JoinColumn(name = "company_id")
	@Column(name = "assigned_company")
	private Company company;
}
