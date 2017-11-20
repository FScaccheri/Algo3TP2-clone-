package modelo;

public class Adquirible {

	private Jugador propietario;
	private double precioDeVenta;
	private static final double PORCENTAJE_DE_VENTA = 0.75;
	
	public Adquirible( double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}
	
	public void adquirir(Jugador jugador) {
		jugador.disminuirCapital(precioDeVenta);
		propietario = jugador;
		jugador.adquirir(this);
	}

	public void vender() {
		propietario.aumentarCapital(precioDeVenta*PORCENTAJE_DE_VENTA);
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