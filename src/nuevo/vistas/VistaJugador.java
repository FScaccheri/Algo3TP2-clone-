package nuevo.vistas;

import modelo.Posicion;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Jugador;
import modelo.Tablero;
import modelo.Vista;

public class VistaJugador implements Vista{

	private final static double RADIO = 15;	
	private GraphicsContext gc;
	private Paint color;
	private int numero;
	private int posX;
	private int posY;
	private VistaTablero vistaTablero;
	private static int cantidadDeJugadores;
	private Jugador jugador;
	
	public VistaJugador(GraphicsContext gc, Jugador jugador, VistaTablero vistaTablero, Paint color) {
		cantidadDeJugadores++;
		
		this.vistaTablero = vistaTablero;
		this.gc = gc;
		this.color = color;
		this.numero = cantidadDeJugadores;
		this.jugador = jugador;
		this.posX = vistaTablero.getVistaCasilleroEn(jugador.getPosicion()).getPosX() + 90;
		this.posY = vistaTablero.getVistaCasilleroEn(jugador.getPosicion()).getPosY() + 40;
	}
	
	public void moverA() {
		Posicion posicion = jugador.getPosicion();
		gc.setFill(Color.WHITE);
		gc.fillRect(posX, posY + numero*17, RADIO, RADIO);
		
		posX = vistaTablero.getVistaCasilleroEn(Tablero.getInstancia().getCasilleros().indexOf(Tablero.getInstancia().getCasillero(posicion))).getPosX() + 90;
		posY = vistaTablero.getVistaCasilleroEn(Tablero.getInstancia().getCasilleros().indexOf(Tablero.getInstancia().getCasillero(posicion))).getPosY() + 40;
		
		dibujar();
	}

	public void dibujar() {

		gc.setFill(color);
		gc.fillOval(posX , posY + numero*17, RADIO, RADIO);
		
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

	@Override
	public void actualizar() {
		moverA();
	}

}
