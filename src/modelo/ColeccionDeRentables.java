package modelo;

import java.util.LinkedList;

import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;
import modelo.casilleros.adquiribles.Servicio;

public class ColeccionDeRentables {

	private LinkedList<Propiedad> propiedades;
	private LinkedList<Servicio> servicios;
	
	public ColeccionDeRentables() {
		propiedades = new LinkedList<Propiedad>();
		servicios = new LinkedList<Servicio>();
	}
	
	public LinkedList<Propiedad> propiedades(){
		return new LinkedList<Propiedad>(propiedades);
	}
	
	public LinkedList<Servicio> servicios(){
		return new LinkedList<Servicio>(servicios);
	}

	public void agregar(Rentable rentable) {
		try {
			propiedades.add((Propiedad) rentable);			
		} catch (ClassCastException e) {
			servicios.add((Servicio) rentable);			
		}
	}

	public void eliminar(Propiedad propiedad) {
		propiedades.remove(propiedad);
	}
	
	public void eliminar(Servicio servicio) {
		servicios.remove(servicio);
	}

}
