package modelo;

public class Propiedad {
	private
	Jugador propietario;
	double precio_venta;
	double alquiler;
	
	public Propiedad(double precio_venta, double alquiler) {
		this.precio_venta = precio_venta;
		this.alquiler = alquiler;
	}

	public int getCantidadDeCasas() {
		return 0;
	}

	public boolean tieneHotel() {
		return false;
	}

	public boolean tienePropietario() {
		return getPropietario() != null;
	}
	
	public Jugador getPropietario() {
		return propietario;
	}
	
	public boolean esPropietario(Jugador jugador) {
		return jugador == propietario;
	}
	
	public void adquirir(Jugador jugador) {
		jugador.disminuirCapital(precio_venta);
		propietario = jugador;
	}

	public void vender() {
		propietario.aumentarCapital(precio_venta/2);
		propietario = null;
	}

	public void activarEfecto(Jugador jugador) {
		if(tienePropietario()) {
			jugador.disminuirCapital(alquiler);
			propietario.aumentarCapital(alquiler);
		}
	}


	
	
}
