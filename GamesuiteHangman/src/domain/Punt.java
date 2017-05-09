package domain;

public class Punt {
	private int x;
	private int y;

	public Punt(int x, int y) {
		super();
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Punt) {
			Punt p = (Punt) object;
			if (this.getX() == p.getX() && this.getY() == p.getY()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
}
