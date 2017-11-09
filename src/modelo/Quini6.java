package modelo;
import java.util.*;

public class Quini6 implements Efecto {
	
	HashMap<Jugador, Integer> ganadores;
	int veces_activado = 0;
	
	public Quini6() {
		this.ganadores = new HashMap<Jugador, Integer>();
	}
	
	/* (non-Javadoc)
	 * @see modelo.Efecto#activarEfecto(modelo.Jugador)
	 */
//	@Override
//	public void activarEfecto(Jugador jugador) {
//		if(veces_activado == 0) {
//			jugador.aumentarCapital(50000);
//			veces_activado++;
//		}else if (veces_activado == 1) {
//			jugador.aumentarCapital(30000);	
//			veces_activado++;
//		}
//	}
	public int vecesGanador( Jugador jugador ) {
		if ( this.ganadores.containsKey( jugador ) )
		return ganadores.get( jugador );
		else return 0;
	}
	public void nuevoGanador( Jugador jugador ) {
		if ( !ganadores.containsKey( jugador ) ) {
			ganadores.put( jugador , 1 );
		}
		else {
			ganadores.put( jugador , ganadores.get( jugador ) + 1 );
		}
	}
	@Override
	public void activarEfecto(Jugador jugador) {
		if ( vecesGanador( jugador ) == 0 ) {
			jugador.aumentarCapital( 50000 );
		}
		else if ( vecesGanador( jugador ) == 1 ) {
			jugador.aumentarCapital( 30000 );
		}
		nuevoGanador( jugador );
	}

}
