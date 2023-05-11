package ar.com.motify;

abstract class Usuario {
	protected String usuario;
	protected String nombre;
	protected String email;
	protected String contraseña;
	protected Boolean estaLogueado;
	
	public Usuario(String usuario, String nombre, String email, String contraseña) {
		this.usuario = usuario;
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.estaLogueado = false;
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getContraseña() {
		return contraseña;
	}



	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}



	public Boolean getEstaLogueado() {
		return estaLogueado;
	}



	public void setEstaLogueado(Boolean estaLogueado) {
		this.estaLogueado = estaLogueado;
	}



	public abstract String mostrarInformacion();
	public abstract Boolean login(String usuario, String contraseña);
	
}
