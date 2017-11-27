package modelo;

public class Casillero {
	private Activable efecto;
	private Posicion posicion = null;
	private String nombre;
	
	public Casillero () {
		
		
	}
	
	public Casillero(String nombre, Activable efecto) {
		this.efecto = efecto;
		this.nombre = nombre;
	}
	
	public Casillero(String nombre, Propiedad efecto, int posicionRelativa) {
		
		this(nombre, efecto);
		efecto.setPosicionRelativa(posicionRelativa);
	}


	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Posicion getPosicion() {
		return this.posicion;
	}
	
	public void caeEn(Jugador jugador) {
		this.efecto.activarEfecto(jugador);
	}
	
	public String getNombre() {
		
		return nombre;
	}
}
