package modelo;

import modelo.excepciones.DebeLanzarLosDados;
import modelo.excepciones.LanzamientoImposible;

public class AdministradorDeTurnos2 {
	ListaCircular<Jugador> jugadores;
	private int actual;
	private boolean lanzoLosDados;
	private int cantidadDeDobles;
	
	public AdministradorDeTurnos2(Jugador... jugadores) {
		this.jugadores = new ListaCircular<Jugador>();
		for(Jugador jugador:jugadores)
			this.jugadores.add(jugador);
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
}
