package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Vivienda;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ViviendaDAO;

public class ViviendaDAOImpl implements ViviendaDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	@Override
	public void crear(Vivienda c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vivienda leer(Vivienda key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Vivienda c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Vivienda key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Vivienda> leerTodo() {
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
