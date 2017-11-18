package modelo;

public class MovimientoDinamico implements Movimiento {

	public void mover(Jugador jugador, int posiciones) {
		if (2 <= posiciones && posiciones <= 6) {
			jugador.mover(posiciones - 2);
		}
		
		if (7 <= posiciones && posiciones <= 10) {
			jugador.mover((int)jugador.getCapital()%posiciones);
		}
		
		if ( 11 <= posiciones && posiciones <= 12) {
//			unJugador.moverAPosicion(unJugador.getPosicion() + unJugador.cantidadDePropiedades()+ unJugador.cantidadDeCasas() + unJugador.cantidadDeHoteles());
		}
	}
}
