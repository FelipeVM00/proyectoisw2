package isw.proyecto.modelo.decorator.impl.pago;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import isw.proyecto.modelo.Residente;
import javafx.beans.property.SimpleStringProperty;

public abstract class Pago implements IPago{
	
	private int id;
	private double valorPago;
	private LocalDate fechaPago;
	private String mesAPagar;
	private Residente residente;
	
	public Pago() {
	}
	
	public Pago(int id, double valor, String fecha, String mes, Residente residente) {
		this.setId(0);
		this.valorPago = valor;
		this.setFechaPago(fecha);
		this.mesAPagar = mes;
		this.residente = residente;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = LocalDate.parse(fechaPago, DateTimeFormatter.ofPattern("d/MM/yyyy"));
	}

	public String getMesAPagar() {
		return mesAPagar;
	}

	public void setMesAPagar(String mesAPagar) {
		this.mesAPagar = mesAPagar;
	}
		
	public SimpleStringProperty idProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Integer.toString(id));
		return str;
	}
	
	public SimpleStringProperty valorPagoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Double.toString(valorPago));
		return str;
	}
	
	public SimpleStringProperty fechaPagoProperty() {
		SimpleStringProperty str = new SimpleStringProperty(fechaPago.toString());
		return str;
	}
	
	public SimpleStringProperty mesAPagarProperty() {
		SimpleStringProperty str = new SimpleStringProperty(mesAPagar);
		return str;
	}
	
	public SimpleStringProperty residenteProperty() {
		SimpleStringProperty str = new SimpleStringProperty(residente.getNombre() + " " + residente.getApellido());
		return str;
	}
}
