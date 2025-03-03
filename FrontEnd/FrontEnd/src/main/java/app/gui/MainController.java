package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainController extends AppController {

	@FXML
	private BorderPane mainPane;

	@FXML
	private Button btnAboutYou;

	@FXML
	private Button btnChangePass;

	@FXML
	private Button btnExit;

	@FXML
	private Button btnLogOut;

	@FXML
	private Button btnRecords;

	@FXML
	public void initialize() {
		addParam("MAIN_SCREEN", mainPane);
		mainPane.setCenter(loadScene(FXML_ABOUTYOU));
	}

	@FXML
	void ToChangePass(ActionEvent event) {
		mainPane.setCenter(loadScene(FXML_CHANGEPASS));
	}

	@FXML
	void toAboutYou(ActionEvent event) {
		mainPane.setCenter(loadScene(FXML_ABOUTYOU));
	}

	@FXML
	void toLogin(ActionEvent event) {
		changeScene(FXML_LOGIN);
	}

	@FXML
	void toRecords(ActionEvent event) {
		mainPane.setCenter(loadScene(FXML_RECORDS));
	}

	@FXML
	void exit(ActionEvent event) {
		System.exit(0);
	}

}
