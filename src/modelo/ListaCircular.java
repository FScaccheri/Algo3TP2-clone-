package modelo;

import java.util.LinkedList;

public class ListaCircular<E> extends LinkedList<E> {

	@Override
	public E get(int index) {
		int indice = (index % size());
		if (indice >= 0)
		return super.get(index % size());
		else return super.get(indice + this.size());
	}

}
