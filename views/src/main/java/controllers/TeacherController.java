package controllers;

import static services.Requester.get;
import static services.Requester.post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.util.converter.DefaultStringConverter;
import services.ColumnBuilder;
import services.GroupConverter;
import services.StudentConverter;
import services.TableBuilder;
import tableItems.Group;
import tableItems.Student;
import tableItems.StudentReport;
import views.TeacherWindow;

public class TeacherController extends UserController {

	public TeacherController(TeacherWindow window, int teacherId) {

		super(window);
		this.basePath = "http://localhost:8083/asgn2/teacher/" + teacherId;

		this.window.setTop(this.displayHelloMessage());
		window.setCreateStudentHandler(e -> createStudent());
		window.setViewStudentHandler(e -> viewStudents());
		window.setGradeStudentHandler(e -> gradeStudents());
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
				viewStudents(data);
			}
		});

		initBox.getChildren().add(group);

		this.window.setCenter(initBox);
	}

	private void viewStudents(String data) {

		List<Student> students = new StudentConverter().convertList(data);
			
		DefaultStringConverter converter = new DefaultStringConverter();
		EventHandler<CellEditEvent<Student, String>> eventHandler = e -> {
			
			Student s = e.getRowValue();
			JSONObject jo = new JSONObject();
			
			switch(e.getTableColumn().getText()) {
			
			case "Address":
				s.setAddress(e.getNewValue());
				break;
			
			case "Phone":
				s.setPhoneNumber(e.getNewValue());
				break;
			case "Email":
				s.setEmail(e.getNewValue());
				break;
			}
			
			try {
				jo.put("address", s.getAddress())
				.put("phoneNumber", s.getPhoneNumber())
				.put("email", s.getEmail())
				.put("cnp", s.getCnp());
				
				post(basePath + "/updateStudent", jo.toString());
			} catch (JSONException e1) {
				e1.printStackTrace();
			}
			
			
		};
		
		TableView<Student> table = new TableBuilder<Student>()
				.addColumn(new ColumnBuilder<Student, String>()
						.name("First Name")
						.cellValueFactory("firstName")
						.build())
				.addColumn(new ColumnBuilder<Student, String>()
						.name("Last Name")
						.cellValueFactory("lastName")
						.build())
				.addColumn(new ColumnBuilder<Student, String>()
						.name("CNP")
						.cellValueFactory("cnp")
						.build())
				.addColumn(new ColumnBuilder<Student, String>()
						.name("Address")
						.cellValueFactory("address")
						.unsortable()
						.editable(converter)
						.onEditCommit(eventHandler)
						.build())
				.addColumn(new ColumnBuilder<Student, String>()
						.name("Phone")
						.cellValueFactory("phoneNumber")
						.unsortable()
						.editable(converter)
						.onEditCommit(eventHandler)
						.build())
				.addColumn(new ColumnBuilder<Student, String>()
						.name("Email")
						.cellValueFactory("email")
						.unsortable()
						.onEditCommit(eventHandler)
						.editable(converter)
						.build())
				.editable()
				.setItems(students)
				.build();
		
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(7);
		
		box.getChildren().add(table);
		
		Button generateReport = new Button("Generate report");
		
		box.getChildren().add(generateReport);
		
		generateReport.setOnAction(e -> {
			
			StudentReport report = new StudentReport(table.getSelectionModel().getSelectedItem(), LocalDateTime.now());
			try {
				String json = new ObjectMapper().writeValueAsString(report);
				System.out.println(json);
				post(basePath + "/saveReport", json);
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
			
		});
		this.window.setCenter(box);
	}
	
	private void gradeStudents() {
		
		HBox initBox = new HBox();
		initBox.setAlignment(Pos.CENTER);
		initBox.setSpacing(7);

		ComboBox<String> groupComboBox = new ComboBox<String>();
		ComboBox<String> studentComboBox = new ComboBox<String>(FXCollections.observableArrayList());
		ComboBox<String> courseComboBox = new ComboBox<String>(FXCollections.observableArrayList());
		
		String groupsString = get(basePath + "/groups");
		
		List<Group> groups = new GroupConverter().convertList(groupsString);
		groupComboBox.setItems(FXCollections.observableArrayList(groups.stream().map(g -> g.getNumber()).collect(Collectors.toList())));
		
		groupComboBox.setOnAction(e -> {
			
			String group = groupComboBox.getValue();
			
			List<Student> students = groups.get(group.charAt(group.length() - 1) - '0' - 1).getStudents();
			studentComboBox.setItems(FXCollections.observableArrayList(students.stream().map(s -> s.getFirstName() + " " + s.getLastName()).collect(Collectors.toList())));		
		});
		
		TextField grade = new TextField();
		
		studentComboBox.setOnAction(e -> {
			
			String group = groupComboBox.getValue();
			
			List<Student> students = groups.get(group.charAt(group.length() - 1) - '0' - 1).getStudents();
			
			String[] name = studentComboBox.getValue().split(" ");
			
			List<String> courses = students.stream()
					.filter(s -> s.getFirstName().equals(name[0]) && s.getLastName().equals(name[1]))
					.map(s -> s.getCourses())
					.findFirst().get()
					.stream()
					.map(s -> s.getCourse())
					.collect(Collectors.toList());
			
		courseComboBox.setItems(FXCollections.observableArrayList(courses));
			
		});
		
		Button gradeButton = new Button("Grade");
		
		gradeButton.setOnAction(e -> {
			
			String group = groupComboBox.getValue();
			
			List<Student> students = groups.get(group.charAt(group.length() - 1) - '0' - 1).getStudents();
			
			String[] name = studentComboBox.getValue().split(" ");
			
			String course = courseComboBox.getValue();
			
			students.stream()
					.filter(s -> s.getFirstName().equals(name[0]) && s.getLastName().equals(name[1]))
					.map(s -> s.getCourses())
					.findFirst().get()
					.stream()
					.filter(gr -> gr.getCourse().equals(course))
					.forEach(gr -> gr.setGrade(Integer.parseInt(grade.getText())));

			
			Student student = students.stream()
					.filter(s -> s.getFirstName().equals(name[0]) && s.getLastName().equals(name[1]))
					.findFirst().get();
			
			
			String json = null;
			try {
				json = new ObjectMapper().writeValueAsString(student);
			} catch (JsonProcessingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println(json);
			post(basePath + "/gradeStudent", json);
			
		});
	
		initBox.getChildren().addAll(groupComboBox, studentComboBox, courseComboBox, grade, gradeButton);

		this.window.setCenter(initBox);
	}

}
