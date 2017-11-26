package modelo;

public class Tirada {
	
	private static int ultimaTirada;
	private static boolean salieronDobles;
	private Tirada() {}
	
	public static int tirar() {
		int resultadoDadoUno = tirarUnDado();
		int resultadoDadoDos = tirarUnDado();
		
		salieronDobles = (resultadoDadoUno == resultadoDadoDos);

		return ultimaTirada = resultadoDadoUno + resultadoDadoDos;
	}
	
	private static int tirarUnDado() {
		
		Dado unDado = new Dado();
		return unDado.tirar();
	}
	
	public static int getUltimaTirada() {
		return ultimaTirada;
	}

	public static boolean fueDoble() {
		
		return salieronDobles;
	}


}
