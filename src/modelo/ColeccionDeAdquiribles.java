package modelo;

import java.util.LinkedList;

public class ColeccionDeAdquiribles {

	private LinkedList<Adquirible> contenidos;
	
	public ColeccionDeAdquiribles() {
		contenidos = new LinkedList<Adquirible>();
	}
	
	public LinkedList<Propiedad> propiedades(){
		LinkedList<Propiedad> propiedades = new LinkedList<Propiedad>();
		for (int i=0;i<contenidos.size();i++) {
			if (contenidos.get(i).getClass() == Propiedad.class) {
				propiedades.add((Propiedad)contenidos.get(i));
			}
		}
		return propiedades;
	}
	
	public LinkedList<Servicio> servicios(){
		LinkedList<Servicio> servicios = new LinkedList<Servicio>();
		for (int i=0;i<contenidos.size();i++) {
			if (contenidos.get(i).getClass() == Servicio.class) {
				servicios.add((Servicio)contenidos.get(i));
			}
		}
		return servicios;
	}
	
	public void agregar(Adquirible elemento) {
		contenidos.add(elemento);
	}
	
	public void eliminar(Adquirible elemento) {
		contenidos.remove(elemento);
	}
}
