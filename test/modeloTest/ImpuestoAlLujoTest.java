package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ImpuestoAlLujo;
import modelo.Jugador;

public class ImpuestoAlLujoTest {

	@Test
	public void testJugadorAfectadoPierde10PorCientoDeSuCapital() {
		ImpuestoAlLujo impLujo = new ImpuestoAlLujo();
		Jugador jugador = new Jugador();
		
		jugador.aumentarCapital(100000);
		double capitalInicial = jugador.getCapital();

		impLujo.activarEfecto(jugador);

		assertEquals( capitalInicial*0.9, jugador.getCapital(), 0);
	}

}
