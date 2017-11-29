package modelo.casilleros;

import modelo.Jugador;
import modelo.Posicion;
import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;

public class Casillero {
	private Activable efecto;
	private Posicion posicion = null;
	private String nombre;
	private int posicionRelativa;
	
	public Casillero () {
		
		
	}
	
	public Casillero(String nombre, Activable efecto, int posicion) {
		this.efecto = efecto;
		this.nombre = nombre;
		this.setNombreARentable(nombre);
		this.posicionRelativa = posicion;
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

	public int getPosicionRelativa() {

		return posicionRelativa;
		
	}
	
}
