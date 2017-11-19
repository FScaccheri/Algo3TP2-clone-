package modelo;

public class AvanceDinamico implements Activable{
	
	private Movimiento movimientoDinamico = new MovimientoDinamico();
	
	public void activarEfecto(Jugador unJugador) {
		int posiciones = unJugador.getUltimaTirada();
		unJugador.avanzar(posiciones, this.movimientoDinamico);
	}

}
