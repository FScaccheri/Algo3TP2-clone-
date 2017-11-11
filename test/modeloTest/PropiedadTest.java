package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Propiedad;

public class PropiedadTest {

	@Test
	public void AlCrearUnaPropiedadLaCantidadDeCasasEsCero() {
		Propiedad propiedad = new Propiedad(0, 0);
		assertEquals(0, propiedad.getCantidadDeCasas(), 0);
	}

	@Test
	public void AlCrearUnaPropiedadtieneHotelDevuelveFalso() {
		Propiedad propiedad = new Propiedad(0, 0);
		assertFalse(propiedad.tieneHotel());
	}

	@Test
	public void AlCrearUnaPropiedadtienePropietarioDevuelveFalse() {
		Propiedad propiedad = new Propiedad(0, 0);
		assertFalse(propiedad.tienePropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadtienePropietarioDevuelveTrue() {
		Propiedad propiedad = new Propiedad(0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void AlCrearUnaPropiedadgetPropietarioDevuelveNull() {
		Propiedad propiedad = new Propiedad(0, 0);
		assertNull(propiedad.getPropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadgetPropietarioDevuelveElJugador() {
		Propiedad propiedad = new Propiedad(0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertEquals(propiedad.getPropietario(), jugador);
	}
	
	@Test
	public void UnJugadorQueNoAdquirioLaPropiedadNoEsPropietario() {
		Propiedad propiedad = new Propiedad(0, 0);
		Jugador propietario = new Jugador();
		Jugador usuario  = new Jugador();
		
		propiedad.adquirir(propietario);
		
		assertFalse(propiedad.esPropietario(usuario));
	}

	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadSuCapitalDisminuyeEnElValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 0);
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.adquirir(jugador);
		
		assertEquals(capitalInicial - 5000, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeSerElPropietario() {
		Propiedad propiedad = new Propiedad(0 ,0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertFalse(propiedad.esPropietario(jugador));
	}
	
	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeTenerPropietario() {
		Propiedad propiedad = new Propiedad(0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertNull(propiedad.getPropietario());
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadSinCasasNiHotelSuCapitalAumentaEnLaMitadDelValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);

		double capitalInicial = jugador.getCapital();

		propiedad.vender();

		assertEquals(capitalInicial + 5000/2, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinPropietarioNoDisminuyeSuCapital() {
		Propiedad propiedad = new Propiedad(5000, 0);
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.activarEfecto(jugador);

		assertEquals(capitalInicial, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioSuCapitalDisminuyeEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 200);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial - 200, inquilino.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioElCapitalDelPropietarioAumentaEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 200);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial + 200, propietario.getCapital(), 0);
	}
}
