package domain;

import db.WoordenLezer;
import domain.*;
import ui.HangManHoofdScherm;
import ui.HangmanPaneel;

public class temp {

	public static void main(String[] args) {
		LijnStuk lijnstuk = new LijnStuk(new Punt(10, 20), new Punt(190, 30));
		Omhullende test = lijnstuk.getOmhullende();
		Omhullende omhullende = new Omhullende(new Punt(10, 20), 180, 10);
		System.out.println(omhullende);
		System.out.println(test);

		HangMan spel = new HangMan(new Speler("Philip"), new WoordenLezer().getWoorden());

		new HangManHoofdScherm(spel, new HangmanPaneel(spel)).start();

		TekeningHangMan tekening = new TekeningHangMan();
		tekening.teken(null);

	}

}
