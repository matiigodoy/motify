package ar.com.motify;

import java.util.HashSet;

public class BaseDeDatos {
	private HashSet<Cancion> listaDeCanciones;
	private HashSet<Distribuidora> listaDeDistribuidoras;
	private HashSet<UsuarioFinal> listaDeUsuariosFinales;
	
	public BaseDeDatos() {
		listaDeCanciones = new HashSet<>();
		listaDeDistribuidoras = new HashSet<>();
		listaDeUsuariosFinales = new HashSet<>();
	}
	
	public void agregarCancion(Cancion cancion) {
		listaDeCanciones.add(cancion);
	}

	public String getListaDeCanciones() {
		for (Cancion cancion : listaDeCanciones) {
            return cancion.getTitulo() + " - " + cancion.getArtista();
        }
		return null;
	}
	
	public Integer getCantidadDeCanciones() {
		return listaDeCanciones.size();
	}
	
	public void agregarDistribuidora(Distribuidora distribuidora) {
		listaDeDistribuidoras.add(distribuidora);
	}
	
	public String getListaDeDistribuidoras() {
		for (Distribuidora distribuidora : listaDeDistribuidoras) {
            return distribuidora.mostrarInformacion();
        }
		return null;
	}
	
	public Integer getCantidadDeDistribuidoras() {
		return listaDeDistribuidoras.size();
	}
	
	public void agregarUsuarioFinal(UsuarioFinal usuarioFinal) {
		listaDeUsuariosFinales.add(usuarioFinal);
	}
	
	public String getListaDeUsuariosFinales() {
		for (UsuarioFinal usuario : listaDeUsuariosFinales) {
            return usuario.mostrarInformacion();
        }
		return null;
	}
	
	public Integer getCantidadDeUsuariosFinales() {
		return listaDeUsuariosFinales.size();
	}

	
	

}
