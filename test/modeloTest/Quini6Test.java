package modeloTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import modelo.Efecto;
import modelo.Jugador;
import modelo.Quini6;

public class Quini6Test {

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorPrimeraVezSuCapitalAumentaEn50000() {
		Efecto quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		jugador.setCapital(0);
		quini6.activarEfecto(jugador);
		
		assertEquals( 50000 , jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorSegundaVezSuCapitalAumentaEn30000() {
		Efecto quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		quini6.activarEfecto(jugador);

		double capitalInicial = jugador.getCapital();
		
		quini6.activarEfecto(jugador);
		
		assertEquals(capitalInicial + 30000 , jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorTerceraVezSuCapitalNoAumenta() {
		Efecto quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		quini6.activarEfecto(jugador);
		quini6.activarEfecto(jugador);

		double capitalInicial = jugador.getCapital();
		
		quini6.activarEfecto(jugador);
		
		assertEquals(capitalInicial, jugador.getCapital(), 0);
	}
	
}
