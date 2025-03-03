package tintin.api.fctregister.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tintin.model.Dates;
import tintin.model.Student;

@Data
public class CreateRegisterRequest {
	
	@Valid
	private Student associatedStudent;
	@Valid
	private Dates associatedDate;
	@NotNull(message = "An hour is required to make a register")
	@Min(value = 0L,message = "The minimun number of hours is 0.5")
	@Max(value = 8L,message = "The maximun number of hours is 8")
	private Double numHours;
	@NotBlank(message = "A description is required to make a register")
	private String description;

}
