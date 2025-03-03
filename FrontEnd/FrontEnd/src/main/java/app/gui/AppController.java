package app.gui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {

	private static final String PATH_BASE = "/app/gui/";
	
	public static String FXML_LOGIN	= PATH_BASE + "Login.fxml";
	public static String FXML_MAIN = PATH_BASE + "Main.fxml";
	public static String FXML_ABOUTYOU = PATH_BASE + "AboutYou.fxml";
	public static String FXML_RECORDS = PATH_BASE + "Records.fxml";
	public static String FXML_ADDRECORD = PATH_BASE + "AddRecord.fxml";
	public static String FXML_CHANGEPASS = PATH_BASE + "ChangePass.fxml";
	public static String FXML_RECORD = PATH_BASE + "Record.fxml";
	
	private static Stage primaryStage;
	
	public AppController() {
		
	}
	
	public AppController(Stage stage){
		primaryStage = stage;
	}
	
	
	public AppController changeScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			primaryStage.setScene(scene);
			return loader.getController();
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Parent loadScene(String fxml) {
		try {
			FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
			Scene scene = new Scene(loader.load());
			return scene.getRoot();
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void addParam(String key, Object param) {
		@SuppressWarnings("unchecked")
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		if (mapa == null) {
			mapa = new HashMap<String, Object>();
			primaryStage.setUserData(mapa);
		}
		mapa.put(key, param);
	}
	
	public Object getParam(String key) {
		@SuppressWarnings("unchecked")
		Map<String, Object> mapa = (Map<String, Object>) primaryStage.getUserData();
		return mapa.get(key);
	}
	
	public void mostrarError(String mensaje) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setTitle("Error");
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
	
}



