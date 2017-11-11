package modelo;

public class Propiedad {
	private
	Jugador propietario;
	double precio_venta;
	
	public int getCantidadDeCasas() {
		return 0;
	}

	public boolean tieneHotel() {
		return false;
	}

	public Jugador getPropietario() {
		return propietario;
	}
	
	public boolean esPropietario(Jugador jugador) {
		return jugador == propietario;
	}
	
	public void adquirir(Jugador jugador) {
		propietario = jugador;
	}


	
	
}
