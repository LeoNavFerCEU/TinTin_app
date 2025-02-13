package app;

import app.gui.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController controller = new AppController(primaryStage);
		controller.changeScene(AppController.FXML_LOGIN);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
	
}
