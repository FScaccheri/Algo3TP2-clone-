package vistas;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Adquirible;

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
	public VistaCasillero(String titulo, int precio, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {

		this(titulo, casillero, posicionX, posicionY, gc);
		gc.setFill(Color.BEIGE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 25);
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX + 5, posicionY + 30, 110, 3);
		gc.setFont(new Font("", 15));
		gc.strokeText("$ " + precio, posicionX + 30, posicionY + 100);
		
	}
	//NO USADO
	public VistaCasillero(String titulo1, String titulo2, int precio, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {

		this(titulo1, casillero, posicionX, posicionY, gc);
		gc.strokeText(titulo2, posicionX + 40, posicionY + 75);
		gc.setFill(Color.BEIGE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 25);
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX + 5, posicionY + 30, 110, 3);
		gc.setFont(new Font("", 15));
		gc.strokeText("$ " + precio, posicionX + 30, posicionY + 100);
		
	}
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
