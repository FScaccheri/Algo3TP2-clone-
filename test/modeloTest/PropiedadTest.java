package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Jugador;
import modelo.Propiedad;

public class PropiedadTest {

	@Test
	public void AlCrearUnaPropiedadLaCantidadDeCasasEsCero() {
		Propiedad propiedad = new Propiedad();
		assertEquals(0, propiedad.getCantidadDeCasas(), 0);
	}

	@Test
	public void AlCrearUnaPropiedadtieneHotelDevuelveFalso() {
		Propiedad propiedad = new Propiedad();
		assertFalse(propiedad.tieneHotel());
	}

	@Test
	public void AlCrearUnaPropiedadgetPropietarioDevuelveNull() {
		Propiedad propiedad = new Propiedad();
		assertNull(propiedad.getPropietario());
	}


	@Test
	public void CuandoUnJugadorAdquiereUnaPropiedadgetPropietarioDevuelveElJugador() {
		Propiedad propiedad = new Propiedad();
		Jugador jugador = new Jugador();
		
		propiedad.adquirir(jugador);
		
		assertEquals(propiedad.getPropietario(), jugador);
	}
	
	@Test
	public void UnJugadorQueNoAdquirioLaPropiedadNoEsPropietario() {
		Propiedad propiedad = new Propiedad();
		Jugador propietario = new Jugador();
		Jugador usuario  = new Jugador();
		
		propiedad.adquirir(propietario);
		
		assertFalse(propiedad.esPropietario(usuario));
	}
}
