package ui;

import javax.swing.JOptionPane;
import domain.Punt;
import domain.Cirkel;

public class Launcher {

	Launcher launcher;

	public void start() {
		launcher = new Launcher();
	}

	public boolean run() {
		int action = Integer.parseInt(
				JOptionPane.showInputDialog("Wat wil je doen? \n1. speler aanmaken? \n2. figuur tekenen? \n0. exit"));
		switch (action) {
		case 0:
			return false;
		case 1:
			// nieuwe speller

			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			// Speler speler = new Speler(naam);
			// JOptionPane.showMessageDialog(speler.getNaam + " heeft als
			// score:" + speler.getScore);

			// JOptionPane.showMessageDialog(null, "... zal binnekort spelen",
			// speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			break;

		case 2:

			String[] choices = { "Punt", "Cirkel", "Lijnstuk", "Driehoek", "Rechthoek" };
			String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			switch (input) {
			case "Punt":
				int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke x coördinaat?"));
				int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke y coördinaat?"));
				Punt punt = new Punt(xCoordinaat, yCoordinaat);
				JOptionPane.showMessageDialog(null, punt);
				break;
			case "Cirkel":
				int xCoordinaat2 = Integer.parseInt(JOptionPane.showInputDialog("Welke x coördinaat?"));
				int yCoordinaat2 = Integer.parseInt(JOptionPane.showInputDialog("Welke y coördinaat?"));
				Punt punt2 = new Punt(xCoordinaat2, yCoordinaat2);
				int straal = Integer.parseInt(JOptionPane.showInputDialog("Welke straal?"));
				Cirkel cirkel = new Cirkel(punt2, straal);
				JOptionPane.showMessageDialog(null, cirkel);
			}
			break;

		}
		return true;
	}
}
