package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	@Test
	public void AlAumentarElCapitalEn50000AumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.aumentarCapital(50000);
		
		assertEquals(capitalInicial + 50000, jugador.getCapital(), 0);
	}

	@Test
	public void AlAumentarElCapitalEn10000AumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.aumentarCapital(10000);
		
		assertEquals(capitalInicial + 10000, jugador.getCapital(), 0);
	}

	// Definir que ocurre si se aumenta el capital en un monto negativo o cero. Lanzamos excepcion o no es un escenario a considerar en nuestro modelo?
}
