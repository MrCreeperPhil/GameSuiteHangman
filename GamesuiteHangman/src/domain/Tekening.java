package domain;

import java.util.ArrayList;

public class Tekening {
	private String naam;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	ArrayList<Vorm> VormenVanTekening = new ArrayList<Vorm>();

	public Tekening(String naam) {
		setNaam(naam);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new IllegalArgumentException(" Name is invalid ");
		} else {
			this.naam = naam;
		}
	}

	public void voegToe(Vorm vorm) {
		if (bevat(vorm) == false) {
			Omhullende figuur = vorm.getOmhullende();

			if (figuur.getMaximumX() > MAX_X || figuur.getMinimumX() < MIN_X || figuur.getMaximumX() > MAX_Y
					|| figuur.getMinimumY() < MIN_Y) {
				throw new DomainException("De figuur moet binnen de grenzen liggen");
			} else {
				VormenVanTekening.add(vorm);
			}

		}

		else {
			throw new DomainException(" The Figure is already in the Picture ");
		}
	}

	public Vorm getVorm(int index) {
		if (index < 0 || index > VormenVanTekening.size())
			throw new DomainException("de array lest begint te tellen vanaf 0");
		return VormenVanTekening.get(index);
	}

	public int getAantalVormen() {
		return VormenVanTekening.size();
	}

	public void verwijder(Vorm vorm) {
		if (bevat(vorm) == true) {
			VormenVanTekening.remove(vorm);
		} else {
			throw new DomainException(" The figure was not found ");
		}
	}

	public boolean bevat(Vorm vorm) {
		if (vorm == null)
			throw new DomainException("de vorm mag niet leeg zijn");
		if (VormenVanTekening.contains(vorm))
			return true;
		return false;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Tekening) {

			Tekening tekening = (Tekening) object;
			if (tekening.getAantalVormen() != this.getAantalVormen()) {
				return false;
			}
			for (Vorm vorm : VormenVanTekening) {
				if (!tekening.bevat(vorm)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String eersteDeel = "Tekening met naam: " + getNaam() + " bestaat uit " + getAantalVormen() + " vormen: \n ";
		String tweedeDeel = "";
		for (int i = 0; i < getAantalVormen(); i++) {
			tweedeDeel = tweedeDeel + getVorm(i).toString() + "\n";
		}
		return eersteDeel + tweedeDeel;
	}

}
