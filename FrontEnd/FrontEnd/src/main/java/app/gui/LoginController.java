package app.gui;

import org.openapitools.client.ApiException;
import org.openapitools.client.api.UserApiServiceApi;
import org.openapitools.client.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AppController{

    @FXML
    private Button btnLogIn;
    
    @FXML
    private Button btnExit;
    
    @FXML
    private PasswordField pfPass;

    @FXML
    private TextField tfUser;
    
    private UserApiServiceApi userApi;
    
    private Alert alert;
    
    @FXML
    void initialize() {
    	userApi = new UserApiServiceApi();
    	addParam("USER_API", userApi);
    	
    	alert = new Alert(AlertType.ERROR);
    	alert.setHeaderText(null);
    	alert.setTitle("Error");
    	alert.setContentText("");
    	addParam("ERROR_ALERT", alert);
    }

    @FXML
    void LogIn(ActionEvent event) {
    	try {
			User user = userApi.login(tfUser.getText(), pfPass.getText());
			addParam("USER", user);
			addParam("STUDENT", user.getLinkedProfile());
			changeScene(FXML_MAIN);
		} catch (ApiException e) {
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
    }
    
    @FXML
    void exit(ActionEvent event) {
    	System.exit(0);
    }

}
