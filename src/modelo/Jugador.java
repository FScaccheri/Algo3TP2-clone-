package modelo;

public class Jugador {
	private static final int CAPITALINICIAL = 100000;
	double capital = CAPITALINICIAL;
	int ultimaTirada = 0;
	
	public double getCapital() {
		return capital;
	}
	
	public void aumentarCapital( double i ) {
		capital+=i;
	}

	public void disminuirCapital( double i ) {
		capital-=i;
	}

	//ESTE METODO NO TIENE SENTIDO, ES SOLO PARA HACER PRUEBAS EN SERVICIO
	//CUANDO ESTE PROGRAMADO EL MOVIMIENTO NO DEBERIA EXISTIR
	public void setUltimaTirada( int ultimaTirada ) {
		this.ultimaTirada = ultimaTirada;	
	}
	
	//VER SI ESTE METODO TIENE SENTIDO LUEGO DE PROGRAMAR EL MOVIMIENTO(SE USA EN SERVICIO)
	public int getUltimaTirada() {
		return ultimaTirada;
	}

}
