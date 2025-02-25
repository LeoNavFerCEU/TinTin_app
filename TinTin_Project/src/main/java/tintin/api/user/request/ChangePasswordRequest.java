package tintin.api.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangePasswordRequest {
	@NotNull(message = "Student ID is required")
	private Long Id;
	@NotBlank(message = "Current password is required")
	private String currentPassword;
	@NotBlank(message = "New password is required")
	private String newPassword;

}
