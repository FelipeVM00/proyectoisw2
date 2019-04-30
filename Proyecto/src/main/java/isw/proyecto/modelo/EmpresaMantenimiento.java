package isw.proyecto.modelo;

public class EmpresaMantenimiento extends EmpresaContratada{

	public EmpresaMantenimiento() {
		
	}
	
	public EmpresaMantenimiento(String nom, String tipoEmpresa, String numContrato, int telefono, String fecha,
			double valorContrato) {
		
		this.setNombre(nom);
		this.setTipoEmpresa(tipoEmpresa);
		this.setNumeroContrato(numContrato);
		this.setTelefono(telefono);
		this.setFechaInicio(fecha);
		this.setFechaTerminacion(fecha);
		this.setValorContrato(valorContrato);
	}
}
