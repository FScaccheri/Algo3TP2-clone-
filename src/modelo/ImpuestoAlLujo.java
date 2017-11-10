package modelo;

public class ImpuestoAlLujo implements Efecto {
	
	private static double VALOR_IMPUESTO = 0.1;
	@Override
	public void activarEfecto(Jugador jugador) {
		jugador.disminuirCapital(jugador.getCapital()*VALOR_IMPUESTO);

	}

}
