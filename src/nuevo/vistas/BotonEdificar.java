package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonEdificarEventHandler;

public class BotonEdificar extends Button implements Vista{
	
	public BotonEdificar() {		
		this.setText("Edificar");
		BotonEdificarEventHandler botonEdificarEventHandler = new BotonEdificarEventHandler();
		this.setOnAction(botonEdificarEventHandler);
	}
	
	@Override
	public void actualizar() {
		this.setDisable(AlgoPoly.getInstancia().lanzoLosDados()); 
	}

}
