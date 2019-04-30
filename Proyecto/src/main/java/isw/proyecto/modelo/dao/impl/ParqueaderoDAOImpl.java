package isw.proyecto.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import isw.proyecto.modelo.Parqueadero;
import isw.proyecto.modelo.ParqueaderoDeCarro;
import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.ParqueaderoDAO;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import isw.proyecto.modelo.factorymethod.DBFactory;
import isw.proyecto.modelo.factorymethod.DBType;
import isw.proyecto.modelo.factorymethod.IDBAdapter;

public class ParqueaderoDAOImpl implements ParqueaderoDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;
	
	private static final String SQL_INSERT = "INSERT INTO parqueaderos (numero, numeroPiso, ocupante, visitante, placa) VALUES (?, ?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM parqueaderos WHERE numero = ?";
	private static final String SQL_UPDATE = "UPDATE parqueaderos SET placa = ?, numero = ?, WHERE numero = ?";
	private static final String SQL_READ = "SELECT * FROM parqueaderos WHERE numero = ?";
	private static final String SQL_READALL = "SELECT * FROM parqueaderos";

private IDBAdapter dbAdapter = DBFactory.getDBadapter(DBType.MySQL);
	
	private Connection conn;
	
	public ParqueaderoDAOImpl() {
		
	}
	
	@Override
	public void crear(Parqueadero c) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		try {
			conn = dbAdapter.getConnection();
			ps = conn.prepareStatement(SQL_INSERT);
			
			ps.setString(1, Integer.toString(c.getNumero()));
			ps.setString(2, null);
			ps.setString(3, c.getOcupante().getNombre() + " " + c.getOcupante().getApellido());
			ps.setString(4, null);
			ps.setString(5, c.getPlaca());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Parqueadero leer(Parqueadero key) {
	
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		Parqueadero parqueadero = null;
		try {
			ps = conn.prepareStatement(SQL_READ);
			
			ps.setString(1, Integer.toString(key.getNumero()));
			
			res = ps.executeQuery();
			
			while(res.next()) {
				parqueadero = new ParqueaderoDeCarro(Integer.valueOf(res.getString(1)), 
						(Residente) new Residente.ResidenteBuilder().setNombre(res.getString(3)).build(),
						null, 
						res.getString(5));
						
			}
			return parqueadero;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return parqueadero;
	}
	

	@Override
	public void actualizar(Parqueadero c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Parqueadero key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Parqueadero> leerTodo() {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		ArrayList<Parqueadero> parqueaderos = new ArrayList<Parqueadero>();
		String nombre[];
		try {
			ps = conn.prepareStatement(SQL_READALL);

			res = ps.executeQuery();
					
			while(res.next()) {
				nombre= res.getString(3).split(" ");
				parqueaderos.add(new ParqueaderoDeCarro(Integer.valueOf(res.getString(1)), 
						(Residente) new Residente.ResidenteBuilder().setNombre(res.getString(3)).build(),
						null, 
						res.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return parqueaderos;
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
