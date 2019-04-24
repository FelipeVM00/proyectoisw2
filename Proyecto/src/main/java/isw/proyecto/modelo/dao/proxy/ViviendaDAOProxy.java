package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Vivienda;
import isw.proyecto.modelo.dao.ViviendaDAO;
import isw.proyecto.modelo.dao.impl.ViviendaDAOImpl;

public class ViviendaDAOProxy implements ViviendaDAO {

private static ViviendaDAO object;
	
	@Override
	public void crear(Vivienda c) {
		if(object == null) {
			object = new ViviendaDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Vivienda leer(Vivienda key) {
		if(object == null) {
			object = new ViviendaDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Vivienda c) {
		if(object == null) {
			object = new ViviendaDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Vivienda key) {
		if(object == null) {
			object = new ViviendaDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Vivienda> leerTodo() {
		if(object == null) {
			object = new ViviendaDAOImpl();
		}
		return object.leerTodo();
	}

}
