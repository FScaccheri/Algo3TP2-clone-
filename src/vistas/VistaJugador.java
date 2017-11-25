package vistas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Casillero;
import modelo.Jugador;
import modelo.Posicion;

public class VistaJugador {

	private GraphicsContext gc;
	private Paint color;
	private int numero;
	private int posX;
	private int posY;
	private VistaTablero tablero;
	private int posicionEnTablero;
	private static double radio = 15;
	
	public VistaJugador(GraphicsContext gc, VistaTablero tablero, Paint color, int numeroJugador) {
		
		this.tablero = tablero;
		this.gc = gc;
		this.color = color;
		this.numero = numeroJugador - 1;
		
		this.posX = 730;
		this.posY = 680;
		
		this.posicionEnTablero = 1;
		
		this.posX = tablero.getCasillero(0).getPosX() + 90;
		this.posY = tablero.getCasillero(0).getPosY() + 40;
	}

	public void avanzar(int tirada) {
		
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY + numero*17, radio, radio);
		
		int proximaPosicion = posicionEnTablero + tirada;
		
		if (proximaPosicion > 20)
			
			proximaPosicion -= 20;
			
		posX = tablero.getCasillero(proximaPosicion).getPosX() + 90;
		posY = tablero.getCasillero(proximaPosicion).getPosY() + 40;
		
		
		dibujar();
		
	}

	public void dibujar() {

		gc.setFill(color);
		gc.fillOval(posX , posY + numero*17, radio, radio);
		
	}

}
