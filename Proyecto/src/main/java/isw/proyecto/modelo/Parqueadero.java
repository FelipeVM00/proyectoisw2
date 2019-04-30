package isw.proyecto.modelo;

import javafx.beans.property.SimpleStringProperty;

public abstract class Parqueadero {

	private int numero;
	private int numeroPiso;
	private Residente ocupante;
	private Visitante visitante;
	private String placa;
	
	public Parqueadero() {
		
	}
	
	
	public Parqueadero (int numerop, Residente ocupante, Visitante visitante, String placa) {
		
		this.numero = numerop;
		this.ocupante = ocupante;
		this.visitante = visitante;
		this.placa = placa;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(int numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	public Residente getOcupante() {
		return ocupante;
	}

	public void setOcupante(Residente ocupante) {
		this.ocupante = ocupante;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}
	
	public SimpleStringProperty numeroProperty() {
		SimpleStringProperty str = new SimpleStringProperty(Integer.toString(numero));
		return str;
	}
	
	public SimpleStringProperty ocupanteProperty() {
		SimpleStringProperty str = new SimpleStringProperty(ocupante.getNombre() + " " + ocupante.getApellido());
		return str;
	}
	
	public SimpleStringProperty visitanteProperty() {
		SimpleStringProperty str = new SimpleStringProperty(visitante.getNombre());
		return str;
	}
	
	public SimpleStringProperty placaProperty() {
		SimpleStringProperty str = new SimpleStringProperty(placa);
		return str;
	}
	
	@Override
	public String toString() {
		return "Parqueadero{ " + "Numero de parqueadero: " 
				+ numero 
				+ " Numero Piso: " 
				+ numeroPiso 
				+ " Nombre de Residente: " 
				+ ocupante.getNombre()
				+ " Nombre de Visitante: " 
				+ " "
				+ " Numero de Placa: " 
				+ placa;
	}
}
