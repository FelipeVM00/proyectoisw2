package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.dao.ResidenteDAO;
import isw.proyecto.modelo.dao.impl.ResidenteDAOImpl;

public class ResidenteDAOProxy implements ResidenteDAO {

private static ResidenteDAO object;
	
	@Override
	public void crear(Residente c) {
		if(object == null) {
			object = new ResidenteDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Residente leer(Residente key) {
		if(object == null) {
			object = new ResidenteDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Residente c) {
		if(object == null) {
			object = new ResidenteDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Residente key) {
		if(object == null) {
			object = new ResidenteDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Residente> leerTodo() {
		if(object == null) {
			object = new ResidenteDAOImpl();
		}
		return object.leerTodo();
	}

}
