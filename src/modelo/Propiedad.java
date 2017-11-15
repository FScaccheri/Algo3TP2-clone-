package modelo;

public class Propiedad extends Adquirible {
	
	private InformeDeAlquileres alquileres;

	public Propiedad(double precio_venta, InformeDeAlquileres informeDeAlquileres) {
		super(precio_venta);
		this.alquileres = informeDeAlquileres;
	}

	public int getCantidadDeCasas() {
		return 0;
	}

	public boolean tieneHotel() {
		return false;
	}
	
	@Override
	public double getAlquiler(Jugador jugador) {
		return alquileres.getAlquilerBase();
	}
}
