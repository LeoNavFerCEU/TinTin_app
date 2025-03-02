package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_ADDRECORD));
    }

    @FXML
    void delete(ActionEvent event) {
    	
    }

}
