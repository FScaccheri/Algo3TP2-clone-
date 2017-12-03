package nuevo.controladores;

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
import nuevo.vistas.ContenedorJuego;
import nuevo.vistas.VistaCasillero;
import nuevo.vistas.VistaTablero;

public class BotonVenderUnAdquiribleEventHandler implements EventHandler<ActionEvent> {

	private Adquirible adquirible;
	private Button boton;
	private VistaTablero vistaTablero;
	private ContenedorJuego contenedorJuego;

	public BotonVenderUnAdquiribleEventHandler(Button boton, Adquirible adquirible, VistaTablero vistaTablero,ContenedorJuego contenedorJuego) {

		this.boton = boton;
		this.adquirible = adquirible;
		this.vistaTablero = vistaTablero;
		this.contenedorJuego = contenedorJuego;
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
		
		contenedorJuego.setBordeJugadores(3);//HardCoded por el momento
	}

}
