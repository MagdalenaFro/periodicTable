package controller.addElement;

import controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import model.Element;
import model.FileOperations;
import model.PopUp;
import model.ValidationLibrary;

public class AddingWindowController {
	private Main main;
	private ObservableList<Integer> periodValues = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7);
	private ObservableList<Integer> groupValues = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18);

	@FXML
	private ChoiceBox periodBox;

	@FXML
	private ChoiceBox groupBox;

	@FXML
	private TextField atomicNumberText;

	@FXML
	private TextField weightText;

	@FXML
	private TextField nameOfElementText;

	@FXML
	private TextField symbolOfElementText;

	@FXML
	private void goHomePage() {
		main.showMainView();
		main.closeAddingWindowStage();
	}

	@FXML
	private void initialize() {
		periodBox.setItems(periodValues);
		groupBox.setItems(groupValues);
	}

	@FXML
	private void saveData() {
		ValidationLibrary validationLibrary = new ValidationLibrary();
		Element element = new Element();
		if (validationLibrary.validateIfInteger(atomicNumberText.getText())
				&& validationLibrary.validateIfInteger(weightText.getText())) {
			element.setAtomicNumber(Integer.parseInt(atomicNumberText.getText()));
			element.setElementName(nameOfElementText.getText());
			element.setGroup(Integer.parseInt(groupBox.getValue().toString()));
			element.setPeriod(Integer.parseInt(periodBox.getValue().toString()));
			element.setWeight(Integer.parseInt(weightText.getText()));
			element.setElementSymbol(symbolOfElementText.getText());

			new FileOperations().saveElementToBase(element);
			goHomePage();

		} else {
			new PopUp().display("Nie uda³o siê poprawnie zapisaæ danych \n - sprawdz wprowadzone wartoœci");
		}

	}
}
