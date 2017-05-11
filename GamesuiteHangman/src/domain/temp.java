package domain;
import domain.*;

public class temp {

	public static void main(String[] args) {
		LijnStuk lijnstuk = new LijnStuk(new Punt(10, 20), new Punt(190, 30));
		Omhullende test = lijnstuk.getOmhullende();
		Omhullende omhullende = new Omhullende(new Punt(10,20), 180, 10);
		System.out.println(omhullende);
		System.out.println(test);

	}

}
