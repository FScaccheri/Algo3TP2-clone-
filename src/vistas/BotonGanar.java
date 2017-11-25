package vistas;

import controladores.BotonGanarEventHandler;
import javafx.scene.control.Button;

public class BotonGanar extends Button{

	public BotonGanar() {

		this.setText("Ganar");
		
		BotonGanarEventHandler botonGanarEventHandler = new BotonGanarEventHandler();
		this.setOnAction(botonGanarEventHandler);
	}
	
}
