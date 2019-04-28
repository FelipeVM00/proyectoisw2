package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Casa;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.CasaDAO;

public class CasaDAOImpl implements CasaDAO, IEncriptador{

	private IAlgoritmoEncript algoritmoEncript;
	
	@Override
	public void crear(Casa c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Casa leer(Casa key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Casa c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Casa key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Casa> leerTodo() {
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
