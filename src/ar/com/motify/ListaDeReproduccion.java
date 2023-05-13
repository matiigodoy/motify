package ar.com.motify;

import java.util.ArrayList;
import java.util.List;

public class ListaDeReproduccion {

	private String nombre;
	private List<Cancion> canciones;
	private List<Cancion> cancionesDescargadas;

	public ListaDeReproduccion(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList();
		this.cancionesDescargadas = new ArrayList();
	}

	// O DESCARGAR LISTA??? Y SI QUIERO DESCARGAR TODAS LAS CANCIONES DE LA LISTA
	// NO ES MEJOR DESCARGAR LA LISTA ??
	public Boolean descargarCancion(Cancion cancion, UsuarioFinal usuarioFinal) {
		if (usuarioFinal.getEstaLogueado()) {
			cancionesDescargadas.add(cancion);
			return true;
		}
		return false;
	}

	public void agregarCanciones(Cancion cancion) {
		if (canciones.size() <= 5) {
			canciones.add(cancion);
		}
	}

	public String reproducirCancion() {
		return canciones.get(0).getTitulo() + " se esta reproduciendo";
	}

	public String verListadoDeCanciones() {
		for (Cancion cancion : canciones) {
			String listado = cancion.toString();
			return listado;
		}
		return null;
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

	public List<Cancion> getCancionesDescargadas() {
		return cancionesDescargadas;
	}

}
