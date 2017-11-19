package modelo;

import java.util.HashMap;

public class Carcel implements Activable{

	private static final double FIANZA = 45000;
	private HashMap<Jugador, Integer> presos;

	public Carcel() {
		this.presos = new HashMap<Jugador, Integer>();
	}

	private int turnosTranscurridos(Jugador jugador) {
		int turnosTranscurridos = this.presos.get(jugador);
		return turnosTranscurridos;
	}


	public void activarEfecto(Jugador jugador) {
		jugador.setMovimiento(new MovimientoNulo());
	}

	public boolean estaPreso(Jugador jugador) {

		return (this.presos.containsKey(jugador));
	}

	public void liberarJugadorPorFianza(Jugador jugador) {

		if ( turnosTranscurridos(jugador) > 0) {

			jugador.disminuirCapital(FIANZA);

			this.presos.remove(jugador);
		}

	}

}
