package app.gui;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import tintin.api.fctregister.request.CreateRegisterRequest;
import tintin.model.Dates;
import tintin.model.FCTRegister;
import tintin.model.Student;

public class AddRecordController extends AppController{

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRegister;

    @FXML
    private ComboBox<String> cbDates;

    @FXML
    private Spinner<Double> spHours;

    @FXML
    private TextArea taDetail;

    private Alert errorAlert;
    
    private Alert infoAlert;
    
    private List<Dates> dates;

    @SuppressWarnings("unchecked")
	@FXML
    public void initialize() {
        // Configurar el SpinnerValueFactory para valores double
        SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0, 0.0, 0.5);
        // Asignar el factory al Spinner
        spHours.setValueFactory(valueFactory);
        
		dates = (List<Dates>) getParam("DATES");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        List<String> formattedDates = new ArrayList<>();
        dates.forEach( date -> formattedDates.add(date.getDate().format(formatter)));
        cbDates.setItems(FXCollections.observableArrayList(formattedDates));
        
        errorAlert = (Alert) getParam("ERROR_ALERT");
    	infoAlert = new Alert(AlertType.INFORMATION);
    	infoAlert.setHeaderText(null);
    	infoAlert.setHeaderText("");
    	infoAlert.setContentText("");
        
    }

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("MAIN_SCREEN");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
    }

    @FXML
    void register(ActionEvent event) {
    	Student student = (Student) getParam("STUDENT");
    	CreateRegisterRequest crRequest = new CreateRegisterRequest();
    	crRequest.setAssociatedStudent(student);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	Dates finalDate = dates.stream().filter(
    			date -> date.getDate().format(formatter).equals(cbDates.getSelectionModel().getSelectedItem()))
    			.collect(Collectors.toList()).get(0);
    	crRequest.setAssociatedDate(finalDate);
    	crRequest.setNumHours(spHours.getValue());
    	crRequest.setDescription(taDetail.getText());
    	Task<FCTRegister> task = new Task<FCTRegister>() {

			@Override
			protected FCTRegister call() throws Exception {
				ObjectMapper mapper = new ObjectMapper();
				mapper.registerModule(new JavaTimeModule());
				String url = "http://localhost:8080/register";
				String requestBody = mapper.writeValueAsString(crRequest);
				HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(url))
		                .header("API-KEY", "fctapikey")
		                .header("Content-Type", "application/json")
		                .header("Accept", "application/json")
		                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
		                .build();
		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());;
		        if (response.statusCode()!= 200) {
					throw new Exception("Error al crear un registro");
				}
		        FCTRegister register = mapper.readValue(response.body(), FCTRegister.class);
				return register;
			}
			
			@Override
			protected void succeeded() {
				infoAlert.setContentText("Register created successfully");
				infoAlert.showAndWait();
			}
    		
			@Override
			protected void failed() {
				errorAlert.setContentText("Error al registrar el estudiante");
				errorAlert.showAndWait();
			}
			
    	};
    	new Thread(task).start();
    	BorderPane mainPane = (BorderPane) getParam("MAIN_SCREEN");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
    }
}