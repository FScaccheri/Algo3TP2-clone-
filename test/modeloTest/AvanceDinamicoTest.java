package modeloTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import modelo.*;

public class AvanceDinamicoTest {
	
	private static Casillero casillero1 = new Casillero();
	private static Casillero casillero2 = new Casillero();
	private static Casillero casillero3 = new Casillero();
	private static Casillero casillero4 = new Casillero();
	private static Casillero casillero5 = new Casillero();
	private static Casillero casillero6 = new Casillero();
	private static Casillero casillero7 = new Casillero();
	private static Casillero casillero8 = new Casillero();
	private static Casillero casillero9 = new Casillero();
	
	@BeforeClass 
	public static void setUp() {
		Tablero.reset();
		Tablero tablero = Tablero.getInstancia();
		tablero.agregar(casillero1);
		tablero.agregar(casillero2);
		tablero.agregar(casillero3);
		tablero.agregar(casillero4);
		tablero.agregar(casillero5);
		tablero.agregar(casillero6);
		tablero.agregar(casillero7);
		tablero.agregar(casillero8);
		tablero.agregar(casillero9);
		
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe2Avanza0() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(2);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 0 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe3Avanza1() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(3);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 1 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero2));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe4Avanza2() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(4);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 2 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero3));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe5Avanza3() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(5);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 3 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero4));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe6Avanza4() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		unJugador.setUltimaTirada(6);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 4 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero5));
	}
	
	//Las Siguientes pruebas para los casos de ultima tirada 7 8 9 y 10, se realiaron para un jugador con cantidad inicial de dinero igual a 100000 @Franco R.
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada7AvanzaRestoDeCapitalDividido7() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(20000);
		
		unJugador.setUltimaTirada(7);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador);
		//120000%7=6 -> avanza 6 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero7));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada8AvanzaRestoDeCapitalDividido8() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(6000);
		
		unJugador.setUltimaTirada(8);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero5));
		
		aDinamico.activarEfecto(unJugador);
		//106000%8=0 -> avanza 0 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero5));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada9AvanzaRestoDeCapitalDividido9() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(9400);
		
		unJugador.setUltimaTirada(9);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero4));
		
		aDinamico.activarEfecto(unJugador);
		//194000%9=9 -> avanza 5 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero9));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada10AvanzaRestoDeCapitalDividido10() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		unJugador.aumentarCapital(73000);
		
		unJugador.setUltimaTirada(10);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador);
		//173000%10=0 -> avanza 0 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero1));
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