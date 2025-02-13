package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AppController{

    @FXML
    private Button btLogIn;

    @FXML
    private PasswordField pfPass;

    @FXML
    private TextField tfUser;

    @FXML
    void LogIn(ActionEvent event) {
    	changeScene(FXML_MAIN);
    }

}
