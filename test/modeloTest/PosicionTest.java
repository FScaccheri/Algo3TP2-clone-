package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Posicion;
import modelo.casilleros.Casillero;

public class PosicionTest {

	@Test
	public void testDosPosicionesSonIgualesSiContienenAlMismoCasillero() {
		Casillero casillero = new Casillero();
		Posicion posicion1 = new Posicion(casillero);
		Posicion posicion2 = new Posicion(casillero);
		
		assertEquals(posicion1,posicion2);
		
	}

}
