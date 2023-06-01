package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Controlador del menu del juego
 *
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class MenuPlayController implements Initializable {


    @FXML
    private Button play;
    @FXML
    private Button exit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void playBtn(ActionEvent event) throws IOException {
        javafx.geometry.Rectangle2D pantalla = Screen.getPrimary().getVisualBounds();
        
        Parent rootMenuJuego = FXMLLoader.load(getClass().getResource("/vista/menuPrincipalJuego.fxml"));
        Scene sceneMenuJuego = new Scene(rootMenuJuego);
        Stage stageMenuJuego = new Stage();
        stageMenuJuego.setTitle("Menú principal");
        stageMenuJuego.setScene(sceneMenuJuego);
        stageMenuJuego.setX(pantalla.getMinX() + 100); // Colocar la ventana a 100 píxeles de la izquierda
        stageMenuJuego.setY(pantalla.getMinY() + 100); // Colocar la ventana a 100 píxeles desde la parte superior

        Parent rootControlador = FXMLLoader.load(getClass().getResource("/vista/menuPrincipalControladorAereo.fxml"));
        Scene sceneControlador = new Scene(rootControlador);
        Stage stageControlador = new Stage();
        stageControlador.setTitle("Menú principal Controlador Aereo");
        stageControlador.setScene(sceneControlador);
        stageControlador.setX(stageMenuJuego.getX() + 620); // Colocar la ventana a la derecha del maestro con un espacio de 20 píxeles
        stageControlador.setY(pantalla.getMinY() + 100); // Colocar la ventana a la misma altura que el maestro
        
        stageMenuJuego.show();
        stageControlador.show();
        
        Button botonPresionado = (Button) event.getSource();
        Stage ventana = (Stage) botonPresionado.getScene().getWindow();
        ventana.close();
    }

    @FXML
    private void exitBtn(ActionEvent event) {
        Button botonPresionado = (Button) event.getSource();
        Stage ventana = (Stage) botonPresionado.getScene().getWindow();
        ventana.close();
    }

}