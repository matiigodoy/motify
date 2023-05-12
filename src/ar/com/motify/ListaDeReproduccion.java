package ar.com.motify;

import java.util.HashSet;

public class ListaDeReproduccion {
	
	private String nombre;
	private String propietario;
	private HashSet<Cancion> canciones;
	
	public ListaDeReproduccion(String nombre, String propietario) {
		this.nombre = nombre;
		this.propietario = propietario;
		canciones = new HashSet<>();
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public HashSet<Cancion> getCanciones() {
		return canciones;
	}

	public void agregarCanciones(Cancion cancion) {
		canciones.add(cancion);
	}
	
	public void verListadoDeCanciones() {
		System.out.println("Canciones en la lista " + nombre);
		for (Cancion cancion : canciones) {
            System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        }
	}
	
	public Integer cantidadDeCanciones() {
		return canciones.size();
	}
	
	public String duracionDeLaLista() {
		Integer duracion = 0;
		for (Cancion cancion : canciones) {
			duracion += cancion.getDuracionEnSegundos();
		}
		Integer minutos = duracion/60;
		Integer segundos = duracion%60;
		String duracionEnMmSs;
		if(segundos<10) {
			duracionEnMmSs = minutos + ":0" + segundos;
		} else {
			duracionEnMmSs = minutos + ":" + segundos;
		}
		return duracionEnMmSs;
	}
	
	public Boolean eliminarCancion(Cancion cancion) {
		return canciones.remove(cancion);
	}
	

}
