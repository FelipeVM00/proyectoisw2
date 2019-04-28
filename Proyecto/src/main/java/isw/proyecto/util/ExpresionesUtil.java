package isw.proyecto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpresionesUtil {
	
	public static boolean tieneSoloLetras(String texto) {
		Pattern soloLetras = Pattern.compile("[a-zA-Z ]");
		Matcher mat = soloLetras.matcher(texto);
		return mat.find();
	}
	
	public static boolean tieneSoloNumeros(String texto) {
		Pattern soloNumeros = Pattern.compile("[0-9]");
		Matcher mat = soloNumeros.matcher(texto);
		return mat.find();
	}
}
