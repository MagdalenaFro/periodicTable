package model;

public class ValidationLibrary {

	public boolean validateIfInteger(String textTovalidate) {
		try {
			Integer.parseInt(textTovalidate);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
