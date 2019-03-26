package isw.proyecto.modelo;

public class Usuario extends Persona{
	
	private Cuenta cuenta;
	private TipoUsuario rol;
	
	public Usuario() {		
	}
	
	private Usuario(String nombre, String apellido, String cedula, String telefono, Cuenta cuenta, TipoUsuario rol) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setCuenta(cuenta);
		this.setRol(rol);
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public TipoUsuario getRol() {
		return rol;
	}

	public void setRol(TipoUsuario rol) {
		this.rol = rol;
	}
	
	public boolean login(String usuario, String contraseña) {
		return false;
	}

	public static class UsuarioBuilder extends PersonaBuilder{
		
		private Cuenta cuenta;
		private TipoUsuario rol;
		
		public UsuarioBuilder setCuenta(Cuenta cuenta) {
			this.cuenta = cuenta;
			return this;
		}
		
		public UsuarioBuilder setRol(TipoUsuario rol) {
			this.rol = rol;
			return this;
		}
		
		@Override
		public Usuario build() {
			
			if(this.rol == TipoUsuario.ADMIN) {
				return new Administrador(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.cuenta, this.rol);
			}
			else if(this.rol == TipoUsuario.SUPERADMIN){
				return new SuperAdministrador(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.cuenta, this.rol);
			}
			else {
				return new Usuario(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.cuenta, this.rol);
			}
		}
	}
	
}
