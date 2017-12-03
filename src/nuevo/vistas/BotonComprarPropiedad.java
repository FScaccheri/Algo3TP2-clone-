package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.AdministradorDeTurnos;
import modelo.AlgoPoly;
import modelo.Vista;
import modelo.casilleros.Casillero;
import modelo.casilleros.adquiribles.Rentable;

public class BotonComprarPropiedad extends Button implements Vista{
	
	public BotonComprarPropiedad() {
		this.setText("Comprar propiedad");
	}
	
	@Override
	public void actualizar() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		setDisable( !algoPoly.casilleroActualALaVenta() || !algoPoly.lanzoLosDados());
	}

}

