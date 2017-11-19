package modelo;

public abstract class Adquirible implements Activable, Alquilable{

	private Jugador propietario;
	private double precio_venta;
		
	public Adquirible( double precio_venta) {
		this.precio_venta = precio_venta;
	}

	/* (non-Javadoc)
	 * @see modelo.Alquilable#getAlquiler(modelo.Jugador)
	 */
	@Override
	abstract public double getAlquiler(Jugador jugador);
	
	@Override
	public void activarEfecto(Jugador jugador) {
		if(tienePropietario() && !esPropietario(jugador)) {
			jugador.disminuirCapital(getAlquiler(jugador));
			getPropietario().aumentarCapital(getAlquiler(jugador));
		}
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