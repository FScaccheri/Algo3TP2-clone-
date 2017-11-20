package modeloTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modelo.Adquirible;
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
	public void AlCrearTerrenoGetAdquiriblesDevuelveUnArrayVacio() {
		Terreno terreno = new Terreno(0, 0);
		
		ArrayList<Adquirible> Adquiribles = terreno.getConstrucciones();
		int cantElementos = Adquiribles.size();
		
		assertEquals(cantElementos, 0);
	}

	@Test
	public void AlCrearTerrenoTieneHotelDevuelveFalso() {
		Terreno terreno = new Terreno(0, 0);
		assertFalse(terreno.tieneHoteles());
	}
	
	@Test
	public void AlCrearTerrenoConstruccionDeCasaPosibleDevuelveTrue() {
		Terreno terreno = new Terreno(1, 0);
		assertTrue(terreno.construccionDeCasaPosible());
	}
	
	@Test
	public void AlCrearTerrenoConstruccionDeHotelPosibleDevuelveFalse() {
		Terreno terreno = new Terreno(1, 1);
		assertFalse(terreno.construccionDeHotelPosible());
	}
	
	@Test
	public void AlAgregarUnaCasaGetCantidadDeCasasDevuelveUno() {
		Terreno terreno = new Terreno(2, 0);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		
		int cantidadDeCasas = terreno.getCantidadDeCasas();
		
		assertEquals(cantidadDeCasas, 1);
	}

	@Test
	public void AlAgregarUnaCasaGetAdquiriblesDevuelveUnArrayConUnAdquirible() {
		Terreno terreno = new Terreno(2, 0);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		
		ArrayList<Adquirible> Adquiribles = terreno.getConstrucciones();
		int cantElementos = Adquiribles.size();
		
		assertEquals(cantElementos, 1);
	}
	
	@Test
	public void AlLlegarALaCantidadMaximaDeCasasConstruccionDeCasaPosibleDevuelveFalse() {
		Terreno terreno = new Terreno(1, 1);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		
		assertFalse(terreno.construccionDeCasaPosible());
	}
	
	@Test
	public void AlLlegarALaCantidadMaximaDeCasasConstruccionDeHotelPosibleDevuelveTrue() {
		Terreno terreno = new Terreno(1, 1);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		
		assertTrue(terreno.construccionDeHotelPosible());
	}
	
	@Test
	public void AlAgregarUnaCasaGetAdquiriblesDevuelveUnArrayConLaMismaCasa() {
		Terreno terreno = new Terreno(2, 0);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		
		ArrayList<Adquirible> Adquiribles = terreno.getConstrucciones();
		
		assertTrue(Adquiribles.get(0)==casa);
	}
	
	@Test
	public void AlAgregarMasCasasQueLaCantidadMaximaLanzaConstruccionImposible() {
		Terreno terreno = new Terreno(2, 0);
		Adquirible casa = new Adquirible(0);
		
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
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarHotel(hotel);
		
		int cantidadDeHoteles = terreno.getCantidadDeHoteles();
		
		assertEquals(cantidadDeHoteles, 1);
	}
	
	@Test
	public void AlAgregarUnHotelTieneHotelesDevuelveTrue() {
		Terreno terreno = new Terreno(0, 2);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarHotel(hotel);
		
		assertTrue(terreno.tieneHoteles());
	}

	@Test
	public void AlAgregarUnHotelGetAdquiriblesDevuelveUnArrayConUnAdquirible() {
		Terreno terreno = new Terreno(0, 2);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarHotel(hotel);
		
		ArrayList<Adquirible> Adquiribles = terreno.getConstrucciones();
		int cantElementos = Adquiribles.size();
		
		assertEquals(cantElementos, 1);
	}
	
	@Test
	public void AlAgregarUnHotelGetAdquiriblesDevuelveUnArrayConElMismoHotel() {
		Terreno terreno = new Terreno(0, 2);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarHotel(hotel);
		
		ArrayList<Adquirible> Adquiribles = terreno.getConstrucciones();
		
		assertTrue(Adquiribles.get(0)==hotel);
	}

	@Test
	public void AlAgregarUnHotelConstruccionDeCasaPosibleDevuelveFalse() {
		Terreno terreno = new Terreno(1, 1);
		Adquirible casa = new Adquirible(0);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		terreno.agregarHotel(hotel);
		
		assertFalse(terreno.construccionDeCasaPosible());
	}
	
	@Test
	public void AlAgregarUnHotelConstruccionDeHotelPosibleDevuelveTrueSiNoEsElMaximo() {
		Terreno terreno = new Terreno(1, 2);
		Adquirible casa = new Adquirible(0);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		terreno.agregarHotel(hotel);
		
		assertTrue(terreno.construccionDeHotelPosible());
	}
	
	@Test
	public void AlLlegarALaCantidadMaximaDeHotelesConstruccionDeHotelPosibleDevuelveFalse() {
		Terreno terreno = new Terreno(1, 1);
		Adquirible casa = new Adquirible(0);
		Adquirible hotel = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		terreno.agregarHotel(hotel);
		
		assertFalse(terreno.construccionDeHotelPosible());
	}
	
	@Test
	public void AlAgregarMasHotelesQueLaCantidadMaximaLanzaConstruccionImposible() {
		Terreno terreno = new Terreno(0, 2);
		Adquirible hotel = new Adquirible(0);
		
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
		Adquirible hotel = new Adquirible(0);
		
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
		Adquirible hotel = new Adquirible(0);
		Adquirible casa = new Adquirible(0);
		
		terreno.agregarCasa(casa);
		terreno.agregarCasa(casa);
		terreno.agregarHotel(hotel);
		
		int cantidadDeCasas = terreno.getCantidadDeCasas();
		
		assertEquals(cantidadDeCasas, 0);
	}
}
