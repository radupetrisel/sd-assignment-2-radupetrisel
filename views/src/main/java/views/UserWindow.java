package views;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class UserWindow {

	protected Stage window;
	private BorderPane layout;
	private Scene mainScene;
	private Button viewProfile;
	private Button updateAddress;
	private Button logout;

	public UserWindow(Stage window) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.layout = new BorderPane();

		this.mainScene = new Scene(this.layout, screenSize.getWidth() / 2, screenSize.getHeight() / 2);
		window.setScene(this.mainScene);
		window.centerOnScreen();

		VBox left = new VBox();
		updateAddress = new Button("Update address");
		viewProfile = new Button("View profile");
		logout = new Button("Logout");

		left.setSpacing(20);
		left.setAlignment(Pos.CENTER);
		left.getChildren().addAll(viewProfile, updateAddress);
		this.layout.setLeft(left);

		VBox bottom = new VBox();
		bottom.getChildren().add(logout);
		bottom.setAlignment(Pos.BOTTOM_RIGHT);
		this.setBottom(bottom);

		this.window = window;
	
	}
	
	public Stage getStage() {
		return this.window;
	}

	public void setLeft(Node left) {
		this.layout.setLeft(left);
	}

	public void setRight(Node right) {
		this.layout.setRight(right);
	}

	public void setTop(Node top) {
		this.layout.setTop(top);
	}

	public void setBottom(Node bottom) {
		this.layout.setBottom(bottom);
	}

	public void setCenter(Node center) {
		this.layout.setCenter(center);
	}
	
	public Node getCenter() {
		return this.layout.getCenter();
	}

	public void setViewProfileAction(EventHandler<ActionEvent> e) {
		this.viewProfile.setOnAction(e);
	}
	
	public void setLogoutAction(EventHandler<ActionEvent> e) {
		this.logout.setOnAction(e);
	}
	
	public void setUpdateAddressAction(EventHandler<ActionEvent> e) {
		this.updateAddress.setOnAction(e);
	}
	
	public void setLogoutHandler(EventHandler<ActionEvent> e) {
		this.logout.setOnAction(e);
	}

}
