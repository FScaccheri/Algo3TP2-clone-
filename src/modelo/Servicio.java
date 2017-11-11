package modelo;

public class Servicio implements Activable {
	private
	Jugador propietario;
	Servicio asociado;
	int multiplicadorDeCosto;
	
	public Servicio( int multiplicador ) {
		this.multiplicadorDeCosto = multiplicador;
	}
	
	public void adquirir( Jugador jugador ) {
		this.propietario = jugador;
	}
	
	public boolean esPropietario( Jugador jugador ) {
		return propietario == jugador;
	}
	
	@Override
	public void activarEfecto( Jugador jugador ) {
		if ( !this.esPropietario(jugador) )
		jugador.disminuirCapital( jugador.getUltimaTirada() * this.multiplicadorDeCosto );
	}

}
