package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonPagarFianzaEventHandler;

public class BotonPagarFianza extends Button implements Vista{
	
	public BotonPagarFianza() {		
		this.setText("PagarFianza");
		BotonPagarFianzaEventHandler botonPagarFianzaEventHandler = new BotonPagarFianzaEventHandler();
		this.setOnAction(botonPagarFianzaEventHandler);
	}
	
	@Override
	public void actualizar() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		this.setDisable( !algoPoly.jugadorActualPreso() || algoPoly.lanzoLosDados() ); 
	}

}
