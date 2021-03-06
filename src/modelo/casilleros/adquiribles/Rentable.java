package modelo.casilleros.adquiribles;

import modelo.Jugador;
import modelo.casilleros.Activable;

public abstract class Rentable extends Adquirible implements Activable, Alquilable{

	private Rentable propDependiente;
	private String nombre;
	
	public Rentable(double precio_venta) {
		super(precio_venta);
	}

	@Override
	public void activarEfecto(Jugador jugador) {
		if(tienePropietario() && !esPropietario(jugador)) {
			jugador.disminuirCapital(getAlquiler());
			getPropietario().aumentarCapital(getAlquiler());
		}
	}
	
	public void asociar(Rentable rentable) {
		propDependiente = rentable;
		rentable.propDependiente = this;
	}

	public boolean estaAsociado() {
		return propDependiente != null;
	}
	
	public Rentable getRentableAsociado() {
		return propDependiente;
	}

	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	}
	
	public String getNombre() {
		
		return nombre;
	}

}
