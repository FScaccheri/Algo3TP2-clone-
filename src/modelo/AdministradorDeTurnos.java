package modelo;

import java.util.LinkedList;

//Esta clase no tiene pruebas pues es solo una propuesta de resolucion a la cuestion de administracion de turnos @FrancoR
public class AdministradorDeTurnos {

	private LinkedList<TieneAccionFinTurno> accionesFinDeTurno;
	private LinkedList<TieneAccionInicioTurno> accionesInicioDeTurno;
	private LinkedList<Jugador> jugadores;
	private Jugador jugadorActual;
	
	public void agregarAccionFinTurno(TieneAccionFinTurno accionPorAgregar) {
		accionesFinDeTurno.add(accionPorAgregar);
	}
	public void agregarAccionInicioTurno(TieneAccionInicioTurno accionPorAgregar) {
		accionesInicioDeTurno.add(accionPorAgregar);
	}
	
	public void finalizarTurno() {
		for (int i = 0; i < accionesFinDeTurno.size(); i++) {
			accionesFinDeTurno.get(i).accionFinDeTurno();
		}
		jugadorActual = this.siguienteJugador(jugadorActual,jugadores);
	}
	
	public void iniciarTurno() {
		for (int i = 0; i < accionesInicioDeTurno.size(); i++) {
			accionesInicioDeTurno.get(i).accionInicioDeTurno();
		}
	}
	
	private Jugador siguienteJugador(Jugador jugadorActual, LinkedList<Jugador> jugadores) {
		Jugador jugadorPorDevolver;
		try {
			jugadorPorDevolver = jugadores.get(jugadores.indexOf(jugadorActual) + 1);
		} catch (IndexOutOfBoundsException e) {
			jugadorPorDevolver = jugadores.get(0);
		}
		return jugadorPorDevolver;
	}
}
