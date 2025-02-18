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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "Company ID. Autogenerate on POST requests")
	@Column(name = "company_id")
	private Long id;
	private String name;
	private String tutorName;
	@Column(name = "tutor_email")
	private String tutorMail;
	private String tutorTlfno;
	private Boolean active;
}
