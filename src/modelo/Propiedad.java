package modelo;

import modelo.excepciones.ConstruccionImposible;

public class Propiedad extends Rentable {
	
	private Alquiler alquiler;
	private Terreno terreno;
	private double costoCasa;
	private double costoHotel;
	
	private Propiedad(double precioDeVenta, double costoCasa) {
		super(precioDeVenta);
		this.costoCasa = costoCasa;
	}
	
	public Propiedad(double precioDeVenta, double alquilerBase, double alquilerUnaCasa, double costoCasa) {
		this(precioDeVenta, costoCasa);
		alquiler = new Alquiler(alquilerBase, alquilerUnaCasa);
		terreno = new Terreno(1, 0);
	}
	
	public Propiedad(double precioDeVenta, double alquilerBase, double alquilerUnaCasa, double alquilerDosCasas, double alquilerUnHotel, double costoCasa, double costoHotel) {
		this(precioDeVenta, costoCasa);
		this.costoHotel = costoHotel;
		alquiler = new Alquiler(alquilerBase, alquilerUnaCasa, alquilerDosCasas, alquilerUnHotel);
		terreno = new Terreno(2, 1);
	}
	
	
	public void construirCasa() {
		if(!puedeCostruirCasa())
			throw new ConstruccionImposible();
		
		Adquirible casa = new Adquirible(costoCasa);
		casa.adquirir(getPropietario());
		terreno.agregarCasa(casa);
		alquiler.aumentarAlquiler();
	}
	
	public void construirHotel() {
		if(!puedeCostruirHotel())
			throw new ConstruccionImposible();
		
		Adquirible hotel = new Adquirible(costoHotel);
		hotel.adquirir(getPropietario());
		terreno.agregarHotel(hotel);
		alquiler.aumentarAlquiler();
	}
	
	@Override
	public void vender() {
		super.vender();
		for(Adquirible construccion : terreno.getConstrucciones())
			construccion.vender();
		terreno.demoler();
		alquiler.reiniciarAlquiler();
	}
		
	@Override
	public double getAlquiler() {
		return alquiler.getAlquiler();
	}
	
	public int getCantidadDeCasas() {
		return terreno.getCantidadDeCasas();
	}

	public int getCantidadDeHoteles() {
		return terreno.getCantidadDeHoteles();
	}
	
	public boolean tieneHotel() {
		return terreno.tieneHoteles();
	}

	private boolean puedeCostruirCasa() {
		return terreno.construccionDeCasaPosible() && (!estaAsociado() || esPropietario(getRentableAsociado().getPropietario()));
	}
	
	private boolean puedeCostruirHotel() {
		return terreno.construccionDeHotelPosible() && (!estaAsociado() || (getCantidadDeCasas() == ((Propiedad) getRentableAsociado()).getCantidadDeCasas()));
	}
}
