package domain;

public class LijnStuk extends Vorm {
	private Punt eindpunt, beginpunt;

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

	public Punt getStartpunt() {
		return beginpunt;
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
		return "Lijn: startpunt: " + this.beginpunt + " - eindpunt: " + this.eindpunt;
	}

}
