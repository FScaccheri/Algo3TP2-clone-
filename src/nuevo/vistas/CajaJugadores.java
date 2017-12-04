package nuevo.vistas;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import modelo.Jugador;
import modelo.Vista;

public class CajaJugadores extends VBox implements Vista {

	private Font fuente;
	private ArrayList<Label> etiquetas;
	private ArrayList<Jugador> jugadores;

	public CajaJugadores (ArrayList<Jugador> jugadores){
		etiquetas = new ArrayList<Label>();
		this.jugadores = jugadores;
		int cantidadJugadores = jugadores.size();

		this.fuente = Font.font("", FontWeight.BOLD, tamanioFuente(cantidadJugadores));

		Image imagenPieza1 = new Image("file:src/nuevo/vistas/imagenes/racecar.jpg", 100, 100, true, false);
		ImageView vistaPieza1 = new ImageView(imagenPieza1);
		Label etiqueta1 = new Label ("Jugador 1");
		Label etiquetaCapital1 = new Label();
		etiqueta1.setTextFill(Color.web("#DC143C"));
		etiqueta1.setFont(fuente);
		etiquetaCapital1.setTextFill(Color.web("#DC143C"));
		etiquetaCapital1.setFont(fuente);
		vistaPieza1.setTranslateY(0);
		etiqueta1.setTranslateY(0);
		etiquetaCapital1.setTranslateY(0);

		etiquetas.add(etiquetaCapital1);

		Image imagenPieza2 = new Image("file:src/nuevo/vistas/imagenes/battleship.jpg", 100, 100, true, false);
		ImageView vistaPieza2 = new ImageView(imagenPieza2);
		Label etiqueta2 = new Label("Jugador 2");
		Label etiquetaCapital2 = new Label();
		etiqueta2.setTextFill(Color.web("#0000CD"));
		etiqueta2.setFont(fuente);
		etiquetaCapital2.setTextFill(Color.web("#0000CD"));
		etiquetaCapital2.setFont(fuente);
		vistaPieza2.setTranslateY( 100 ); 
		etiqueta2.setTranslateY( 100 ); 
		etiquetaCapital2.setTranslateY(100);
		
		etiquetas.add(etiquetaCapital2);

		Image imagenPieza3 = new Image("file:src/nuevo/vistas/imagenes/tophat.jpg", 100, 100, true, false);
		ImageView vistaPieza3 = new ImageView(imagenPieza3);
		Label etiqueta3 = new Label("Jugador 3");
		Label etiquetaCapital3 = new Label();
		etiqueta3.setTextFill(Color.web("#3D9140"));
		etiqueta3.setFont(fuente);
		etiquetaCapital3.setTextFill(Color.web("#3D9140"));
		etiquetaCapital3.setFont(fuente);
		vistaPieza3.setTranslateY( 200 ); 
		etiqueta3.setTranslateY( 200); 
		etiquetaCapital3.setTranslateY( 200 );
		
				
		setAlignment(Pos.TOP_CENTER);
		setSpacing(5);
		setPadding(new Insets(20));
		getChildren().addAll(vistaPieza1, etiqueta1, etiquetaCapital1, vistaPieza2, etiqueta2, etiquetaCapital2, vistaPieza3, etiqueta3, etiquetaCapital3);
		
		etiquetas.add(etiquetaCapital3);
	}

	private int tamanioFuente(int cantidadJugadores) {
		return 20;
	}

	@Override
	public void actualizar() {
		for (int i = 0; i < jugadores.size(); i++) {
			etiquetas.get(i).setText("$ " + (int)jugadores.get(i).getCapital());
		}
		
	}

}
