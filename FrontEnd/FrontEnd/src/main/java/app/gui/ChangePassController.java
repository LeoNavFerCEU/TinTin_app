package app.gui;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import tintin.api.user.request.ChangePasswordRequest;
import tintin.model.User;

public class ChangePassController extends AppController{

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnChangePass;

    @FXML
    private PasswordField pfConfirmPass;

    @FXML
    private PasswordField pfNewPass;

    @FXML
    private PasswordField pfOldPass;
    
    private User user;
    
    private Alert errorAlert;
    
    private Alert infoAlert;
    
    @FXML
    void initialize() {
    	user = (User) getParam("USER");
    	errorAlert = (Alert) getParam("ERROR_ALERT");
    	infoAlert = new Alert(AlertType.INFORMATION);
    	infoAlert.setHeaderText(null);
    	infoAlert.setHeaderText("");
    	infoAlert.setContentText("");
    }

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_ABOUTYOU));
    }

    @FXML
    void changePass(ActionEvent event) {
    	ChangePasswordRequest cpRequest = new ChangePasswordRequest();
    	cpRequest.setId(user.getId());
    	cpRequest.setCurrentPassword( DigestUtils.sha256Hex(pfOldPass.getText()));
    	cpRequest.setNewPassword(DigestUtils.sha256Hex(pfNewPass.getText()));
    	Task<Void> taskStudent = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				ObjectMapper mapper = new ObjectMapper();
				String url = "http://localhost:8080/user";
				String requestBody = mapper.writeValueAsString(cpRequest);
				HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(url))
		                .header("API-KEY", "fctapikey")
		                .header("Content-Type", "application/json")
		                .header("Accept", "application/json")
		                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
		                .build();
		        client.send(request, HttpResponse.BodyHandlers.ofString());;
		        return null;
			}
			
			@Override
			protected void succeeded() {
				infoAlert.setContentText("Passowrd changed successfully");
				infoAlert.showAndWait();
				BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
		    	mainPane.setCenter(loadScene(FXML_ABOUTYOU));
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
