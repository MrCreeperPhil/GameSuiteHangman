package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TekeningHangManTest {
	TekeningHangMan tekening;

	@Before
	public void setUp() {
		tekening = new TekeningHangMan();
	}

	@Test
	public void TekeningHangMan_maakt_nieuwe_hangman_tekening_met_naam_hangman_en_18_vormen_waarven_14_onzichtbare() {
		assertEquals("hangman", tekening.getNaam());
		assertEquals(18, tekening.getGalg().size() + tekening.getMannetje().size());
		assertEquals(14, tekening.getAantalOnzichtbaar());
	}

	@Test(expected = DomainException.class)
	public void voegToe_gooit_Exception() {
		tekening.verwijder(new Cirkel(new Punt(1, 2), 1));
	}

	@Test(expected = DomainException.class)
	public void verwijder_gooit_Exception() {
		tekening.voegToe(new Cirkel(new Punt(1, 2), 1));
	}

	@Test(expected = DomainException.class)
	public void zetVolgendeZichtbaar_gooit_exception_wanneer_alle_vormen_al_zichtbaar_zijn() {
		for (int i = 0; i < 14; i++) {
			tekening.zetVolgendeZichtbaar();
		}
		tekening.zetVolgendeZichtbaar();
	}

	@Test
	public void zetVolgendeZichtbaar_zet_volgende_vorm_zichtbaar() {
		tekening.zetVolgendeZichtbaar();
		assertTrue(tekening.getMannetje().get(0).isZichtbaar());
		assertFalse(tekening.getMannetje().get(1).isZichtbaar());
		tekening.zetVolgendeZichtbaar();
		assertTrue(tekening.getMannetje().get(1).isZichtbaar());
	}

	@Test
	public void reset_maakt_alle_vormen_behalve_galg_terug_onzichtbaar() {
		for (int i = 0; i < 14; i++) {
			tekening.zetVolgendeZichtbaar();
		}
		tekening.reset();
		boolean result = true;
		for (Vorm vorm : tekening.getMannetje()) {
			if (vorm.isZichtbaar()) {
				result = true;
			}
		}
		for (Vorm vorm : tekening.getGalg()) {
			if (!vorm.isZichtbaar()) {
				result = true;
			}
		}
		assertTrue(result);
	}

}
