package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Visitante;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.VisitanteDAO;

public class VisitanteDAOImpl implements VisitanteDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Visitante c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Visitante leer(Visitante key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Visitante c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Visitante key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Visitante> leerTodo() {
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
