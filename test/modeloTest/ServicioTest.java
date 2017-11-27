package modeloTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tirada;
import modelo.casilleros.adquiribles.Servicio;

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
		int resultado = Tirada.tirar();
		
		double capitalInicial = usuario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial-100*resultado, usuario.getCapital(), 0 );
	}
	
	@Test
	public void testServicioConPropietarioPagaAlquilerMultiplicadoPorUltimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0,100, 0);
		
		usuario.aumentarCapital(10000);
		servicio.adquirir(propietario);
		int resultado = Tirada.tirar();
		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial+100*resultado, propietario.getCapital(), 0 );
	}
	
	@Test
	public void testServicioCuyoPropietarioEsDuenioDelServicioAsociadoCobraAlquilerComboMultiplicadoPorUlimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0, 100, 200); //100 alquiler simple, 200 alquiler en combo
		Servicio servicio2 = new Servicio(0, 100, 200);
		
		servicio.asociar(servicio2);
		
		servicio.adquirir(propietario);
		servicio2.adquirir(propietario);
		
		int resultado = Tirada.tirar();
		double capitalInicial = usuario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial-200*resultado, usuario.getCapital(), 0 );
	}
	
	@Test
	public void testServicioCuyoPropietarioEsDuenioSelSerivicioAsociadoPagaAlquilerComboMultiplicadoPorUlimaTiradaDeQuienCae() {
		Jugador propietario = new Jugador();
		Jugador usuario = new Jugador();
		Servicio servicio = new Servicio(0, 100, 200); //100 alquiler simple, 200 alquiler en combo
		Servicio servicio2 = new Servicio(0, 100, 200);
		
		servicio.asociar(servicio2);
		
		servicio.adquirir(propietario);
		servicio2.adquirir(propietario);
		
		int resultado = Tirada.tirar();
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(usuario);
		
		Assert.assertEquals( capitalInicial+200*resultado, propietario.getCapital(), 0 );
	}
	
	@Test
	public void testServicioNoLeCobraASuPropietario() {
		Jugador propietario = new Jugador();
		Servicio servicio = new Servicio(0,100, 0);
		
		servicio.adquirir(propietario);

		Tirada.tirar();		
		double capitalInicial = propietario.getCapital();
		
		servicio.activarEfecto(propietario);
		
		Assert.assertEquals( capitalInicial, propietario.getCapital(), 0 ); 
	}
	
	@Test
	public void ServiciosAsociadosConDueniosDistintosCobranElAlquilerCorrecto() {
		Servicio servicio1 = new Servicio(0, 101, 201);
		Servicio servicio2 = new Servicio(0, 102, 202);
		Jugador propietario1 = new Jugador();
		Jugador propietario2 = new Jugador();
		Jugador inquilino = new Jugador();
		
		servicio1.asociar(servicio2);
		
		servicio1.adquirir(propietario1);
		servicio2.adquirir(propietario2);

		int resultado = Tirada.tirar();
		double capitalInicial = inquilino.getCapital();
		
		servicio1.activarEfecto(inquilino);
		
		Assert.assertEquals(capitalInicial-101*resultado , inquilino.getCapital(), 0 ); 
	}

}
