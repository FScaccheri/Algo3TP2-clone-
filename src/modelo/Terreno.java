package modelo;

import java.util.ArrayList;

import modelo.excepciones.ConstruccionImposible;

public class Terreno {
	private ArrayList<Edificio> casas;
	private ArrayList<Edificio> hoteles;
	private int cantidadDeCasasMaxima;
	private int cantidadDeHotelesMaxima;
	
	public Terreno(int cantidadDeCasasMaxima, int cantidadDeHotelesMaxima){
		casas = new ArrayList<Edificio>();
		hoteles = new ArrayList<Edificio>();
		this.cantidadDeCasasMaxima = cantidadDeCasasMaxima;
		this.cantidadDeHotelesMaxima = cantidadDeHotelesMaxima;
	}

	public int getCantidadDeCasas() {
		if(tieneHoteles())
			return 0;
		return casas.size();
	}

	public int getCantidadDeHoteles() {
		return hoteles.size();
	}

	public void agregarCasa(Edificio casa) {
		if(!construccionDeCasaPosible())
			throw new ConstruccionImposible();
		casas.add(casa);
	}
	
	public void agregarHotel(Edificio hotel) {
		if(!construccionDeHotelPosible())
			throw new ConstruccionImposible();
		
		hoteles.add(hotel);
	}

	public ArrayList<Edificio> getEdificios() {
		ArrayList<Edificio> edificios = new ArrayList<Edificio>(casas);
		edificios.addAll(hoteles);
		return edificios;
	}

	public boolean tieneHoteles() {
		return getCantidadDeHoteles() != 0;
	}

	public boolean construccionDeCasaPosible() {
		return (cantidadDeCasasMaxima != getCantidadDeCasas()) && !tieneHoteles();
	}

	public boolean construccionDeHotelPosible() {
		return !construccionDeCasaPosible() && (cantidadDeHotelesMaxima != getCantidadDeHoteles());
	}
}
