package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ListaCircular;

public class ListaCircularTest {

	@Test
	public void testElIndiceLoopea() {
		ListaCircular<Integer> lista = new ListaCircular<Integer>();
		lista.add(0);
		lista.add(1);
		lista.add(3);
		
		assertTrue(lista.get(5) == 3);
	}

	@Test
	public void testConIndicesNegativosSeRecorreLaListaAlReves() {
		ListaCircular<Integer> lista = new ListaCircular<Integer>();
		lista.add(0);
		lista.add(1);
		lista.add(3);
		
		assertTrue(lista.get(-1) == 3 );
	}
}
