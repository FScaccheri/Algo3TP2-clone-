package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Edificio;
import modelo.Jugador;

public class EdificioTest {

	@Test
	public void DevuelveSuAlquilerCorrectamente() {
		Edificio casa = new Edificio(100, 200);
		Jugador jugador = new Jugador();

		double alquiler = casa.getAlquiler(jugador);
		
		assertEquals(alquiler, 200, 0);
	}

}
