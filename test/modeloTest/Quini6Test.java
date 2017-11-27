package modeloTest;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;


import modelo.Jugador;
import modelo.casilleros.Quini6;

public class Quini6Test {

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorPrimeraVezSuCapitalAumentaEn50000() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();

		quini6.activarEfecto(jugador);

		assertEquals( capitalInicial + 50000 , jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorSegundaVezSuCapitalAumentaEn30000() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		quini6.activarEfecto(jugador);

		double capitalInicial = jugador.getCapital();
		
		quini6.activarEfecto(jugador);
		
		assertEquals(capitalInicial + 30000 , jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnQuini6PorTerceraVezSuCapitalNoAumenta() {
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador();
		
		quini6.activarEfecto(jugador);
		quini6.activarEfecto(jugador);

		double capitalInicial = jugador.getCapital();
		
		quini6.activarEfecto(jugador);
		
		assertEquals(capitalInicial, jugador.getCapital(), 0);
	}
	
	@Test
	public void CuandoTresJuagadoresCaeEnQuini6PorPrimeraVezSuCapitalAumentaCorrectamente() {
		Quini6 quini6 = new Quini6();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Jugador jugador3 = new Jugador();
		
		double capitalInicial1 = jugador1.getCapital();
		double capitalInicial2 = jugador2.getCapital();
		double capitalInicial3 = jugador2.getCapital();
		
		quini6.activarEfecto(jugador1);
		quini6.activarEfecto(jugador2);
		quini6.activarEfecto(jugador3);

		assertEquals( capitalInicial1 + 50000 , jugador1.getCapital(), 0);
		assertEquals( capitalInicial2 + 50000 , jugador2.getCapital(), 0);
		assertEquals( capitalInicial3 + 50000 , jugador3.getCapital(), 0);
	}
}
