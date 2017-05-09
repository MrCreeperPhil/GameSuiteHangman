package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Punt;
import domain.Cirkel;

public class CirkelTest {

	private int xCoordinaat;
	private int yCoordinaat;
	private Punt middelpunt;
	private int radius;
	private Cirkel cirkel;

	@Before
	public void setUp() throws Exception {
		xCoordinaat = 5;
		yCoordinaat = 10;
		middelpunt = new Punt(xCoordinaat, yCoordinaat);
		radius = 7;
		cirkel = new Cirkel(middelpunt, radius);
	}

	@Test
	public void Cirkel_moet_een_cirkel_maken_met_gegeven_middelpunt_en_radius() {
		assertEquals(middelpunt, cirkel.getMiddelpunt());
		assertEquals(radius, cirkel.getRadius());
	}

	@Test(expected = DomainException.class)
	public void Cirkel_met_middelpunt_null_moet_exception_opgooien() {
		Cirkel cirkelAnder = new Cirkel(null, radius);
	}

	@Test(expected = DomainException.class)
	public void Cirkel_met_radius_kleiner_dan_0_moet_exception_opgooien() {
		Cirkel cirkelAnder = new Cirkel(middelpunt, -5);
	}

	@Test(expected = DomainException.class)
	public void Cirkel_met_radius_gelijk_aan_0_moet_exception_opgooien() {
		Cirkel cirkelAnder = new Cirkel(middelpunt, 0);
	}

	@Test
	public void equals_moet_true_teruggeven_als_de_twee_cirkels_hetzelfde_middelpunt_en_dezelfde_straal_hebben() {
		Cirkel cirkelAnder = new Cirkel(middelpunt, radius);
		assertTrue(cirkel.equals(cirkelAnder));
	}

	@Test
	public void equals_moet_false_teruggeven_als_tweede_cirkel_null_is() {
		assertFalse(cirkel.equals(null));
	}

	@Test
	public void equals_moet_false_teruggeven_als_het_middelpunt_verschillend_is() {
		Punt puntAnder = new Punt(xCoordinaat - 1, yCoordinaat - 1);
		Cirkel cirkelAnder = new Cirkel(puntAnder, radius);
		assertFalse(cirkel.equals(cirkelAnder));
	}

	@Test
	public void equals_moet_false_teruggeven_als_de_straal_verschillend_is() {
		Cirkel cirkelAnder = new Cirkel(middelpunt, radius + 1);
		assertFalse(cirkel.equals(cirkelAnder));
	}

}
