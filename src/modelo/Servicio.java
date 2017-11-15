package modelo;

public class Servicio extends Adquirible {
	private
	Servicio asociado;
	double alquiler;

	public Servicio( double precioVenta, double alquiler ) {
		super(precioVenta);
		this.alquiler = alquiler;
	}


	@Override
	public void activarEfecto( Jugador jugador ) {
		if ( this.tienePropietario()  && !this.esPropietario(jugador)) {
			jugador.disminuirCapital( jugador.getUltimaTirada() * this.alquiler );
			getPropietario().aumentarCapital( jugador.getUltimaTirada() * this.alquiler );

		}
	}

}
