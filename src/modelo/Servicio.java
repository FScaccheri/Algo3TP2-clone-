package modelo;

public class Servicio extends Rentable {

	private Servicio asociado;
	private double alquilerSimple;
	private double alquilerCombo;

	public Servicio( double precioVenta, double alquilerSimple, double alquilerCombo ) {
		super(precioVenta);
		this.alquilerSimple = alquilerSimple;
		this.alquilerCombo = alquilerCombo;
	}

	public void asociar( Servicio socio ) {
		if ( !this.estaEnCombo() ) {
			this.asociado = socio;
			socio.asociar(this);
		}
	}

	private boolean estaEnCombo() {
		return ( this.asociado != null && (this.getPropietario() == this.asociado.getPropietario() ));
	}

	@Override
	public double getAlquiler() {
		if ( this.estaEnCombo() )
			return Tirada.getUltimaTirada() * this.alquilerCombo;
		return Tirada.getUltimaTirada() * this.alquilerSimple;
	}

}
