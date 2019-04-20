package isw.proyecto.modelo.dao.impl;

import isw.proyecto.modelo.dao.AdministradorDAO;
import isw.proyecto.modelo.dao.ApartamentoDAO;

public abstract class DAOFactory {

	public static AdministradorDAO getAdministradorDAO() {
		return new AdministradorDAOImpl();
	}
	
	public static ApartamentoDAO getApartamentoDAO() {
		return new ApartamentoDAOImpl();
	}
	
	
}
