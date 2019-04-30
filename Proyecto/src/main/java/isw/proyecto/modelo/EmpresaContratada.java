package isw.proyecto.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class EmpresaContratada {

	private String nombre;
	private String tipoEmpresa;
	private String numeroContrato;
	private int telefono;
	private LocalDate fechaInicio;
	private LocalDate fechaTerminacion;
	private double valorContrato;
	private List<Empleado> empleados;

	public EmpresaContratada() {
	}

	public EmpresaContratada(String nom, String tipoEmpresa, String numContrato, int telefono, String fecha,
			double valorContrato) {
		this.nombre = nom;
		this.tipoEmpresa = tipoEmpresa;
		this.numeroContrato = numContrato;
		this.telefono = telefono;
		this.setFechaInicio(fecha);
		this.setFechaTerminacion(fecha);
		this.valorContrato = valorContrato;
	}

	

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresaAseoRB) {
		this.tipoEmpresa = tipoEmpresaAseoRB;
	}
	
	public String getNumeroContrato() {
		return numeroContrato;
	}	

	public void setNumeroContrato(String numContrato) {
		this.numeroContrato = numContrato;
	}
	
	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = LocalDate.parse(fechaInicio, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	public LocalDate getFechaTerminacion() {
		return fechaTerminacion;
	}

	public void setFechaTerminacion(String fechaTerminacion) {
		this.fechaTerminacion = LocalDate.parse(fechaTerminacion, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	public Double getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(double valorContrato) {
		this.valorContrato = valorContrato;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}


	public SimpleStringProperty nombreProperty() {
		SimpleStringProperty str = new SimpleStringProperty(nombre);
		return str;
	}
	
	public SimpleStringProperty tipoEmpresaProperty() {
		SimpleStringProperty str = new SimpleStringProperty(tipoEmpresa);
		return str;
	}

	public SimpleStringProperty numeroContratoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(numeroContrato);
		return str;
	}
	
	public SimpleStringProperty telefonoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Integer.toString(telefono));
		return str;
	}
	
	public SimpleStringProperty fechaInicioProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaInicio.toString());
		return str;
	}
	
	public SimpleStringProperty fechaTerminacionProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaTerminacion.toString());
		return str;
	}
	
	public SimpleStringProperty valorContratoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Double.toString(valorContrato));
		return str;
	}
	
	@Override
	public String toString() {
		return "Empresa{ " + "nombre: " 
				+ nombre + " Tipo de empresa: " 
				+ tipoEmpresa + " Numero de contrato: " 
				+ numeroContrato + " Telefono: " + telefono 
				+ " Fecha Inicio: " 
				+ fechaInicio
				+ " Fecha Terminacion: "
				+ fechaTerminacion
				+ " Valor de contrato es: "
				+ valorContrato;
	}
}
