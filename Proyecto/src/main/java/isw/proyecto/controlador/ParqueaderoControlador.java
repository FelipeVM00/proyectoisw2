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

	@FXML
    private JFXTabPane pestañasPane;

    @FXML
    private JFXTextField numeroParqueoCarro;

    @FXML
    private JFXTextField nombreResidenteCarro;

    @FXML
    private JFXTextField placaVehiculoCarro;

    @FXML
    private JFXRadioButton tipoResidenteCarro;

    @FXML
    private ToggleGroup tipoVisitante;

    @FXML
    private JFXRadioButton tipoVisitanteCarro;

    @FXML
    private JFXTextField cedulaResidenteCarro;

    @FXML
    private JFXButton asignarParqueoIndvCarro;

    @FXML
    private JFXButton sorteoAleatorioCarro;

    @FXML
    private TableView<Parqueadero> tablaAsignacionCarros;

    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoCar;

    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignCar;

    @FXML
    private JFXTextField bucarAsignacionCarro;

    @FXML
    private JFXTextField numeroParqueoMoto;

    @FXML
    private JFXTextField nombreResidenteMoto;

    @FXML
    private JFXTextField placaVehiculoMoto;

    @FXML
    private JFXRadioButton tipoResidenteMoto;

    @FXML
    private JFXRadioButton tipoVisitanteMoto;

    @FXML
    private JFXTextField cedulaResidenteMoto;

    @FXML
    private JFXButton asignarParqueoIndvMoto;

    @FXML
    private JFXButton sorteoAleatorioMoto;

    @FXML
    private TableView<Parqueadero> tablaAsignacionMot;

    @FXML
    private TableColumn<Parqueadero, String> columnaNumParqueaderoMot;

    @FXML
    private TableColumn<Parqueadero, String> columnaResidenteAsignMot;

    @FXML
    private JFXTextField buscarAsignacionMoto;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
