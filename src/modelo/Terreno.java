package modelo;

import java.util.ArrayList;

import modelo.excepciones.ConstruccionImposible;

public class Terreno {
	private ArrayListLimitado<Edificio> casas;
	private ArrayListLimitado<Edificio> hoteles;
	
	public Terreno(int cantidadDeCasasMaxima, int cantidadDeHotelesMaxima){
		casas = new ArrayListLimitado<Edificio>(cantidadDeCasasMaxima, new ConstruccionImposible());
		hoteles = new ArrayListLimitado<Edificio>(cantidadDeHotelesMaxima, new ConstruccionImposible());
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
		casas.addConExcepcion(casa);
	}
	
	public void agregarHotel(Edificio hotel) {
		if(getCantidadDeCasas() != casas.getCantidadMaxima())
			throw new ConstruccionImposible();			
		
		hoteles.addConExcepcion(hotel);
	}

	public ArrayList<Edificio> getEdificios() {
		ArrayList<Edificio> edificios = new ArrayList<Edificio>(casas);
		edificios.addAll(hoteles);
		return edificios;
	}

	public boolean tieneHoteles() {
		return getCantidadDeHoteles() != 0;
	}	
}
