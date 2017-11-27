package vistas;

import java.util.LinkedList;

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
	
	public VistaJugador(GraphicsContext gc, LinkedList<Jugador> jugadores, VistaTablero tablero, Paint color, int numeroJugador) {
		
		this.tablero = tablero;
		this.gc = gc;
		this.color = color;
		this.numero = numeroJugador - 1;
		this.posicionEnTablero = 0;
		this.posX = tablero.getVistasCasillero(posicionEnTablero).getPosX() + 90;
		this.posY = tablero.getVistasCasillero(posicionEnTablero).getPosY() + 40;
		this.jugador = jugadores.get(numero);
	}

	public void moverA(int posicionEnTablero) {
		
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY + numero*17, radio, radio);
			
		posX = tablero.getVistasCasillero(posicionEnTablero).getPosX() + 90;
		posY = tablero.getVistasCasillero(posicionEnTablero).getPosY() + 40;
		
		
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
