package modelo;

public class Quini6 {
	
	int veces_activado = 0;
	
	public void activarEfecto(Jugador jugador) {
		if(veces_activado == 0) {
			jugador.aumentarCapital(50000);
			veces_activado++;
		}else if (veces_activado == 1) {
			jugador.aumentarCapital(30000);	
			veces_activado++;
		}
	}

}
