package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.movimiento.MovimientoDinamico;
import modelo.casilleros.movimiento.MovimientoInverso;

//FALTAN PRUEBAS @FrancoR
public class RetrocesoDinamico implements Activable{
	
	private MovimientoDinamico movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(movimientoDinamico.mover(unJugador, unJugador.getUltimaTirada()), new MovimientoInverso());
	}

}