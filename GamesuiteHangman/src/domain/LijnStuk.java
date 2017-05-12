package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm {
	private Punt eindpunt, beginpunt;
	private boolean zichtbaar = true;

	public LijnStuk(Punt beginpunt, Punt eindpunt) {
		super();
		setEindpuntEnBeginpunt(eindpunt, beginpunt);
	}

	public Punt getEindpunt() {
		return eindpunt;
	}

	private void setEindpuntEnBeginpunt(Punt eindpunt, Punt beginpunt) {
		if (eindpunt == null)
			throw new DomainException("eindpunt mag niet leeg zijn.");
		if (beginpunt == null)
			throw new DomainException("beginpunt mag niet leeg zijn.");
		if (eindpunt == beginpunt)
			throw new DomainException("eindpunt en beginpunt mogen niet dezelfde waarde hebben.");
		this.eindpunt = eindpunt;
		this.beginpunt = beginpunt;

	}

	public Punt getBeginpunt() {
		return beginpunt;
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
		LijnStuk other = (LijnStuk) obj;
		if (beginpunt == null) {
			if (other.beginpunt != null)
				return false;
		} else if (!beginpunt.equals(other.beginpunt))
			return false;
		if (eindpunt == null) {
			if (other.eindpunt != null)
				return false;
		} else if (!eindpunt.equals(other.eindpunt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lijn: startpunt: " + this.beginpunt + " - eindpunt: " + this.eindpunt + "\n" + this.getOmhullende();
	}

	@Override
	public Omhullende getOmhullende() {
		int kleinsteX = Math.min(this.getBeginpunt().getX(), this.getEindpunt().getX());

		int kleinsteY = Math.min(this.getBeginpunt().getY(), this.getEindpunt().getY());

		int grootsteX = Math.max(this.getBeginpunt().getX(), this.getEindpunt().getX());

		int grootsteY = Math.max(this.getBeginpunt().getY(), this.getEindpunt().getY());

		Omhullende omhullende = new Omhullende((new Punt(kleinsteX, kleinsteY)), (grootsteX - kleinsteX),
				(grootsteY - kleinsteY));

		return omhullende;
	}

	@Override
	public void teken(Graphics graphics) {
		// TODO Auto-generated method stub

	}

}
