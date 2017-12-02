package modelo.casilleros.movimiento;

import modelo.Jugador;

public class MovimientoInverso implements Movimiento{
	
	@Override
	public void mover(Jugador jugador, int posiciones) {
		for ( int i = 0; i < posiciones; i++ ) {
			jugador.setPosicion(jugador.getPosicion().anterior());
		}
	}

}
