package isw.proyecto.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/*
 * Esta clase es el controlador de la vista Tablero que es la principal del programa.
 */
public class TableroControlador implements Initializable {

	/*
	 * Panel principal
	 */
    @FXML
    private AnchorPane holderPane;
    
    /*
     * Boton del modulo inicio.
     */
    @FXML
    private JFXButton btnHome;
    
    /*
     * Boton del modulo agenda.
     */
    @FXML
    private JFXButton btnAgenda;
    
    /*
     * Boton del modulo finanzas.
     */
    @FXML
    private JFXButton btnFinanzas;
    
    /*
     * Boton del modulo parqueadero.
     */
    @FXML
    private JFXButton btnParqueadero;
    
    /*
     * Boton del modulo residentes.
     */
    @FXML
    private JFXButton btnResidentes;
    
    /*
     * Boton del modulo empresas.
     */
    @FXML
    private JFXButton btnEmpresas;
    
    /*
     * Boton del modulo reportes.
     */
    @FXML
    private JFXButton btnReportes;
    
    /*
     * Boton del modulo quejas.
     */
    @FXML
    private JFXButton btnQuejas;
    
    /*
     * Boton del modulo configuracioón.
     */
    @FXML
    private JFXButton btnConfig;
    
    /*
     * Variables de tipo AnchorPane para hacer la funcion de cache de todas las vistas en el controlador.
     */
    AnchorPane home, agenda, finanzas, parqueadero, residentes, empresas, reportes, quejas, config;
    
    /*
     * Inicializa la vista y almacena en cache todas los archivos fxml.
     * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Carga todos los archivos fxml en cache
        try {
             home = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Home.fxml"));
             agenda = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Agenda.fxml"));
             finanzas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Finanzas.fxml"));
             parqueadero = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Parqueadero.fxml"));
             residentes = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Residentes.fxml"));
             empresas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Empresas.fxml"));
             reportes = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Reportes.fxml"));
             quejas = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Quejas.fxml"));
             config = FXMLLoader.load(getClass().getResource("/isw/proyecto/vista/Configuracion.fxml"));
             setNode(home);
        } catch (IOException ex) {
            Logger.getLogger(TableroControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
  
    /*
     * Establece el modulo a mostarse en el tablero 
     * @param node el modulo clickeado
     */
    private void setNode(Node node) {
    	if(! holderPane.getChildren().contains(node)) {
    		holderPane.getChildren().clear();
            holderPane.getChildren().add((Node) node);
            FadeTransition ft = new FadeTransition(Duration.millis(1000));
            ft.setNode(node);
            ft.setFromValue(0.1);
            ft.setToValue(1);
            ft.setCycleCount(1);
            ft.setAutoReverse(false);
            ft.play();
    	}    
    }

    /*
     * Cambia de vista a agenda.
     */
    @FXML
    private void switchAgenda(ActionEvent event) {
        setNode(agenda);
    }
    
    /*
     * Cambia de vista a empresas.
     */
    @FXML
    private void switchEmpresas(ActionEvent event) {
        setNode(empresas);
    }
    
    /*
     * Cambia de vista a inicio.
     */
    @FXML
    private void switchHome(ActionEvent event) {
        setNode(home);
    }
    
    /*
     * Cambia de vista a finanzas.
     */
    @FXML
    private void switchFinanzas(ActionEvent event) {
        setNode(finanzas);
    }
    
    /*
     * Cambia de vista a parqueadero.
     */
    @FXML
    private void switchParqueadero(ActionEvent event) {
        setNode(parqueadero);
    }
    
    /*
     * Cambia de vista a reportes.
     */
    @FXML
    private void switchReportes(ActionEvent event) {
        setNode(reportes);
    }
    
    /*
     * Cambia de vista a residentes.
     */
    @FXML
    private void switchResidentes(ActionEvent event) {
        setNode(residentes);
    }

    /*
     * Cambia de vista a quejas.
     */
    @FXML
    private void switchQuejas(ActionEvent event) {
        setNode(quejas);
    }
    
    /*
     * Cambia de vista a configuracion.
     */
    @FXML
    private void switchConfig(ActionEvent event) {
        setNode(config);
    }
}
