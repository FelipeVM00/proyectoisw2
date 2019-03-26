package isw.proyecto.modelo;

import isw.proyecto.modelo.builder.IBuilder;

/**
 * Esta clase es la abstraccion de cualquier persona dentro del sistema
 */
public abstract class Persona {
	
	
	/**
	 * Nombre de la persona
	 */
	private String nombre;
	/**
	 * Apellido de la persona
	 */
	private String apellido;
	/**
	 * Cedula de la persona
	 */
	private String cedula;
	/**
	 * Telefono de la persona
	 */
	private String telefono;
	
	/**
	 * Devuelve el nombre de la persona
	 * @return el nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Establece el nombre de la persona
	 * @param nombre nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido de la persona
	 * @return el apellido de la persona
	 */
	public String getApellido() {
		return apellido;
	}
	
	/**
	 * Establece el apellido de la persona
	 * @param apellido apellido de la persona
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Devuelve la cedula de la persona
	 * @return la cedula de la persona
	 */
	public String getCedula() {
		return cedula;
	}
	
	/**
	 * Establece la cedula de la persona
	 * @param cedula cedula de la persona
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	/**
	 * Devuelve el telefono de la persona
	 * @return el telefono de la persona
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Establece el telefono de la persona
	 * @param telefono telefono de la persona
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Clase anidada para implementar el patron de diseño Builder
	 */
	public static class PersonaBuilder implements IBuilder<Persona>{
		
		/**
		 * Nombre de la persona builder
		 */
		private String nombre;
		/**
		 * Apellido de la persona builder
		 */
		private String apellido;
		/**
		 * Cedula de la persona builder
		 */
		private String cedula;
		/**
		 * Telefono de la persona builder
		 */
		private String telefono;
		
		/**
		 * Establece el nombre de la persona en el builder
		 * @param nombre nombre de la persona
		 * @return la instancia del builder para poder seguir agregando informacion
		 */
		public PersonaBuilder setNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		/**
		 * Establece el apellido de la persona en el builder
		 * @param apellido apellido de la persona
		 * @return la instancia del builder para poder seguir agregando informacion
		 */
		public PersonaBuilder setApellido(String apellido) {
			this.apellido = apellido;
			return this;
		}
		
		/**
		 * Establece la cedula de la persona en el builder
		 * @param nombre nombre de la persona
		 * @return la instancia del builder para poder seguir agregando informacion
		 */
		public PersonaBuilder setCedula(String cedula) {
			this.cedula = cedula;
			return this;
		}
		
		/**
		 * Establece el telefono de la persona en el builder
		 * @param telefono telefono de la persona
		 * @return la instancia del builder para poder seguir agregando informacion
		 */
		public PersonaBuilder setTelefono(String telefono) {
			this.telefono = telefono;
			return this;
		}
		
		/**
		 * Devuelve el nombre almacenado en el builder de persona
		 * para que las clases que hereden de esta puedan obtenerlos
		 * @return nombre de la persona
		 */
		public String getNombre() {
			return this.nombre;
		}
		
		/**
		 * Devuelve el apellido almacenado en el builder de persona
		 * para que las clases que hereden de esta puedan obtenerlos
		 * @return apellido de la persona
		 */
		public String getApellido() {
			return this.apellido;
		}
		
		/**
		 * Devuelve la cedula almacenado en el builder de persona
		 * para que las clases que hereden de esta puedan obtenerlos
		 * @return cedula de la persona
		 */
		public String getCedula() {
			return this.cedula;
		}
		
		/**
		 * Devuelve el telefono almacenado en el builder de persona
		 * para que las clases que hereden de esta puedan obtenerlos
		 * @return telefono de la persona
		 */
		public String getTelefono() {
			return this.telefono;
		}
		
		/**
		 * Sobreescritura del metodo build de la interfaz IBuilder pasandole por parametro
		 * un objeto tipo Persona y retornando null debido a que nunca se va a instanciar
		 * una clase Persona.
		 */
		@Override
		public Persona build() {
			return null;
		}
	}
}
