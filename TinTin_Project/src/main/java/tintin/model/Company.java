package tintin.api.server.model;

import lombok.Data;

@Data
public class Company {
	private Long id;
	private String name;
	private String tutorName;
	private String tutorMail;
	private String tutorTlfno;
	private Boolean active;
}
