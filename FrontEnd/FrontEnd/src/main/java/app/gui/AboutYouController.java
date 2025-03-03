package app.gui;

import org.openapitools.client.api.StudentApiSeviceApi;
import org.openapitools.client.model.Student;
import org.openapitools.client.model.StudentDto;
import org.openapitools.client.model.User;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

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
    
    private StudentApiSeviceApi studentApi;
    private Alert errorAlert;
    
    @FXML
    void initialize() {
    	Student student = (Student) getParam("STUDENT");
    	User user = (User) getParam("USER");
    	errorAlert = (Alert) getParam("ERROR_ALERT");
    	studentApi = new StudentApiSeviceApi();
    	Task<StudentDto> taskStudent = new Task<StudentDto>() {

			@Override
			protected StudentDto call() throws Exception {
				return studentApi.getStudent(student.getId());
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
				lblCompanyTutor.setText("");
				lblSchoolTutor.setText(dto.getTutorName());
				lblYear.setText(dto.getCourseYear());
				lblHoursToDo.setText(dto.getHoursTotal().toString());
				lblHoursLeft.setText(dto.getHoursLeft().toString());
				lblHoursDone.setText(dto.getHoursWorked());
			}
			
			@Override
			protected void failed() {
				errorAlert.setContentText(getException().getMessage());
				errorAlert.showAndWait();
			}
    		
    	};
    	new Thread(taskStudent).start();
    }

}

