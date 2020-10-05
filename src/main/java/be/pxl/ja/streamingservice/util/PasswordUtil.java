package be.pxl.ja.streamingservice.util;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";

	public static int calculateStrength(String password) {
		int score;
		if (password.length() < 6) {
			score = 0;
		} else {
			if (password.length() < 10) {
				score = 1;
			} else {
				score = 2;
			}
			boolean containsDigits = false;
			boolean containsLowerCaseLetters = false;
			boolean containsUpperCaseLetters = false;
			boolean containsSpecialCharacters = false;
			for (int i = 0; i < password.length(); i++) {
				char character = password.charAt(i);
				if (Character.isDigit(character)) {
					containsDigits = true;
				}
				if (Character.isLowerCase(character)) {
					containsLowerCaseLetters = true;
				}
				if (Character.isUpperCase(character)) {
					containsUpperCaseLetters = true;
				}
				if (SPECIAL_CHARACTERS.indexOf(character) != -1) {
					containsSpecialCharacters = true;
				}
			}
			if (containsDigits) {
				score += 2;
			} if (containsLowerCaseLetters) {
				score += 2;
			} if (containsUpperCaseLetters) {
				score += 2;
			} if (containsSpecialCharacters) {
				score += 2;
			}
		}
		return score;
	}
}
