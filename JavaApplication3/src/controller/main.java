package controller;

import java.awt.geom.Rectangle2D;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import ServidorSockets.Servidor;

/**
 * Metodo principal que corre el juego
 *
 *@author Vidal Flores
 */
public class main extends Application {



    /**
     * se declara el contructor del metodo main para poder hacer ejecutable el
     * proyecto
     *
     * @param args se envian los argumentos y comandos de linea
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    /**
     * Método principal que genera el hilo necesario para poder ejecutar la GUI
     * y todos sus elementos.
     *
     * @param stage se envia como parametro el escenario de la GUI
     *
     */
    public void start(Stage stage) throws Exception {
        
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


/*
        Servidor servidor = new Servidor(8080);
        Thread hiloServidor = new Thread(servidor);
        hiloServidor.start();
     }
*/
    }
}
