package modelo;

public class Policia implements Activable{

	private Casillero carcel;
	
	public Policia(Casillero carcel) {
		this.carcel = carcel;
	}
	
	public void activarEfecto(Jugador jugador) {
		jugador.setPosicion( this.carcel.getPosicion() );		
	}
}
