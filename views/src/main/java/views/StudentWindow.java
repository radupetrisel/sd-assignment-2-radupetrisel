package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentWindow extends UserWindow {

	public StudentWindow(Stage window) {
		
		super(window);
		window.setTitle("Student");
		
		VBox right = new VBox();
		right.setAlignment(Pos.CENTER_LEFT);
		right.setSpacing(10);
		
		Button enrol = new Button("Enrol");
		Button viewGrades = new Button("View grades");
		Button deleteProfile = new Button("Delete profile");
		
		right.getChildren().addAll(enrol, viewGrades, deleteProfile);
		this.setRight(right);
		
//		enrol.setOnAction(e -> enrol());
//		viewGrades.setOnAction(e -> viewGrades());
//		deleteProfile.setOnAction(e -> deleteProfile());
	}


}
