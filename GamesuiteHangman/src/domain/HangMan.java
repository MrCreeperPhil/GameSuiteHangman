package domain;

public class HangMan {

	private Speler speler;
	private WoordenLijst woordenLijst;
	private HintWoord hintwoord;
	private TekeningHangMan tekening = new TekeningHangMan();

	public HangMan(Speler speler, WoordenLijst woordenLijst) {
		this.setSpeler(speler);
		this.setWoordenLijst(woordenLijst);
		hintwoord = new HintWoord(woordenLijst.getRandomWoord());
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
		return this.hintwoord.toString();
	}

	public Speler getSpeler() {
		return this.speler;
	}

	public TekeningHangMan getTekening() {
		return this.tekening;
	}

	public void raad(char letter) {
		if (!this.hintwoord.raad(letter)) {
			this.tekening.zetVolgendeZichtbaar();
		}

	}

	public boolean isGameOver() {
		try {
			tekening.zetVolgendeZichtbaar();
		} catch (DomainException e) {
			return true;
		}
		return false;
	}

	public boolean isGewonnen() {
		return hintwoord.isGeraden();
	}

}
