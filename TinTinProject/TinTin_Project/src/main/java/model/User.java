package model;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String username;
	private String password;
	private String profileType;
	private Student associatedProfile;
	private Boolean active;
}
