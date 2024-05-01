package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
/*verifica il corretto riconoscimento dei comandi*/
public class FabbricaDiComandiFisarmonicaTest {
	FabbricaDiComandiFisarmonica fc = new FabbricaDiComandiFisarmonica();
	private Comando expected;
	
	@Test
	public void testComandoNonValido() {
		expected = new ComandoNonValido();
		assertEquals(expected.getNome(), fc.costruisciComando("pluto").getNome());
	}
	
	@Test
	public void testComandoConParametro() {
		expected = new ComandoVai();
		expected.setParametro("sud");
		Comando current = fc.costruisciComando("vai sud");
		assertEquals(expected.getNome(), current.getNome());
		assertEquals(expected.getParametro(), current.getParametro());
	}

}
