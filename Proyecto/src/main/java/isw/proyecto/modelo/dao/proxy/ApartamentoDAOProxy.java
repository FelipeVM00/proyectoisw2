package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Apartamento;
import isw.proyecto.modelo.dao.ApartamentoDAO;
import isw.proyecto.modelo.dao.impl.ApartamentoDAOImpl;

public class ApartamentoDAOProxy implements ApartamentoDAO {

private static ApartamentoDAO object;
	
	@Override
	public void crear(Apartamento c) {
		if(object == null) {
			object = new ApartamentoDAOImpl();
		}
		object.crear(c);
		
	}

	@Override
	public Apartamento leer(Apartamento key) {
		if(object == null) {
			object = new ApartamentoDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Apartamento c) {
		if(object == null) {
			object = new ApartamentoDAOImpl();
		}
		object.actualizar(c);
		
	}

	@Override
	public void eliminar(Apartamento key) {
		if(object == null) {
			object = new ApartamentoDAOImpl();
		}
		object.eliminar(key);
		
	}

	@Override
	public List<Apartamento> leerTodo() {
		if(object == null) {
			object = new ApartamentoDAOImpl();
		}
		return object.leerTodo();
	}

}
