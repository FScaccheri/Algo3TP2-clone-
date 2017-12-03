package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.Vista;

public class BotonPagarFianza extends Button implements Vista{
	
	public BotonPagarFianza() {		
		this.setText("PagarFianza");
	}
	
	@Override
	public void actualizar() {
//		this.setDisable(AdministradorDeTurnos2.getInstancia().lanzoLosDados()); 
	}

}
