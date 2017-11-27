package modelo.casilleros.movimiento;

import modelo.Jugador;
import modelo.Tirada;
import modelo.casilleros.Activable;

//FALTAN PRUEBAS @FrancoR
public class RetrocesoDinamico implements Activable{
	
	private MovimientoDinamico movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(movimientoDinamico.mover(unJugador, Tirada.getUltimaTirada()), new MovimientoInverso());
	}

}