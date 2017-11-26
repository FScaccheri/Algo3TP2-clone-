package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Propiedad;
import modelo.excepciones.ConstruccionImposible;

public class PropiedadTest {

	@Test
	public void AlCrearUnaPropiedadLaCantidadDeCasasEsCero() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		assertEquals(0, propiedad.getCantidadDeCasas());
	}

	@Test
	public void AlCrearUnaPropiedadLaCantidadDeHotelesEsCero() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		assertEquals(0, propiedad.getCantidadDeHoteles());
	}
	
	@Test
	public void AlCrearUnaPropiedadtieneHotelDevuelveFalso() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		assertFalse(propiedad.tieneHotel());
	}

	@Test
	public void AlCrearUnaPropiedadtienePropietarioDevuelveFalse() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		assertFalse(propiedad.tienePropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadtienePropietarioDevuelveTrue() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void AlCrearUnaPropiedadgetPropietarioDevuelveNull() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		assertNull(propiedad.getPropietario());
	}
	
	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadgetPropietarioDevuelveElJugador() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertEquals(propiedad.getPropietario(), jugador);
	}
	
	@Test
	public void UnJugadorQueNoAdquirioLaPropiedadNoEsPropietario() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		Jugador usuario  = new Jugador();
		
		propiedad.adquirir(propietario);
		
		assertFalse(propiedad.esPropietario(usuario));
	}

	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadSuCapitalDisminuyeEnElValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.adquirir(jugador);
		
		assertEquals(capitalInicial - 5000, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeSerElPropietario() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertFalse(propiedad.esPropietario(jugador));
	}
	
	@Test
	public void CuandoUnJugadorVendeUnaPropiedadDejaDeTenerPropietario() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.vender();

		assertNull(propiedad.getPropietario());
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinPropietarioNoDisminuyeSuCapital() {
		Propiedad propiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		propiedad.activarEfecto(jugador);

		assertEquals(capitalInicial, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioSuCapitalDisminuyeEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial - 200, inquilino.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadSinCasasNiHotelConPropietarioElCapitalDelPropietarioAumentaEnElAlquilerDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.activarEfecto(inquilino);

		assertEquals(capitalInicial + 200, propietario.getCapital(), 0);
	}
	
	@Test
	public void CuandoUnJugadorCaeEnUnaPropiedadDeLaCualEsPropietarioNoDisminuyeSuCapital() {
		Propiedad propiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.activarEfecto(propietario);

		assertEquals(capitalInicial, propietario.getCapital(), 0);
	}
	
	@Test
	public void ConstruirUnaCasaDisminuyeElCapitalDelPropietarioEnElCostoDeLaCasa() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 200, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		propiedad.construirCasa();

		assertEquals(capitalInicial-200, propietario.getCapital(), 0);
	}

	@Test
	public void ConstruirUnaCasaAumentaLaCantidadCasasEnUno() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();

		assertEquals(propiedad.getCantidadDeCasas(), 1);
	}
	
	@Test
	public void ConstruirUnHotelDisminuyeElCapitalDelPropietarioEnElCostoDelHotel() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 200);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);		
		propiedad.construirCasa();
		propiedad.construirCasa();

		double capitalInicial = propietario.getCapital();
		
		propiedad.construirHotel();

		assertEquals(capitalInicial-200, propietario.getCapital(), 0);
	}
	
	@Test
	public void ConstruirUnHotelAumentaLaCantidadHotelesEnUno() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);		
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();

		assertEquals(propiedad.getCantidadDeHoteles(), 1);
	}

	@Test
	public void AlConstruirUnHotelTieneHotelDevuelveTrue() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);		
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();

		assertTrue(propiedad.tieneHotel());
	}

	@Test
	public void CuandoUnJugadorCaeEnLaPropiedadConUnaCasaSuCapitalDisminuyeCorrectamente() {
		Propiedad propiedad = new Propiedad(0, 0, 200, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-200, inquilino.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorCaeEnLaPropiedadConUnHotelSuCapitalDisminuyeCorrectamente() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 200, 0, 0);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-200, inquilino.getCapital(), 0);
	}
	
	@Test
	public void CuandoNoSePuedeConstruirUnaCasaNoDisminuyeElCapitalDelPropietario() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 200, 0);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();
		propiedad.construirCasa();

		double capitalInicial = propietario.getCapital();
		
		try {
			propiedad.construirCasa();
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
				
		assertEquals(capitalInicial, propietario.getCapital(), 0);
	}

	@Test
	public void CuandoNoSePuedeConstruirUnHotelNoDisminuyeElCapitalDelPropietario() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 200);
		Jugador propietario = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();

		double capitalInicial = propietario.getCapital();
		
		try {
			propiedad.construirHotel();
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
				
		assertEquals(capitalInicial, propietario.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadSinEdificiosSuCapitalAumentaEnUn75PorcientoDelValorDeLaPropiedad() {
		Propiedad propiedad = new Propiedad(5000, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);

		double capitalInicial = jugador.getCapital();

		propiedad.vender();

		assertEquals(capitalInicial + 5000*0.75, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadConUnaCasaSuCapitalAumentaEnUn75PorcientoDelValorTotal() {
		Propiedad propiedad = new Propiedad(5000, 0, 0, 0, 0, 2000, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.construirCasa();
		
		double capitalInicial = jugador.getCapital();

		propiedad.vender();

		assertEquals(capitalInicial + (5000+2000)*0.75, jugador.getCapital(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadConUnHotelSuCapitalAumentaEnUn75PorcientoDelValorTotal() {
		Propiedad propiedad = new Propiedad(5000, 0, 0, 0, 0, 2000, 6000);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();
		
		double capitalInicial = jugador.getCapital();

		propiedad.vender();

		assertEquals(capitalInicial + (5000+2000+2000+6000)*0.75, jugador.getCapital(), 0);
	}

	@Test
	public void AlTratarDeConstruirEnPropiedadesDependientesConDistintosPropietariosLanzaConstruccionImposible() {
		Propiedad propiedad1 = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad2 = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		propiedad1.asociar(propiedad2);
		
		propiedad1.adquirir(jugador1);
		propiedad2.adquirir(jugador2);
		
		try {
			propiedad1.construirCasa();
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}

	@Test
	public void AlTratarDeConstruirUnHotelSinQueEstenCompletasLasCasaEnPropiedadesDependientesLanzaConstruccionImposible() {
		Propiedad propiedad1 = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad2 = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad1.asociar(propiedad2);
		
		propiedad1.adquirir(jugador);
		propiedad2.adquirir(jugador);
		
		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		try {
			propiedad1.construirHotel();
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void CuandoUnJugadorVendeUnaPropiedadConCasasGetCantidadDeCasasDevuelveCero() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.construirCasa();
		propiedad.construirCasa();
		
		propiedad.vender();

		assertEquals(propiedad.getCantidadDeCasas(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadUnHotelGetCantidadDeHotelesDevuelveCero() {
		Propiedad propiedad = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		propiedad.construirCasa();
		propiedad.construirCasa();
		propiedad.construirHotel();
		
		propiedad.vender();

		assertEquals(propiedad.getCantidadDeHoteles(), 0);
	}

	@Test
	public void CuandoUnJugadorVendeUnaPropiedadConCasasYOtroLaCompraCobraElAlquilerCorrecto() {
		Propiedad propiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		propiedad.adquirir(propietario);
		propiedad.construirCasa();
		propiedad.construirCasa();
		
		propiedad.vender();

		propiedad.adquirir(propietario);
		
		double capitalInicial = inquilino.getCapital();
		
		propiedad.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-200, inquilino.getCapital(), 0);
	}
}
