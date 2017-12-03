package modelo;

import java.util.ArrayList;

import modelo.excepciones.DebeLanzarLosDados;
import modelo.excepciones.LanzamientoImposible;

public class AdministradorDeTurnos {
	ListaCircular<Jugador> jugadores;
	private int actual;
	private boolean lanzoLosDados;
	private int cantidadDeDobles;
	
	public AdministradorDeTurnos() {
		this.jugadores = new ListaCircular<Jugador>();
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
	}
	
	public void finalizarTurno() {
		if(!lanzoLosDados())
			throw new DebeLanzarLosDados();
		
		if((!Tirada.fueDoble()) || (cantidadDeDobles == 1)) {
			actual++;
			cantidadDeDobles = -1;
		}
		cantidadDeDobles++;
		
		lanzoLosDados = false;
	}
	
	public Jugador getJugadorActual() {
		return jugadores.get(actual);
	}
	
	public void lanzarDados() {
		if(lanzoLosDados())
			throw new LanzamientoImposible();
		Tirada.tirar();
		lanzoLosDados = true;
	}
	
	public boolean lanzoLosDados() {
		return lanzoLosDados;
	}

	public ArrayList<Jugador> getJugadores() {
		return new ArrayList<Jugador>(jugadores);
	}

	public void eliminarJugador(Jugador jugadorActual) {
		
		jugadores.remove(jugadorActual);
		
	}
}
