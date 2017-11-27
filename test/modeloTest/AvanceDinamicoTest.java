package modeloTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import modelo.*;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.movimiento.AvanceDinamico;

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
		
		Tirada.setUltimaTirada(2);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 0 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe3Avanza1() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		Tirada.setUltimaTirada(3);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 1 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero2));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe4Avanza2() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		Tirada.setUltimaTirada(4);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero9));
		
		aDinamico.activarEfecto(unJugador); //avanza 2 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero2));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe5Avanza3() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		Tirada.setUltimaTirada(5);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador); //avanza 3 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero4));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConUnaTiradaDe6Avanza4() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		
		Tirada.setUltimaTirada(6);
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
		
		Tirada.setUltimaTirada(7);
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
		
		Tirada.setUltimaTirada(8);
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
		
		Tirada.setUltimaTirada(9);
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
		
		Tirada.setUltimaTirada(10);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador);
		//173000%10=0 -> avanza 0 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada11Avanza11MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		Propiedad propiedad1 = new Propiedad(100,10,20,10);
		Propiedad propiedad2 = new Propiedad(100,10,20,10,10,10,10);
		Propiedad propiedad3 = new Propiedad(100,10,20,10);
		Propiedad propiedad4 = new Propiedad(100,10,20,10);
		Propiedad propiedad5 = new Propiedad(100,10,20,10);
		
		unJugador.adquirir(propiedad1);
		unJugador.adquirir(propiedad2);
		unJugador.adquirir(propiedad3);
		unJugador.adquirir(propiedad4);
		unJugador.adquirir(propiedad5);

		propiedad1.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirHotel();
		
		Tirada.setUltimaTirada(11);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador);
		
		//11-7 = 4
		assertEquals(Tablero.getInstancia().posicion(casillero5),unJugador.getPosicion());
	}
	
	@Test
	public void testAlCaerUnJugadorEnAvanceDinamicoConTirada12Avanza12MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
		
		Jugador unJugador = new Jugador();
		AvanceDinamico aDinamico = new AvanceDinamico();
		Propiedad propiedad1 = new Propiedad(100,10,20,10);
		Propiedad propiedad2 = new Propiedad(100,10,20,10,10,10,10);
		Propiedad propiedad3 = new Propiedad(100,10,20,10);
		Propiedad propiedad4 = new Propiedad(100,10,20,10);
		Propiedad propiedad5 = new Propiedad(100,10,20,10);
		Propiedad propiedad6 = new Propiedad(100,10,20,10);
		Propiedad propiedad7 = new Propiedad(100,10,20,10);
		unJugador.aumentarCapital(10000);
		
		unJugador.adquirir(propiedad1);
		unJugador.adquirir(propiedad2);
		unJugador.adquirir(propiedad3);
		unJugador.adquirir(propiedad4);
		unJugador.adquirir(propiedad5);
		unJugador.adquirir(propiedad6);
		unJugador.adquirir(propiedad7);

		propiedad1.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		propiedad3.construirCasa();
		
		Tirada.setUltimaTirada(12);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		aDinamico.activarEfecto(unJugador);
		
		//12-2-3-2-1-1-1-1 = 1
		assertEquals(Tablero.getInstancia().posicion(casillero2), unJugador.getPosicion());
	}
}