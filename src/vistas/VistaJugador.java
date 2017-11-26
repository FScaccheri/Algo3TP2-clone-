package vistas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Jugador;

public class VistaJugador {

	private GraphicsContext gc;
	private Paint color;
	private int numero;
	private int posX;
	private int posY;
	private VistaTablero tablero;
	private int posicionEnTablero;
	private static double radio = 15;
	private Jugador jugador;
	
	public VistaJugador(GraphicsContext gc, VistaTablero tablero, Paint color, int numeroJugador) {
		
		this.tablero = tablero;
		this.gc = gc;
		this.color = color;
		this.numero = numeroJugador - 1;
		
		this.posicionEnTablero = 0;
		
		posX = tablero.getCasillero(posicionEnTablero).getPosX() + 90;
		posY = tablero.getCasillero(posicionEnTablero).getPosY() + 40;
		jugador = new Jugador();
	}

	public void avanzar(int tirada) {
		
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY + numero*17, radio, radio);
		
		posicionEnTablero += tirada;
		
		if (posicionEnTablero >= 20)
			
			posicionEnTablero -= 20;
			
		posX = tablero.getCasillero(posicionEnTablero).getPosX() + 90;
		posY = tablero.getCasillero(posicionEnTablero).getPosY() + 40;
		
		
		dibujar();
		
	}

	public void dibujar() {

		gc.setFill(color);
		gc.fillOval(posX , posY + numero*17, radio, radio);
		
	}

	public Paint getColor() {
		
		return color;
	}

	public int getPosX() {
		
		return posX - 90;
	}

	public int getPosY() {

		return posY - 40;
	}
	
	public Jugador getJugadorAsociado() {
		return jugador;
	}

}
