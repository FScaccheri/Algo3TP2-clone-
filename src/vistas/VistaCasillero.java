package vistas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class VistaCasillero {

	public static void dibujar(String titulo, int posicionX, int posicionY, GraphicsContext gc) {
		
		gc.setFill(Color.BROWN);
		gc.fillRect(posicionX, posicionY, 100, 100);
		gc.strokeText(titulo , posicionX + 30, posicionY + 50, 100);
		
	}

}
