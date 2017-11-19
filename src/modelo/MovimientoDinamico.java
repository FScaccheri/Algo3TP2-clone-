package modelo;

public class MovimientoDinamico {

	public int mover(Jugador jugador, int ultimaTirada) {
		
		int porMover = 0;
		
		if (2 <= ultimaTirada && ultimaTirada <= 6) {
			porMover = (ultimaTirada - 2);
		}
		
		if (7 <= ultimaTirada && ultimaTirada <= 10) {
			porMover = ((int)jugador.getCapital()%ultimaTirada);
		}
		
		if ( 11 <= ultimaTirada && ultimaTirada <= 12) {
//			return (jugador.cantidadDePropiedades()+ jugador.getCantidadDeCasas() + jugador.getCantidadDeHoteles()));
		}
		
		return porMover;
	}
}
