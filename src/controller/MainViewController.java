package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Element;
import model.FileOperations;

public class MainViewController implements Initializable {
	private Main main;

	@FXML
	private TableView<Element> table;

	@FXML
	private TableColumn<Element, String> atomicNumber;

	@FXML
	private TableColumn<Element, String> elementName;

	private ArrayList<Element> elements;

	@FXML
	private GridPane elementsTable;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FileOperations fileOperations = new FileOperations();
		elements = fileOperations.readFromFile();
		if (elements != null & elements.size() != 0) {
			ObservableList<Element> data = FXCollections.observableArrayList(elements);
			table.itemsProperty().setValue(data);
			atomicNumber.setSortType(TableColumn.SortType.ASCENDING);
			table.getSortOrder().add(atomicNumber);
			atomicNumber.setCellValueFactory(new PropertyValueFactory<Element, String>("atomicNumber"));
			elementName.setCellValueFactory(new PropertyValueFactory<Element, String>("elementName"));

			SortedList<Element> sortedData = new SortedList<>(data);
			sortedData.comparatorProperty().bind(table.comparatorProperty());
			table.setItems(sortedData);

			putElementsToGridPane();
		}
	}

	private void putElementsToGridPane() {
		elements.stream().forEach(element -> {
			Label label = new Label();
			label.setText(element.getElementSymbol());
			label.setStyle("-fx-font-weight: bold; -fx-font-size: 16pt; ");
			elementsTable.setHalignment(label, HPos.CENTER);
			elementsTable.setRowIndex(label, element.getPeriod() - 1);
			elementsTable.setColumnIndex(label, element.getGroup() - 1);
			elementsTable.getChildren().addAll(label);
		});

	}

	@FXML
	private void goToAddingWindow() throws IOException {
		main.showAddingWindowStage();
	}

	public void closeProgram(ActionEvent actionEvent) {
		Platform.exit();
		System.exit(0);
	}

}