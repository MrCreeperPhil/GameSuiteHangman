package domain;

public class HangMan {

	private Speler speler;
	private WoordenLijst woordenLijst;
	private HintWoord hintwoord;

	public HangMan(Speler speler, WoordenLijst woordenLijst) {
		this.setSpeler(speler);
		this.setWoordenLijst(woordenLijst);
	}

	private void setSpeler(Speler speler) {
		if (speler == null) {
			throw new DomainException("Voeg een speler toe.");
		}
		this.speler = speler;
	}

	private void setWoordenLijst(WoordenLijst woordenLijst) {
		if (woordenLijst == null) {
			throw new DomainException("Voeg een woordenlijst toe.");
		}
		this.woordenLijst = woordenLijst;
	}

	public String getHint() {
		return null;
	}

	public Speler getSpeler() {
		return this.speler;
	}

	public TekeningHangMan getTekening() {
		return null;
	}

	public void raad(char letter) {

	}

	public boolean isGameOver() {
		return false;
	}

	public boolean isGewonnen() {
		return false;
	}

}
