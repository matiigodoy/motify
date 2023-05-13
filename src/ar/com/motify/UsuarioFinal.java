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
	public Boolean login(String email, String contraseña) {
		if (email.equals(getEmail()) && contraseña.equals(getContraseña())) {
			System.out.println("¡Inicio de sesión correcto!");
			System.out.println("Bienvenido " + getNombre());
			setEstaLogueado(true);
			return true;
		} else {
			System.out.println("Datos incorrectos. Intente nuevamente.");
			return false;
		}
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

}
