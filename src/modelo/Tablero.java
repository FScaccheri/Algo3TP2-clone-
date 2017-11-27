package modelo;

import java.util.LinkedList;

import modelo.casilleros.Casillero;
import vistas.VistaJugador;
public class Tablero {
	
	private static Tablero instancia = null;
	
	private ListaCircular<Casillero> casilleros;
	
	private Tablero() {
		casilleros = new ListaCircular<Casillero>();
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
	
	public Casillero getCasilleroSiguiente(Casillero casillero) {
		return casilleros.get( casilleros.indexOf(casillero) + 1);

	}
	
	public Casillero getCasilleroAnterior(Casillero casillero) {
		return casilleros.get( casilleros.indexOf(casillero) - 1);
	}
	
	public void caerEn(Jugador jugador, Posicion posicion) {
		this.getCasillero(posicion).caeEn(jugador);
	}

	public LinkedList<Casillero> getCasilleros() {
		
		return casilleros;
	}
	

}
