package modelo;

public abstract class Rentable extends Adquirible implements Activable, Alquilable{

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

}
