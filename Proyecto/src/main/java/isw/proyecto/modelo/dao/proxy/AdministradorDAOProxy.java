package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Administrador;
import isw.proyecto.modelo.dao.AdministradorDAO;
import isw.proyecto.modelo.dao.impl.AdministradorDAOImpl;

public class AdministradorDAOProxy implements AdministradorDAO{

	private static AdministradorDAO object;
	
	@Override
	public void crear(Administrador c) {
		if(object == null) {
			object = new AdministradorDAOImpl();
		}
		object.crear(c);
	}

	@Override
	public Administrador leer(Administrador key) {
		if(object == null) {
			object = new AdministradorDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Administrador c) {
		if(object == null) {
			object = new AdministradorDAOImpl();
		}
		object.actualizar(c);	
	}

	@Override
	public void eliminar(Administrador key) {
		if(object == null) {
			object = new AdministradorDAOImpl();
		}
		object.eliminar(key);		
	}

	@Override
	public List<Administrador> leerTodo() {
		if(object == null) {
			object = new AdministradorDAOImpl();
		}
		return object.leerTodo();
	}

}
