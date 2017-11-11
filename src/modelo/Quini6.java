package modelo;
import java.util.*;

public class Quini6 implements Efecto {
	
	HashMap<Jugador, Integer> ganadores;
	private static final double PRIMERPREMIO = 50000;
	private static final double SEGUNDOPREMIO = 30000;
	
	public Quini6() {
		this.ganadores = new HashMap<Jugador, Integer>();
	}
	
	private int vecesGanador( Jugador jugador ) {
		if ( this.ganadores.containsKey( jugador ) ) {
			return ganadores.get( jugador );			
		}else {
			return 0;
		}
	}
	
	private void nuevoGanador( Jugador jugador ) {
		ganadores.put( jugador, vecesGanador( jugador ) + 1 );
	}
	
	@Override
	public void activarEfecto(Jugador jugador) {
		int veces_ganador = vecesGanador( jugador );
		if ( veces_ganador == 0 ) {
			jugador.aumentarCapital( PRIMERPREMIO );
		}
		else if ( veces_ganador == 1 ) {
			jugador.aumentarCapital( SEGUNDOPREMIO );
		}
		nuevoGanador( jugador );
	}

}
