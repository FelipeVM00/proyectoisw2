package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Visitante;
import isw.proyecto.modelo.dao.VisitanteDAO;
import isw.proyecto.modelo.dao.impl.VisitanteDAOImpl;

public class VisitanteDAOProxy implements VisitanteDAO {

private static VisitanteDAO object;
	
	@Override
	public void crear(Visitante c) {
		if(object == null) {
			object = new VisitanteDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Visitante leer(Visitante key) {
		if(object == null) {
			object = new VisitanteDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Visitante c) {
		if(object == null) {
			object = new VisitanteDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Visitante key) {
		if(object == null) {
			object = new VisitanteDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Visitante> leerTodo() {
		if(object == null) {
			object = new VisitanteDAOImpl();
		}
		return object.leerTodo();
	}

}
