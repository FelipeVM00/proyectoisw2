package isw.proyecto.controlador;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;

import isw.proyecto.modelo.Parqueadero;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeTableColumn;

public class ParqueaderoControlador implements Initializable{

	
	/**
	 * declarando Botones
	 */
	@FXML
    private JFXButton asignarParqueoIndvCarro;
	@FXML
    private JFXButton sorteoAleatorioCarro;
	@FXML
    private JFXButton asignarParqueoIndvMoto;
    @FXML
    private JFXButton sorteoAleatorioMoto;
	
    
    /**
	 * declarando TabPane
	 */
	@FXML
    private JFXTabPane pestañasPane;

	
	/**
	 * declarando TextField
	 */
    @FXML
    private JFXTextField numeroParqueoCarro;
    @FXML
    private JFXTextField nombreResidenteCarro;
    @FXML
    private JFXTextField placaVehiculoCarro;
    @FXML
    private JFXTextField cedulaResidenteCarro;
    @FXML
    private JFXTextField bucarAsignacionCarro;
    @FXML
    private JFXTextField numeroParqueoMoto;
    @FXML
    private JFXTextField nombreResidenteMoto;
    @FXML
    private JFXTextField placaVehiculoMoto;
    @FXML
    private JFXTextField buscarAsignacionMoto;
    @FXML
    private JFXTextField cedulaResidenteMoto;
    
    
    /**
	 * declarando RadioButton
	 */
    @FXML
    private JFXRadioButton tipoResidenteCarro;
    @FXML
    private JFXRadioButton tipoVisitanteCarro;
    @FXML
    private JFXRadioButton tipoResidenteMoto;
    @FXML
    private JFXRadioButton tipoVisitanteMoto;
    
    
    /**
	 * declarando TableView
	 */
    @FXML
    private TableView<Parqueadero> tablaAsignacionCarros;
    @FXML
    private TableView<Parqueadero> tablaAsignacionMot;

    
    /**
	 * declarando TableColumn
	 */
    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoMot;
    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignMot;
    @FXML
    private TableColumn<Parqueadero, String> columnaPlacaCar;
    @FXML
    private TableColumn<Parqueadero, String> columnaPlacaMot;
    
    @FXML
    private ToggleGroup tipoVisitante;

    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
