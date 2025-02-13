package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    void cancel(ActionEvent event) {
    	
    }

    @FXML
    void changePass(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla principal");
    	mainPane.setCenter(loadScene(FXML_ABOUTYOU));
    }

}
