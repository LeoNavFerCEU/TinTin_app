package app.gui;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import tintin.dto.StudentDto;
import tintin.model.Student;
import tintin.model.User;

public class AboutYouController extends AppController{

    @FXML
    private Label fullName;

    @FXML
    private Label lblCompany;

    @FXML
    private Label lblCompanyTutor;

    @FXML
    private Label lblCourse;

    @FXML
    private Label lblEva;

    @FXML
    private Label lblHoursDone;

    @FXML
    private Label lblHoursLeft;

    @FXML
    private Label lblHoursToDo;

    @FXML
    private Label lblProfile;

    @FXML
    private Label lblSchoolTutor;

    @FXML
    private Label lblYear;

    @FXML
    private Label username;
    
    private Alert errorAlert;
    
    @FXML
    void initialize() {
    	Student student = (Student) getParam("STUDENT");
    	User user = (User) getParam("USER");
    	errorAlert = (Alert) getParam("ERROR_ALERT");
    	Task<StudentDto> taskStudent = new Task<StudentDto>() {

			@Override
			protected StudentDto call() throws Exception {
				String url = "http://localhost:8080/student/" + student.getId();
				HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(url))
		                .header("API-KEY", "fctapikey")
		                .header("Accept", "application/json")
		                .GET()
		                .build();
		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());;
		        ObjectMapper objectMapper = new ObjectMapper();
                StudentDto student = objectMapper.readValue(response.body(), StudentDto.class);
				return student;
			}
			
			@Override
			protected void succeeded() {
				StudentDto dto = getValue();
				fullName.setText(dto.getFullName()); 
				username.setText("@" + user.getUsername());
				lblProfile.setText(user.getProfileType());
				lblCourse.setText(dto.getCourse());
				lblEva.setText(dto.getInternshipPeriod());
				lblCompany.setText(dto.getCompanyName());
				lblCompanyTutor.setText(dto.getCompanyTutorName());
				lblSchoolTutor.setText(dto.getSchoolTutorName());
				lblYear.setText(dto.getCourseYear());
				lblHoursToDo.setText(dto.getHoursTotal().toString());
				lblHoursLeft.setText(dto.getHoursLeft().toString());
				lblHoursDone.setText(dto.getHoursWorked());
			}
			
			@Override
			protected void failed() {
				errorAlert.setContentText(getException().getLocalizedMessage());
				errorAlert.showAndWait();
			}
    		
    	};
    	new Thread(taskStudent).start();
    }

}

