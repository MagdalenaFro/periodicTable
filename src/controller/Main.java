package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane root;
	private static Stage addingStage;

	@Override
	public void start(Stage primaryStage) {
		try {
			Main.primaryStage = primaryStage;
			Main.primaryStage.setTitle("Periodic table of elements");

			showMainView();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void showMainView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MainView.fxml"));
			root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add("controller/application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void showAddingWindowStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("addElement/AddingWindow.fxml"));
		BorderPane addingWindowBP = loader.load();
		// root.setCenter(addingWindowBP);
		addingStage = new Stage();
		addingStage.setTitle("Dodawanie pierwiastka");
		addingStage.initModality(Modality.WINDOW_MODAL);
		addingStage.initOwner(primaryStage);

		Scene addingScene = new Scene(addingWindowBP);
		addingScene.getStylesheets().add("controller/application.css");
		addingStage.setScene(addingScene);
		addingStage.showAndWait();
	}

	public static void closeAddingWindowStage() {
		addingStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
