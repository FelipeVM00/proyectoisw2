package isw.proyecto.modelo;

import java.util.Set;

public class ZonaParqueadero {
	
	private String ubicacion;
	private Set<Parqueadero> parqueaderos;
	
	public ZonaParqueadero() {
		
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Set<Parqueadero> getParqueaderos() {
		return parqueaderos;
	}

	public void setParqueaderos(Set<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}
	
	
}
