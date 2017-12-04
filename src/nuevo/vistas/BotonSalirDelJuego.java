package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.Vista;
import nuevo.controladores.BotonSalidaEventHandler;

public class BotonSalirDelJuego extends Button implements Vista{

	public BotonSalirDelJuego() {
		this.setText("Salir");
		this.setTranslateY(200);
		BotonSalidaEventHandler botonSalidaEventHandler = new BotonSalidaEventHandler();
		this.setOnAction(botonSalidaEventHandler);
	}
	
	@Override
	public void actualizar() {
		setDisable(false);
		
	}

}
