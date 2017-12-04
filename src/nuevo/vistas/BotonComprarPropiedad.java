package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;
import nuevo.controladores.BotonComprarEventHandler;

public class BotonComprarPropiedad extends Button implements Vista{
	
	public BotonComprarPropiedad() {
		this.setText("Comprar propiedad");
		BotonComprarEventHandler botonComprarEventHandler = new BotonComprarEventHandler();
		this.setOnAction(botonComprarEventHandler);
	}
	
	@Override
	public void actualizar() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		setDisable( !algoPoly.casilleroActualALaVenta() || !algoPoly.lanzoLosDados());
	}

}

