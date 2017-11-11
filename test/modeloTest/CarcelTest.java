package modeloTest;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Carcel;
import modelo.Jugador;

public class CarcelTest {
	
	@Test
	public void JugadorQueCaeEnCarcelEntraEnLaCarcel() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		
		assertTrue( carcel.estaPreso(jugador) );
		
	}
	
	@Test
	public void JugadorDebeEsperarTresTurnosParaSalirDeLaCarcel() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);		
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
		
		
		assertFalse( carcel.estaPreso(jugador));
		
	}
	
	@Test
	public void JugadorSaleDeLaCarcelSiPagaLaFianza() {
			
		Jugador jugador = new Jugador();
			
		Carcel carcel = new Carcel();
		
		jugador.aumentarCapital(45000);
			
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
			
		carcel.liberarJugadorPorFianza(jugador);
			
		assertFalse( carcel.estaPreso(jugador) );
	}
	
	@Test
	public void JugadorNoPuedePagarLaFianzaEnElPrimerTurnoDeEspera() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		
		carcel.liberarJugadorPorFianza(jugador);
		
		assertTrue( carcel.estaPreso(jugador) );
	}

}
