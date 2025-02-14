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
public class FCTRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "FCT ID. Autogenerate on POST requests")
	@Column(name = "fct_register_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student associatedStudent;
	@ManyToOne
	@JoinColumn(name = "date")
	@Column(name = "associated_date")
	private Dates associatedDatePeriod;
	@Column(name = "hours")
	private Integer numHours;
	private String description;
	
}
