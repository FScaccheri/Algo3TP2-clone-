package modelo;

import java.util.LinkedList;

import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Servicio;
import modelo.casilleros.movimiento.Movimiento;
import modelo.casilleros.movimiento.MovimientoBasico;
import modelo.excepciones.CapitalInsuficiente;

public class Jugador {
	private static final int CAPITALINICIAL = 100000;
	private double capital = CAPITALINICIAL;
	private Posicion posicion = null;
	private Movimiento movimiento;
	private ColeccionDeRentables adquiridos;
	
	public Jugador() {
		movimiento = new MovimientoBasico();
		adquiridos = new ColeccionDeRentables();
	}
	
	public double getCapital() {
		return capital;
	}
	
	private void modificarCapital(double i) {
		if((capital + i) < 0)
			throw new CapitalInsuficiente();
		capital+=i;
	}
	
	public void aumentarCapital( double i ) {
		modificarCapital(i);
	}

	public void disminuirCapital( double i ) {
		modificarCapital(-i);
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

	
	public void adquirir(Propiedad propiedad) { 
		propiedad.adquirir(this);
		adquiridos.agregar(propiedad);
	}

	public void adquirir(Servicio servicio) { 
		servicio.adquirir(this);
		adquiridos.agregar(servicio);
	}
	
	public void vender(Propiedad propiedad) {		
		propiedad.vender();
		adquiridos.eliminar(propiedad);
	}
	
	public void vender(Servicio servicio) {
		servicio.vender();
		adquiridos.eliminar(servicio);
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
		for (int i=0; i<propiedades.size();i++) {
			if (propiedades.get(i).tieneHotel()) { hoteles++;}
		}
		return hoteles;
	}

	public ColeccionDeRentables getAdquiridos() {		
		return adquiridos;
	}

	public int getPosicionRelativa() {
		return getPosicion().getCasillero().getPosicionRelativa();
	}

	
}
