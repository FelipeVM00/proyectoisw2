package isw.proyecto.modelo.dao;

import java.util.List;

public interface OperacionesDB <T>{

	public void crear(T c);
	public T leer(T key);
	public void actualizar(T c);
	public void eliminar(T key);
	
	public List<T> leerTodo();
	
}
