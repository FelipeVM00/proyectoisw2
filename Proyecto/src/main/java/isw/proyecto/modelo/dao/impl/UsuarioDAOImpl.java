package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Usuario;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario leer(Usuario key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> leerTodo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encriptarInfo(String info, String pass) throws Exception {
		return algoritmoEncript.encriptarInfo(info, pass);
	}

	public IAlgoritmoEncript getAlgoritmoEncript() {
		return algoritmoEncript;
	}

	public void setAlgoritmoEncript(IAlgoritmoEncript algoritmoEncript) {
		this.algoritmoEncript = algoritmoEncript;
	}
}
