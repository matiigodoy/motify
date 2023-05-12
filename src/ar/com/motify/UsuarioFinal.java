package ar.com.motify;

public class UsuarioFinal extends Usuario{
	
	private Boolean esPremium;

	public UsuarioFinal(String nombre, String email, String contraseña) {
		super(nombre, email, contraseña);
		esPremium = false;
	}

	@Override
	public String mostrarInformacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean login(String email, String contraseña) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getEsPremium() {
		return esPremium;
	}

	public void setEsPremium(Boolean esPremium) {
		this.esPremium = esPremium;
	}

}
