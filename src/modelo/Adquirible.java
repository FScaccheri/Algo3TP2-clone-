package modelo;

public class Adquirible {

	private Jugador propietario;
	private double precioDeVenta;
		
	public Adquirible( double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}
	
	public void adquirir(Jugador jugador) {
		jugador.disminuirCapital(precioDeVenta);
		propietario = jugador;
		jugador.adquirir(this);
	}

	public void vender() {
		propietario.aumentarCapital(precioDeVenta/2);
		propietario = null;
	}
	
	public Jugador getPropietario() {
		return propietario;
	}

	public boolean tienePropietario() {
		return getPropietario() != null;
	}

	public boolean esPropietario(Jugador jugador) {
		return jugador == propietario;
	}
	
}