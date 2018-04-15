package views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TeacherWindow extends UserWindow {

	public TeacherWindow(Stage window) {

		super(window);
		window.setTitle("Teacher");

		VBox right = new VBox();
		right.setAlignment(Pos.CENTER);
		right.setSpacing(10);

		Button createStudent = new Button("Add student");
		Button deleteStudent = new Button("Delete student");
		Button gradeStudent = new Button("Mark student");
		Button viewStudent = new Button("View student");

		right.getChildren().addAll(createStudent, gradeStudent, viewStudent, deleteStudent);

//		createStudent.setOnAction(e -> createStudent());
//		deleteStudent.setOnAction(e -> deleteStudent());
//		gradeStudent.setOnAction(e -> gradeStudent());
//		viewStudent.setOnAction(e -> viewStudent());

		this.setRight(right);
	}

}
