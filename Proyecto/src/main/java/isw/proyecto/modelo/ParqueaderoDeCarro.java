package isw.proyecto.modelo;

public class ParqueaderoDeCarro extends Parqueadero{

	public ParqueaderoDeCarro() {
		
	}
	
	public ParqueaderoDeCarro(int numerop, Residente ocupante, Visitante visitante, String placa) {
		
		this.setNumero(numerop);
		this.setOcupante(ocupante);
		this.setVisitante(visitante);
		this.setPlaca(placa);
	}
}
