package ar.com.motify;

import java.util.HashSet;

public class UsuarioFinal extends Usuario {

	private Boolean esPremium;
	private HashSet<Cancion> cancionesDescargadas;

	public UsuarioFinal(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		esPremium = false;
		setCancionesDescargadas(new HashSet<Cancion>());
	}

	@Override
	public String mostrarInformacion() {
		return "-Nombre: " + getNombre() + "\n-Email: " + getEmail();
	}

	@Override
	public String login(String email, String contraseña) {
		String respuesta = "";
		if (email.equals(getEmail()) && contraseña.equals(getContraseña())) {
			respuesta = "¡Inicio de sesión correcto! \n Bienvenido" + getNombre();
		} else {
			respuesta = "Datos incorrectos. Intente nuevamente.";
		}
		return respuesta;

	}

	public Boolean getPremium() {
		return esPremium;
	}

	public void setPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

	public HashSet<Cancion> getCancionesDescargadas() {
		return cancionesDescargadas;
	}

	public void setCancionesDescargadas(HashSet<Cancion> cancionesDescargadas) {
		this.cancionesDescargadas = cancionesDescargadas;
	}
	
	public void agregarCancionDescargada(Cancion cancion) {
		cancionesDescargadas.add(cancion);
	}
}
