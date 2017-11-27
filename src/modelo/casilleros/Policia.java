package modelo.casilleros;

import modelo.Jugador;
import modelo.Posicion;

public class Policia implements Activable{

	private Posicion carcel;
	
	public Policia(Posicion carcel) {
		this.carcel = carcel;
	}
	
	public void activarEfecto(Jugador jugador) {
		jugador.setPosicion( this.carcel );		
	}
}
