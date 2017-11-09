package modelo;

public class Jugador {
	double capital = 0;
	
	public double getCapital() {
		return capital;
	}
	
	public void aumentarCapital(double i) {
		capital+=i;
	}

	public void disminuirCapital(double i) {
		capital-=i;
	}
}
