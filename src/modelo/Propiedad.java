package modelo;

public class Propiedad extends Adquirible {
	
	private
	InformeDeAlquileres alquileres;
	InformeDeConstruccion construccion;
	int casas = 0;
	boolean conHotel = false;

	public Propiedad(double precio_venta, InformeDeAlquileres informeDeAlquileres, InformeDeConstruccion informeDeConstruccion) {
		super(precio_venta);
		alquileres = informeDeAlquileres;
		construccion = informeDeConstruccion;
	}

	public int getCantidadDeCasas() {
		return casas;
	}

	public boolean tieneHotel() {
		return conHotel;
	}
	
	@Override
	public double getAlquiler(Jugador jugador) {
		return alquileres.getAlquilerBase();
	}
	
	public void construirCasa() {
		casas++;
	}
	
	public void construirHotel() {
		conHotel = true;
	}
	
	public int getCantidadDeHoteles() {
		if (conHotel) {	return 1;} else { return 0; }
	}
	
}
