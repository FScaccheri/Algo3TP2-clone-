package modelo;

public class Posicion {
		private Casillero casillero;
		
		public Posicion(Casillero casillero) {
			this.casillero = casillero;
		}
		
		public Posicion siguiente() {
			Tablero tablero = Tablero.getInstancia();
			return new Posicion( tablero.getCasillero( tablero.posicion(this.casillero) + 1 ) );
		}
}
