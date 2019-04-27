package isw.proyecto.modelo;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public abstract class EmpresaContratada {
	
	public SimpleStringProperty nombre = new SimpleStringProperty();
	public SimpleStringProperty tipoEmpresa = new SimpleStringProperty();
	public SimpleStringProperty numeroContrato = new SimpleStringProperty();
	public SimpleStringProperty telefono = new SimpleStringProperty();
	public SimpleStringProperty fechaInicio = new SimpleStringProperty();
	public SimpleStringProperty fechaTerminacion = new SimpleStringProperty();
	public SimpleStringProperty valorContrato = new SimpleStringProperty();
	public List<Empleado> empleados;
	
	public String getNombre() {
		return nombre.get();
	}
	
		public String getTipoEmpresa() {
		return tipoEmpresa.get();
	}

	public String getNumeroContrato() {
		return numeroContrato.get();
	}

	public String getTelefono() {
		return telefono.get();
	}

	public String getFechaInicio() {
		return fechaInicio.get();
	}

	public String getFechaTerminacion() {
		return fechaTerminacion.get();
	}

	public String getValorContrato() {
		return valorContrato.get();
	}

	
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
}
