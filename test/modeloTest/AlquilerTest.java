package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.casilleros.adquiribles.Alquiler;

public class AlquilerTest {

	@Test
	public void AlCrearAlquilerGetAlquilerDevuelveElAlquilerBase() {
		Alquiler alquileres = new Alquiler(100, 0, 0, 0);
		double alquiler = alquileres.getAlquiler();
		assertEquals(100, alquiler, 0);
	}

	@Test
	public void AlAumentarElAlquilerGetAlquilerDevuelveElAlquilerSiguiente() {
		Alquiler alquileres = new Alquiler(0, 0, 200, 0);
		alquileres.aumentarAlquiler();
		alquileres.aumentarAlquiler();
		double alquiler = alquileres.getAlquiler();
		assertEquals(200, alquiler, 0);
	}

	@Test
	public void AlReiniciarElAlquilerGetAlquilerDevuelveElPrimerSiguiente() {
		Alquiler alquileres = new Alquiler(200, 0, 0, 0);
		alquileres.aumentarAlquiler();
		alquileres.aumentarAlquiler();
		alquileres.aumentarAlquiler();
		alquileres.reiniciarAlquiler();
		double alquiler = alquileres.getAlquiler();
		assertEquals(200, alquiler, 0);
	}
}
