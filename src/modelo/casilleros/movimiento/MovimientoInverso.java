package modelo.casilleros.movimiento;

import modelo.Jugador;

public class MovimientoInverso implements Movimiento{
	
	@Override
	public void mover(Jugador jugador, int posiciones) {
		jugador.retroceder(posiciones);
	}

}
