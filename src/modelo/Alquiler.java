package modelo;

import java.util.ArrayList;

public class Alquiler {
	private ArrayList<Double> alquileres;
	private int alquilerActual;
	
	public Alquiler(double alquilerBase, double alquilerUnaCasa) {
		alquileres = new ArrayList<Double>();
		alquileres.add(alquilerBase);
		alquileres.add(alquilerUnaCasa);
	}
	
	public Alquiler(double alquilerBase, double alquilerUnaCasa, double alquilerDosCasas, double alquilerUnHotel) {
		this(alquilerBase, alquilerUnaCasa);
		alquileres.add(alquilerDosCasas);
		alquileres.add(alquilerUnHotel);
	}

	public double getAlquiler() {
		return alquileres.get(alquilerActual);
	}

	public void aumentarAlquiler() {
		alquilerActual++;
	}

}
