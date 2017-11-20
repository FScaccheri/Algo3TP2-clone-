package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Dado;

public class DadoTest {

	@Test
	public void AlTirarElDadoElResultadoEstaEntreUnoYSeis() {
		Dado dado = new Dado();
		int resultado = dado.tirar();
		assertTrue(resultado>=1);
		assertTrue(resultado<=6);
	}

}
