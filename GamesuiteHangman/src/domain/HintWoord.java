package domain;

import java.util.ArrayList;

public class HintWoord {

	private ArrayList<HintLetter> hintLetters;

	public HintWoord(String woord) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "HintWoord []";
	}

}
