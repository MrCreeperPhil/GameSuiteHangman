package domain;

public class Omhullende {
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;

	public Omhullende(Punt positieLinksBoven, int breedte, int hoogte) {
		this.setLinkerBovenhoek(positieLinksBoven);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
	}

	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	private void setLinkerBovenhoek(Punt positieLinksBoven) {
		if (positieLinksBoven == null) {
			throw new DomainException("De linkerbovenhoek mag niet null zijn");
		}

		this.linkerBovenhoek = positieLinksBoven;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte < 0) {
			throw new DomainException("Breedte mag niet kleiner dan 0 zijn.");
		}
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte < 0) {
			throw new DomainException("Hoogte mag niet kleiner dan 0 zijn.");
		}
		this.hoogte = hoogte;
	}

	public int getMinimumX() {
		return this.getLinkerBovenhoek().getX();
	}

	public int getMinimumY() {
		return this.getLinkerBovenhoek().getY();
	}

	public int getMaximumX() {
		return this.getMinimumX() + this.getBreedte();
	}

	public int getMaximumY() {
		return this.getMinimumY() + this.getHoogte();
	}

	@Override
	public String toString() {
		return "Omhullende: " + linkerBovenhoek + " - " + breedte + " - " + hoogte;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Omhullende) {
			Omhullende p = (Omhullende) object;
			if (this.getLinkerBovenhoek() == p.getLinkerBovenhoek() && this.getBreedte() == p.getBreedte()
					&& this.getHoogte() == p.getHoogte()) {
				return true;
			}
		}
		return false;
	}

}
