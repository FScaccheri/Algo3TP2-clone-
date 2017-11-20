package modelo;

public class Tirada {

	public int tirar() {
		Dado dado = new Dado();
		return dado.tirar()+dado.tirar();
	}

}
