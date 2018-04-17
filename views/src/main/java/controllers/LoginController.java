package controllers;

import javafx.stage.Stage;
import views.LoginWindow;
import views.StudentWindow;
import views.TeacherWindow;

public class LoginController {
	
	public LoginController(LoginWindow window) {
		
		window.setStudentWindowHandler(e -> new StudentController(new StudentWindow(window.getStage()), 1));
		window.setTeacherWindowHandler(e -> new TeacherController(new TeacherWindow(window.getStage()), 1));
		
	}
}
