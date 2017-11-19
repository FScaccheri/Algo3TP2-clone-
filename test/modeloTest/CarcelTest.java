package modeloTest;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Posicion;

public class CarcelTest {
	
	@Test
	public void testJugadorQueCaeEnCarcelEntraEnLaCarcel() {		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		
		assertTrue( carcel.estaPreso(jugador) );
		
	}

//	@Test 
//	public void JugadorDebeEsperarTresTurnosParaSalirDeLaCarcel() {
//		
//		Jugador jugador = new Jugador();
//		
//		Carcel carcel = new Carcel();
//		
//		carcel.activarEfecto(jugador);		
//		carcel.activarEfecto(jugador);
//		carcel.activarEfecto(jugador);
//		
//		
//		assertFalse( carcel.estaPreso(jugador));
//		
//	}
//	
	@Test
	public void testJugadorSaleDeLaCarcelSiPagaLaFianza() {			
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		jugador.aumentarCapital(45000);
			
		carcel.activarEfecto(jugador);			
		carcel.liberarJugadorPorFianza(jugador);
			
		assertFalse( carcel.estaPreso(jugador) );
	}
//	
//	@Test
//	public void JugadorNoPuedePagarLaFianzaEnElPrimerTurnoDeEspera() {
//		
//		Jugador jugador = new Jugador();
//		
//		Carcel carcel = new Carcel();
//		
//		carcel.activarEfecto(jugador);
//		
//		carcel.liberarJugadorPorFianza(jugador);
//		
//		assertTrue( carcel.estaPreso(jugador) );
//	}
	
	@Test
	public void testJugadorPresoNoPuedeMoverse() {
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		Casillero casilleroCarcel = new Casillero(carcel);
		Posicion posicionCarcel = new Posicion(casilleroCarcel);
		casilleroCarcel.setPosicion(posicionCarcel);
			
		jugador.setPosicion(posicionCarcel);
		carcel.activarEfecto(jugador);	
		jugador.avanzar(5);
		
		assertTrue( carcel.estaPreso(jugador) );
		assertEquals( posicionCarcel, jugador.getPosicion());

	}

}
