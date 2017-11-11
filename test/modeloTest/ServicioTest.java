package modeloTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Servicio;

public class ServicioTest {

	@Test
	public void testJugadorQueLoAdquiereEsSuPropietario() {
		Jugador jugador = new Jugador();
		Servicio servicio = new Servicio(1);
		
		servicio.adquirir(jugador);
		
		Assert.assertTrue(servicio.esPropietario(jugador));
	}
	
	@Test
	public void testServicioSinPropietarioNoCobra(){
		Jugador jugador = new Jugador();
		Servicio servicio = new Servicio(1);
		

		jugador.aumentarCapital(10000);
		double capitalInicial = jugador.getCapital();
		
		servicio.activarEfecto(jugador);
		
		Assert.assertEquals( capitalInicial, jugador.getCapital(), 0 );
		
	}
	
	@Test
	public void testServicioConPropietarioCobraMultiplicadorPorUltimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(100);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		usuario.setUltimaTirada(10);
		
		double capitalInicial = usuario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial-100*10, usuario.getCapital(), 0 ); //100*10
	}
	
	@Test
	public void testServicioNoLeCobraASuPropietario() {
		Jugador propietario = new Jugador();
		Servicio servicio = new Servicio(100);
		
		propietario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		propietario.setUltimaTirada(10);
		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(propietario);
		
		Assert.assertEquals( capitalInicial, propietario.getCapital(), 0 ); //100*10
	}
}
