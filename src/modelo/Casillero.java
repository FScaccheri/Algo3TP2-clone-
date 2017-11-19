package modelo;

public class Casillero {
	private Activable efecto;
	private Posicion posicion = null;
	
	public Casillero(Activable efecto) {
		this.efecto = efecto;
	}
	
	public Casillero() {
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
}
