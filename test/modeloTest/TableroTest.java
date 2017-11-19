package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

public class TableroTest {

/*	@Test
	public void testAgregadoUnCasilleroAlTableroPuedoConocerSuOrden() {
		Tablero.reset();
		Tablero unTablero = Tablero.getInstancia();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		Casillero casillero4 = new Casillero();
		
		unTablero.agregar(casillero1);
		unTablero.agregar(casillero2);
		unTablero.agregar(casillero3);
		unTablero.agregar(casillero4);
		
		assertTrue(unTablero.posicion(casillero1) == 0);
		assertTrue(unTablero.posicion(casillero2) == 1);
		assertTrue(unTablero.posicion(casillero3) == 2);
		assertTrue(unTablero.posicion(casillero4) == 3);
	}*/
	@Test
	public void testLosCasillerosSeAgreganEnOrden() {
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		
		tablero.agregar(casillero1);
		tablero.agregar(casillero2);
		
		assertTrue( casillero2 == tablero.casilleroSiguiente(casillero1) );
	}
	
	@Test
	public void testSoloExisteUnaInstanciadDeTablero() {
		Tablero.reset();
		Tablero tablero1 = Tablero.getInstancia();
		Tablero tablero2 = Tablero.getInstancia();
		
		assertEquals( tablero1, tablero2 );
	}
	
	@Test
	public void testSePuedeObtenerUnCasilleroConociendoSuPosicion() {
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero = new Casillero();
		
		tablero.agregar(casillero);
		
		assertEquals(tablero.getCasillero(casillero.getPosicion()),casillero);
	}
	
	@Test
	public void testSePuedeConocerLaPosicionDeUnCasillero() {
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero = new Casillero();
		
		tablero.agregar(casillero);
		
		assertEquals(tablero.posicion(casillero),casillero.getPosicion());
	}
}
