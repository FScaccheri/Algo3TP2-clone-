package modelo;

public class Propiedad extends Adquirible {
	
	private
	InformeDeAlquileres alquileres;
	InformeDeConstruccion construccion;

	public Propiedad(double precio_venta, InformeDeAlquileres informeDeAlquileres, InformeDeConstruccion informeDeConstruccion) {
		super(precio_venta);
		alquileres = informeDeAlquileres;
		construccion = informeDeConstruccion;
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
