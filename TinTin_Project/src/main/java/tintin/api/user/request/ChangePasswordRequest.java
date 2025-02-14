package tintin.api.user.request;

import lombok.Data;

@Data
public class ChangePasswordRequest {

	private Long Id;
	private String currentPassword;
	private String newPassword;

}
