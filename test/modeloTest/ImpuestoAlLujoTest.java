package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ImpuestoAlLujo;
import modelo.Jugador;
import modelo.Quini6;

public class ImpuestoAlLujoTest {

	@Test
	public void JugadorAfectadoPierde10PorCientoDeSuCapital() {
		ImpuestoAlLujo impLujo = new ImpuestoAlLujo();
		Jugador jugador = new Jugador();
		
		jugador.aumentarCapital(100000);

		impLujo.activarEfecto(jugador);

		assertEquals( 90000 , jugador.getCapital(), 0);
	}

}
