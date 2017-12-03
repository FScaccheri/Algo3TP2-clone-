package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AdministradorDeTurnos;
import modelo.Jugador;
import modelo.Tirada;
import modelo.excepciones.LanzamientoImposible;

public class AdministradorDeTurnosTest {
	
	@Test
	public void ElPrimerTurnoEsElDelPrimerJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();

		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);

		assertEquals(admin.getJugadorActual(), jugador1);
	}

	@Test
	public void AlFinalizarUnTurnoElJugadorActualEsElSiguiente() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		Tirada.setSalieronDobles(false);
		admin.finalizarTurno();
		
		assertEquals(admin.getJugadorActual(), jugador2);
	}

	@Test
	public void AlFinalizarLosTurnosDeTodosLosJugadoresVuelveAEmpezar() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		Tirada.setSalieronDobles(false);
		admin.finalizarTurno();
		admin.lanzarDados();
		Tirada.setSalieronDobles(false);
		admin.finalizarTurno();
		admin.lanzarDados();
		Tirada.setSalieronDobles(false);
		admin.finalizarTurno();
		admin.lanzarDados();
		Tirada.setSalieronDobles(false);
		admin.finalizarTurno();
		
		assertEquals(admin.getJugadorActual(), jugador1);
	}
	

	@Test
	public void SiLanzaLosDadosDosVecesLanzaLanzamientoImposible() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		try {
			admin.lanzarDados();
			fail();
		} catch (LanzamientoImposible e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void SiSalenDoblesEsElTurnoDelMismoJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		Tirada.setSalieronDobles(true);
		
		assertEquals(admin.getJugadorActual(), jugador1);
	}
	
	@Test
	public void SiSalenDoblesDosVecesEsElTurnoDelSiguienteJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		Tirada.setSalieronDobles(true);
		admin.finalizarTurno();
		admin.lanzarDados();
		Tirada.setSalieronDobles(true);
		admin.finalizarTurno();
		
		assertEquals(admin.getJugadorActual(), jugador2);
	}
	
	@Test
	public void AntesDeLanzarLosDadosLanzoLosDadosDevuelveFalse() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		assertFalse(admin.lanzoLosDados());
	}

	@Test
	public void LuegoDeLanzarLosDadosLanzoLosDadosDevuelveTrue() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos admin = new  AdministradorDeTurnos();
		
		admin.agregarJugador(jugador1);
		admin.agregarJugador(jugador2);
		admin.agregarJugador(jugador3);
		admin.agregarJugador(jugador4);
		
		admin.lanzarDados();
		
		assertTrue(admin.lanzoLosDados());
	}
}
