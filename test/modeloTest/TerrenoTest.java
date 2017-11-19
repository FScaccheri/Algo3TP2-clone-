package modeloTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modelo.Edificio;
import modelo.Terreno;
import modelo.excepciones.ConstruccionImposible;

public class TerrenoTest {

	@Test
	public void AlCrearTerrenoGetCantidadDeCasasDevuelveCero() {
		Terreno terreno = new Terreno(0, 0);
		
		int cantidadDeCasas = terreno.getCantidadDeCasas();
		
		assertEquals(cantidadDeCasas, 0);
	}

	@Test
	public void AlCrearTerrenoGetCantidadDeHotelesDevuelveCero() {
		Terreno terreno = new Terreno(0, 0);
		
		int cantidadDeHoteles = terreno.getCantidadDeHoteles();
		
		assertEquals(cantidadDeHoteles, 0);
	}

	@Test
	public void AlCrearTerrenoGetEdificiosDevuelveUnArrayVacio() {
		Terreno terreno = new Terreno(0, 0);
		
		ArrayList<Edificio> edificios = terreno.getEdificios();
		int cantElementos = edificios.size();
		
		assertEquals(cantElementos, 0);
	}

	@Test
	public void AlCrearTerrenoTieneHotelDevuelveFalso() {
		Terreno terreno = new Terreno(0, 0);
		assertFalse(terreno.tieneHoteles());
	}
	
	@Test
	public void AlAgregarUnaCasaGetCantidadDeCasasDevuelveUno() {
		Terreno terreno = new Terreno(2, 0);
		Edificio casa = new Edificio(0, 0);
		
		terreno.agregarCasa(casa);
		
		int cantidadDeCasas = terreno.getCantidadDeCasas();
		
		assertEquals(cantidadDeCasas, 1);
	}

	@Test
	public void AlAgregarUnaCasaGetEdificiosDevuelveUnArrayConUnEdificio() {
		Terreno terreno = new Terreno(2, 0);
		Edificio casa = new Edificio(0, 0);
		
		terreno.agregarCasa(casa);
		
		ArrayList<Edificio> edificios = terreno.getEdificios();
		int cantElementos = edificios.size();
		
		assertEquals(cantElementos, 1);
	}
	
	@Test
	public void AlAgregarUnaCasaGetEdificiosDevuelveUnArrayConLaMismaCasa() {
		Terreno terreno = new Terreno(2, 0);
		Edificio casa = new Edificio(0, 0);
		
		terreno.agregarCasa(casa);
		
		ArrayList<Edificio> edificios = terreno.getEdificios();
		
		assertTrue(edificios.get(0)==casa);
	}
	
	@Test
	public void AlAgregarMasCasasQueLaCantidadMaximaLanzaConstruccionImposible() {
		Terreno terreno = new Terreno(2, 0);
		Edificio casa = new Edificio(0, 0);
		
		terreno.agregarCasa(casa);
		terreno.agregarCasa(casa);
		
		try {
			terreno.agregarCasa(casa);
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}

	@Test
	public void AlAgregarUnHotelGetCantidadDeHotelesDevuelveUno() {
		Terreno terreno = new Terreno(0, 2);
		Edificio hotel = new Edificio(0, 0);
		
		terreno.agregarHotel(hotel);
		
		int cantidadDeHoteles = terreno.getCantidadDeHoteles();
		
		assertEquals(cantidadDeHoteles, 1);
	}
	
	@Test
	public void AlAgregarUnHotelTieneHotelesDevuelveTrue() {
		Terreno terreno = new Terreno(0, 2);
		Edificio hotel = new Edificio(0, 0);
		
		terreno.agregarHotel(hotel);
		
		assertTrue(terreno.tieneHoteles());
	}

	@Test
	public void AlAgregarUnHotelGetEdificiosDevuelveUnArrayConUnEdificio() {
		Terreno terreno = new Terreno(0, 2);
		Edificio hotel = new Edificio(0, 0);
		
		terreno.agregarHotel(hotel);
		
		ArrayList<Edificio> edificios = terreno.getEdificios();
		int cantElementos = edificios.size();
		
		assertEquals(cantElementos, 1);
	}
	
	@Test
	public void AlAgregarUnHotelGetEdificiosDevuelveUnArrayConElMismoHotel() {
		Terreno terreno = new Terreno(0, 2);
		Edificio hotel = new Edificio(0, 0);
		
		terreno.agregarHotel(hotel);
		
		ArrayList<Edificio> edificios = terreno.getEdificios();
		
		assertTrue(edificios.get(0)==hotel);
	}

	@Test
	public void AlAgregarMasHotelesQueLaCantidadMaximaLanzaConstruccionImposible() {
		Terreno terreno = new Terreno(0, 2);
		Edificio hotel = new Edificio(0, 0);
		
		terreno.agregarHotel(hotel);
		terreno.agregarHotel(hotel);
		
		try {
			terreno.agregarHotel(hotel);
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}

	@Test
	public void AlAgregarUnHotelEnUnTerrenoQueNoTieneLaCantidadMaximaDeCasasLanzaConstruccionImposible() {
		Terreno terreno = new Terreno(2, 2);
		Edificio hotel = new Edificio(0, 0);
		
		try {
			terreno.agregarHotel(hotel);
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}

	@Test
	public void AlAgregarUnHotelGetCantidadDeCasasDevuelveCero() {
		Terreno terreno = new Terreno(2, 2);
		Edificio hotel = new Edificio(0, 0);
		Edificio casa = new Edificio(0, 0);
		
		terreno.agregarCasa(casa);
		terreno.agregarCasa(casa);
		terreno.agregarHotel(hotel);
		
		int cantidadDeCasas = terreno.getCantidadDeCasas();
		
		assertEquals(cantidadDeCasas, 0);
	}
}
