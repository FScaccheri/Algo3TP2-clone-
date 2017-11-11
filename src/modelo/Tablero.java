package modelo;

import java.util.LinkedList;
public class Tablero {
	
	private LinkedList<Casillero> casilleros;
	
	public Tablero() {
		casilleros = new LinkedList<Casillero>();
	};
	
	public void agregar(Casillero unCasillero) {
		casilleros.add(unCasillero);
	};
	
	//La posicion del primer casillero añadido, es 0, es decir, la del segundo es 1, y asi sucesivamente;
	public int posicion(Casillero unCasillero) {
		return casilleros.indexOf(unCasillero);
	}
}
