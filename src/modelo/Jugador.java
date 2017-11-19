package modelo;

import java.util.LinkedList;

public class Jugador {
	private static final int CAPITALINICIAL = 100000;
	double capital = CAPITALINICIAL;
	int ultimaTirada = 0;
	Posicion posicion = null;
	Movimiento movimiento;
	ColeccionDeAdquiribles adquiridos;
	
	public Jugador() {
		movimiento = new MovimientoBasico();
		adquiridos = new ColeccionDeAdquiribles();
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

	public Posicion getPosicion() {

		return this.posicion ;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	public void setMovimiento(Movimiento movimiento) {
		this.movimiento = movimiento;
	}
	
	public void avanzar(int posiciones) {
		this.movimiento.mover(this, posiciones);	
	}
	
	public void avanzar(int posiciones, Movimiento movimiento) {
		movimiento.mover(this, posiciones);
	}

	
	public void adquirir(Adquirible elementoPorAdquirir) { 
		adquiridos.agregar(elementoPorAdquirir);
	}

	public int cantidadDePropiedades() {
		return adquiridos.propiedades().size();
	}
	
	public int getCantidadDeCasas() {
		int casas = 0;
		LinkedList<Propiedad> propiedades = adquiridos.propiedades();
		for (int i = 0; i<propiedades.size();i++) {
			casas += propiedades.get(i).getCantidadDeCasas();
		};
		return casas;
	}
	
	public int getCantidadDeHoteles() {
		int hoteles = 0;
		LinkedList<Propiedad> propiedades = adquiridos.propiedades();
		for (int i=0; 1<propiedades.size();i++) {
			if (propiedades.get(i).tieneHotel()) { hoteles++;}
		}
		return hoteles;
	}
}
