package controllers;

import static services.Requester.get;
import static services.Requester.post;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import views.LoginWindow;
import views.UserWindow;

public abstract class UserController {
	
	protected UserWindow window;
	protected int userId;
	protected String basePath;
	
	@SuppressWarnings("unchecked")
	public UserController(UserWindow u) {
		
		this.window = u;
		
		this.window.setViewProfileAction(e -> {
			
			String json = get(basePath + "/profile");
			
			Map<String, String> data = null;
			
			try {
				data = new ObjectMapper().readValue(json, HashMap.class);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			viewProfile(data);
		});
		
		this.window.setUpdateAddressAction(e -> this.updateAddress());
		this.window.setLogoutAction(e -> new LoginController(new LoginWindow(window.getStage())));
		
	}
	
	protected VBox displayHelloMessage() {
		
		String json = get(basePath + "/profile");

		Map<String, String> data = null;
		
		try {
			data = new ObjectMapper().readValue(json, HashMap.class);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Text hello = new Text("Hello " + data.get("firstName") + "!");
		hello.setFont(Font.font("Times New Roman", 25));
		hello.setSmooth(true);

		VBox helloBox = new VBox();
		helloBox.getChildren().add(hello);
		helloBox.setAlignment(Pos.CENTER);

		return helloBox;
	}
	
	protected void viewProfile(Map<String, String> data) {
		
		VBox profileBox = new VBox();
		profileBox.setAlignment(Pos.CENTER);
		profileBox.setSpacing(7);
		
		HBox firstNameBox = new HBox();
		HBox lastNameBox = new HBox();
		HBox cnpBox = new HBox();
		HBox addressBox = new HBox();
		HBox emailBox = new HBox();
		HBox phoneNumberBox = new HBox();
		
		firstNameBox.setAlignment(Pos.CENTER);
		lastNameBox.setAlignment(Pos.CENTER);
		cnpBox.setAlignment(Pos.CENTER);
		addressBox.setAlignment(Pos.CENTER);
		emailBox.setAlignment(Pos.CENTER);
		phoneNumberBox.setAlignment(Pos.CENTER);
			
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
		
		Text firstNameText = new Text(data.get("firstName"));
		Text lastNameText = new Text(data.get("lastName"));
		Text cnpText = new Text(data.get("cnp"));
		Text addressText = new Text(data.get("address"));
		Text emailText = new Text(data.get("email"));
		Text phoneNumberText = new Text(data.get("phoneNumber"));
		
		firstNameBox.getChildren().addAll(firstNameLabel, firstNameText);
		lastNameBox.getChildren().addAll(lastNameLabel, lastNameText);
		cnpBox.getChildren().addAll(cnpLabel, cnpText);
		addressBox.getChildren().addAll(addressLabel, addressText);
		emailBox.getChildren().addAll(emailLabel, emailText);
		phoneNumberBox.getChildren().addAll(phoneNumberLabel, phoneNumberText);
		
		profileBox.getChildren().addAll(firstNameBox, lastNameBox, cnpBox, addressBox, emailBox, phoneNumberBox);
		
		this.window.setCenter(profileBox);
	}
	
	private void updateAddress() {

		HBox box = new HBox();
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);

		Label newAddressLabel = new Label("New address: ");
		TextField newAddressField = new TextField();
		Text success = new Text("Success");
		success.setFill(Color.GREEN);
		success.setVisible(false);

		box.setOnKeyPressed(e -> {

			if (e.getCode().equals(KeyCode.ENTER)) {

				JSONObject jo = null;
				try {
					jo = new JSONObject()
							.put("address", newAddressField.getText());
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
				
				post(basePath + "/updateAddress", jo.toString());
				success.setVisible(true);
			}
		});

		box.getChildren().addAll(newAddressLabel, newAddressField, success);
		this.window.setCenter(box);
	}
}
