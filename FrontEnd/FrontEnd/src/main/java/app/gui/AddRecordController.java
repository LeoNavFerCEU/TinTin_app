package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class AddRecordController extends AppController{

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRegister;

    @FXML
    private ComboBox<?> cbDates; // Asegúrate de tipar correctamente el ComboBox si es necesario

    @FXML
    private Spinner<Double> spHours; // Cambia Spinner<?> a Spinner<Double>

    @FXML
    private TextArea taDetail;

    @FXML
    public void initialize() {
        // Configurar el SpinnerValueFactory para valores double
        SpinnerValueFactory.DoubleSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 100.0, 0.0, 0.5);

        // Asignar el factory al Spinner
        spHours.setValueFactory(valueFactory);
    }

    @FXML
    void cancel(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
        
    }

    @FXML
    void register(ActionEvent event) {
    	BorderPane mainPane = (BorderPane) getParam("Pantalla Principal");
    	mainPane.setCenter(loadScene(FXML_RECORDS));
    }
}