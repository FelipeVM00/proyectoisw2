package isw.proyecto.controlador;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import isw.proyecto.modelo.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EmpresasControlador implements Initializable {

	// declarando botones
	@FXML
	private Button aniadirBT;
	@FXML
	private Button modificarBT;
	@FXML
	private Button eliminarBT;
	@FXML
	private Button nuevoBT;

	// declarando textfields
	@FXML
	private TextField nombreTF;
	@FXML
	private TextField numeroContratoTF;
	@FXML
	private TextField telefonoTF;
	@FXML
	private TextField fechaInicioTF;
	@FXML
	private TextField fechaTerminacionTF;
	@FXML
	private TextField valorContratoTF;
	
	//declarando radio buttons
	@FXML
	private RadioButton tipoEmpresaAseoRB;
	@FXML
	private RadioButton tipoEmpresaMantenimientoRB;
	@FXML
	private RadioButton tipoEmpresaVigilanciaRB;

	// declarando tablas y columnas
	@FXML
	private TableView<EmpresaContratada> tablaContratos;
	@FXML
	private TableColumn nombreCL;
	@FXML
	private TableColumn tipoEmpresaCL;
	@FXML
	private TableColumn numeroContratoCL;
	@FXML
	private TableColumn telefonoCL;
	@FXML
	private TableColumn fechaInicioContratoCL;
	@FXML
	private TableColumn fechaTerminacionContratoCL;
	@FXML
	private TableColumn valorContratoCL;
	ObservableList<EmpresaContratada> contratos;

	private int posicionEmpresaEnTabla;

	@FXML
	private void nuevo(ActionEvent event) {
		nombreTF.setText("");
		numeroContratoTF.setText("");
		telefonoTF.setText("");
		fechaInicioTF.setText("");
		fechaTerminacionTF.setText("");
		valorContratoTF.setText("");
		modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
	}

	@FXML
	private void aniadir(ActionEvent event) {
		EmpresaContratada empresas = new EmpresaAseo();
		empresas.setNombre(nombreTF.getText());
		empresas.setTipoEmpresa(tipoEmpresaAseoRB.getText());
		empresas.setNumeroContrato(numeroContratoTF.getText());
		empresas.setTelefono(Integer.parseInt(telefonoTF.getText()));
		empresas.setFechaInicio(fechaInicioTF.getText());
		//empresas.setFechaTerminacion(fechaTerminacionTF.getText());
		empresas.setValorContrato(Double.parseDouble(valorContratoTF.getText()));
		contratos.add(empresas);
	}

	@FXML
	private void modificar(ActionEvent event) {
		EmpresaContratada empresas = new EmpresaAseo();
		empresas.setNombre(nombreTF.getText());
		empresas.setTipoEmpresa(tipoEmpresaAseoRB.getText());
		empresas.setNumeroContrato(numeroContratoTF.getText());
		empresas.setTelefono(Integer.parseInt(telefonoTF.getText()));
		empresas.setFechaInicio(fechaInicioTF.getText());
		empresas.setFechaTerminacion(fechaTerminacionTF.getText());
		empresas.setValorContrato(Double.parseDouble(valorContratoTF.getText()));
		contratos.set(posicionEmpresaEnTabla, empresas);
	}

	@FXML
	private void eliminar(ActionEvent event) {
		contratos.remove(posicionEmpresaEnTabla);
	}

	private final ListChangeListener<EmpresaContratada> selectorTablaEmpresas = new ListChangeListener<EmpresaContratada>() {
		@Override
		public void onChanged(ListChangeListener.Change<? extends EmpresaContratada> c) {
			ponerEmpresaSeleccionada();
		}
	};

	
	 //PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaContratos"
	 
	public EmpresaContratada getTablaEmpresaSeleccionada() {
		if (tablaContratos != null) {
			List<EmpresaContratada> tabla = tablaContratos.getSelectionModel().getSelectedItems();
			if (tabla.size() == 1) {
				final EmpresaContratada competicionSeleccionada = tabla.get(0);
				return competicionSeleccionada;
			}
		}
		return null;
	}

	// Metodo para poner en los textFields la tupla que selccionemos
	 
	private void ponerEmpresaSeleccionada() {
		final EmpresaContratada empresas = getTablaEmpresaSeleccionada();
		posicionEmpresaEnTabla = contratos.indexOf(empresas);

		if (empresas != null) {

			// Pongo los textFields con los datos correspondientes
			nombreTF.setText(empresas.getNombre());
			//tipo empresa
			numeroContratoTF.setText(empresas.getNumeroContrato());
			telefonoTF.setText(empresas.getTelefono().toString());
			fechaInicioTF.setText(empresas.getFechaInicio().toString());
			fechaTerminacionTF.setText(empresas.getFechaTerminacion());
			valorContratoTF.setText(empresas.getValorContrato().toString());

			// Pongo los botones en su estado correspondiente
			modificarBT.setDisable(false);
			eliminarBT.setDisable(false);
			aniadirBT.setDisable(true);
		}
	}

	// Metodo para inicializar la tabla
	 
	private void inicializarTablaContratos() {
		nombreCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("nombre"));
		tipoEmpresaCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("tipo de empresa"));
		numeroContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("numero de contrato"));
		telefonoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("telefono"));
		fechaInicioContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("fecha de inicio de contrato"));
		fechaTerminacionContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("fecha de termino de contrato"));
		valorContratoCL.setCellValueFactory(new PropertyValueFactory<EmpresaContratada, String>("valor contrato"));

		contratos = FXCollections.observableArrayList();
		tablaContratos.setItems(contratos);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		// Inicializamos la tabla
		this.inicializarTablaContratos();
		
		// Ponemos estos dos botones para que no se puedan seleccionar
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

		// Seleccionar las tuplas de la tabla de las empresas
		final ObservableList<EmpresaContratada> tablaContratosSel = tablaContratos.getSelectionModel().getSelectedItems();
		tablaContratosSel.addListener(selectorTablaEmpresas);
		
		// Inicializamos la tabla con algunos datos aleatorios
        for (int i = 0; i < 5; i++) {
            EmpresaContratada c1 = new EmpresaAseo();
            c1.setNombre("Nombre empresa " + i);
            //c1.setTipoEmpresa(tipoEmpresaAseoRB);
            c1.setNumeroContrato("abcd" + i);
            c1.setTelefono(12345 + i);
            c1.setFechaInicio("31/12/2019");
            c1.setFechaTerminacion("12345"+i);
            c1.setValorContrato(2000000000);
            contratos.add(c1);
        }

	}

}
