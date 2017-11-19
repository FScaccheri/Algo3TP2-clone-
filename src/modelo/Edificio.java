package modelo;

public class Edificio extends Adquirible{
	private double alquiler;
	
	public Edificio(double precio_venta, double alquiler) {
		super(precio_venta);
		this.alquiler = alquiler;
	}

	@Override
	public double getAlquiler(Jugador jugador) {
		return alquiler;
	}
	
	
}
