package modelo;

import java.util.HashMap;

public class Carcel implements Efecto{

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
		
		if ( !this.presos.containsKey(jugador))
			
			this.presos.put(jugador, 0);
			
		else {
			
			if ( turnosTranscurridos(jugador) < 3) { 
				
				this.presos.put(jugador, turnosTranscurridos(jugador) + 1);

				if (turnosTranscurridos(jugador) == 3)
					
					this.presos.remove(jugador);
				
			}
		
		}
		
	}

	public boolean estaPreso(Jugador jugador) {

		return (this.presos.containsKey(jugador));
	}

	public void liberarJugadorPorFianza(Jugador jugador) {
		
		if ( turnosTranscurridos(jugador) > 1) {

			jugador.disminuirCapital(FIANZA);
		
			this.presos.remove(jugador);
		}
		
	}

}
