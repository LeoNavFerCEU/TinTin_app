package model;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String username;
	private String password;
	private String tipoPerfil;
	private Student perfilAsociado;
	private Boolean active;
}
