package domain;

import java.util.ArrayList;

public class Tekening {
	private String naam;
	ArrayList<Vorm> vormen = new ArrayList<Vorm>();
    private static final int MIN_X=0,MIN_Y=0;
    private static final int MAX_X=399,MAX_Y=399;
    
	public Tekening(String naam) {
		super();
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}
	
	public void voegToe(Vorm vorm){
		if(vorm == null) throw new DomainException("de vorm mag niet leeg");
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index){
		if (index <0) throw new DomainException("de array lest begint te tellen vanaf 0");
		return vormen.get(index);
	}
	
	public int getAantalVormen(){
		return vormen.size();
	}
	
	public void verwijder(Vorm teverwijderen){
		vormen.remove(teverwijderen);
		
	}
	public boolean bevat(Vorm vorm){
		if (vorm== null) throw new DomainException("de vorm mag niet leeg zijn");
		if(vormen.contains(vorm))return true;
		return false;	
	}

	@Override
	public String toString() {
		return "Tekening [naam=" + naam + ", vormen=" + vormen + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tekening other = (Tekening) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equals(other.naam))
			return false;
		if (vormen == null) {
			if (other.vormen != null)
				return false;
		} else if (!vormen.equals(other.vormen))
			return false;
		return true;
	}
	
    
}
