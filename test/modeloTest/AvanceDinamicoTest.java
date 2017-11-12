package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;
import modelo.*;

public class AvanceDinamicoTest {

	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe2Avanza0() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(2);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 0);
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe3Avanza1() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(3);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 1);
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe4Avanza2() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(4);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 2);
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe5Avanza3() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(5);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 3);
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe6Avanza4() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(6);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 4);
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada7AvanzaRestoDeCapitalDividido7() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(20000);
		
		unJugador.setUltimaTirada(7);
		unJugador.moverAPosicion(0);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 0+(20000%7));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada8AvanzaRestoDeCapitalDividido8() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(6000);
		
		unJugador.setUltimaTirada(8);
		unJugador.moverAPosicion(3);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 3+(6000%8));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada9AvanzaRestoDeCapitalDividido9() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(94000);
		
		unJugador.setUltimaTirada(9);
		unJugador.moverAPosicion(4);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 4+(94000%9));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada10AvanzaRestoDeCapitalDividido10() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(73000);
		
		unJugador.setUltimaTirada(10);
		unJugador.moverAPosicion(18);
		
		aDinamico.activarEfecto(unJugador);
		
		assertTrue(unJugador.getPosicion() == 18+(73000%10));
	}
	
//	@Test
//	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada11Avanza11MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
//		
//		Jugador unJugador = new Jugador();
//		AvanceDinamico aDinamico = new AvanceDinamico();
//		Propiedad propiedad1 = new Propiedad(100,10);
//		Propiedad propiedad2 = new Propiedad(100,10);
//		Propiedad propiedad3 = new Propiedad(100,10);
//		Propiedad propiedad4 = new Propiedad(100,10);
//		Propiedad propiedad5 = new Propiedad(100,10);
//		
//		propiedad1.adquirir(unJugador);
//		propiedad2.adquirir(unJugador);
//		propiedad3.adquirir(unJugador);
//		propiedad4.adquirir(unJugador);
//		propiedad5.adquirir(unJugador);
//		propiedad1.agregarCasa();
//		propiedad2.agregarCasa();
//		propiedad2.agregarHotel();
//		
//		unJugador.setUltimaTirada(11);
//		unJugador.moverAPosicion(0);
//		
//		aDinamico.activarEfecto(unJugador);
//		
//		assertTrue(unJugador.getPosicion() == 0+ 11-2-2-1-1-1);
//	}
//	
//	@Test
//	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada12Avanza11MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
//		
//		Jugador unJugador = new Jugador();
//		AvanceDinamico aDinamico = new AvanceDinamico();
//		Propiedad propiedad1 = new Propiedad(100,10);
//		Propiedad propiedad2 = new Propiedad(100,10);
//		Propiedad propiedad3 = new Propiedad(100,10);
//		Propiedad propiedad4 = new Propiedad(100,10);
//		Propiedad propiedad5 = new Propiedad(100,10);
//		Propiedad propiedad6 = new Propiedad(100,10);
//		Propiedad propiedad7 = new Propiedad(100,10);
//		
//		propiedad1.adquirir(unJugador);
//		propiedad2.adquirir(unJugador);
//		propiedad3.adquirir(unJugador);
//		propiedad4.adquirir(unJugador);
//		propiedad5.adquirir(unJugador);
//		propiedad6.adquirir(unJugador);
//		propiedad7.adquirir(unJugador);
//		
//		propiedad1.agregarCasa();
//		propiedad2.agregarCasa();
//		propiedad2.agregarHotel();
//		propiedad3.agregarCasa();
//		propiedad4.agregarCasa();
//		propiedad5.agregarCasa();
//		propiedad5.agregarHotel();
//		
//		unJugador.setUltimaTirada(11);
//		unJugador.moverAPosicion(0);
//		
//		aDinamico.activarEfecto(unJugador);
//		
//		assertTrue(unJugador.getPosicion() == 0+ 12-2-2-2-2-2-1-1);
//	}
}