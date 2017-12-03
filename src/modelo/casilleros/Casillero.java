package modelo.casilleros;

import modelo.Jugador;
import modelo.Posicion;
import modelo.casilleros.adquiribles.Rentable;

public class Casillero {
	private Activable efecto;
	private Posicion posicion = null;
	private String nombre;
	
	public Casillero () {}
	
	public Casillero(String nombre, Activable efecto) {
		this.efecto = efecto;
		this.nombre = nombre;
		setNombreARentable(nombre);
	}


	private void setNombreARentable(String nombreRentable) {

			if (efecto instanceof Rentable) {
				
				((Rentable) efecto).setNombre(nombreRentable);
			}
		
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

	public Activable getEfecto() {
		
		return efecto;
	}
	
}
