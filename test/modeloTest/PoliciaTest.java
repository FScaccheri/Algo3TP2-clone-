package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;
import modelo.Policia;
import modelo.Posicion;

public class PoliciaTest {
	
	@Test
	public void JugadorQueCaeEnPoliciaVaALaCarcel() {
		Jugador jugador = new Jugador();
		Casillero carcel = new Casillero();
		Posicion posicionCarcel = new Posicion(carcel);
		carcel.setPosicion(posicionCarcel);
		Policia policia = new Policia(carcel);
		
		policia.activarEfecto(jugador);
		
		assertEquals(jugador.getPosicion(), carcel.getPosicion());
		
	}
	
}


