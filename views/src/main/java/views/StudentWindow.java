package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StudentWindow extends UserWindow {

	private Button viewGrades;
	private Button enrol;
	
	public StudentWindow(Stage window) {
		
		super(window);
		window.setTitle("Student");
		
		VBox right = new VBox();
		right.setAlignment(Pos.CENTER_LEFT);
		right.setSpacing(10);
		
		enrol = new Button("Enrol");
		viewGrades = new Button("View grades");
		
		right.getChildren().addAll(enrol, viewGrades);
		this.setRight(right);
	}
	
	public void setViewGradesHandler(EventHandler<ActionEvent> e) {
		this.viewGrades.setOnAction(e);
	}
	
	public void setEnrolHandler(EventHandler<ActionEvent> e) {
		this.enrol.setOnAction(e);
	}
	
	


}
