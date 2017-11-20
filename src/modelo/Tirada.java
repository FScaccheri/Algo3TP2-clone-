package modelo;

public class Tirada {
	
	private static int ultimaTirada;
	private Tirada() {}
	
	public static int tirar() {
		Dado dado = new Dado();
		return ultimaTirada = dado.tirar() + dado.tirar();
	}
	
	public static int getUltimaTirada() {
		return ultimaTirada;
	}

}
