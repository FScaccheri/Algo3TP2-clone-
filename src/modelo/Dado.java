package modelo;

import java.util.Random;

public class Dado {
	public int tirar() {
		return new Random().nextInt(6)+1;
	}
}
