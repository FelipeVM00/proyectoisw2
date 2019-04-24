package isw.proyecto.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;

public class FinanzasControlador implements Initializable{
	
	@FXML
    private JFXTabPane pestañasPane;

	@FXML
    private Label fondosLabel;

    @FXML
    private JFXTreeTableView<?> transaccionesTabla;

    @FXML
    private TreeTableColumn<?, ?> tablaFecha;

    @FXML
    private TreeTableColumn<?, ?> tablaDescripcion;

    @FXML
    private TreeTableColumn<?, ?> tablaMonto;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pestañasPane.getStylesheets().add("/isw/proyecto/vista/custom.css");
		
	}

    
}
