package modelo;

public class Adquirible {

	private Jugador propietario;
	private double precio_venta;
		
	public Adquirible( double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	public void adquirir(Jugador jugador) {
		jugador.disminuirCapital(precio_venta);
		propietario = jugador;
		jugador.adquirir(this);
	}

	public void vender() {
		propietario.aumentarCapital(precio_venta/2);
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