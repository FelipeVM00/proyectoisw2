package isw.proyecto.modelo.dao.proxy;

import java.util.List;

import isw.proyecto.modelo.Usuario;
import isw.proyecto.modelo.dao.UsuarioDAO;
import isw.proyecto.modelo.dao.impl.UsuarioDAOImpl;

public class UsuarioDAOProxy implements UsuarioDAO {

private static UsuarioDAO object;
	
	@Override
	public void crear(Usuario c) {
		if(object == null) {
			object = new UsuarioDAOImpl();
		}
		
		object.crear(c);

	}

	@Override
	public Usuario leer(Usuario key) {
		if(object == null) {
			object = new UsuarioDAOImpl();
		}
		return object.leer(key);
	}

	@Override
	public void actualizar(Usuario c) {
		if(object == null) {
			object = new UsuarioDAOImpl();
		}
		
		object.actualizar(c);

	}

	@Override
	public void eliminar(Usuario key) {
		if(object == null) {
			object = new UsuarioDAOImpl();
		}
		
		object.eliminar(key);

	}

	@Override
	public List<Usuario> leerTodo() {
		if(object == null) {
			object = new UsuarioDAOImpl();
		}
		return object.leerTodo();
	}

}
