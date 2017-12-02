package modelo.casilleros.movimiento;

import modelo.Jugador;
import modelo.Tirada;
import modelo.casilleros.Activable;

//FALTAN PRUEBAS @FrancoR
public class RetrocesoDinamico implements Activable{
	
	private Movimiento movimientoDinamicoInverso = new MovimientoDinamicoInverso();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(Tirada.getUltimaTirada(), movimientoDinamicoInverso);
	}

}