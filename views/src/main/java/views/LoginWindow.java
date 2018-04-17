package views;

import controllers.StudentController;
import controllers.TeacherController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginWindow {

	private Button studentWindow;
	private Button teacherWindow;
	private Stage stage;

	public LoginWindow(Stage window) {
		
		this.stage = window;
		VBox box = new VBox();
		Scene scene = new Scene(box, 300, 300);

		studentWindow = new Button("Student");
		teacherWindow = new Button("Teacher");

		box.getChildren().addAll(teacherWindow, studentWindow);
		box.setAlignment(Pos.CENTER);
		
		window.setScene(scene);
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public void setStudentWindowHandler(EventHandler<ActionEvent> e) {
		studentWindow.setOnAction(e);
	}

	public void setTeacherWindowHandler(EventHandler<ActionEvent> e) {
		teacherWindow.setOnAction(e);
	}

}
