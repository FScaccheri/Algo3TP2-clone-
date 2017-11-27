package modelo.casilleros.movimiento;

import modelo.Jugador;
import modelo.casilleros.Activable;

public class AvanceDinamico implements Activable{
	
	private MovimientoDinamico movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(movimientoDinamico.mover(unJugador, unJugador.getUltimaTirada()));
	}

}
