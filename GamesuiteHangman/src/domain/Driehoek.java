package domain;

public class Driehoek extends Vorm {
	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			throw new DomainException("The points may not be null");
		}
		if (hoekPunt1.getX() == hoekPunt2.getX() && hoekPunt1.getY() == hoekPunt2.getY()
				|| hoekPunt3.getX() == hoekPunt2.getX() && hoekPunt3.getY() == hoekPunt2.getY()
				|| hoekPunt1.getX() == hoekPunt3.getX() && hoekPunt1.getY() == hoekPunt3.getY()) {
			throw new DomainException("All points need to be different");
		}
		if ((hoekPunt2.getX() - hoekPunt1.getX())
				* (hoekPunt3.getY() - hoekPunt1.getY()) == (hoekPunt3.getX() - hoekPunt1.getX())
						* (hoekPunt2.getY() - hoekPunt1.getY())) {
			throw new DomainException("The points may not be on the same line");
		} else {
			this.hoekPunt1 = hoekPunt1;
			this.hoekPunt2 = hoekPunt2;
			this.hoekPunt3 = hoekPunt3;
		}

	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) object;
			if (this.getHoekPunt1().equals(driehoek.getHoekPunt1())
					&& this.getHoekPunt2().equals(driehoek.getHoekPunt2())
					&& this.getHoekPunt3().equals(driehoek.getHoekPunt3())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + this.getHoekPunt1() + " - hoekpunt2: " + this.getHoekPunt2() + " - hoekpunt3: " + this.getHoekPunt3();
	}
}
