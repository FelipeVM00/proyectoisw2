package isw.proyecto.modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import isw.proyecto.modelo.Residente;
import isw.proyecto.modelo.bridge.IAlgoritmoEncript;
import isw.proyecto.modelo.bridge.IEncriptador;
import isw.proyecto.modelo.dao.PagoDAO;
import isw.proyecto.modelo.decorator.impl.pago.Pago;
import isw.proyecto.modelo.decorator.impl.pago.PagoAdministracion;
import isw.proyecto.modelo.factorymethod.DBFactory;
import isw.proyecto.modelo.factorymethod.DBType;
import isw.proyecto.modelo.factorymethod.IDBAdapter;

public class PagoDAOImpl implements PagoDAO, IEncriptador{
	
	private IAlgoritmoEncript algoritmoEncript;

	private static final String SQL_INSERT = "INSERT INTO pagos (valorPago, fechaPago, mesAPagar, residente) VALUES (?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM pagos WHERE id = ?";
	private static final String SQL_UPDATE = "UPDATE pagos SET valor = ?, mesAPagar = ?, fechaPago = ?, residente = ? WHERE id = ?";
	private static final String SQL_READ = "SELECT * FROM pagos WHERE id = ?";
	private static final String SQL_READALL = "SELECT * FROM pagos";
	
	private IDBAdapter dbAdapter = DBFactory.getDBadapter(DBType.MySQL);
	
	private Connection conn;
	
	public PagoDAOImpl() {
		
	}
	
	@Override
	public void crear(Pago c) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		try {
			conn = dbAdapter.getConnection();
			ps = conn.prepareStatement(SQL_INSERT);
			
			ps.setString(1, Double.toString(c.getValorPago()));
			ps.setString(2, c.getFechaPago().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(3, c.getMesAPagar());
			ps.setString(4, c.getResidente().getNombre() + " " + c.getResidente().getApellido());
			
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
	public Pago leer(Pago key) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		Pago pago = null;
		try {
			ps = conn.prepareStatement(SQL_READ);
			
			ps.setString(1, Integer.toString(key.getId()));
			
			res = ps.executeQuery();
			
			while(res.next()) {
				pago = new PagoAdministracion(Integer.valueOf(res.getString(1)), 
						Double.valueOf(res.getString(2)), 
						res.getString(3), res.getString(4), 
						(Residente) new Residente.ResidenteBuilder().setNombre(res.getString(5)).build());
			}
			return pago;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pago;
	}

	@Override
	public void actualizar(Pago c) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SQL_UPDATE);
			
			ps.setString(1, Double.toString(c.getValorPago()));
			ps.setString(2, c.getMesAPagar());
			ps.setString(3, c.getFechaPago().format(DateTimeFormatter.ofPattern("d/MM/yyyy")));
			ps.setString(4, c.getResidente().getNombre() + " " + c.getResidente().getApellido());
			ps.setString(5, Integer.toString(c.getId()));
			
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
	public void eliminar(Pago key) {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(SQL_DELETE);
			
			ps.setString(1, Integer.toString(key.getId()));
			
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
	public List<Pago> leerTodo() {
		conn = dbAdapter.getConnection();
		PreparedStatement ps;
		ResultSet res;
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		String nombre[];
		try {
			ps = conn.prepareStatement(SQL_READALL);

			res = ps.executeQuery();
					
			while(res.next()) {
				nombre= res.getString(5).split(" ");
				pagos.add(new PagoAdministracion(Integer.valueOf(res.getString(1)), 
						Double.valueOf(res.getString(2)), 
						res.getString(3), res.getString(4), 
						(Residente) new Residente.ResidenteBuilder().setNombre(nombre[0]).setApellido(nombre[1]).build()));
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
		
		return pagos;
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
