package modelo;

public class Jugador {
	double capital = 0;
	
	public double getCapital() {
		return capital;
	}
	
	public void setCapital( double capital ) {
		this.capital+=capital;
	}
	public void aumentarCapital(double i) {
		capital+=i;
	}

}
