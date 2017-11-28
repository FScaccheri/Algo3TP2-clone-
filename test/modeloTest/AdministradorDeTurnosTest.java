package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.AdministradorDeTurnos2;
import modelo.Jugador;
import modelo.Tirada;
import modelo.excepciones.LanzamientoImposible;

public class AdministradorDeTurnosTest {

	@Test
	public void AdministradorDeTurnosRecibeUnJugador() {
		new AdministradorDeTurnos2(new Jugador());
		assertTrue(true);
	}

	@Test
	public void AdministradorDeTurnosRecibeVariosJugadores() {
		new AdministradorDeTurnos2(new Jugador(), new Jugador(), new Jugador(), new Jugador());
		assertTrue(true);
	}
	
	@Test
	public void ElPrimerTurnoEsElDelPrimerJugador() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		assertEquals(admin.getJugadorActual(), jugador1);
	}

	@Test
	public void AlFinalizarUnTurnoElJugadorActualEsElSiguiente() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		
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
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		
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
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		
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
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		
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
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		
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
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		assertFalse(admin.lanzoLosDados());
	}

	@Test
	public void LuegoDeLanzarLosDadosLanzoLosDadosDevuelveTrue() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		Jugador jugador4 = new Jugador();
		
		AdministradorDeTurnos2 admin = new  AdministradorDeTurnos2(jugador1, jugador2, jugador3 , jugador4);
		admin.lanzarDados();
		assertTrue(admin.lanzoLosDados());
	}
}
