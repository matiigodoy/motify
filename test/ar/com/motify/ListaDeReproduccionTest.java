package ar.com.motify;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaDeReproduccionTest {

	@Test
	public void queSePuedaInstanciarListaDeReproduccion() {
		// Preparación
		ListaDeReproduccion lista;
		UsuarioFinal usuario;
		usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		final String NOMBRE_LISTA = "Hitazos";
		final String PROPIETARIO_ESPERADO = "Matii Godoy";
		final Integer CANTIDAD_CANCIONES_ESPERADAS = 0;
		
		// Ejecución
		lista = new ListaDeReproduccion(NOMBRE_LISTA, usuario.getNombre());
		
		// Validación
		assertNotNull(lista);
		assertEquals(PROPIETARIO_ESPERADO,lista.getPropietario());
		assertEquals(CANTIDAD_CANCIONES_ESPERADAS, lista.cantidadDeCanciones());
	}
	
	@Test
	public void queLaDuracionDeLaListaTengaFormatoMmSs() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		ListaDeReproduccion lista = new ListaDeReproduccion("Hitazos", usuario.getNombre());
		Cancion cancion1 = new Cancion("Té para tres", "Soda stereo", 184, Genero.ROCK);
		Cancion cancion2 = new Cancion("Médium", "Gustavo Cerati", 333, Genero.ROCK);
		final String DURACION_ESPERADA = "8:37";
		
		// Ejecución
		lista.agregarCanciones(cancion1);
		lista.agregarCanciones(cancion2);
		
		// Validación
		assertNotNull(lista);
		assertEquals(DURACION_ESPERADA, lista.duracionDeLaLista());
	}

}
