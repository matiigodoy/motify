package ar.com.motify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class UsuarioFinalTest {

	@Test
	public void queSePuedaInstanciarUnUsuarioFinal() {
		// Preparación
		UsuarioFinal usuarioFinal;
		final String NOMBRE = "Mora";
		final String EMAIL = "mora@gmail.com";
		final String PASSWORD = "*****";

		// Ejecución
		usuarioFinal = new UsuarioFinal(NOMBRE, EMAIL, PASSWORD);

		// Validación
		assertNotNull(usuarioFinal);
		assertEquals(EMAIL, usuarioFinal.getEmail());
	}

	@Test
	public void queUnUsuarioFinalPuedaDescargarUnaCancionDeLaLista() {
		// set up
		String email = "mora@hotmail.com";
		String password = "****";

		// exercise
		UsuarioFinal usuarioFinal = new UsuarioFinal("mora", email, password);
		usuarioFinal.setPremium(true);
		Cancion cancion = new Cancion("Chop suey!", "System Of A Down", 210, Genero.NUMETAL);
		ListaDeReproduccion playlist = new ListaDeReproduccion("Rock mix", usuarioFinal);
		playlist.agregarCancion(cancion, usuarioFinal.getPremium());

		usuarioFinal.login(email, password);
		List<Cancion> listadoCanciones = playlist.getCanciones();
		Boolean descargaExpected = listadoCanciones.get(0).descargar(usuarioFinal);
		
		// verify
		assertTrue(descargaExpected);
	}
	
	@Test
	// Matii Test
	public void queUnUsuarioFreeNoPuedaDescargarCancion() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		Cancion cancion = new Cancion("Té Para Tres", "Soda Stereo", 184, Genero.ROCK);
		
		// Ejecución
		Boolean descarga = cancion.descargar(usuario);
		
		// Validación
		assertFalse(descarga);
	}
	
	@Test
	// Mati Test
	public void queUnUsuarioPremiumPuedaDescargarCancion() {
		// Preparación
		UsuarioFinal usuario = new UsuarioFinal("Matii Godoy", "matii@gmail.com", "pass1234");
		usuario.setPremium(true);
		Cancion cancion = new Cancion("Té Para Tres", "Soda Stereo", 184, Genero.ROCK);
		
		// Ejecución
		Boolean descarga = cancion.descargar(usuario);
		
		// Validación
		assertTrue(descarga);
	}

}
