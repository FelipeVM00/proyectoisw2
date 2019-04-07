package isw.proyecto.modelo;

import java.util.Set;

public class Bloque{
	
	private int numero;
	private Set<Apartamento> conjuntoDeAptos;
	private int numeroPisos;
	
	public Bloque() {
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Set<Apartamento> getConjuntoDeAptos() {
		return conjuntoDeAptos;
	}

	public void setConjuntoDeAptos(Set<Apartamento> conjuntoDeAptos) {
		this.conjuntoDeAptos = conjuntoDeAptos;
	}

	public int getNumeroPisos() {
		return numeroPisos;
	}

	public void setNumeroPisos(int numeroPisos) {
		this.numeroPisos = numeroPisos;
	}
	
	
}
