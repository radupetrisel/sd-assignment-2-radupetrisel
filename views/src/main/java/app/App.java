package app;

import controllers.StudentController;
import controllers.TeacherController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import views.StudentWindow;
import views.TeacherWindow;

public class App extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {

		primaryStage.centerOnScreen();

		VBox box = new VBox();
		Scene scene = new Scene(box, 300, 300);
		
		Button studentWindow = new Button("Student");
		Button teacherWindow = new Button("Teacher");
		
		box.getChildren().addAll(teacherWindow, studentWindow);
		box.setAlignment(Pos.CENTER);
		
		studentWindow.setOnAction(e -> new StudentController(new StudentWindow(primaryStage), 1));
		teacherWindow.setOnAction(e -> new TeacherController(new TeacherWindow(primaryStage), 1));
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
