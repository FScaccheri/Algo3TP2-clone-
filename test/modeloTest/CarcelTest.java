package modeloTest;
import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Posicion;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.excepciones.CapitalInsuficiente;
import modelo.excepciones.LiberacionInvalida;

public class CarcelTest {
	
	@Test
	public void testJugadorQueCaeEnCarcelEntraEnLaCarcel() {		
		Jugador jugador = new Jugador();
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		
		assertTrue( carcel.estaPreso(jugador) );
		
	}

	@Test 
	public void JugadorDebeEsperarTresTurnosParaSalirDeLaCarcel() {
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		tablero.agregar(casillero1);
		tablero.agregar(casillero2);
		tablero.agregar(casillero3);
			
		jugador.setPosicion(casillero1.getPosicion());
		carcel.activarEfecto(jugador);
		
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
		
		assertFalse( carcel.estaPreso(jugador) );
	}
	
	@Test
	public void testJugadorSaleDeLaCarcelSiPagaLaFianza() {			
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		jugador.aumentarCapital(45000);
			
		carcel.activarEfecto(jugador);			
		carcel.activarEfecto(jugador);			
		carcel.liberarJugadorPorFianza(jugador);
			
		assertFalse( carcel.estaPreso(jugador) );
	}
	
	@Test
	public void CuandoUnJugadorTrataDePagarLaFianzaEnElPrimerTurnoDeEsperaLanzaLiberacionInvalida() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		try {
			carcel.liberarJugadorPorFianza(jugador);
			fail();
		} catch (LiberacionInvalida e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void JugadorNoPuedePagarLaFianzaEnElPrimerTurnoDeEspera() {
		
		Jugador jugador = new Jugador();
		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		try {
			carcel.liberarJugadorPorFianza(jugador);
			fail();
		} catch (LiberacionInvalida e) {
			assertTrue(true);
		}
		
		assertTrue( carcel.estaPreso(jugador) );
	}
	
	@Test
	public void testJugadorPresoNoPuedeMoverse() {
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		Casillero casilleroCarcel = new Casillero("Carcel", carcel);
		Posicion posicionCarcel = new Posicion(casilleroCarcel);
		casilleroCarcel.setPosicion(posicionCarcel);
			
		jugador.setPosicion(posicionCarcel);
		carcel.activarEfecto(jugador);	
		jugador.avanzar(5);
		
		assertTrue( carcel.estaPreso(jugador) );
		assertEquals( posicionCarcel, jugador.getPosicion());

	}
	
	@Test
	public void testJugadorLiberadoPuedeMoverse() {
		Jugador jugador = new Jugador();			
		Carcel carcel = new Carcel();		
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		Casillero casillero1 = new Casillero();
		Casillero casillero2 = new Casillero();
		Casillero casillero3 = new Casillero();
		tablero.agregar(casillero1);
		tablero.agregar(casillero2);
		tablero.agregar(casillero3);
			
		jugador.setPosicion(casillero1.getPosicion());
		carcel.activarEfecto(jugador);	
		
		carcel.activarEfecto(jugador);	
		carcel.activarEfecto(jugador);	
		carcel.activarEfecto(jugador);	
		
		jugador.avanzar(2);
		
		assertFalse( carcel.estaPreso(jugador) );
		assertEquals( casillero3.getPosicion(), jugador.getPosicion());

	}
	
	@Test
	public void CuandoUnJugadorNoTieneCapitalSuficienteYPagaFianzaLanzaCapitalInsuficiente() {
		
		Jugador jugador = new Jugador();		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
		
		jugador.disminuirCapital(90000);
		assertTrue(jugador.getCapital()<45000);
		try {
			carcel.liberarJugadorPorFianza(jugador);
			fail();
		} catch (CapitalInsuficiente e) {
			assertTrue(true);
		}		
	}
	
	@Test
	public void CuandoUnJugadorNoTieneCapitalSuficienteYPagaFianzaSigueEnLaCarcel() {
		
		Jugador jugador = new Jugador();		
		Carcel carcel = new Carcel();
		
		carcel.activarEfecto(jugador);
		carcel.activarEfecto(jugador);
		
		jugador.disminuirCapital(90000);
		assertTrue(jugador.getCapital()<45000);
		try {
			carcel.liberarJugadorPorFianza(jugador);
			fail();
		} catch (CapitalInsuficiente e) {
			assertTrue(true);
		}
		
		assertTrue( carcel.estaPreso(jugador) );
	}

}
