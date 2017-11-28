package modelo;

public class Tirada {
	
	private static int ultimaTirada;
	private static boolean salieronDobles;
	private Tirada() {}
	
	public static int tirar() {
		Dado dado = new Dado();
		int resultadoDadoUno = dado.tirar();
		int resultadoDadoDos = dado.tirar();
		
		salieronDobles = (resultadoDadoUno == resultadoDadoDos);

		return ultimaTirada = resultadoDadoUno + resultadoDadoDos;
	}
	
	public static int getUltimaTirada() {
		return ultimaTirada;
	}

	public static boolean fueDoble() {
		return salieronDobles;
	}
	
	// Existe para probar avance dinamico.
	public static void setUltimaTirada(int tirada) {
		ultimaTirada = tirada;
	}

	// Existe para probar AdministradorDeTurnos.
	public static void setSalieronDobles(boolean dobles) {
		salieronDobles = dobles;
	}
}
