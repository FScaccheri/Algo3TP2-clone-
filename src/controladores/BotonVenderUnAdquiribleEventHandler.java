package controladores;

import java.util.LinkedList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Posicion;
import modelo.Tablero;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Adquirible;
import vistas.ContenedorJuego;
import vistas.VistaCasillero;
import vistas.VistaTablero;

public class BotonVenderUnAdquiribleEventHandler implements EventHandler<ActionEvent> {

	private Adquirible adquirible;
	private Button boton;
	private VistaTablero vistaTablero;

	public BotonVenderUnAdquiribleEventHandler(Button boton, Adquirible adquirible, VistaTablero vistaTablero) {

		this.boton = boton;
		this.adquirible = adquirible;
		this.vistaTablero = vistaTablero;
	}

	@Override
	public void handle(ActionEvent event) {
		
		adquirible.vender();
		//Falta que "despinte" el casillero que se vendio. @FScaccheri
		boton.setDisable(true);
		
		this.limpiar();
	}
	
	public void limpiar() {
		
		LinkedList<Casillero> casilleros = Tablero.getInstancia().getCasilleros();
		boolean encontrado = false;
		Posicion posicion = null;
		for (int i = 1; i <= casilleros.size(); i++ ) {
			if (casilleros.get(i).getEfecto() == adquirible) {
				encontrado = true;
				posicion = casilleros.get(i).getPosicion();
			}
		}
		
		if (encontrado) {
			
			VistaCasillero vistaCasillero = vistaTablero.getVistaCasilleroEn(posicion);
			int posX = vistaCasillero.getPosX();
			int posY = vistaCasillero.getPosY();
	
			vistaTablero.getGC().setFill(Color.BEIGE);
			vistaTablero.getGC().fillRect(posX + 5, posY + 5, 110, 25);
		}
	}

}
