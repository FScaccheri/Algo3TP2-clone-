package modelo;

public class InformeDeConstruccion {
	private
	double casa;
	double hotel;
	
	public InformeDeConstruccion(double precio_casa, double precio_hotel) {
		casa = precio_casa;
		hotel = precio_hotel;
	}
	
	public InformeDeConstruccion() {
		this(0, 0);
	}
	
	public double getPrecioDeCasa() {
		return casa;
	}
	
	public double getPrecioDeHotel() {
		return hotel;
	}
}
