package ui;

import javax.swing.JOptionPane;
import domain.*;

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
			String[] choices = { "Punt", "Cirkel", "Driehoek", "Rechthoek" };
			String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
					JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

			if (input == null) {
				return false;
			}
			try {
				switch (input) {

				case "Punt":
					Punt punt = punt();
					JOptionPane.showMessageDialog(null, punt);
					break;

				case "Cirkel":
					Punt punt2 = punt();
					int straal = Integer.parseInt(JOptionPane.showInputDialog("Welke straal?"));
					Cirkel cirkel = new Cirkel(punt2, straal);
					JOptionPane.showMessageDialog(null, cirkel);
					break;
				case "Rechthoek":
					Punt punt3 = punt();
					int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Welke hoogte?"));
					int breedte = Integer.parseInt(JOptionPane.showInputDialog("Welke breedte?"));
					Rechthoek rechthoek = new Rechthoek(punt3, breedte, hoogte);
					JOptionPane.showMessageDialog(null, rechthoek);
					break;
				case "Driehoek":
<<<<<<< HEAD
					Punt punt4 = punt();
					Punt punt5 = punt();
=======
					JOptionPane.showMessageDialog(null, "geef co�rdinaten voor punt 1");
					Punt punt4 = punt();
					JOptionPane.showMessageDialog(null, "geef co�rdinaten voor punt 2");
					Punt punt5 = punt();
					JOptionPane.showMessageDialog(null, "geef co�rdinaten voor punt 3");
>>>>>>> 6db95382f0b16f231f9e1b4fe13fc45144e1c61f
					Punt punt6 = punt();
					Driehoek driehoek = new Driehoek(punt4, punt5, punt6);
					JOptionPane.showMessageDialog(null, driehoek);
					break;
				}
<<<<<<< HEAD
				break;
			} catch (Exception e) {
=======

				break;
			} catch (NumberFormatException e) {
>>>>>>> 6db95382f0b16f231f9e1b4fe13fc45144e1c61f
				System.out.println("geen lege waarden doorgeven");
			} catch (DomainException e) {
				System.out.println(e.getMessage());
			}

		case 999:
			break;

		default:
			break;
		}
		return true;
	}

	public Punt punt() {
		int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke x co�rdinaat?"));
		int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke y co�rdinaat?"));
		Punt punt = new Punt(xCoordinaat, yCoordinaat);
		return punt;
	}

}
