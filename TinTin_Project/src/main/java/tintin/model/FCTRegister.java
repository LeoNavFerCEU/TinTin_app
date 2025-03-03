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
@Entity(name = "fct_register")
public class FCTRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "FCT ID. Autogenerate on POST requests")
	@Column(name = "fct_register_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "associated_student")
	private Student associatedStudent;
	@ManyToOne
	@JoinColumn(name = "associated_date")
	private Dates associatedDate;
	@Column(name = "hours")
	private Double numHours;
	private String description;
	
}
