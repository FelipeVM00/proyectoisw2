package isw.proyecto.modelo;

public class Empleado extends Persona{
	
	private int id;
	private EmpresaContratada trabajaPara;
	private int horasSemanales;
	
	private Empleado(String nombre, String apellido, String cedula, String telefono, int id, EmpresaContratada trabajaPara, int horasSemanales) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCedula(cedula);
		this.setTelefono(telefono);
		this.setId(id);
		this.setTrabajaPara(trabajaPara);
		this.setHorasSemanalas(horasSemanales);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public EmpresaContratada getTrabajaPara() {
		return trabajaPara;
	}
	
	public void setTrabajaPara(EmpresaContratada trabajaPara) {
		this.trabajaPara = trabajaPara;
	}
	
	public int getHorasSemanalas() {
		return horasSemanales;
	}
	
	public void setHorasSemanalas(int horasSemanalas) {
		this.horasSemanales = horasSemanalas;
	}
	
	public static class EmpleadoBuilder extends PersonaBuilder{
		
		private int id;
		private EmpresaContratada trabajaPara;
		private int horasSemanales;
		
		public EmpleadoBuilder setId(int id) {
			this.id = id;
			return this;
		}
		
		public EmpleadoBuilder setTrabajaPara(EmpresaContratada empresa) {
			this.trabajaPara = empresa;
			return this;
		}
		
		public EmpleadoBuilder setHorasSemanales(int horas) {
			this.horasSemanales = horas;
			return this;
		}
		
		@Override
		public Empleado build() {
			return new Empleado(this.getNombre(), this.getApellido(), this.getCedula(), this.getTelefono(), this.id, this.trabajaPara, this.horasSemanales);
		}
	}
	
	/*
	@Override
    public String toString() {
        return "Empleado{" + "nombre=" + getNombre() + ", apellido=" + getApellido() + ", cedula=" 
                + getCedula() + ", \ntelefono=" + getTelefono() + ", \nID=" + id 
                + ", \nEmpresa=" + trabajaPara + ", \nHoras Semanales=" + horasSemanales + '}';
    }
    */
	
}
