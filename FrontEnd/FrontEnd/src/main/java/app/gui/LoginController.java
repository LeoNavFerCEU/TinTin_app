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
import javafx.scene.control.TextField;
import tintin.model.User;

public class LoginController extends AppController{

    @FXML
    private Button btnLogIn;
    
    @FXML
    private Button btnExit;
    
    @FXML
    private PasswordField pfPass;

    @FXML
    private TextField tfUser;
    
    private Alert alert;
    
    @FXML
    void initialize() {
    	alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText(null);
    	alert.setTitle("Error");
    	alert.setContentText("");
    	addParam("ERROR_ALERT", alert);
    }

    @FXML
    void LogIn(ActionEvent event) {
    	String name = tfUser.getText();
    	String pass = DigestUtils.sha256Hex(pfPass.getText());
		Task<User> taskUser = new Task<User>() {

			@Override
			protected User call() throws Exception {
				String url = "http://localhost:8080/user?username=" + name + "&password=" + pass;
				HttpClient client = HttpClient.newHttpClient();
		        HttpRequest request = HttpRequest.newBuilder()
		                .uri(URI.create(url))
		                .header("API-KEY", "fctapikey")
		                .header("Accept", "application/json")
		                .GET()
		                .build();
		        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());;
                ObjectMapper objectMapper = new ObjectMapper();
                User user = objectMapper.readValue(response.body(), User.class);
				return user;
			}
			
			@Override
			protected void succeeded() {
				addParam("USER", getValue());
				addParam("STUDENT", getValue().getLinkedProfile());
				changeScene(FXML_MAIN);
			}
			
			@Override
			protected void failed() {
				alert.setContentText(getException().getMessage());
				alert.showAndWait();
			}
			
		};
		new Thread(taskUser).start();
    }
    
    @FXML
    void exit(ActionEvent event) {
    	System.exit(0);
    }

}
