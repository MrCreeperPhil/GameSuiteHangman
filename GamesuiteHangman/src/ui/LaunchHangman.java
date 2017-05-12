package ui;

import javax.swing.JOptionPane;
import domain.*;

public class LaunchHangman {

	Launcher launcher;

	public void start() {
		launcher = new Launcher();
	}
	Speler speler= null;
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
				speler = new Speler(naam);
				JOptionPane.showMessageDialog(null, speler.getNaam() + " heeft als score: " + speler.getScore());

				JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(),
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		case 2:
			//nieuwe figuur aanmaken
			String naamFiguur = JOptionPane.showInputDialog(null, "Voer de naam van je figuur in.");
			if (naamFiguur == null || naamFiguur.trim().equals("")){
				return false;
			}
			
			TekeningHangMan figuren = new TekeningHangMan();
			GameHoofdScherm view = new GameHoofdScherm(speler.getNaam(), figuren);
			view.setVisible(true);
			view.teken();
			//gamehoofdscherm
			
			while(action!=0){
				
			
			int action2 = 0;
			String figuurAction = JOptionPane.showInputDialog(null, "Wat wil je doen: \n 1. Vorm maken \n 2. Tekening tonen \n 0. Exit ");
			if (figuurAction == null) {
				return false;
			}
			//try en catch?
			try {
				action2 = Integer.parseInt(figuurAction);
			} catch (NumberFormatException e) {
				System.out.println("Geef een correcte input.");
				action2 = 999;
			}
			switch (action2){
			
			case 0: 
				return false;
				
			case 1:
				//Vorm maken
				String[] choices = { "Punt", "Cirkel", "Driehoek", "Rechthoek", "Lijnstuk" };
				String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "The Choice of a Lifetime",
						JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

				if (input == null) {
					return false;
				}
				try {
					switch (input) {

						case "Punt":
							Punt punt = punt();
							break;

						case "Cirkel":
							Punt punt2 = punt();
							int straal = Integer.parseInt(JOptionPane.showInputDialog("Welke straal?"));
							Cirkel cirkel = new Cirkel(punt2, straal);
							figuren.voegToe(cirkel);
							view.teken();
							break;
						case "Rechthoek":
							Punt punt3 = punt();
							int hoogte = Integer.parseInt(JOptionPane.showInputDialog("Welke hoogte?"));
							int breedte = Integer.parseInt(JOptionPane.showInputDialog("Welke breedte?"));
							Rechthoek rechthoek = new Rechthoek(punt3, breedte, hoogte);
							figuren.voegToe(rechthoek);
							view.teken();
							break;
						case "Driehoek":
							JOptionPane.showMessageDialog(null, "geef coördinaten voor punt 1");
							Punt punt4 = punt();
							JOptionPane.showMessageDialog(null, "geef coördinaten voor punt 2");
							Punt punt5 = punt();
							JOptionPane.showMessageDialog(null, "geef coördinaten voor punt 3");
							Punt punt6 = punt();
							Driehoek driehoek = new Driehoek(punt4, punt5, punt6);
							figuren.voegToe(driehoek);
							view.teken();
							break;
						case "Lijnstuk":
							JOptionPane.showMessageDialog(null, "geef coördinaten voor punt 1");
							Punt punt7 = punt();
							JOptionPane.showMessageDialog(null, "geef coördinaten voor punt 2");
							Punt punt8 = punt();
							LijnStuk lijnstuk = new LijnStuk (punt7, punt8);
							figuren.voegToe(lijnstuk);
							view.teken();
						}	

						break;
					} catch (NumberFormatException e) {
						System.out.println("geen lege waarden doorgeven");
					} catch (DomainException e) {
						System.out.println(e.getMessage());
					}
			case 2: 
				//Tekening tonen
				JOptionPane.showMessageDialog(null, figuren.toString());
				
				}
			
		
			
		}

		case 999:
			break;

		default:
			break;
		}
		return true;
	}

	public Punt punt() {
		int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke x coördinaat?"));
		int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("Welke y coördinaat?"));
		Punt punt = new Punt(xCoordinaat, yCoordinaat);
		return punt;
	}

}
