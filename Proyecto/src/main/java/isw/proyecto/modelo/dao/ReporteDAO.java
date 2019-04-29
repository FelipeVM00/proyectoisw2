package isw.proyecto.modelo.dao;

import java.util.List;

import isw.proyecto.modelo.EmpresaContratada;
import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.Visitante;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.factorymethod.IReporte;

public interface ReporteDAO extends OperacionesDB<IReporte>{

	public List<Pago> leerPagos();
	public List<EmpresaContratada> leerEmpresas();
	public List<Residente> leerResidentes();
	public List<Visitante> leerVisitantes();
	public List<Parqueadero> leerParqueaderos();
}
