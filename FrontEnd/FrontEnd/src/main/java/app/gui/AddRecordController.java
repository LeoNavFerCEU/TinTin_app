package app.gui;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openapitools.client.api.FctRegisterApiServiceApi;
import org.openapitools.client.model.CreateRegisterRequest;
import org.openapitools.client.model.Dates;
import org.openapitools.client.model.FCTRegister;
import org.openapitools.client.model.Student;

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
    
    private FctRegisterApiServiceApi fctApi;

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
        
        fctApi = new FctRegisterApiServiceApi();
        
        errorAlert = (Alert) getParam("ERROR_ALERT");
    	infoAlert = new Alert(AlertType.INFORMATION);
    	infoAlert.setHeaderText(null);
    	infoAlert.setHeaderText("");
    	infoAlert.setContentText("");
        
    }

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
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
				return fctApi.createRegister(crRequest);
			}
			
			@Override
			protected void succeeded() {
				infoAlert.setContentText("Register created successfully");
				infoAlert.showAndWait();
			}
    		
			@Override
			protected void failed() {
				errorAlert.setContentText(getException().getMessage());
				errorAlert.showAndWait();
			}
			
    	};
    	new Thread(task).start();
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
    }
}