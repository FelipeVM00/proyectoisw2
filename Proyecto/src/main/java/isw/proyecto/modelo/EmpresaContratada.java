package isw.proyecto.modelo;

import java.util.Date;
import java.util.List;

public abstract class EmpresaContratada {
	
	private String nombre;
	private Date contratadaDesde;
	private double costoContrato;
	private List<Empleado> empleados;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getContratadaDesde() {
		return contratadaDesde;
	}
	
	public void setContratadaDesde(Date contratadaDesde) {
		this.contratadaDesde = contratadaDesde;
	}
	
	public double getCostoContrato() {
		return costoContrato;
	}
	
	public void setCostoContrato(double costoContrato) {
		this.costoContrato = costoContrato;
	}
	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	
}
