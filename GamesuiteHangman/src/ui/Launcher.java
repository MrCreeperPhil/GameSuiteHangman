package ui;

import javax.swing.JOptionPane;
import domain.Punt;
import domain.Cirkel;
import domain.Speler;

public class Launcher {

	Launcher launcher;

	public void start() {
		launcher = new Launcher();
	}

	// launcher blijft loopen zolang run() boolean true is.
	public boolean run() {
		int action = 0;
		String actionString = JOptionPane
				.showInputDialog("Wat wil je doen? \n1. speler aanmaken? \n2. figuur tekenen? \n0. exit");

		// Als Cancel knop in inputDialog aangeklikt wordt, wordt de boolean
		// false en stopt de launcher.
		if (actionString == null) {
			return false;
		}
		// Als de gebruiker iets anders ingeeft dan een getal, krijgen we een
		// NumberFormatException.class Deze moet gecaught worden.
		try {
			action = Integer.parseInt(actionString);
		} catch (NumberFormatException e) {
			System.out.println("Geef een correcte input.");
			action = 999;
		}

		// action = Integer.parseInt(actionString);

		switch (action) {
		case 0:
			return false;
		case 1:

			// nieuwe speler
			String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
			try {
				Speler speler = new Speler(naam);
				JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore());

				JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(),
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case 2:

			String[] choices = { "Punt", "Cirkel", "Lijnstuk", "Driehoek", "Rechthoek" };
			String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

			// TODO: NullPointerException opvangen bij cancel
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

		case 999:
			break;
		default:
			break;
		}
		return true;
	}
}
