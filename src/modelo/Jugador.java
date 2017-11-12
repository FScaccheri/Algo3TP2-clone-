package modelo;

public class Jugador {
	double capital = 0;
	int ultimaTirada = 0;
	private int posicion;
	
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

	public int getPosicion() {

		return this.posicion ;
	}

	//Metodo provisional para "mover" al Jugador, hasta que se implemente correctamente
	//el movimiento. @Franco S.
	public void moverAPosicion(int nuevaPosicion) {
		
		this.posicion = nuevaPosicion;
		
	}

}
