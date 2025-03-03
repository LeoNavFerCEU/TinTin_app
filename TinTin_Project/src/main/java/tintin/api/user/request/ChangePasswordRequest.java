package tintin.api.user.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChangePasswordRequest {
	@NotNull(message = "Student ID is required")
	@Valid
	private Long id;
	
	@NotBlank(message = "Current password is required")
	@Valid
	private String currentPassword;
	
	@NotBlank(message = "New password is required")
	@Valid
	private String newPassword;

}
