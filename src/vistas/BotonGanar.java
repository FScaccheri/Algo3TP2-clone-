package vistas;

import controladores.BotonGanarEventHandler;
import javafx.scene.control.Button;

public class BotonGanar extends Button{

	public BotonGanar(String nombre) {

		this.setText(nombre);
		
		BotonGanarEventHandler botonGanarEventHandler = new BotonGanarEventHandler();
		this.setOnAction(botonGanarEventHandler);
	}
	
}
