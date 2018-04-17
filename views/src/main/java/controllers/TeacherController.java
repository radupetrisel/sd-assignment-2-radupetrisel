package controllers;

import static services.Requester.get;
import static services.Requester.post;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import services.StudentConverter;
import services.StudentObserver;
import services.TableBuilder;
import tableItems.Student;
import views.TeacherWindow;

public class TeacherController extends UserController {

	public TeacherController(TeacherWindow window, int teacherId) {

		super(window);
		this.basePath = "http://localhost:8083/asgn2/teacher/" + teacherId;

		this.window.setTop(this.displayHelloMessage());
		window.setCreateStudentHandler(e -> createStudent());
		window.setViewStudentHandler(e -> viewStudents());
	}

	private void createStudent() {

		HBox bigBox = new HBox();
		bigBox.setAlignment(Pos.CENTER);

		VBox labelColumn = new VBox();
		labelColumn.setAlignment(Pos.CENTER_RIGHT);
		labelColumn.setSpacing(20);

		VBox inputColumn = new VBox();
		inputColumn.setAlignment(Pos.CENTER_LEFT);
		inputColumn.setSpacing(10);

		bigBox.getChildren().addAll(labelColumn, inputColumn);

		Label firstNameLabel = new Label("First name: ");
		firstNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label lastNameLabel = new Label("Last name: ");
		lastNameLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label cnpLabel = new Label("CNP: ");
		cnpLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label addressLabel = new Label("Address: ");
		addressLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label emailLabel = new Label("Email: ");
		emailLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label phoneNumberLabel = new Label("Phone: ");
		phoneNumberLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		Label groupLabel = new Label("Group: ");
		groupLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

		TextField firstNameField = new TextField();
		TextField lastNameField = new TextField();
		TextField cnpField = new TextField();
		TextField addressField = new TextField();
		TextField emailField = new TextField();
		TextField phoneNumberField = new TextField();
		TextField groupField = new TextField();

		Button create = new Button("Create");
		create.setAlignment(Pos.BOTTOM_RIGHT);

		labelColumn.getChildren().addAll(firstNameLabel, lastNameLabel, cnpLabel, addressLabel, emailLabel,
				phoneNumberLabel, groupLabel);

		inputColumn.getChildren().addAll(firstNameField, lastNameField, cnpField, addressField, emailField,
				phoneNumberField, groupField, create);

		create.setOnAction(e -> {

			try {
				JSONObject jo = new JSONObject().put("firstName", firstNameField.getText())
						.put("lastName", lastNameField.getText()).put("cnp", cnpField.getText())
						.put("address", addressField.getText()).put("email", emailField.getText())
						.put("phoneNumber", phoneNumberField.getText()).put("group", groupField.getText());

				post(basePath + "/createStudent", jo.toString());

			} catch (JSONException e1) {
				e1.printStackTrace();
			}

			Stage alert = new Stage();
			alert.initModality(Modality.APPLICATION_MODAL);

			VBox alertBox = new VBox();
			alertBox.setAlignment(Pos.CENTER);
			alertBox.setSpacing(10);

			Scene alertScene = new Scene(alertBox, 150, 50);

			Text msg = new Text("Student created succesfully!");
			Button ok = new Button("Ok");

			alertBox.getChildren().addAll(msg, ok);

			ok.setOnAction(a -> alert.close());

			alert.setScene(alertScene);
			alert.showAndWait();
		});

		this.window.setCenter(bigBox);
	}

	// private void deleteStudent() {
	//
	// Stage delete = new Stage();
	// delete.initModality(Modality.APPLICATION_MODAL);
	//
	// VBox box = new VBox();
	// box.setAlignment(Pos.CENTER);
	//
	// Scene scene = new Scene(box, 200, 100);
	//
	// TextField firstName = new TextField();
	// firstName.setPromptText("First name");
	//
	// TextField lastName = new TextField();
	// lastName.setPromptText("Last name");
	//
	// Button del = new Button("Delete");
	//
	// box.getChildren().addAll(firstName, lastName, del);
	//
	// del.setOnAction(e -> {
	//
	// TeacherBL tbl = new TeacherBL();
	//
	// tbl.deleteStudent(tbl.findStudentByName(firstName.getText(),
	// lastName.getText()));
	//
	// delete.close();
	// });
	//
	// delete.setScene(scene);
	// delete.showAndWait();
	// }
	//
	// private void gradeStudent() {
	//
	// HBox box = new HBox();
	// box.setAlignment(Pos.CENTER);
	// box.setSpacing(10);
	//
	// TextField firstName = new TextField();
	// firstName.setPromptText("First name");
	//
	// TextField lastName = new TextField();
	// lastName.setPromptText("Last name");
	//
	// TextField course = new TextField();
	// course.setPromptText("Course");
	//
	// TextField grade = new TextField();
	// grade.setPromptText("Grade");
	//
	// box.getChildren().addAll(firstName, lastName, course, grade);
	//
	// box.setOnKeyPressed(e -> {
	//
	// if (e.getCode().equals(KeyCode.ENTER)) {
	//
	// TeacherBL tbl = new TeacherBL();
	// tbl.giveMarkToStudent(course.getText(),
	// tbl.findStudentByName(firstName.getText(), lastName.getText()),
	// Integer.parseInt(grade.getText()));
	//
	// Stage alert = new Stage();
	// alert.initModality(Modality.APPLICATION_MODAL);
	//
	// VBox vbox = new VBox();
	// Scene alertS = new Scene(vbox, 100, 100);
	//
	// vbox.getChildren().add(new Text("Success"));
	//
	// Button ok = new Button("Ok");
	//
	// vbox.getChildren().add(ok);
	//
	// ok.setOnAction(a -> alert.close());
	//
	// alert.setScene(alertS);
	// alert.showAndWait();
	// }
	//
	// });
	//
	// this.setCenter(box);
	// }
	//
	private void viewStudents() {

		HBox initBox = new HBox();
		initBox.setAlignment(Pos.CENTER);
		initBox.setSpacing(7);

		TextField group = new TextField();
		group.setPromptText("Group");

		this.window.setCenter(initBox);
		initBox.setOnKeyPressed(e -> {

			if (e.getCode().equals(KeyCode.ENTER)) {

				String data = get(basePath + "/viewStudents?group=" + group.getText());
				displayStudents(data);
			}
		});

		initBox.getChildren().add(group);

		this.window.setCenter(initBox);
	}

	private void displayStudents(String data) {

		List<Student> students = new StudentConverter().convert(data);
		
		EventHandler<CellEditEvent<Student, String>> event = e -> {
							
				Student student = e.getRowValue();
				
				switch(e.getTableColumn().getText()) {
					case "Address":
						student.setAddress(e.getNewValue());
						break;
					case "Phone":
						student.setPhoneNumber(e.getNewValue());
						break;
					case "Email":
						student.setEmail(e.getNewValue());
						break;
				}
				
				try {
					
					JSONObject jo = new JSONObject()
							.put("address", student.getAddress())
							.put("phoneNumber", student.getPhoneNumber())
							.put("email", student.getEmail())
							.put("cnp", student.getCnp());
					
					post(basePath + "/updateStudent", jo.toString());
					
				} catch (JSONException e1) {
					e1.printStackTrace();
				}

			};

		TableView<Student> table = new TableBuilder<Student>().addColumn("First name", "firstName", false)
				.addColumn("Last name", "lastName", false).addColumn("CNP", "cnp", false)
				.addColumn("Address", "address", event)
				.addColumn("Phone", "phoneNumber", event)
				.addColumn("Email", "email", event)
				.setEditable(true)
				.setItems(students)
				.build();

		this.window.setCenter(table);
	}

}
