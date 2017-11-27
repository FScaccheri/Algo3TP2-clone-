package vistas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.Adquirible;
import modelo.Casillero;

public class VistaCasillero {
	
	private int posX;
	private int posY;
	private Casillero casillero;
	
	public VistaCasillero(String titulo, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {
		
		this.posX = posicionX;
		this.posY = posicionY;
		this.casillero = casillero;
		dibujar(titulo, posicionX, posicionY, gc);
	}



	public VistaCasillero(String titulo1, String titulo2, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {

		this.posX = posicionX;
		this.posY = posicionY;
		this.casillero = casillero;
		dibujar(titulo1, posicionX, posicionY, gc);
		gc.strokeText(titulo2, posicionX + 40, posicionY + 75);
		
	}
	//NO USADO
	public VistaCasillero(String titulo, Adquirible adquirible, int posicionX, int posicionY, GraphicsContext gc) {

		this.posX = posicionX;
		this.posY = posicionY;
		dibujar(titulo, posicionX, posicionY, gc);
		gc.setFill(Color.BEIGE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 25);
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX + 5, posicionY + 30, 110, 3);
		gc.setFont(new Font("", 15));
		gc.strokeText("$ " + adquirible.getPrecioVenta(), posicionX + 30, posicionY + 100);
		
	}
	//NO USADO
	public VistaCasillero(String titulo1, String titulo2, Adquirible adquirible, int posicionX, int posicionY, GraphicsContext gc) {

		this.posX = posicionX;
		this.posY = posicionY;
		dibujar(titulo1, posicionX, posicionY, gc);
		gc.strokeText(titulo2, posicionX + 40, posicionY + 75);
		gc.setFill(Color.BEIGE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 25);
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX + 5, posicionY + 30, 110, 3);
		gc.setFont(new Font("", 15));
		gc.strokeText("$ " + adquirible.getPrecioVenta(), posicionX + 30, posicionY + 100);
		
	}
	//NO USADO
	public void dibujar(String titulo, int posicionX, int posicionY, GraphicsContext gc) {
		
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX, posicionY, 120, 120);
		gc.setFill(Color.WHITE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 110);
		gc.setFont(new Font("", 10 ));
		gc.strokeText(titulo , posicionX + 40, posicionY + 60);
		
		
	}

	public int getPosX() {
		
		return posX;
	}
	
	public int getPosY() {
		
		return posY;
	}

}
