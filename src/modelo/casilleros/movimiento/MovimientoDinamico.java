package modelo.casilleros.movimiento;

import modelo.Jugador;

public class MovimientoDinamico implements Movimiento {

	public void mover(Jugador jugador, int ultimaTirada) {
				
		if (2 <= ultimaTirada && ultimaTirada <= 6) {
			jugador.avanzar((ultimaTirada - 2));
		}
		
		if (7 <= ultimaTirada && ultimaTirada <= 10) {
			jugador.avanzar((int)jugador.getCapital()%ultimaTirada);
		}
		
		if ( 11 <= ultimaTirada && ultimaTirada <= 12) {
			jugador.avanzar(ultimaTirada - (jugador.cantidadDePropiedades()+ jugador.getCantidadDeCasas() + jugador.getCantidadDeHoteles()));
		}
		
	}
}
