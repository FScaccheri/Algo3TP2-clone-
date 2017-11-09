package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;

public class JugadorTest {

	@Test
	public void AlAumentarElCapitalUnaVezAumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.aumentarCapital(50000);
		
		assertEquals(capitalInicial + 50000, jugador.getCapital(), 0);
	}

	@Test
	public void AlAumentarElCapitalDosVecesConValoresDistintosAumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.aumentarCapital(50000);
		jugador.aumentarCapital(10000);
		
		assertEquals(capitalInicial + 60000, jugador.getCapital(), 0);
	}

	@Test
	public void AlDisminuirElCapitalUnaVezAumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.disminuirCapital(50000);
		
		assertEquals(capitalInicial - 50000, jugador.getCapital(), 0);
	}

	@Test
	public void AlDisminuirElCapitalDosVecesConValoresDistintosAumentaCorrectamente() {
		Jugador jugador = new Jugador();
		double capitalInicial = jugador.getCapital();
		
		jugador.disminuirCapital(50000);
		jugador.disminuirCapital(10000);
		
		assertEquals(capitalInicial - 60000, jugador.getCapital(), 0);
	}
}
