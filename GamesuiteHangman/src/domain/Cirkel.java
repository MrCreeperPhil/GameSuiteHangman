package domain;

public class Cirkel extends Vorm {
	private Punt middelpunt;
	private int radius;

	public Cirkel(Punt middelpunt, int radius) {
		super();
		this.setMiddelpunt(middelpunt);
		this.setRadius(radius);
	}

	public Punt getMiddelpunt() {
		return middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) {
		if (middelpunt == null) {
			throw new DomainException("middelpunt mag niet null zijn");
		}
		this.middelpunt = middelpunt;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		if (radius <= 0) {
			throw new DomainException("radius moet strikt positief zijn");
		}
		this.radius = radius;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Cirkel) {
			Cirkel p = (Cirkel) object;
			if (this.getMiddelpunt().equals(((Cirkel) object).getMiddelpunt())
					&& this.getRadius() == ((Cirkel) object).getRadius()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Cirkel: middelpunt: " + middelpunt + " - straal: " + radius;
	}

	
	@Override
	public Omhullende getOmhullende() {
		return new Omhullende(new Punt(this.middelpunt.getX()-this.radius, this.middelpunt.getY()-this.radius) ,radius*2, radius*2);
	}
}
