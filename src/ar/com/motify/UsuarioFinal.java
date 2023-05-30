package ar.com.motify;

public class UsuarioFinal extends Usuario {

	private Boolean esPremium;

	public UsuarioFinal(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		esPremium = false;
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

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

}
