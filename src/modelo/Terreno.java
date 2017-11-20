package modelo;

import java.util.ArrayList;

import modelo.excepciones.ConstruccionImposible;

public class Terreno {
	private ArrayList<Adquirible> casas;
	private ArrayList<Adquirible> hoteles;
	private int cantidadDeCasasMaxima;
	private int cantidadDeHotelesMaxima;
	
	public Terreno(int cantidadDeCasasMaxima, int cantidadDeHotelesMaxima){
		casas = new ArrayList<Adquirible>();
		hoteles = new ArrayList<Adquirible>();
		this.cantidadDeCasasMaxima = cantidadDeCasasMaxima;
		this.cantidadDeHotelesMaxima = cantidadDeHotelesMaxima;
	}

	public void agregarCasa(Adquirible casa) {
		if(!construccionDeCasaPosible())
			throw new ConstruccionImposible();
		
		casas.add(casa);
	}
	
	public void agregarHotel(Adquirible hotel) {
		if(!construccionDeHotelPosible())
			throw new ConstruccionImposible();
		
		hoteles.add(hotel);
	}

	public ArrayList<Adquirible> getConstrucciones() {
		ArrayList<Adquirible> Adquiribles = new ArrayList<Adquirible>(casas);
		Adquiribles.addAll(hoteles);
		return Adquiribles;
	}
	
	public boolean construccionDeCasaPosible() {
		return (cantidadDeCasasMaxima != getCantidadDeCasas()) && !tieneHoteles();
	}

	public boolean construccionDeHotelPosible() {
		return !construccionDeCasaPosible() && (cantidadDeHotelesMaxima != getCantidadDeHoteles());
	}
	
	public int getCantidadDeCasas() {
		if(tieneHoteles())
			return 0;
		return casas.size();
	}

	public int getCantidadDeHoteles() {
		return hoteles.size();
	}

	public boolean tieneHoteles() {
		return getCantidadDeHoteles() != 0;
	}
}
