package app;

import controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.LoginWindow;

public class App extends Application {
	
	public static void main(String[] args) {
		
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.centerOnScreen();

		new LoginController(new LoginWindow(primaryStage));
		
		primaryStage.show();
	}
}
