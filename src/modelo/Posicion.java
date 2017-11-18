package modelo;

public class Posicion {
		private Casillero casillero;
		
		public Posicion(Casillero casillero) {
			this.casillero = casillero;
		}
		
		public Posicion siguiente() {
			Tablero tablero = Tablero.getInstancia();
			return new Posicion( tablero.casilleroSiguiente(this.casillero) );
		}

		private Casillero getCasillero() {
			return this.casillero;
		}
		
		@Override
		public boolean equals(Object obj) {
			final Posicion posicion = (Posicion)obj;
			if ( posicion.getCasillero() == this.getCasillero() ) return true;
			return super.equals(obj);
		}
		
		
}
