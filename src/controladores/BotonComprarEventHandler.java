package controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.paint.Paint;
import modelo.Jugador;
import modelo.casilleros.Activable;
import modelo.casilleros.adquiribles.Adquirible;
import modelo.casilleros.adquiribles.Propiedad;
import modelo.casilleros.adquiribles.Rentable;
import modelo.casilleros.adquiribles.Servicio;
import vistas.ContenedorJuego;
import vistas.VistaJugador;

public class BotonComprarEventHandler implements EventHandler<ActionEvent>{

	private GraphicsContext gc;
	private Button botonComprar;
	private VistaJugador vistaJugador;
	private ContenedorJuego contenedorJuego;

	public BotonComprarEventHandler(ContenedorJuego contenedorJuego, GraphicsContext gc, Button botonComprar) {
		
		this.contenedorJuego = contenedorJuego;
		this.gc = gc;
		this.botonComprar = botonComprar;
	}

	@Override
	public void handle(ActionEvent event) {
		
		vistaJugador = contenedorJuego.getVistaJugadorActual();
		Jugador jugador = vistaJugador.getJugadorAsociado();
		jugador = contenedorJuego.getJugadorActual();
		Activable aAdquirir =  jugador.getPosicion().getCasillero().getEfecto();
		
		if ( (aAdquirir instanceof Adquirible) && ( ! ((Adquirible)aAdquirir).tienePropietario())) {
			
			if(aAdquirir instanceof Propiedad)
				jugador.adquirir((Propiedad) aAdquirir);
			
			if(aAdquirir instanceof Servicio)
				jugador.adquirir((Servicio) aAdquirir);
		
			int posX = vistaJugador.getPosX();
			int posY = vistaJugador.getPosY();
			Paint color = vistaJugador.getColor();
		
			gc.setFill(color);
			gc.fillRect(posX + 5, posY + 5, 110, 25);
		

			botonComprar.setDisable(true);
		} else if (!(aAdquirir instanceof Adquirible)) {
			
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Transaccion no completada");
			alerta.setHeaderText("No se puede adquirir!");
			
		}
		
		else {
			
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Transaccion no completada");
			alerta.setHeaderText("La propiedad ya tiene duenio!");
		}
	}

}
