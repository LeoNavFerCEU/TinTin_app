package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;

public class RecordsController extends AppController{

    @FXML
    private Button btnNewRecord;
    
    @FXML
    private Button btnBuscar;

    @FXML
    private RadioButton rbCompletas;

    @FXML
    private RadioButton rbSinCompletar;

    @FXML
    private RadioButton rbTodas;

    @FXML
    private ToggleGroup radioButtonsFIltro;
    
    @FXML
    private TableView<?> table;

    @FXML
    void changeToAddRecords(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_ADDRECORD));
    }

    @FXML
    void consultarRegistros(ActionEvent event) {
    	
    }
}
