package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.excepciones.CapitalInsuficiente;
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
	
	@Test
	public void CuandoUnaPropiedadAsociadaTieneHotelLaOtraPropiedadPuedeConstruirUnHotel() {
		Propiedad propiedad1 = new Propiedad(0, 0, 0, 0, 0, 0, 0);
		Propiedad propiedad2 = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		propiedad1.asociar(propiedad2);
		
		Jugador propietario = new Jugador();
		
		propiedad1.adquirir(propietario);
		propiedad2.adquirir(propietario);
		
		propiedad1.construirCasa();
		propiedad1.construirCasa();
		
		propiedad2.construirCasa();
		propiedad2.construirCasa();
		
		propiedad1.construirHotel();
		propiedad2.construirHotel();
		assertTrue(propiedad2.tieneHotel());
	}
	
	// Pruebas 2da entrega
	@Test
	public void Entrega2test1() {
		Propiedad propiedad = new Propiedad(200, 0, 0, 0, 0, 0, 0);
		Jugador propietario = new Jugador();
		
		double capitalInicial = propietario.getCapital();
		propiedad.adquirir(propietario);
		assertEquals(capitalInicial-200, propietario.getCapital(), 0);
	}
	
	@Test
	public void Entrega2test2() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Jugador propietario = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		buenosAiresSur.construirCasa();
		assertEquals(capitalInicial-5000, propietario.getCapital(), 0);
	}
	
	@Test
	public void Entrega2test3() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		
		double capitalInicial = inquilino.getCapital();
		buenosAiresSur.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-3000, inquilino.getCapital(), 0);
	}
	
	@Test
	public void Entrega2test4() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		buenosAiresSur.construirCasa();
		
		double capitalInicial = inquilino.getCapital();
		buenosAiresNorte.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-3500, inquilino.getCapital(), 0);
	}
	
	@Test
	public void Entrega2test5() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		buenosAiresNorte.asociar(buenosAiresSur);
		
		Jugador propietario = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		buenosAiresNorte.construirCasa();
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		
		double capitalInicial = propietario.getCapital();
		
		try {
			buenosAiresNorte.construirHotel();
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
		
		assertEquals(capitalInicial, propietario.getCapital(), 0);
	}
	
	@Test
	public void Entrega2test6() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		buenosAiresNorte.asociar(buenosAiresSur);
		
		Jugador propietario = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		buenosAiresNorte.construirCasa();
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		buenosAiresSur.construirCasa();
		
		double capitalInicial = propietario.getCapital();
		
		buenosAiresSur.construirHotel();
		
		assertEquals(capitalInicial-8000, propietario.getCapital(), 0);
	}

	@Test
	public void Entrega2test7() {
		Propiedad buenosAiresNorte = new Propiedad(25000, 2500, 3500, 4000, 6000, 5500, 9000);
		Propiedad buenosAiresSur = new Propiedad(20000, 2000, 3000, 3500, 5000, 5000, 8000);
		buenosAiresNorte.asociar(buenosAiresSur);
		
		Jugador propietario = new Jugador();
		Jugador inquilino = new Jugador();
		
		buenosAiresNorte.asociar(buenosAiresSur);
		buenosAiresNorte.adquirir(propietario);
		buenosAiresSur.adquirir(propietario);
		
		buenosAiresNorte.construirCasa();
		buenosAiresNorte.construirCasa();
		buenosAiresSur.construirCasa();
		buenosAiresSur.construirCasa();
		buenosAiresSur.construirHotel();
		
		double capitalInicial = inquilino.getCapital();		
		buenosAiresSur.activarEfecto(inquilino);
		
		assertEquals(capitalInicial-5000, inquilino.getCapital(), 0);
	}

	@Test
	public void Entrega2test9() {
		Propiedad santaFe = new Propiedad(15000, 1500, 3500, 4000);
		Jugador propietario = new Jugador();
		
		santaFe.adquirir(propietario);
		
		double capitalInicial = propietario.getCapital();
		
		santaFe.construirCasa();
		
		assertEquals(capitalInicial-4000, propietario.getCapital(), 0);
	}
	
	// Pruebas 3ra entrega
	@Test
	public void CuandoNoTieneCapitalAlComprarUnaCasaLanzaCapitalInsuficiente() {
		Jugador jugador = new Jugador();
		jugador.disminuirCapital(100000);
		assertEquals(0, jugador.getCapital(), 0);
		
		Propiedad propiedad = new Propiedad(200, 0, 0, 0, 0, 0, 0);
		
		try {
			propiedad.adquirir(jugador);
			fail();
		} catch (CapitalInsuficiente e) {
			assertTrue(true);
		}
	}	
	
	@Test
	public void test3() {
		Jugador jugadorSinCapital = new Jugador();
		Jugador otroJugador = new Jugador();
		Jugador nuevoPropietario = new Jugador();
		Jugador tercerJugador = new Jugador();
		
		Propiedad propiedadDelJugadorSinCapital = new Propiedad(100000, 100, 0, 0, 0, 0, 0);
		Propiedad otraPropiedad = new Propiedad(0, 200, 0, 0, 0, 0, 0);
		
		otraPropiedad.adquirir(otroJugador);
		
		propiedadDelJugadorSinCapital.adquirir(jugadorSinCapital);
		assertEquals(0, jugadorSinCapital.getCapital(), 0);
		
		try {
			otraPropiedad.activarEfecto(jugadorSinCapital);
			fail();
		} catch (CapitalInsuficiente e) {
			assertTrue(true);
			propiedadDelJugadorSinCapital.vender();
		}
		
		propiedadDelJugadorSinCapital.adquirir(nuevoPropietario);
		
		double capitalInicial = nuevoPropietario.getCapital();
		propiedadDelJugadorSinCapital.activarEfecto(tercerJugador);
		
		assertEquals(capitalInicial+100, nuevoPropietario.getCapital(), 0);
	}
}
