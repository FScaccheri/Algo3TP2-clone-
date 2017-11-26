package modelo;

public class Servicio extends Rentable {

	private double alquilerSimple;
	private double alquilerCombo;

	public Servicio( double precioVenta, double alquilerSimple, double alquilerCombo ) {
		super(precioVenta);
		this.alquilerSimple = alquilerSimple;
		this.alquilerCombo = alquilerCombo;
	}

	@Override
	public double getAlquiler() {
		if ( this.estaAsociado() && esPropietario(getRentableAsociado().getPropietario()))
			return Tirada.getUltimaTirada() * this.alquilerCombo;
		return Tirada.getUltimaTirada() * this.alquilerSimple;
	}
	
}
