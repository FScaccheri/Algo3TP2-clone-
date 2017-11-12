package modelo;

public class Servicio extends Adquirible {
	private
	Servicio asociado;

	public Servicio( double precioVenta, double alquiler ) {
		this.precio_venta = precioVenta;
		this.alquiler = alquiler;
	}


	@Override
	public void activarEfecto( Jugador jugador ) {
		if ( this.tienePropietario()  && !this.esPropietario(jugador)) {
			jugador.disminuirCapital( jugador.getUltimaTirada() * this.alquiler );
			propietario.aumentarCapital( jugador.getUltimaTirada() * this.alquiler );

		}
	}

}
