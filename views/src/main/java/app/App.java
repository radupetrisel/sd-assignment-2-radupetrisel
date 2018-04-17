package app;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.LoginWindow;

public class App extends Application {

	public static void main(String[] args) {
		
		JSONObject oj = null;
		try {
			
			oj = new JSONObject()
					.put("firstName", "Radu")
					.put("lastName", "Petrisel")
					.put("cnp", "1960920125844")
					.put("address", "Azuga 3")
					.put("phoneNumber", "0747673818")
					.put("email", "radupetrisel@gmail.com");
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//post("http://localhost:8083/asgn2/student/save", oj.toString());
		
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.centerOnScreen();

		new LoginController(new LoginWindow(primaryStage));
		
		primaryStage.show();
	}
}
