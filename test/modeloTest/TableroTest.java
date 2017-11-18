package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.*;

public class TableroTest {

	@Test
	public void testAgregadoUnCasilleroAlTableroPuedoConocerSuOrden() {
		
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
	}

}
