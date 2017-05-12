package domain;

public class Speler {
	private String naam;
	private int score = 0;

	public Speler(String naam) {
		setNaam(naam);

	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new DomainException("Dit mag niet");
		} else {
			this.naam = naam;
		}
	}

	public int getScore() {
		return score;
	}

	public int addToScore(int pointsToAdd) {
		int score1 = score;
		score = score + pointsToAdd;
		if (score < 0) {
			score = score1;
			throw new DomainException("Dit mag niet");
		} else {
			setScore(score);
		}
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean equals(Object object) {
		if (object instanceof Speler) {
			Speler speler = (Speler) object;
			if (this.getNaam().equals(speler.getNaam()) && this.getScore() == speler.getScore()) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return this.getNaam() + " heeft als score " + this.getScore();
	}
}
