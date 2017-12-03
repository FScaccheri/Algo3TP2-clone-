package nuevo.vistas;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.Tirada;
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
		
		getGraphicsContext2D().setFill(Color.LIGHTSKYBLUE);
		getGraphicsContext2D().fillRect(280, 280, 240, 240);

		getGraphicsContext2D().setFill(Color.GREEN);
		getGraphicsContext2D().setFont(new Font("", 30));
		getGraphicsContext2D().fillText("" + algoPoly.getUltimaTirada(), 350, 340);
		
		if(algoPoly.salieronDobles())
			getGraphicsContext2D().fillText("DOBLES!", 350, 400);
		
		getGraphicsContext2D().setFont(new Font("",20));
		getGraphicsContext2D().fillText("Turno del Jugador " + algoPoly.getNombreDeJugadorActual(), 300, 440);
			
	}
	
	public GraphicsContext getGC() {
		return this.gc;
	}
}
