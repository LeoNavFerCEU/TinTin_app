package tintin.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SchoolTutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "School Tutor ID. Autogenerate on POST requests")
	@Column(name = "school_tutor_id")
	private Long id;
	private String fullName;
	private Boolean active;
}
