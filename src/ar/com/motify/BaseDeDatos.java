package ar.com.motify;

import java.util.HashSet;

public class BaseDeDatos {
	private HashSet<Cancion> listaDeCanciones;
	private HashSet<Distribuidora> listaDeDistribuidoras;
	
	public BaseDeDatos() {
		listaDeCanciones = new HashSet<>();
		listaDeDistribuidoras = new HashSet<>();
	}
	
	public void agregarCancion(Cancion cancion) {
		listaDeCanciones.add(cancion);
	}

	public void getListaDeCanciones() {
		for (Cancion cancion : listaDeCanciones) {
            System.out.println(cancion.getTitulo() + " - " + cancion.getArtista());
        }
	}
	
	public Integer getCantidadDeCanciones() {
		return listaDeCanciones.size();
	}
	
	public void agregarDistribuidora(Distribuidora distribuidora) {
		listaDeDistribuidoras.add(distribuidora);
	}
	
	public void getListaDeDistribuidoras() {
		for (Distribuidora distribuidora : listaDeDistribuidoras) {
            System.out.println(distribuidora.mostrarInformacion());
        }
	}
	
	public Integer getCantidadDeDistribuidoras() {
		return listaDeDistribuidoras.size();
	}

	
	

}
