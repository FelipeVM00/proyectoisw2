package isw.proyecto.modelo.facade;

import isw.proyecto.modelo.facade.subsistemas.SistemaControlVisitantes;

public class SubSistemasFacadeImpl implements ISubSistemasFacade{

	SistemaControlVisitantes sistemaControlVisitantes;

	@Override
	public void pedirReporte() {	
		sistemaControlVisitantes.generarReporteVisitas();
	}
	
}
