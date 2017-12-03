package nuevo.vistas;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import modelo.Jugador;
import modelo.Vista;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;

public class VistaCasillero implements Vista{
	
	private int posX;
	private int posY;
	private GraphicsContext gc;
	private Casillero casillero;
	private static ArrayList<VistaJugador> vistasJugadores;
	
	public static void setVistasJugadores(ArrayList<VistaJugador> lasVistasJugadores) {
		vistasJugadores = lasVistasJugadores;
	}
	
	public VistaCasillero(String titulo, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {
		this.gc = gc;
		this.posX = posicionX;
		this.posY = posicionY;
		this.casillero = casillero;
		dibujar(titulo, posicionX, posicionY, gc);
	}



	public VistaCasillero(String titulo1, String titulo2, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {

		this(titulo1, casillero, posicionX, posicionY, gc);
		gc.strokeText(titulo2, posicionX + 40, posicionY + 75);
		
	}
	
	public VistaCasillero(String titulo, int precio, Casillero casillero, int posicionX, int posicionY, GraphicsContext gc) {

		this(titulo, casillero, posicionX, posicionY, gc);
		gc.setFill(Color.BEIGE);
		gc.fillRect(posicionX + 5, posicionY + 5, 110, 25);
		gc.setFill(Color.BLACK);
		gc.fillRect(posicionX + 5, posicionY + 30, 110, 3);
		gc.setFont(new Font("", 15));
		gc.strokeText("$ " + precio, posicionX + 30, posicionY + 100);
		
	}
	
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

	public Casillero getCasillero() {
		
		return casillero;
	}

	@Override
	public void actualizar() {
		
		try {
			Jugador jugador = ((Rentable) casillero.getEfecto()).getPropietario();
			if (jugador == null) {
				gc.setFill(Color.BEIGE);
				gc.fillRect(posX + 5, posY + 5, 110, 25);	
			} else {
				
				for(VistaJugador vistaJugador:vistasJugadores) {
					if(vistaJugador.getJugadorAsociado() == jugador) {
						Paint color = vistaJugador.getColor();
					
						gc.setFill(color);
						gc.fillRect(posX + 5, posY + 5, 110, 25);					
					}
					try {
						Propiedad propiedad = (Propiedad) casillero.getEfecto();
					
						if( propiedad.tieneCasas() || propiedad.tieneHotel()) {
						
							if (propiedad.getCantidadDeCasas() == 1) {
								gc.setFill(Color.BLACK);
								gc.fillRoundRect(posX + 7, posY + 7, 21, 21, 10, 10);
								gc.setFill(Color.KHAKI);
								gc.fillRoundRect(posX + 8, posY + 8, 19, 19, 10, 10);
								
							} else if (propiedad.getCantidadDeCasas() == 2) {
								
								gc.setFill(Color.BLACK);
								gc.fillRoundRect(posX + 7, posY + 7, 21, 21, 10, 10);
								gc.fillRoundRect(posX + 30, posY + 7, 21, 21, 10, 10);
								gc.setFill(Color.KHAKI);
								gc.fillRoundRect(posX + 8, posY + 8, 19, 19, 10, 10);
								gc.fillRoundRect(posX + 31, posY + 8, 19, 19, 10, 10);
								
							} else {
								
								gc.setFill(Color.BLACK);
								gc.fillRoundRect(posX + 7, posY + 7, 43, 21, 10, 10);
								gc.setFill(Color.BROWN);
								gc.fillRoundRect(posX + 8, posY + 8, 41, 19, 10, 10);
							}
								
						
						}
						
					
					} catch (ClassCastException e) {}
				}
			}
			
		} catch (ClassCastException e) {}
	}

}
