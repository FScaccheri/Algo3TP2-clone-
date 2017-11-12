package modelo;

public class Propiedad extends Adquirible {

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

	public void activarEfecto(Jugador jugador) {
		if(tienePropietario() && !esPropietario(jugador)) {
			jugador.disminuirCapital(alquiler);
			propietario.aumentarCapital(alquiler);
		}
	}
}
