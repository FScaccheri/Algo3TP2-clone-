package modelo;

public class AvanceDinamico implements Activable{
	
	private MovimientoDinamico movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		unJugador.avanzar(movimientoDinamico.mover(unJugador, unJugador.getUltimaTirada()));
	}

}
