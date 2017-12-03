package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AlgoPoly;
import modelo.Vista;

public class BotonPagarFianza extends Button implements Vista{
	
	public BotonPagarFianza() {		
		this.setText("PagarFianza");
	}
	
	@Override
	public void actualizar() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		this.setDisable( !algoPoly.jugadorActualPreso() || algoPoly.lanzoLosDados() ); 
	}

}
