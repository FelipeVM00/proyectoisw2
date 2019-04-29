package isw.proyecto.modelo.factorymethod;

import java.io.FileWriter;
import java.io.IOException;

import javafx.collections.ObservableList;

public class ArchivoTXT implements IReporte{
	
	public ArchivoTXT() {
		
	}

	@Override
	public <T> void generarReporte(String nombreArchivo, ObservableList<T> lista) throws IOException{
		 FileWriter writer = new FileWriter(nombreArchivo + ".txt");
	        for (T o : lista) {
	        	writer.append("\r\n");
	            writer.write(o.toString());
	        }
	        writer.close();
	}

}
