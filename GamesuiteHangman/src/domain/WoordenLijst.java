package domain;


import java.util.ArrayList;
public class WoordenLijst {
	ArrayList<String> woorden = new ArrayList<String>();
	
	public WoordenLijst(){
	}
	
	public int getAantalWoorden(){
		return woorden.size();
	}
	
	public void voegToe(String woord){
		setWoord(woord);
		woorden.add(woord);
	}
	
	public void setWoord(String woord){
		if(woord == null || woord.trim().isEmpty() ){
			throw new DomainException(" The word may not be empty ");
		}else if(woorden.contains(woord)){
			throw new DomainException(" The word is already in the list ");
		}
	}
	
	public String getRandomWoord(){
		if(woorden.size() > 0){
		int random = (int) (Math.random() * woorden.size());
		return woorden.get(random);
		}else{
			throw new DomainException("Verzameling moet woorden bevatten.");
		}
	}
}
