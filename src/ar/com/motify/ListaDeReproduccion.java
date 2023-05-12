package ar.com.motify;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {
	
	private String nombre;
	private List<Cancion> canciones;
	
	public ListaDeReproduccion(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList();
	}
	
	public void agregarCanciones(Cancion cancion) {
		canciones.add(cancion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

}
