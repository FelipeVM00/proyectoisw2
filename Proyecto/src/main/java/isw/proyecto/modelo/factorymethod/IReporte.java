package isw.proyecto.modelo.factorymethod;

import java.io.IOException;

import javafx.collections.ObservableList;

public interface IReporte {
	public <T> void generarReporte(String nombreArchivo, ObservableList<T> lista) throws IOException;
}
