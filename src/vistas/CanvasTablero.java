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

		VistaCasillero.dibujar("SALIDA", 640, 640, gc);						//1
		VistaCasillero.dibujar("QUINI 6", 520, 640, gc);					//2
		VistaCasillero.dibujar("BS AS", "SUR", 20000 , 400, 640, gc);		//3
		VistaCasillero.dibujar("EDESUR", 35000, 280, 640, gc);				//4
		VistaCasillero.dibujar("BS AS", "NORTE", 25000, 160, 640, gc);		//5
		VistaCasillero.dibujar("CARCEL", 40, 640, gc);						//6
		VistaCasillero.dibujar("CORDOBA", "SUR", 18000, 40, 520, gc);		//7
		VistaCasillero.dibujar("ACANCE", "DINAMICO", 40, 400, gc);			//8
		VistaCasillero.dibujar("SUBTE", 40000, 40, 280, gc);				//9
		VistaCasillero.dibujar("CORDOBA", "NORTE", 20000, 40,160, gc);		//10
		VistaCasillero.dibujar("IMPUESTO", "DE LUJO", 40, 40, gc);			//11
		VistaCasillero.dibujar("SANTA FE", 15000, 160, 40, gc);				//12
		VistaCasillero.dibujar("AYSA", 30000, 280, 40, gc); 				//13
		VistaCasillero.dibujar("SALTA", "NORTE", 23000, 400, 40, gc);		//14
		VistaCasillero.dibujar("SALTA", "SUR", 23000, 520, 40, gc);			//15
		VistaCasillero.dibujar("POLICIA", 640, 40, gc);						//16
		VistaCasillero.dibujar("TREN", 38000, 640, 160, gc);				//17
		VistaCasillero.dibujar("NEUQUEN", 17000, 640, 280, gc);				//18
		VistaCasillero.dibujar("RETROCESO", "DINAMICO", 640, 400, gc);		//19
		VistaCasillero.dibujar("TUCUMAN", 25000, 640, 520, gc);				//20
		
		
		
		
	}

}
