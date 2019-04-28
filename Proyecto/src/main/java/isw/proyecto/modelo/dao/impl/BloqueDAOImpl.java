package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Bloque;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.BloqueDAO;

public class BloqueDAOImpl implements BloqueDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Bloque c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Bloque leer(Bloque key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Bloque c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Bloque key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bloque> leerTodo() {
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
