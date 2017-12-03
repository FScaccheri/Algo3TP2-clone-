package nuevo.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.Jugador;
import modelo.casilleros.Carcel;
import nuevo.vistas.ContenedorJuego;

public class BotonPagarFianzaEventHandler implements EventHandler<ActionEvent>{

	private ContenedorJuego contenedorJuego;
	private Button botonPagarFianza;

	public BotonPagarFianzaEventHandler() {

		this.contenedorJuego = contenedorJuego;
		this.botonPagarFianza = botonPagarFianza;
	}

	@Override
	public void handle(ActionEvent event) {
		
//		Jugador jugador = contenedorJuego.getJugadorActual();
//		Carcel carcel = (Carcel) jugador.getPosicion().getCasillero().getEfecto();
//		
//		carcel.liberarJugadorPorFianza(jugador);
//		botonPagarFianza.setDisable(true);
//		
//		contenedorJuego.setBordeJugadores(3);//HardCoded por el momento
	}

}
