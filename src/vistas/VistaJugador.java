package vistas;

import java.util.LinkedList;
import modelo.Posicion;
import modelo.AdministradorDeTurnos2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Jugador;
import modelo.Tablero;

public class VistaJugador {

	private GraphicsContext gc;
	private Paint color;
	private int numero;
	private int posX;
	private int posY;
	private VistaTablero vistaTablero;
	private static double radio = 15;
	private Jugador jugador;
	
	public VistaJugador(GraphicsContext gc, LinkedList<Jugador> jugadores, VistaTablero vistaTablero, Paint color, int numeroJugador) {
		
		this.vistaTablero = vistaTablero;
		this.gc = gc;
		this.color = color;
		this.numero = numeroJugador - 1;
		this.jugador = jugadores.get(numero);
		this.posX = vistaTablero.getVistaCasilleroEn(jugador.getPosicion()).getPosX() + 90;
		this.posY = vistaTablero.getVistaCasilleroEn(jugador.getPosicion()).getPosY() + 40;
	}
	
	public void moverA(Posicion posicion) {
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY + numero*17, radio, radio);
		
		posX = vistaTablero.getVistaCasilleroEn(Tablero.getInstancia().getCasilleros().indexOf(Tablero.getInstancia().getCasillero(posicion))).getPosX() + 90;
		posY = vistaTablero.getVistaCasilleroEn(Tablero.getInstancia().getCasilleros().indexOf(Tablero.getInstancia().getCasillero(posicion))).getPosY() + 40;
		
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
