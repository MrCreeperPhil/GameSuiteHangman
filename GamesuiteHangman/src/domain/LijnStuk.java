package domain;

public class LijnStuk {
	private Punt eindpunt, beginpunt;

	public LijnStuk( Punt beginpunt,Punt eindpunt) {
		super();
		setBeginpunt(beginpunt);
		setEindpunt(eindpunt);
	}

	public Punt getEindpunt() {
		return eindpunt;
	}

	private void setEindpunt(Punt eindpunt) {
		if(eindpunt==null)throw new DomainException("eindpunt mag niet leeg zijn.");
		this.eindpunt = eindpunt;
	}

	public Punt getBeginpunt() {
		return beginpunt;
	}

	private void setBeginpunt(Punt beginpunt) {
		if(beginpunt==null)throw new DomainException("beginpunt mag niet leeg zijn.");
		this.beginpunt = beginpunt;
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
		return "LijnStuk [eindpunt=" + eindpunt + ", beginpunt=" + beginpunt + "]";
	}
}
