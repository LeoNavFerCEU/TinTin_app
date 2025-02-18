package tintin.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "User ID. Autogenerate on POST requests")
	@Column(name = "user_id")
	private Long id;
	private String username;
	private String password;
	private String profileType;
	@OneToOne
	@JoinColumn(name = "linked_profile")
	private Student linkedProfile;
	private Boolean active;
}
