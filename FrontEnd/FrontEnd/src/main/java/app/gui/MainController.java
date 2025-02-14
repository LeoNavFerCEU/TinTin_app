package app.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainController extends AppController{

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

    public void initialize() {
    	cargarPantalla(FXML_ABOUTYOU);
	}
    
    @FXML
    void cambiarVentana(ActionEvent event) {
        // Obtener el botón que disparó el evento
        Button botonPresionado = (Button) event.getSource();
        addParam("Pantalla Principal", mainPane);
        // Determinar qué pantalla cargar según el botón
        String fxmlFile = "";
        if (botonPresionado == btnAboutYou) {
            fxmlFile = "/app/gui/AboutYou.fxml";
        } else if (botonPresionado == btnChangePass) {
            fxmlFile = "/app/gui/ChangePass.fxml";
        } else if (botonPresionado == btnRecords) {
            fxmlFile = "/app/gui/Records.fxml";
        } else if (botonPresionado == btnLogOut) {
            fxmlFile = "/app/gui/Login.fxml";
        }
        
        // Cargar la pantalla correspondiente
        if (!fxmlFile.isEmpty()) {
        	if (fxmlFile.equals("/app/gui/Login.fxml")) {
        		changeScene(FXML_LOGIN);
        	} else {
        		cargarPantalla(fxmlFile);        		
        	}
        }
    }
    
    private void cargarPantalla(String fxmlFile) {
        try {
            // Cargar el archivo FXML
            Parent pantalla = loadScene(fxmlFile);
            // Limpiar el contenido actual y mostrar la nueva pantalla
            mainPane.setCenter(pantalla);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	@FXML
    void Exit(ActionEvent event) {
        System.exit(0);
    }

}
