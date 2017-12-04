package nuevo.controladores;

import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.AudioClip;
import modelo.AlgoPoly;
import modelo.excepciones.CapitalInsuficiente;

public class BotonTirarDadosEventHandler implements EventHandler<ActionEvent>{
	
	private AudioClip audioClip;
	final URL RESOURCE = getClass().getResource("sonidos/dados.wav");
	
	public BotonTirarDadosEventHandler() {
		this.audioClip = new AudioClip(RESOURCE.toString());
		this.audioClip.setVolume(0.1);
	}
		
	@Override
	public void handle(ActionEvent event) {
		
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		algoPoly.lanzarDados();
		audioClip.play();
		try {
			algoPoly.avanzarJugadorActual();
		} catch (CapitalInsuficiente e) {

			Button botonVentaHastaPagar = new Button();
			botonVentaHastaPagar.setOnAction(new VenderHastaPoderPagarEventHandler());
			botonVentaHastaPagar.fire();
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setHeaderText("No tiene dinero para pagar el alquiler!");
			alerta.setContentText("Venda alguna de sus propiedades");
			alerta.show();
		}
		algoPoly.actualizar();
		

	}

}
