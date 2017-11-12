package modelo;

public abstract class Adquirible implements Activable{

	protected Jugador propietario;
	protected double precio_venta;
	protected double alquiler;

	public Adquirible() {
		super();
	}
	
	public Adquirible( double precio_venta, double alquiler ) {
		this.precio_venta = precio_venta;
		this.alquiler = alquiler;
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

	public abstract void activarEfecto(Jugador jugador);

}