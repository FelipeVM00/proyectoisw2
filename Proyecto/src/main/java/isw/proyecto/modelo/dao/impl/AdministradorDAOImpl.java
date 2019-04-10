package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Administrador;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.AdministradorDAO;

public class AdministradorDAOImpl implements AdministradorDAO, IEncriptador{

	private IAlgoritmoEncript algoritmoEncript;
	
	@Override
	public void crear(Administrador c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador leer(Administrador key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Administrador c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Administrador key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administrador> leerTodo() {
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
