package model;

import lombok.Data;

@Data
public class Usuario {
	private String nombre;
	private String contraseña;
	private String alumno;
	private Alumno alumnoAsociado;
	private Boolean activo;
	
}
