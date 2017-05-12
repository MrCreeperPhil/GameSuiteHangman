package domain;

import java.util.ArrayList;

public class HintWoord {

	private ArrayList<HintLetter> hintLetters = new ArrayList<>();

	public HintWoord(String woord) {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("Vul een woord in");
		}
		for (char letter : woord.toCharArray()) {
			this.hintLetters.add(new HintLetter(letter));
		}
	}

	public String getWoord() {
		String result = "";
		for (HintLetter letter : hintLetters) {
			result += letter.getLetter();
		}
		return result;
	}

	public boolean isGeraden() {
		for (HintLetter letter : hintLetters) {
			if (!letter.isGeraden()) {
				return false;
			}
		}
		return true;
	}

	public boolean raad(char letter) {
		boolean result = false;
		for (HintLetter hintletter : hintLetters) {
			if (hintletter.raad(letter)) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "";
		for (HintLetter hintletter : hintLetters) {
			result += " " + hintletter.toChar();
		}
		result = result.substring(1);
		return result;
	}

}
