package isw.proyecto.modelo.decorator.impl.pago;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import isw.proyecto.modelo.Residente;
import javafx.beans.property.SimpleStringProperty;

public abstract class Pago implements IPago{
	
	private int id;
	private double valorPago;
	private Date fechaPago;
	private String mesAPagar;
	private Residente residente;
	
	public Pago() {
	}
	
	public Pago(double valor, String fecha, String mes, Residente residente) {
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

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		try {
			this.fechaPago = new SimpleDateFormat("dd/MM/yyyy").parse(fechaPago);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getMesAPagar() {
		return mesAPagar;
	}

	public void setMesAPagar(String mesAPagar) {
		this.mesAPagar = mesAPagar;
	}
		
}
