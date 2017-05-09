package ui;

import javax.swing.JOptionPane;


public class Launcher {

	public static void main(String[] args) {
		
		
		int action1 = 0;
		String action="";
		while(action.trim().equals("")||action.isEmpty()&& (action!="1" ||action!="2"||action!="0")){
		    action = JOptionPane.showInputDialog("Wat wil je doen? \n1. speler aanmaken? \n2. figuur tekenen? \n0. exit");
		}
		try{
		action1= Integer.parseInt(action);
		}
		catch(NumberFormatException e ){
		//	action = JOptionPane.showConfirm
		}
			switch(action1)
			{
			case 0:
				break;
			case 1:
				//nieuwe speller
				
				String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
				//Speler speler = new Speler(naam);
				//JOptionPane.showMessageDialog(speler.getNaam + " heeft als score:" + speler.getScore);
				
				
				//JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case 2:
				
					String[] choices = { "Punt", "Cirkel", "Lijnstuk", "Driehoek", "Rechthoek" };
				    String input = (String) JOptionPane.showInputDialog(null, "Choose now...",
				    		"The Choice of a Lifetime", JOptionPane.QUESTION_MESSAGE, null,
				    		choices,
				            choices[0]); 
				        System.out.println(input);
				        break;
			}
	}

}
