package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileOperations {
	private ArrayList<Element> elements;
	private Element currentElement;

	public ArrayList<Element> readFromFile() {
		try {
			File file = new File(Dictionary.BASE_NAME);
			if (file.exists()) {
				readEachLine(file);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return elements;
	}

	private void readEachLine(File file) throws IOException {
		elements = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(Dictionary.BASE_NAME));
			String currentLine;
			do {
				currentLine = bufferedReader.readLine();
				elements.add(convertToElement(currentLine));
			} while (currentLine != null);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		} finally {
			bufferedReader.close();
		}
	}

	private Element convertToElement(String currentLine) {
		currentElement = new Element();
		String[] currentLineArray = currentLine.split(Dictionary.COMMA);
		currentElement.setAtomicNumber(Integer.parseInt(currentLineArray[0]));
		currentElement.setElementName(currentLineArray[1]);
		currentElement.setPeriod(Integer.parseInt(currentLineArray[2]));
		currentElement.setGroup(Integer.parseInt(currentLineArray[3]));
		currentElement.setWeight(Integer.parseInt(currentLineArray[4]));
		currentElement.setElementSymbol(currentLineArray[5]);

		return currentElement;

	}

	public void saveElementToBase(Element element) {
		try {
			FileWriter fileWriter = new FileWriter(Dictionary.BASE_NAME, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(convvertToLine(element));
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private String convvertToLine(Element element) {
		StringBuilder builder = new StringBuilder();
		builder.append(element.getAtomicNumber());
		builder.append(Dictionary.COMMA);
		builder.append(element.getElementName());
		builder.append(Dictionary.COMMA);
		builder.append(element.getPeriod());
		builder.append(Dictionary.COMMA);
		builder.append(element.getGroup());
		builder.append(Dictionary.COMMA);
		builder.append(element.getWeight());
		builder.append(Dictionary.COMMA);
		builder.append(element.getElementSymbol());

		return builder.toString();
	}
}
