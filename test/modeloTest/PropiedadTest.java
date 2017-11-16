package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.InformeDeAlquileres;
import modelo.InformeDeConstruccion;
import modelo.Jugador;
import modelo.Propiedad;

public class PropiedadTest {

	@Test
	public void AlCrearUnaPropiedadLaCantidadDeCasasEsCero() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		assertEquals(0, propiedad.getCantidadDeCasas(), 0);
	}

	@Test
	public void AlCrearUnaPropiedadtieneHotelDevuelveFalso() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		assertFalse(propiedad.tieneHotel());
	}

	@Test
	public void AlCrearUnaPropiedadtienePropietarioDevuelveFalse() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		assertFalse(propiedad.tienePropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadtienePropietarioDevuelveTrue() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void AlCrearUnaPropiedadgetPropietarioDevuelveNull() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		assertNull(propiedad.getPropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadgetPropietarioDevuelveElJugador() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertEquals(propiedad.getPropietario(), jugador);
	}
	
	@Test
	public void UnJugadorQueNoAdquirioLaPropiedadNoEsPropietario() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador propietario = new Jugador();
		Jugador usuario  = new Jugador();
		
		propiedad.adquirir(propietario);
		
		assertFalse(propiedad.esPropietario(usuario));
	}

	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadSuCapitalDisminuyeEnElValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.adquirir(jugador);
		
		assertEquals(capitalInicial - 5000, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeSerElPropietario() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertFalse(propiedad.esPropietario(jugador));
	}
	
	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeTenerPropietario() {
		Propiedad propiedad = new Propiedad(0, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertNull(propiedad.getPropietario());
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadSinCasasNiHotelSuCapitalAumentaEnLaMitadDelValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);

		double capitalInicial = jugador.getCapital();

		propiedad.vender();

		assertEquals(capitalInicial + 5000/2, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinPropietarioNoDisminuyeSuCapital() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(), new InformeDeConstruccion());
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.activarEfecto(jugador);

		assertEquals(capitalInicial, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioSuCapitalDisminuyeEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200, 0, 0, 0), new InformeDeConstruccion());
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial - 200, inquilino.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioElCapitalDelPropietarioAumentaEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200, 0, 0, 0), new InformeDeConstruccion());
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial + 200, propietario.getCapital(), 0);
	}
	
	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadDeLaCualEsPropietarioNoDisminuyeSuCapital() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200, 0, 0, 0), new InformeDeConstruccion());
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.activarEfecto(propietario);

		assertEquals(capitalInicial, propietario.getCapital(), 0);
	}
	
	@Test
	public void testConstruirUnaCasaEnUnaPropiedadAumentaLaCantidadDeCasasEnEsaPropiedad() {

		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200, 0, 0, 0), new InformeDeConstruccion());
		Jugador unJugador = new Jugador();
		propiedad.adquirir(unJugador);
		propiedad.construirCasa();
		
		assertEquals(1,propiedad.getCantidadDeCasas());
	}
	
	@Test
	public void testUnaPropiedadTieneCantidadDeCasasInicialCero() {
		
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200,0,0,0),new InformeDeConstruccion());
		
		assertEquals(0, propiedad.getCantidadDeCasas());
	}
	
	@Test
	public void testUnaPropiedadTieneCantidadDeHotelesInicialCero() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200,0,0,0),new InformeDeConstruccion());
		
		assertEquals(0,propiedad.getCantidadDeHoteles());
	}
	
	@Test
	public void testConstuirUnHotelEnUnaPropiedadAumentaLaCantidadDeHoteles() {
		Propiedad propiedad = new Propiedad(5000, new InformeDeAlquileres(200,0,0,0),new InformeDeConstruccion());
		Jugador unJugador = new Jugador();
		propiedad.adquirir(unJugador);
		propiedad.construirHotel();
		
		assertEquals(1,propiedad.getCantidadDeHoteles());
	}
}
