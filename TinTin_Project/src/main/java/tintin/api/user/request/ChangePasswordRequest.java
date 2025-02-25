package tintin.api.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChangePasswordRequest {
	@NotBlank(message = "Student ID is required")
	private Long Id;
	@NotBlank(message = "Current password is required")
	private String currentPassword;
	@NotBlank(message = "New password is required")
	private String newPassword;

}
