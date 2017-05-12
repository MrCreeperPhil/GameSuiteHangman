package domain;

public class HintLetter {

	private char letter;
	private boolean geraden = false;

	public HintLetter(char letter) {
		this.letter = letter;
	}

	public boolean isGeraden() {
		return this.geraden;
	}

	public boolean raad(char letter) {
		if (this.isGeraden()) {
			return false;
		} else {
			if (Character.toLowerCase(letter) == Character.toLowerCase(this.getLetter())) {
				this.geraden = true;
			}
			return Character.toLowerCase(letter) == Character.toLowerCase(this.getLetter());
		}
	}

	public char toChar() {
		if (this.isGeraden()) {
			return this.getLetter();
		} else {
			return '_';
		}
	}

	public char getLetter() {
		return this.letter;
	}

}
