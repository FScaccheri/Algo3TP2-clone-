package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Tirada;

public class TiradaTest {

	@Test
	public void AlRealizarUnaTiradaElResultadoEstaEntreDosYDoce() {
		Tirada tirada = new Tirada();
		int resultado = tirada.tirar();
		assertTrue(resultado>=2);
		assertTrue(resultado<=12);
	}

}
