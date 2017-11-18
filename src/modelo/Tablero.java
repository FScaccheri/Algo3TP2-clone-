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
	public static void reset() {
		instancia = null;
	}
	
	public void agregar(Casillero unCasillero) {
		unCasillero.setPosicion( new Posicion(unCasillero) );
		casilleros.add(unCasillero);
	};
	
	//La posicion del primer casillero anadido, es 0, es decir, la del segundo es 1, y asi sucesivamente;
	public Posicion posicion(Casillero unCasillero) {
		return casilleros.get(casilleros.indexOf(unCasillero)).getPosicion();
	}
	
	public Casillero getCasillero(int posicion) {
		return casilleros.get(posicion);
	}
	
	public Casillero casilleroSiguiente(Casillero casillero) {
		return casilleros.get( casilleros.indexOf(casillero) + 1);
	}
	
}
