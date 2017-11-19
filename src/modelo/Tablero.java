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
	}
	
	public Posicion posicion(Casillero unCasillero) {
		return casilleros.get(casilleros.indexOf(unCasillero)).getPosicion();
	}
		
	public Casillero getCasillero(Posicion posicion) {
		return casilleros.get(casilleros.indexOf(posicion.getCasillero()));
	}
	
	public Casillero casilleroSiguiente(Casillero casillero) {
		return casilleros.get( casilleros.indexOf(casillero) + 1);

	}
	
	public void caerEn(Jugador jugador, Posicion posicion) {
		this.getCasillero(posicion).caeEn(jugador);
	}
}
