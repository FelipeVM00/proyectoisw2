package isw.proyecto.modelo.dao.impl;

import isw.proyecto.modelo.dao.AdministradorDAO;
import isw.proyecto.modelo.dao.ApartamentoDAO;
import isw.proyecto.modelo.dao.ArrendatarioDAO;
import isw.proyecto.modelo.dao.BloqueDAO;
import isw.proyecto.modelo.dao.CasaDAO;
import isw.proyecto.modelo.dao.CuentaDAO;
import isw.proyecto.modelo.dao.EmpleadoDAO;
import isw.proyecto.modelo.dao.EmpresaDAO;
import isw.proyecto.modelo.dao.LoginDAO;
import isw.proyecto.modelo.dao.PagoDAO;
import isw.proyecto.modelo.dao.ParqueaderoDAO;
import isw.proyecto.modelo.dao.ReporteDAO;
import isw.proyecto.modelo.dao.ResidenteDAO;
import isw.proyecto.modelo.dao.UsuarioDAO;
import isw.proyecto.modelo.dao.VisitanteDAO;
import isw.proyecto.modelo.dao.ViviendaDAO;
import isw.proyecto.modelo.dao.ZonaResidencialDAO;

public abstract class DAOFactory {

	public static AdministradorDAO getAdministradorDAO() {
		return new AdministradorDAOImpl();
	}
	
	public static ApartamentoDAO getApartamentoDAO() {
		return new ApartamentoDAOImpl();
	}
	
	public static ArrendatarioDAO getArrendatarioDAO() {
		return new ArrendatarioDAOImpl();
	}
	
	public static BloqueDAO getBloqueDAO() {
		return new BloqueDAOImpl();
	}
	
	public static CasaDAO getCasaDAO() {
		return new CasaDAOImpl();
	}
	
	public static CuentaDAO getCuentaDAO() {
		return new CuentaDAOImpl();
	}
	
	public static EmpleadoDAO getEmpleadoDAO() {
		return new EmpleadoDAOImpl();
	}
	
	public static EmpresaDAO getEmpresaDAO() {
		return new EmpresaDAOImpl();
	}
	
	public static LoginDAO getLoginDAO() {
		return new LoginDAOImpl();
	}
	
	public static ParqueaderoDAO getParqueaderoDAO() {
		return new ParqueaderoDAOImpl();
	}
	
	public static ResidenteDAO getResidenteDAO() {
		return new ResidenteDAOImpl();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl();
	}
	
	public static VisitanteDAO getVisitanteDAO() {
		return new VisitanteDAOImpl();
	}
	
	public static ViviendaDAO getViviendaDAO() {
		return new ViviendaDAOImpl();
	}
	
	public static ZonaResidencialDAO getZonaResidencialDAO() {
		return new ZonaResidencialDAOImpl();
	}
	
	public static PagoDAO getPagoDAO() {
		return new PagoDAOImpl();
	}
	
	public static ReporteDAO getReporteDAO() {
		return new ReporteDAOImpl();
	}
}
