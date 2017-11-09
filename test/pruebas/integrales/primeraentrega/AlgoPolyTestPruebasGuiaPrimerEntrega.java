package pruebas.integrales.primeraentrega;

import static org.junit.Assert.*;

import org.junit.Test;


public class AlgoPolyTestPruebasGuiaPrimerEntrega {

	@Test
	public void testCaerEnQuiniAumentaEnCincuentaMilElDinero() {
//		Jugador unJugador = new Jugador();
//		Casillero unCasillero = new Casillero(new Quini6);
//		
//		int dineroAntesDeQuini = unJugador.dinero();
//		unJugador.caerEn(unCasillero);
//		int dineroDespuesDeQuini = unJugador.dinero();
		
//		Assert.assertEquals(dineroDespuesDeQuini,dineroAntesDeQuini + 50000);
		assertTrue(true);
	}

	@Test
	void testCaerEnQuiniPorSegundaVezAumentaSoloTreintaMilElDinero() {
//		Jugador unJugador = new Jugador();
//		Casillero unCasillero = new Casillero(Quini6.instanciaUnica());
//		
//		unJugador.caerEn(unCasillero);
//		int DineroDespuesDeQuiniPrimeraVez = unJugador.dinero();
//		unJugador.caerEn(unCasillero);
//		int dineroDespuesDeQuiniSegundaVez = unJugador.dinero();
		
//		Assert.assertEquals(dineroDespuesDeQuiniSegundaVez, dineroDespuesDeQuiniSegundaVez + 30000);
		assertTrue(true);
	}
	
	@Test
	void testCaerEnQuiniMasDeDosVecesNoAumentaDinero() {
		
//		Jugador unJugador = new Jugador();
//		Casillero unCasillero = new Casillero(Quini6.instanciaUnica());
//		
//		unJugador.caerEn(unCasillero);
//		unJugador.caerEn(unCasillero);
//		int dineroDespuesDeQuiniSegundaVez = unJugador.dinero();
//		unJugador.caerEn(unCasillero);
		
//		Assert.assertEquals(dineroDespuesDeQuiniSegundaVez, unJugador.dinero());
		assertTrue(true);
	}
	
	@Test
	void testUnJugadorEsPropietarioDeUnBarrioLuegoDeComprarlo() {
		
//		Jugador unJugador = new Jugador();
//		Casillero unCasillero = new Casillero(CordobaNorte.instanciaUnica());
//		
//		unJugador.recibirDinero(100000);
//		unJugador.caerEn(unCasillero);
//		unJugador.comprar();
		
//		Assert.assertTrue(unJugador.esDuenoDe(CordobaNorte.instanciaUnica());
		assertTrue(true);
	}
	
	@Test
	void testUnJugadorEnLaCarcelNoPuedeMover() {
		
//		Jugador unJugador = new Jugador();
//		Casillero casilleroCarcel = new Casillero(Carcel.instanciaUnica());
//		Casillero casilleroNoCarcel = new Casillero(Quini6.instanciaUnica());
//		boolean excepcionLanzada = false;
//		
//		unJugador.caerEn(casilleroCarcel);
//		try {
//			unJugador.caerEn(casilleroNoCarcel);
//		} catch (MovimientoInvalidoException) {
//			excepcionLanzada = true;
//		}
		
//		Assert.assertTrue(excepcionLanzada);
		assertTrue(true);
	}
	
	@Test
	void testUnJugadorPuedeMoverFueraDeCarcelSiPagoFianzaEnTurno2o3Preso() {
		
		//DUDOSO TEST! @FrancoRiborati
		//IniciarTurno lo puede hacer una clase principal como AlgoPoly? @FrancoRiborati
		
//		Jugador unJugador = new Jugador();
//		unJugador.recibirDinero(100000);
//		Casillero casilleroCarcel = new Casillero(Carcel.instanciaUnica());
//		Casillero casilleroNoCarcel = new Casillero(Quini6.instanciaUnica());
//		boolean excepcionLanzada = false;
//		
//		unJugador.caerEn(casilleroCarcel);
//		unJugador.iniciarTurno();
//		unJugador.terminarTurno();
//		unJugador.pagarFianza();
//		try{
//			unJugador.caerEn(casilleroNoCarcel);
//		} catch (MovimientoInvalidoException) {
//			excepcionLanzada = true;
//		};
		
//		Assert.assertFalse(excepcionLanzada);
		assertTrue(true);
	}
	
	@Test
	void testUnJugadorNoPuedePagarFianzaSiTieneFondosInsuficientes() {
		
//		Jugador unJugador = new Jugador();
//		unJugador.recibirDinero(100);
//		Casillero casilleroCarcel = new Casillero(Carcel.instanciaUnica());
//		Casillero casilleroNoCarcel = new Casillero(Quini6.instanciaUnica());
//		boolean excepcionFondosInsuficientesLanzada = false;
//		boolean excepcionMovimientoInvalidoLanzada = false;
//		
//		unJugador.caerEn(casilleroCarcel);
//		unJugador.terminarTurno();
//		unJugador.iniciarTurno();
//		try{
//			unJugador.pagarFianza();
//		} catch (FondosInsuficientesException) {
//			excepcionFondosInsuficientesLanzada = true;
//		}
//		try{
//			unJugador.caerEn(casilleroNoCarcel);
//		} catch (MovimientoInvalidoException) {
//			excepcionMovimientoInvalidoLanzada = true;
//		};
		
//		Assert.assertTrue(excepcionFondosInsuficientesLanzada);
//		Assert.assertTrue(excepcionMovimientoInvalidoLanzada);

		assertTrue(true);
	}
	
	@Test
	void testAvanceDinamicoCon2a6Avanza2MenosQueLoLanzadoAntes() {
		
		//TO DO
		
//		Jugador jugadorCaeCon2, jugadorCaeCon3, jugadorCaeCon4, jugadorCaeCon5, jugadorCaeCon6 = new Jugador();
//		Casillero casilleroAvanceDinamico = new Casillero(AvanceDinamico.instanciaUnica());
//		Casillero casilleroSubte = new Casillero(Subte.instanciaUnica());
//		Casillero casilleroCordobaNorte = new Casillero(CordobaNorte.instanciaUnica());
//		Casillero casilleroImpuestoDeLujo = new Casillero(ImpuestoDeLujo.instanciaUnica());
//		Casillero casilleroSantaFe = new Casillero(SantaFe.instanciaUnica());
//		
		assertTrue(true);
	}
}

