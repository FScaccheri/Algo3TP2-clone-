package modeloTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Servicio;

public class ServicioTest {

	@Test
	public void testServicioAdquiridoTienePropietario() {
		Jugador jugador = new Jugador();
		Servicio servicio = new Servicio(0, 0, 0);
		
		servicio.adquirir(jugador);
		
		Assert.assertTrue(servicio.tienePropietario());
	}
	
	@Test
	public void testJugadorQueLoAdquiereEsSuPropietario() {
		Jugador jugador = new Jugador();
		Servicio servicio = new Servicio(0,1, 0);
		
		servicio.adquirir(jugador);
		
		Assert.assertTrue(servicio.esPropietario(jugador));
	}
	
	@Test
	public void testAdquirirUnServicioDisminuyeCapitalDePropietarioEnSuValorDeVenta() {
		Servicio servicio = new Servicio(5000,1, 0);;
		Jugador jugador = new Jugador();
		
		double capitalInicial = jugador.getCapital();
		
		servicio.adquirir(jugador);
		
		assertEquals(capitalInicial - 5000, jugador.getCapital(), 0);
	}
	
	@Test
	public void testServicioSinPropietarioNoCobra(){
		Jugador jugador = new Jugador();
		Servicio servicio = new Servicio(0,1, 0);
		

		jugador.aumentarCapital(10000);
		double capitalInicial = jugador.getCapital();
		
		servicio.activarEfecto(jugador);
		
		Assert.assertEquals( capitalInicial, jugador.getCapital(), 0 );
		
	}
	
	@Test
	public void testServicioConPropietarioCobraAlquilerMultiplicadoPorUltimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0,100, 0);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		usuario.setUltimaTirada(10);
		
		double capitalInicial = usuario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial-100*10, usuario.getCapital(), 0 ); //100*10
	}
	
	@Test
	public void testServicioConPropietarioPagaAlquilerMultiplicadoPorUltimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0,100, 0);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		usuario.setUltimaTirada(10);
		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial+100*10, propietario.getCapital(), 0 ); //100*10
	}
	
	@Test
	public void testServicioCuyoPropietarioEsDuenioDeSuSocioCobraAlquilerComboMultiplicadoPorUlimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0, 100, 200); //100 alquiler simple, 200 alquiler en combo
		Servicio servicio2 = new Servicio(0, 100, 200);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		servicio2.adquirir(propietario);
		servicio.asociar(servicio2);
		usuario.setUltimaTirada(10);
		
		double capitalInicial = usuario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial-200*10, usuario.getCapital(), 0 ); //200*10
	}
	
	@Test
	public void testServicioCuyoPropietarioEsDuenioDeSuSocioPagaAlquilerComboMultiplicadoPorUlimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0, 100, 200); //100 alquiler simple, 200 alquiler en combo
		Servicio servicio2 = new Servicio(0, 100, 200);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		servicio2.adquirir(propietario);
		servicio.asociar(servicio2);
		usuario.setUltimaTirada(10);
		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial+200*10, propietario.getCapital(), 0 ); //200*10
	}
	
	@Test
	public void testServicioNoLeCobraASuPropietario() {
		Jugador propietario = new Jugador();
		Servicio servicio = new Servicio(0,100, 0);
		
		propietario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		propietario.setUltimaTirada(10);
		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(propietario);
		
		Assert.assertEquals( capitalInicial, propietario.getCapital(), 0 ); 
	}
}
