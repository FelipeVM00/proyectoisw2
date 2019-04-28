package isw.proyecto.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.DatePicker;

public abstract class EmpresaContratada {

	public String nombre;
	public String tipoEmpresa;
	public String numeroContrato;
	public int telefono;
	public DatePicker fechaInicio;
	public String fechaTerminacion;
	public double valorContrato;
	public List<Empleado> empleados;

	public EmpresaContratada() {
	}

	public EmpresaContratada(String nom, String tipoEmpresa, String numContrato, int telefono, DatePicker fechaInicio, String fechaTerminacion,
			double valorContrato) {
		this.nombre = nom;
		this.tipoEmpresa = tipoEmpresa;
		this.numeroContrato = numContrato;
		this.telefono = telefono;
		this.fechaInicio = fechaInicio;
		this.fechaTerminacion = fechaTerminacion;
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
	
	public DatePicker getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(DatePicker fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaTerminacion() {
		return fechaTerminacion;
	}

	public void setFechaTerminacion(String fechaTerminacion) {
		this.fechaTerminacion = fechaTerminacion;
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
	
	public SimpleIntegerProperty telefonoProperty() {
		SimpleIntegerProperty str = new SimpleIntegerProperty(telefono);
		return str;
	}
	
	public SimpleStringProperty fechaInicioProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaInicio.toString());
		return str;
	}
	
	public SimpleStringProperty fechaTerminacionProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaTerminacion);
		return str;
	}
	
	public SimpleDoubleProperty valorContratoProperty() {
		SimpleDoubleProperty str = new SimpleDoubleProperty(valorContrato);
		return str;
	}
	
	
}
