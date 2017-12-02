package modelo.casilleros.movimiento;

import modelo.Jugador;

public class MovimientoBasico implements Movimiento {

	/* (non-Javadoc)
	 * @see modelo.Movimiento#mover(modelo.Jugador, int)
	 */
	@Override
	public void mover(Jugador jugador, int posiciones) {
		for ( int i = 0; i < posiciones; i++ ) {
			jugador.setPosicion(jugador.getPosicion().siguiente());
		}
	}
}
