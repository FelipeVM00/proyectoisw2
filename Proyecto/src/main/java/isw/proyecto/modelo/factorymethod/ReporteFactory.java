package isw.proyecto.modelo.factorymethod;

public class ReporteFactory {

	 public static IReporte getTipoArchivo(TipoArchivo tipo) {
	        switch (tipo) {
	            case TXT:
	                return new ArchivoTXT();
	            case CSV:
	                return new ArchivoCSV();
	            case XLSX:
	            	return new ArchivoXLSX();
	            default:
	                throw new IllegalArgumentException("No soportado");
	        }
	 }
	 
}
