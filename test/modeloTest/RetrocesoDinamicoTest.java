package modeloTest;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import modelo.*;
import modelo.casilleros.Casillero;
import modelo.casilleros.RetrocesoDinamico;
import modelo.casilleros.adquiribles.Propiedad;

public class RetrocesoDinamicoTest {
	
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
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConUnaTiradaDe2Retrocede0() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		
		unJugador.setUltimaTirada(2);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		rDinamico.activarEfecto(unJugador); //retrocede 0 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConUnaTiradaDe3Retrocede1() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		
		unJugador.setUltimaTirada(3);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero2));
		
		rDinamico.activarEfecto(unJugador); //retrocede 1 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConUnaTiradaDe4Retrocede2() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();

		unJugador.setUltimaTirada(4);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero9));
		
		rDinamico.activarEfecto(unJugador); //retrocede 2 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero7));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConUnaTiradaDe5Retrocede3() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();

		unJugador.setUltimaTirada(5);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero4));
		
		rDinamico.activarEfecto(unJugador); //retrocede 3 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConUnaTiradaDe6Retrocede4() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();

		unJugador.setUltimaTirada(6);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero6));
		
		rDinamico.activarEfecto(unJugador); //retrocede 4 lugares
		
		assertEquals(unJugador.getPosicion(),Tablero.getInstancia().posicion(casillero2));
	}
	
	//Las Siguientes pruebas para los casos de ultima tirada 7 8 9 y 10, se realiaron para un jugador con cantidad inicial de dinero igual a 100000 @Franco R.
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada7RetrocedeRestoDeCapitalDividido7() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		unJugador.aumentarCapital(20000);
		
		unJugador.setUltimaTirada(7);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero9));
		
		rDinamico.activarEfecto(unJugador);
		//120000%7=6 -> retrocede 6 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero3));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada8RetrocedeRestoDeCapitalDividido8() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		unJugador.aumentarCapital(6000);
		
		unJugador.setUltimaTirada(8);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero5));
		
		rDinamico.activarEfecto(unJugador);
		//106000%8=0 -> retrocede 0 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero5));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada9RetrocedeRestoDeCapitalDividido9() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		unJugador.aumentarCapital(9400);
		
		unJugador.setUltimaTirada(9);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero9));
		
		rDinamico.activarEfecto(unJugador);
		//194000%9=9 -> retrocede 5 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero4));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada10RetrocedeRestoDeCapitalDividido10() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		unJugador.aumentarCapital(73000);
		
		unJugador.setUltimaTirada(10);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero1));
		
		rDinamico.activarEfecto(unJugador);
		//173000%10=0 -> retrocede 0 lugares
		assertEquals(unJugador.getPosicion(), Tablero.getInstancia().posicion(casillero1));
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada11Retrocede11MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		Propiedad propiedad1 = new Propiedad(100,10,20,10);
		Propiedad propiedad2 = new Propiedad(100,10,20,10,10,10,10);
		Propiedad propiedad3 = new Propiedad(100,10,20,10);
		Propiedad propiedad4 = new Propiedad(100,10,20,10);
		Propiedad propiedad5 = new Propiedad(100,10,20,10);
		
		propiedad1.adquirir(unJugador);
		propiedad2.adquirir(unJugador);
		propiedad3.adquirir(unJugador);
		propiedad4.adquirir(unJugador);
		propiedad5.adquirir(unJugador);
		propiedad1.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirHotel();
		
		unJugador.setUltimaTirada(11);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero7));
		
		rDinamico.activarEfecto(unJugador);
		
		//11-7 = 4 -> retrocede 4 lugares
		assertEquals(Tablero.getInstancia().posicion(casillero3),unJugador.getPosicion());
	}
	
	@Test
	public void testAlCaerUnJugadorEnRetrocesoDinamicoConTirada12Retrocede12MenosLaSumaLaCantidadDeDeSusTerrenosCasasYHoteles() {
		
		Jugador unJugador = new Jugador();
		RetrocesoDinamico rDinamico = new RetrocesoDinamico();
		Propiedad propiedad1 = new Propiedad(100,10,20,10);
		Propiedad propiedad2 = new Propiedad(100,10,20,10,10,10,10);
		Propiedad propiedad3 = new Propiedad(100,10,20,10);
		Propiedad propiedad4 = new Propiedad(100,10,20,10);
		Propiedad propiedad5 = new Propiedad(100,10,20,10);
		Propiedad propiedad6 = new Propiedad(100,10,20,10);
		Propiedad propiedad7 = new Propiedad(100,10,20,10);
		unJugador.aumentarCapital(10000);
		
		propiedad1.adquirir(unJugador);
		propiedad2.adquirir(unJugador);
		propiedad3.adquirir(unJugador);
		propiedad4.adquirir(unJugador);
		propiedad5.adquirir(unJugador);
		propiedad6.adquirir(unJugador);
		propiedad7.adquirir(unJugador);
		propiedad1.construirCasa();
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		propiedad3.construirCasa();
		
		unJugador.setUltimaTirada(12);
		unJugador.setPosicion(Tablero.getInstancia().posicion(casillero9));
		
		rDinamico.activarEfecto(unJugador);
		
		//12-2-3-2-1-1-1-1 = 1 ---> retrocede 1 lugar
		assertEquals(Tablero.getInstancia().posicion(casillero8), unJugador.getPosicion());
	}
}