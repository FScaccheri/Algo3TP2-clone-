package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.casilleros.adquiribles.Propiedad;

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
	
	@Test
	public void testAdquirirUnaPropiedadAumentaLaCantidadDePropiedadesQueTiene() {
		
		Jugador unJugador = new Jugador();
		Propiedad propiedad1 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad2 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad3 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad4 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad5 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad6 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad7 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad8 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad9 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		unJugador.aumentarCapital(10000);
		
		propiedad1.adquirir(unJugador);
		propiedad2.adquirir(unJugador);
		propiedad3.adquirir(unJugador);
		propiedad4.adquirir(unJugador);
		propiedad5.adquirir(unJugador);
		propiedad6.adquirir(unJugador);
		propiedad7.adquirir(unJugador);
		propiedad8.adquirir(unJugador);
		propiedad9.adquirir(unJugador);
		
		assertTrue(unJugador.cantidadDePropiedades() == 9);
	}
	
	@Test
	public void testConstruirUnaCasaEnUnaPropiedadAdquiridaAumentaLaCantidadDeCasasDelJugador() {
		Jugador unJugador = new Jugador();
		Propiedad propiedad1 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		unJugador.aumentarCapital(10000);
		propiedad1.adquirir(unJugador);
		
		propiedad1.construirCasa();
		
		assertEquals(1,unJugador.getCantidadDeCasas());
	}
	
	@Test
	public void testUnJugadorComienzaConCantidadDeCasasNula() {
		Jugador unJugador = new Jugador();
		
		assertEquals(0,unJugador.getCantidadDeCasas());
	}
	
	@Test
	public void testConstruirMultiplesCasasEnPropiedadesDeUnJugadorAumentaCorrectamenteLaCantidadDeCasas() {
		
		Jugador unJugador = new Jugador();
		Propiedad propiedad1 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad2 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad3 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad4 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad5 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad6 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad7 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad8 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad9 = new Propiedad(100, 0, 0, 0, 0, 0, 0);
		unJugador.aumentarCapital(10000);
		
		propiedad1.adquirir(unJugador);
		propiedad2.adquirir(unJugador);
		propiedad3.adquirir(unJugador);
		propiedad4.adquirir(unJugador);
		propiedad5.adquirir(unJugador);
		propiedad6.adquirir(unJugador);
		propiedad7.adquirir(unJugador);
		propiedad8.adquirir(unJugador);
		propiedad9.adquirir(unJugador);
		
		propiedad1.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		
		assertEquals(3,unJugador.getCantidadDeCasas());
	}
	
}
