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
		if ( !this.presos.containsKey(jugador)) {
			this.presos.put(jugador, 0);
			jugador.setMovimiento(new MovimientoNulo());
		}
	}

	public boolean estaPreso(Jugador jugador) {
		return (this.presos.containsKey(jugador));
	}

	public void liberar(Jugador jugador) {
		this.presos.remove(jugador);
		jugador.setMovimiento(new MovimientoBasico());
	}
	public void liberarJugadorPorFianza(Jugador jugador) {
			jugador.disminuirCapital(FIANZA);
			this.liberar(jugador);
	}

}
