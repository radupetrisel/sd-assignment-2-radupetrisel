package app;

import static services.Requester.post;

import org.json.JSONException;
import org.json.JSONObject;

import controllers.LoginController;
import javafx.application.Application;
import javafx.stage.Stage;
import views.LoginWindow;

public class App extends Application {

	private static final String basePath = "http://localhost:8083/asgn2/root/";
	
	public static void main(String[] args) {
		
//		JSONObject oj = null;
//		try {
//			
//			oj = new JSONObject()
//					.put("firstName", "Radu")
//					.put("lastName", "Petrisel")
//					.put("cnp", "1960920125844")
//					.put("address", "Azuga 3")
//					.put("phoneNumber", "0747673818")
//					.put("email", "radupetrisel@gmail.com")
//					.put("group", "30432");
//			
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		
////		for (int i = 1; i <= 4; i++) {
////			JSONObject group = null;
////			
////			try {
////				group = new JSONObject()
////						.put("groupNo", "3043" + i);
////				post(basePath + "/group", group.toString());
////			} catch (JSONException e) {
////				e.printStackTrace();
////			}
////		}
//		
//		post(basePath + "/student", oj.toString());
		
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.centerOnScreen();

		new LoginController(new LoginWindow(primaryStage));
		
		primaryStage.show();
	}
}
