package modelo;

import java.util.ArrayList;

public class ArrayListLimitado<T> extends ArrayList<T>{
	private	int cantidadMaxima;
	private RuntimeException excepcion;
	
	public ArrayListLimitado(int i, RuntimeException excepcion) {
		cantidadMaxima = i;
		this.excepcion = excepcion;
	}
	
	public boolean addConExcepcion(T e) throws RuntimeException{
		if (this.size() == cantidadMaxima)
			throw excepcion;
		return this.add(e);
	}
	
	public int getCantidadMaxima() {
		return cantidadMaxima;
	}
}
