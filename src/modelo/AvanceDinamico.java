package modelo;

public class AvanceDinamico implements Activable{
	
	public void activarEfecto(Jugador unJugador) {
		
		if (2 <= unJugador.getUltimaTirada() && unJugador.getUltimaTirada() <= 6) {
			//unJugador.moverAPosicion(unJugador.getPosicion() + unJugador.getUltimaTirada() - 2);
			unJugador.avanzar(unJugador.getUltimaTirada() - 2);
		}
		
		if (7 <= unJugador.getUltimaTirada() && unJugador.getUltimaTirada() <= 10) {
			//unJugador.moverAPosicion((int)(unJugador.getPosicion() + (unJugador.getCapital()%unJugador.getUltimaTirada())));
			unJugador.avanzar((int)unJugador.getCapital()%unJugador.getUltimaTirada());
		}
		
		if ( 11 <= unJugador.getUltimaTirada() && unJugador.getUltimaTirada() <= 12) {
//			unJugador.moverAPosicion(unJugador.getPosicion() + unJugador.cantidadDePropiedades()+ unJugador.cantidadDeCasas() + unJugador.cantidadDeHoteles());
		}
	}

}
