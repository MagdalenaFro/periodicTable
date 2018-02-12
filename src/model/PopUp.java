package model;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {

	public void display(String text) {
		Stage popupWindow = new Stage();

		popupWindow.initModality(Modality.APPLICATION_MODAL);
		// popupWindow.setTitle("Dodawanie nowego pierwiastka");

		Label label = new Label(text);
		Button button = new Button("Close");

		button.setOnAction(e -> popupWindow.close());

		VBox layout = new VBox(10);

		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout, 300, 200);
		popupWindow.setScene(scene);
		popupWindow.showAndWait();
	}

}
