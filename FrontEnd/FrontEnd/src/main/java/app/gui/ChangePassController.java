package app.gui;

import org.openapitools.client.api.UserApiServiceApi;
import org.openapitools.client.model.ChangePasswordRequest;
import org.openapitools.client.model.User;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

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
    
    private UserApiServiceApi userApi;
    
    private User user;
    
    private Alert errorAlert;
    
    private Alert infoAlert;
    
    @FXML
    void initialize() {
    	userApi = new UserApiServiceApi();
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
    	cpRequest.setCurrentPassword(pfOldPass.getText());
    	cpRequest.setNewPassword(pfNewPass.getText());
    	Task<Void> taskStudent = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				userApi.changePassword(cpRequest);
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
