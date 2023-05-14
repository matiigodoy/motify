package ar.com.motify;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {

	private String nombre;
	private String propietario;
	private List<Cancion> canciones;
	private List<Cancion> cancionesDescargadas;

	public ListaDeReproduccion(String nombre, String propietario) {
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>();
		this.cancionesDescargadas = new ArrayList<Cancion>();
	}
	
	public Boolean descargarCancion(Cancion cancion, UsuarioFinal usuarioFinal) {
		if (usuarioFinal.getEstaLogueado()) {
			cancionesDescargadas.add(cancion);
			return true;
		}
		return false;
	}

	public void agregarCanciones(Cancion cancion) {
		if (cantidadDeCanciones() < 5) {
			canciones.add(cancion);
		}
	}

	public String reproducirCancion() {
		return canciones.get(0).getTitulo() + " se esta reproduciendo";
	}

	public String verListadoDeCanciones() {
		String listadoVacio = "Canciones en la lista " + nombre;
		for (Cancion cancion : canciones) {
            return cancion.toString();
        }
		return listadoVacio;
	}

	public Integer cantidadDeCanciones() {
		return canciones.size();
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

	public List<Cancion> getCancionesDescargadas() {
		return cancionesDescargadas;
	}
	public String duracionDeLaLista() {
		Integer duracion = 0;
		for (Cancion cancion : canciones) {
			duracion += cancion.getDuracionEnSegundos();
		}
		Integer minutos = duracion/60;
		Integer segundos = duracion/60;
		String duracionEnMmSs;
		if(segundos<10) {
			duracionEnMmSs = minutos + ":0" + segundos;
		} else {
			duracionEnMmSs = minutos + ":" + segundos;
		}
		return duracionEnMmSs;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

}
