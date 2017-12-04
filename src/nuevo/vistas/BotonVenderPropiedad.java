package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonVenderEventHandler;

public class BotonVenderPropiedad extends Button implements Vista{
	
	public BotonVenderPropiedad() {		
		this.setText("Vender propiedad");
		BotonVenderEventHandler botonVenderEventHandler = new BotonVenderEventHandler();
		this.setOnAction(botonVenderEventHandler);
	}
	
	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
