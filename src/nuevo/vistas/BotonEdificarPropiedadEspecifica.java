package nuevo.vistas;

import javafx.scene.control.Button;
import modelo.Vista;
import modelo.casilleros.adquiribles.Propiedad;

public class BotonEdificarPropiedadEspecifica extends Button implements Vista{
	private Propiedad propiedad;
	public BotonEdificarPropiedadEspecifica(Propiedad propiedad) {
		this.propiedad = propiedad;
		setText(propiedad.getNombre());
	}

	@Override
	public void actualizar() {
		setDisable( !propiedad.puedeCostruirCasa() && !propiedad.puedeCostruirHotel() );
	}

}
