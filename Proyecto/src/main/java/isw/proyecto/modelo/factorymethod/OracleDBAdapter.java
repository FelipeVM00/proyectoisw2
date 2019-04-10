package isw.proyecto.modelo.factorymethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import isw.proyecto.util.PropertiesUtil;
import oracle.jdbc.driver.OracleDriver;

public class OracleDBAdapter implements IDBAdapter{
	
	private static final String DB_PROPERTIES = "META-INF/DBOracle.properties";

    private static final String DB_SERVICE_PROP = "service";
    private static final String DB_HOST_PROP = "host";
    private static final String DB_PASSWORD_PROP = "password";
    private static final String DB_PORT_PROP = "port";
    private static final String DB_USER_PROP = "user";

    static {
        //Bloque para registrar el Driver de Oracle
        try {
            new OracleDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("Connection class ==> " + connection.getClass().getName());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST_PROP);
        String port = prop.getProperty(DB_PORT_PROP);
        String service = prop.getProperty(DB_SERVICE_PROP);
        String user = prop.getProperty(DB_USER_PROP);
        String password = prop.getProperty(DB_PASSWORD_PROP);

        String connectionString = "jdbc:oracle:thin:"+user+"/"+password+"@//"+host+":"+port+"/"+service;
        System.out.println("ConnectionString ==> " + connectionString);
        return connectionString;
    }
}
