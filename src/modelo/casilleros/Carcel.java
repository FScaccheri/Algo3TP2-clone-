package modelo.casilleros;

import java.util.HashMap;

import modelo.Jugador;
import modelo.casilleros.movimiento.MovimientoBasico;
import modelo.casilleros.movimiento.MovimientoNulo;
import modelo.excepciones.CapitalInsuficiente;
import modelo.excepciones.LiberacionInvalida;

public class Carcel implements Activable{

	private static final double FIANZA = 45000;
	private HashMap<Jugador, Integer> presos;

	public Carcel() {
		this.presos = new HashMap<Jugador, Integer>();
	}

	public void activarEfecto(Jugador jugador) {
		if ( !this.presos.containsKey(jugador)) {
			this.presos.put(jugador, 0);
			jugador.setMovimiento(new MovimientoNulo());
		} else if(presos.get(jugador) < 2) {
			this.presos.put(jugador, presos.get(jugador) + 1);
		} else {
			liberar(jugador);
		}
	}

	public boolean estaPreso(Jugador jugador) {
		return (this.presos.containsKey(jugador));
	}

	public void liberar(Jugador jugador) {
		if(presos.get(jugador) == 0)
			throw new LiberacionInvalida();
		this.presos.remove(jugador);
		jugador.setMovimiento(new MovimientoBasico());
	}
	public void liberarJugadorPorFianza(Jugador jugador) {
		if(jugador.getCapital() < FIANZA)
			throw new CapitalInsuficiente();
		
		this.liberar(jugador);
		jugador.disminuirCapital(FIANZA);
	}

	public int getTurnosPreso(Jugador jugador) {
		
		int turnos = presos.get(jugador);
		return turnos;
	}

}
