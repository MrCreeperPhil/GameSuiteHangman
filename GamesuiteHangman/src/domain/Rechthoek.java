package domain;

import java.awt.Graphics;

public class Rechthoek extends Vorm {
	private int breedte, hoogte;
	private Punt linkerBovenhoek;
	private boolean zichtbaar = true;

	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
		super();
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt linkerBovenhoek) {

		if (linkerBovenhoek == null)
			throw new DomainException("positie mag niet null zijn");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte <= 0)
			throw new DomainException("breedte mag niet kleiner of gelijk aan 0 zijn");
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <= 0)
			throw new DomainException("hoogte mag niet kleiner of gelijk aan 0 zijn");
		this.hoogte = hoogte;
	}

	@Override
	public boolean isZichtbaar() {
		return this.zichtbaar;
	}

	@Override
	public void setZichtbaar(boolean zichtbaar) {
		this.zichtbaar = zichtbaar;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rechthoek other = (Rechthoek) obj;
		if (breedte != other.breedte)
			return false;
		if (hoogte != other.hoogte)
			return false;
		if (linkerBovenhoek == null) {
			if (other.linkerBovenhoek != null)
				return false;
		} else if (!linkerBovenhoek.equals(other.linkerBovenhoek))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rechthoek: positie: " + this.getLinkerBovenhoek() + " - breedte: " + this.getBreedte() + " - hoogte: "
				+ this.getHoogte() + "\n" + this.getOmhullende();
	}

	public Omhullende getOmhullende() {
		Omhullende omhullende = new Omhullende(this.getLinkerBovenhoek(), this.getBreedte(), this.getHoogte());
		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub

	}

}
