package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class RecordsController extends AppController{

    @FXML
    private Button btnNewRecord;

    @FXML
    void changeToAddRecords(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_ADDRECORD));
    }

}
