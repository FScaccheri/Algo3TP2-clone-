package modelo;

import java.util.LinkedList;
public class Tablero {
	
	private static Tablero instancia = null;
	
	private LinkedList<Casillero> casilleros;
	
	private Tablero() {
		casilleros = new LinkedList<Casillero>();
	};
	
	public static Tablero getInstancia() {
		if ( instancia == null ) {
			instancia = new Tablero();
		}
		return instancia;
	}
	
	public void agregar(Casillero unCasillero) {
		casilleros.add(unCasillero);
	};
	
	//La posicion del primer casillero anadido, es 0, es decir, la del segundo es 1, y asi sucesivamente;
	public int posicion(Casillero unCasillero) {
		return casilleros.indexOf(unCasillero);
	}
}
