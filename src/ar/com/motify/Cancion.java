package ar.com.motify;

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

	public void setDuracionEnSegundos(Integer duracionEnSegundos) {
		this.duracionEnSegundos = duracionEnSegundos;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
