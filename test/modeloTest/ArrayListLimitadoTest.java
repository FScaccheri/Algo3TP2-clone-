package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ArrayListLimitado;
import modelo.Edificio;
import modelo.excepciones.ConstruccionImposible;

public class ArrayListLimitadoTest {

	@Test
	public void AlAgregarMasElementosQueElMaximoLanzaLaRespectivaExcepcion() {
		ArrayListLimitado<Edificio> edificios = new ArrayListLimitado<Edificio>(1, new ConstruccionImposible());
		Edificio casa = new Edificio(0, 0);
		
		edificios.addConExcepcion(casa);
		
		try {
			edificios.addConExcepcion(casa);			
			fail();
		} catch (ConstruccionImposible e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void AlAgregarMasElementosQueElMaximoQueNoAgregaLosElementos() {
		ArrayListLimitado<Edificio> edificios = new ArrayListLimitado<Edificio>(1, new ConstruccionImposible());
		Edificio casa = new Edificio(0, 0);
		
		edificios.addConExcepcion(casa);
		
		try {
			edificios.addConExcepcion(casa);			
			fail();
		} catch (ConstruccionImposible e) {
			assertEquals(edificios.size(), 1);
		}
	}

}
