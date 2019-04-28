package isw.proyecto.modelo.dao.impl;

import java.util.List;

import isw.proyecto.modelo.Arrendatario;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ArrendatarioDAO;

public class ArrendatarioDAOImpl implements ArrendatarioDAO, IEncriptador{

	private IAlgoritmoEncript algoritmoEncript;
	
	@Override
	public void crear(Arrendatario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Arrendatario leer(Arrendatario key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(Arrendatario c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Arrendatario key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Arrendatario> leerTodo() {
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
