package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Posicion;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.Policia;

public class PoliciaTest {
	
	@Test
	public void JugadorQueCaeEnPoliciaVaALaCarcel() {
		Jugador jugador = new Jugador();
		Casillero carcel = new Casillero("Carcel", new Carcel());
		Posicion posicionCarcel = new Posicion(carcel);
		carcel.setPosicion(posicionCarcel);
		Policia policia = new Policia(posicionCarcel);
		
		policia.activarEfecto(jugador);
		
		assertEquals(jugador.getPosicion(), carcel.getPosicion());
		
	}
	
}


