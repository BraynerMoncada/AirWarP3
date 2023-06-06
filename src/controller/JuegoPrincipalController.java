package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;


/**
 * FXML Controller class
 *
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class JuegoPrincipalController implements Initializable {

    String rutaImagen = "src/imagenes/mapaMundi.jpg";
    int alturaMapa=395;
    int anchoMapa=780;
    
    
    @FXML
    private GridPane mapaJuego;
    
    private int contador=0;
     
    private int numAerosyPorta;
   
    private Random random=new Random();
    @FXML
    private ImageView imageFondo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Image image = new Image(new FileInputStream(rutaImagen));
            imageFondo.setImage(image);
            } catch (FileNotFoundException e) {
            System.out.println("Error al cargar la imagen: " + e.getMessage());
        }
        numAerosyPorta = random.nextInt(10) + 6;
        System.out.println(numAerosyPorta + "aeros");
        System.out.println(contador + "conta");
        while (contador < numAerosyPorta) {
            int posX = random.nextInt(11); 
            generarBotones(posX, contador);
            contador++;
            System.out.println(posX+"posx");
        }
    }

    public void generarBotones(int x, int y) {
        Button mapButton = createButton("Pista"); // Cambiar el texto según corresponda
        mapaJuego.add(mapButton, x, y);

    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(42, 10);
        // Agregar funcionalidad de aeropuerto o portaaviones
        return button;
    }
    
}