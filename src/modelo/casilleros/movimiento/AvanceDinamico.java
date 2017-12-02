package modelo.casilleros.movimiento;

import modelo.Jugador;
import modelo.Tirada;
import modelo.casilleros.Activable;

public class AvanceDinamico implements Activable{
	
	private Movimiento movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(Tirada.getUltimaTirada(), movimientoDinamico);
	}

}
