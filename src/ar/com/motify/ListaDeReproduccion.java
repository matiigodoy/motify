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
	
	public String reproducirCancion() {
		return canciones.get(0).getTitulo() + " se esta reproduciendo";
	}
	
	public String verListadoDeCanciones() {
		String listado = "";
		for (Cancion cancion : canciones) {
			listado = cancion.toString();
		}
		return listado;
	}
	
	public Integer cantidadDeCanciones() {
		return canciones.size();
	}
	
	public Long duracionDeLaLista() {
		Long duracion = 0L;
		for (Cancion cancion : canciones) {
			duracion += cancion.getDuracionEnSegundos();
		}
		return duracion;
	}
	
	public Boolean eliminarCancion(Cancion cancion) {
		return canciones.remove(cancion);
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
