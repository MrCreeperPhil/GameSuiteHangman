package domain;

import java.awt.Graphics;

public abstract class Vorm {

	private boolean zichtbaar = true;

	public Vorm() {

	}

	public abstract boolean isZichtbaar();

	public abstract void setZichtbaar(boolean zichtbaar);

	public abstract void teken(Graphics graphics);

	public abstract boolean equals(Object object);

	public abstract String toString();

	public abstract Omhullende getOmhullende();

}
