package app.gui;

import org.openapitools.client.api.FctRegisterApiServiceApi;

import app.model.Record;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class RecordController extends AppController{

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnDelete;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblHours;

    @FXML
    private TextArea taDetail;
    
    private FctRegisterApiServiceApi fctApi;
    
    private Alert errorAlert;
    
    private Alert infoAlert;
    
    private Record record;
    
    @FXML
    void initialize() {
    	fctApi = new FctRegisterApiServiceApi();
    	record = (Record) getParam("RECORD");
    	
    	errorAlert = (Alert) getParam("ERROR_ALERT");
    	infoAlert = new Alert(AlertType.INFORMATION);
    	infoAlert.setHeaderText(null);
    	infoAlert.setHeaderText("");
    	infoAlert.setContentText("");
    	
    	lblDate.setText(record.getDate());
    	lblHours.setText(record.getHours().toString());
    	taDetail.setText(record.getDetails());
    }

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
    }

    @FXML
    void delete(ActionEvent event) {
    	Task<Void> task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				fctApi.deleteRegister(record.getIdRegister());
				return null;
			}
			
			@Override
			protected void succeeded() {
				infoAlert.setContentText("Register deleted successfully");
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
