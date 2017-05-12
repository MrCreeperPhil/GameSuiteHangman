package domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class TekeningHangMan extends Tekening {

	private Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
	private Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
	private Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
	private Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
	private Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
	private Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
	private Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
	private Vorm neus = new Cirkel(new Punt(280, 128), 2);
	private Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
	private Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
	private Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
	private Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
	private Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
	private Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
	private Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
	private Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
	private Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
	private Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
	private ArrayList<Vorm> galg = new ArrayList<>();
	private ArrayList<Vorm> mannetje = new ArrayList<>();

	public TekeningHangMan() {
		super("hangman");
		galg.add(galgStaaf);
		galg.add(galgBodem);
		galg.add(hangbar);
		galg.add(koord);
		mannetje.add(hoofd);
		mannetje.add(oogLinks);
		mannetje.add(oogRechts);
		mannetje.add(neus);
		mannetje.add(mond);
		mannetje.add(lijf);
		mannetje.add(beenLinks);
		mannetje.add(beenRechts);
		mannetje.add(voetLinks);
		mannetje.add(voetRechts);
		mannetje.add(armLinks);
		mannetje.add(armRechts);
		mannetje.add(handLinks);
		mannetje.add(handRechts);
		for (Vorm vorm : mannetje) {
			vorm.setZichtbaar(false);
		}
	}

	public ArrayList<Vorm> getGalg() {
		return galg;
	}

	public ArrayList<Vorm> getMannetje() {
		return mannetje;
	}

	public int getAantalOnzichtbaar() {
		int result = 0;
		for (Vorm vorm : mannetje) {
			if (!vorm.isZichtbaar()) {
				result++;
			}
		}
		return result;
	}

	public void zetVolgendeZichtbaar() {
		for (Vorm vorm : mannetje) {
			if (!vorm.isZichtbaar()) {
				vorm.setZichtbaar(true);
				return;
			}
		}
		throw new DomainException("Alle vormen zijn al zichtbaar.");
	}

	public void reset() {
		for (Vorm vorm : mannetje) {
			vorm.setZichtbaar(false);
		}
	}

	public void teken(Graphics graphics) {
		for (Vorm vorm : galg)
			 vorm.teken(graphics);
		for (Vorm vorm : mannetje)
			if(vorm.isZichtbaar()){
				 vorm.teken(graphics);
			}

	}

	@Override
	public void verwijder(Vorm vorm) {
		throw new DomainException("Je kan geen vormen verwijderen uit de HangMan.");
	}

	@Override
	public void voegToe(Vorm vorm) {
		throw new DomainException("Je kan geen vormen toevoegen aan de HangMan.");
	}

}
