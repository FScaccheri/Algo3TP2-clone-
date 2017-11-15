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
	public double getAlquiler(Jugador jugador) {
		return jugador.getUltimaTirada() * this.alquiler;
	}

}
