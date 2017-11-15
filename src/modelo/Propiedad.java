package modelo;

public class Propiedad extends Adquirible {
	
	private double alquiler;

	public Propiedad(double precio_venta, double alquiler) {
		super(precio_venta);
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
			getPropietario().aumentarCapital(alquiler);
		}
	}
}
