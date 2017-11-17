package modelo;

import java.util.LinkedList;

public class Jugador {
	private static final int CAPITALINICIAL = 100000;
	double capital = CAPITALINICIAL;
	int ultimaTirada = 0;
	private int posicion;
	LinkedList<Propiedad> propiedades;
	LinkedList<Servicio> servicios;
	
	public Jugador() {
		propiedades = new LinkedList<Propiedad>();
		servicios = new LinkedList<Servicio>();
	}
	
	public double getCapital() {
		return capital;
	}
	
	public void aumentarCapital( double i ) {
		capital+=i;
	}

	public void disminuirCapital( double i ) {
		capital-=i;
	}

	//ESTE METODO NO TIENE SENTIDO, ES SOLO PARA HACER PRUEBAS EN SERVICIO
	//CUANDO ESTE PROGRAMADO EL MOVIMIENTO NO DEBERIA EXISTIR
	public void setUltimaTirada( int ultimaTirada ) {
		this.ultimaTirada = ultimaTirada;	
	}
	
	//VER SI ESTE METODO TIENE SENTIDO LUEGO DE PROGRAMAR EL MOVIMIENTO(SE USA EN SERVICIO)
	public int getUltimaTirada() {
		return ultimaTirada;
	}

	public int getPosicion() {

		return this.posicion ;
	}

	//Metodo provisional para "mover" al Jugador, hasta que se implemente correctamente
	//el movimiento. @Franco S.
	public void moverAPosicion(int nuevaPosicion) {
		
		this.posicion = nuevaPosicion;
		
	}
	
	public void adquirir(Propiedad elementoPorAdquirir) { 
		propiedades.add(elementoPorAdquirir);
	}
	
	public void adquirir(Servicio elementoPorAdquirir) {
		servicios.add(elementoPorAdquirir);
	}

	public int cantidadDePropiedades() {
		return propiedades.size();
	}
	
	public int getCantidadDeCasas() {
		int casas = 0;
		for (int i = 0; i<propiedades.size();i++) {
			casas += propiedades.get(i).getCantidadDeCasas();
		};
		return casas;
	}
}
