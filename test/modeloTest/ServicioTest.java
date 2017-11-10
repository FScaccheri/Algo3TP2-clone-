package modeloTest;

import static org.junit.Assert.*;

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
		
		servicio.activarEfecto(jugador);
		
		Assert.assertEquals( 10000, jugador.getCapital(), 0 );
		
	}
	@Test
	public void testServicioConPropietarioCobraMultiplicadorPorUltimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(100);
		
		servicio.adquirir(propietario);
		usuario.aumentarCapital(10000);
		usuario.setUltimaTirada(10);
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( 9000, usuario.getCapital(), 0 ); //100*10
	}
	
	@Test
	public void testServicioNoLeCobraASuPropietario() {
		Jugador propietario = new Jugador();
		Servicio servicio = new Servicio(100);
		
		servicio.adquirir(propietario);
		propietario.aumentarCapital(10000);
		propietario.setUltimaTirada(10);
		
		servicio.activarEfecto(propietario);
		
		Assert.assertEquals( 10000, propietario.getCapital(), 0 ); //100*10
	}
}
