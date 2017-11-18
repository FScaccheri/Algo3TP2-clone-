package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Casillero;
import modelo.Tablero;

public class CasilleroTest {

	@Test
	public void testSeInstanciaSinPosicion() {
		Casillero casillero = new Casillero();
		
		assertEquals( casillero.getPosicion(), null );
	}

	@Test
	public void testObtieneSuPosicionAlSerAgregadoAlTablero() {
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero = new Casillero();
		
		tablero.agregar(casillero);
		
		assertFalse( casillero.getPosicion() == null );
	}
}
