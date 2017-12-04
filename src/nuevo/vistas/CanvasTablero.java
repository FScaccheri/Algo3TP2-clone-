package nuevo.vistas;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Vista;
import javafx.scene.text.Font;

public class CanvasTablero extends Canvas implements Vista{
	
	private GraphicsContext gc;
	
	public CanvasTablero(int ancho, int alto) {
		super(ancho,alto);
		gc = getGraphicsContext2D();
		gc.setFill(Color.BISQUE);
		gc.fillRoundRect(0, 0, 800, 800, 10, 10);
		gc.setFill(Color.LIGHTSKYBLUE);
		gc.fillRoundRect(280, 280, 240, 240, 10, 10);		
	}

	@Override
	public void actualizar() {
		AlgoPoly algoPoly = AlgoPoly.getInstancia();
		
		gc.setFill(Color.LIGHTSKYBLUE);
		gc.fillRect(280, 280, 240, 240);

		gc.setFill(Color.WHITE);
		gc.setStroke(Color.BLACK);
		gc.setFont(new Font("", 30));
		gc.fillText("Dados: " + algoPoly.getUltimaTirada(), 350, 410); 
		gc.strokeText("Dados: " + algoPoly.getUltimaTirada(), 350, 410); 
		
		if(algoPoly.salieronDobles()) {
			
			gc.setFill(Color.GOLD);
			gc.fillText("DOBLES!", 350, 450); 
			gc.strokeText("DOBLES!", 350, 450); 
		}
		
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("", 20));
		gc.fillText("Turno del Jugador " + algoPoly.getNombreDeJugadorActual(), 300, 350); 
		gc.strokeText("Turno del Jugador " + algoPoly.getNombreDeJugadorActual(), 300, 350); 
			
	}
	
	public GraphicsContext getGC() {
		return this.gc;
	}
}
