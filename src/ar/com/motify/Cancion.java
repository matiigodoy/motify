package ar.com.motify;

import java.util.Objects;

public class Cancion {
	
	private String titulo;
	private String artista;
	private Integer duracionEnSegundos;
	private Genero genero;

	public Cancion(String titulo, String artista, Integer duracionEnSegundos, Genero genero) {
		this.titulo = titulo;
		this.artista = artista;
		this.duracionEnSegundos = duracionEnSegundos;
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(artista, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(artista, other.artista) && Objects.equals(titulo, other.titulo);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Integer getDuracionEnSegundos() {
		return duracionEnSegundos;
	}
	
	public String getDuracionEnMinutosYSegundos() {
		Integer minutos = duracionEnSegundos/60;
		Integer segundos = duracionEnSegundos%60;
		String duracionEnMmSs;
		if(segundos<10) {
			duracionEnMmSs = minutos + ":0" + segundos;
		} else {
			duracionEnMmSs = minutos + ":" + segundos;
		}
		return duracionEnMmSs;
	}

	public void setDuracionEnSegundos(Integer duracionEnSegundos) {
		this.duracionEnSegundos = duracionEnSegundos;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String reproducir() {
		return "Reproduciendo... " + titulo + " - " + artista;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", duracionEnSegundos=" + duracionEnSegundos
				+ ", genero=" + genero + "]";
	}
	
	public Boolean descargar(UsuarioFinal usuario) {
		if(usuario.getPremium()) {
			usuario.agregarCancionDescargada(this);
			return true;
		}
		return false;
	}

}
