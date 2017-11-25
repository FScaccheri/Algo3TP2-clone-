package vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CajaJugadores extends VBox{

	private Font fuente;
	private int distancia;
	private int scale;

	public CajaJugadores(int cantidadJugadores) {

		//Fuente de etiquetas
		this.fuente = Font.font("", FontWeight.BOLD, tamanioFuente(cantidadJugadores));
		//Distancia en pixeles entre iconos y Labels de jugadores
		this.distancia = 600/cantidadJugadores;
		//Scaling en pixeles de los iconos de los jugadores
		this.scale = 300/cantidadJugadores;
		
		int i = 0;
		// Seteo de imagenes de jugadores (sus piezas)
		Image imagenPieza1 = new Image("file:src/vistas/imagenes/racecar.jpg", scale, scale, true, false);
		ImageView vistaPieza1 = new ImageView(imagenPieza1);
		Label etiqueta1 = new Label ("Jugador 1");
		etiqueta1.setTextFill(Color.web("#DC143C"));
		etiqueta1.setFont(fuente);
		vistaPieza1.setTranslateY(0);
		vistaPieza1.setTranslateY( distancia*i );
		etiqueta1.setTranslateY(0);

		i = 1;
		Image imagenPieza2 = new Image("file:src/vistas/imagenes/battleship.jpg", scale, scale, true, false);
		ImageView vistaPieza2 = new ImageView(imagenPieza2);
		Label etiqueta2 = new Label("Jugador 2");
		etiqueta2.setTextFill(Color.web("#0000CD"));
		etiqueta2.setFont(fuente);
		vistaPieza2.setTranslateY( distancia*i ); //200
		etiqueta2.setTranslateY( distancia*i ); //200
		
		i = 2;
		Image imagenPieza3 = new Image("file:src/vistas/imagenes/tophat.jpg", scale, scale, true, false);
		ImageView vistaPieza3 = new ImageView(imagenPieza3);
		Label etiqueta3 = new Label("Jugador 3");
		etiqueta3.setTextFill(Color.web("#3D9140"));
		etiqueta3.setFont(fuente);
		vistaPieza3.setTranslateY(400);
		vistaPieza3.setTranslateY( distancia*i ); //400
		etiqueta3.setTranslateY( distancia*i); //400
		
				
		setAlignment(Pos.TOP_CENTER);
		setSpacing(5);
		setPadding(new Insets(20));
		getChildren().addAll(vistaPieza1, etiqueta1, vistaPieza2, etiqueta2, vistaPieza3, etiqueta3);
		
	}

	private int tamanioFuente(int cantidadJugadores) {
		
		return 20;
	}

}
