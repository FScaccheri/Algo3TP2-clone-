package vistas;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class CanvasTablero extends Canvas{
	
	private GraphicsContext gc;
	
	public CanvasTablero(int ancho, int alto) {
		
		super(ancho,alto);
		gc = this.getGraphicsContext2D();
		gc.setFill(Color.BISQUE);
		gc.fillRoundRect(0, 0, 800, 800, 10, 10);
		
	}


	public void pintarTablero() {

		VistaCasillero.dibujar("SALIDA", 600, 600, gc);
		
		
		
	}

}
