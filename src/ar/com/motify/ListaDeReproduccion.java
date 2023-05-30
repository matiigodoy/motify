package ar.com.motify;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class ListaDeReproduccion {

	private String nombre;
	private String propietario;
	private HashSet<Cancion> canciones;
	private List<Cancion> cancionesDescargadas;

	public ListaDeReproduccion(String nombre, String propietario) {
		this.nombre = nombre;
		this.propietario = propietario;
		canciones = new HashSet<Cancion>();
		this.cancionesDescargadas = new ArrayList<Cancion>();
	}

	public Boolean descargarCancion(Cancion cancion, UsuarioFinal usuarioFinal) {
		cancionesDescargadas.add(cancion);
		return true;
	}

	public void agregarCanciones(Cancion cancion) {
		if (cantidadDeCanciones() < 5) {
			canciones.add(cancion);
		}
	}
	
	public void agregarCancion(Cancion cancion, Boolean esPremium) {
		if(esPremium) {
			if(canciones.size()<100) {
				canciones.add(cancion);
			} else {
				System.out.println("Alcanzaste el máximo de canciones permitidas (100)");
			}
		} else {
			if(canciones.size()<10) {
				canciones.add(cancion);
			} else {
				System.out.println("Pasate a Premium para agregar hasta 100 canciones!");
			}
		}
	}

	public String reproducirCancion() {
		//return canciones.get(0).getTitulo() + " se esta reproduciendo";
		//Revisar método. Debemos evitar duplicados por eso usamos HashSet. En este caso, no es posible usar get().
		return "Reproduciendo lista";
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

	public HashSet<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(HashSet<Cancion> canciones) {
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
		Integer segundos = duracion%60;
		String duracionEnMmSs;
		if (segundos < 10) {
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

	@Override
	public int hashCode() {
		return Objects.hash(nombre, propietario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDeReproduccion other = (ListaDeReproduccion) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(propietario, other.propietario);
	}
	

}
