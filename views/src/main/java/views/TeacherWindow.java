package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherWindow extends UserWindow {

	private Button createStudent;
	private Button deleteStudent;
	private Button gradeStudent;
	private Button viewStudent;
	
	public TeacherWindow(Stage window) {

		super(window);
		window.setTitle("Teacher");

		VBox right = new VBox();
		right.setAlignment(Pos.CENTER);
		right.setSpacing(10);

		createStudent = new Button("Add student");
		deleteStudent = new Button("Delete student");
		gradeStudent = new Button("Mark student");
		viewStudent = new Button("View student");

		right.getChildren().addAll(createStudent, gradeStudent, viewStudent, deleteStudent);

		this.setRight(right);
	}
	
	public void setCreateStudentHandler(EventHandler<ActionEvent> e) {
		this.createStudent.setOnAction(e);
	}
	
	public void setDeleteStudentHandler(EventHandler<ActionEvent> e) {
		this.deleteStudent.setOnAction(e);
	}
	
	public void setGradeStudentHandler(EventHandler<ActionEvent> e) {
		this.gradeStudent.setOnAction(e);
	}
	
	public void setViewStudentHandler(EventHandler<ActionEvent> e) {
		this.viewStudent.setOnAction(e);
	}
}
