package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Tirada;

public class TiradaTest {

	@Test
	public void AlRealizarUnaTiradaElResultadoEstaEntreDosYDoce() {
		int resultado = Tirada.tirar();
		assertTrue(resultado>=2);
		assertTrue(resultado<=12);
	}

	@Test
	public void UltimaTiradaDevuelveLaUltimaTirada() {
		int resultado1 = Tirada.tirar();
		int resultado2 = Tirada.getUltimaTirada();
		assertEquals(resultado1, resultado2);
	}

	@Test
	public void DespuesDeDosTiradasGetUltimaTiradaDevuelvenElMismoResultado() {
		Tirada.tirar();
		Tirada.tirar();

		int resultado1 = Tirada.getUltimaTirada();
		int resultado2 = Tirada.getUltimaTirada();
		
		assertEquals(resultado1, resultado2);
	}
}
