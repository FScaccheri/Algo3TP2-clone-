package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonTerminarEventHandler;

public class BotonTerminarTurno extends Button implements Vista{
	
	public BotonTerminarTurno() {
		this.setText("Terminar turno");
		BotonTerminarEventHandler botonTerminarEventHandler = new BotonTerminarEventHandler();
		this.setOnAction(botonTerminarEventHandler);
	}
	
	@Override
	public void actualizar() {
		this.setDisable(!AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
