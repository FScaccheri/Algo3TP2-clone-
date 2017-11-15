package modelo;

public class InformeDeAlquileres {
	private
	double base;
	double unaCasa;
	double dosCasas;
	double hotel;
	
	public InformeDeAlquileres() {
		this(0,0,0,0);
	}
	
	public InformeDeAlquileres(double base, double unaCasa, double dosCasas, double hotel) {
		this.base = base;
		this.unaCasa = unaCasa;
		this.dosCasas = dosCasas;
		this.hotel = hotel;
	}
	
	public double getAlquilerBase() {
		return base;
	}

	public double getAlquilerConUnaCasa() {
		return unaCasa;
	}
	
	public double getAlquilerConDosCasas() {
		return dosCasas;
	}

	public double getAlquilerConHotel() {
		return hotel;
	}
}
