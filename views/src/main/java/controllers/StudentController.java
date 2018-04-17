package controllers;

import static services.Requester.get;
import static services.Requester.post;

import java.util.List;
import java.util.Map;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import services.GradeConverter;
import services.TableBuilder;
import tableItems.Grade;
import views.StudentWindow;

public class StudentController extends UserController {

	public StudentController(StudentWindow window, int studentId) {

		super(window);
		this.basePath = "http://localhost:8083/asgn2/student/" + studentId;

		this.window.setTop(this.displayHelloMessage());
		window.setViewGradesHandler(e -> {

			String data = get(basePath + "/viewGrades");
			List<Grade> grades = new GradeConverter().convert(data);

			TableView<Grade> table = new TableBuilder<Grade>().addColumn("Course", "course", false).addColumn("Grade", "grade", false)
					.setEditable(false).setItems(grades).build();

			viewGrades(table);
		});
		
		window.setEnrolHandler(e -> enrol());
	}

	private void viewGrades(TableView<Grade> table) {

		window.setCenter(table);
	}
	
	@Override
	protected void viewProfile(Map<String, String> data) {
		
		super.viewProfile(data);
		
		Label groupLabel = new Label("Group: ");
		groupLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Text groupText = new Text(data.get("group"));
		
		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(groupLabel, groupText);
		
		((VBox)this.window.getCenter()).getChildren().add(box);
	}

	private void enrol() {

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);

		Label courseNameLabel = new Label("Course ");
		TextField courseName = new TextField();
		Text success = new Text("Success");
		success.setFill(Color.GREEN);
		success.setVisible(false);

		box.setOnKeyPressed(e -> {

			if (e.getCode().equals(KeyCode.ENTER)) {
				
				String body = post(basePath + "/enrol", courseName.getText());
				System.out.println(body);
				success.setVisible(true);
			}
		});

		box.getChildren().addAll(courseNameLabel, courseName, success);
		this.window.setCenter(box);

	}
}
