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
import modelo.grafo;
import modelo.nodoGrafo;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


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

    private int contador = 0;
    private int numAerosyPorta;
    private Random random = new Random();
    @FXML
    private ImageView imageFondo;
    private grafo AeropuertosPortaaviones;

    /**
     * Initializes the controller class.
     * @param url
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
        System.out.println(numAerosyPorta + " aeropuertos y portaaviones");
        System.out.println(contador + " conta");

        AeropuertosPortaaviones = new grafo(numAerosyPorta);

        while (contador < numAerosyPorta) {
            System.out.println(contador + " esto es contador");
            int posX = random.nextInt(12);

            if (posX >= 0 && posX <= 10 && contador < numAerosyPorta - 1) {
                generarBotonesAeropuerto(posX, contador);
            } else {
                generarBotonesPortaaviones(posX, contador);
            }
            contador++;
            System.out.println(posX);
        }

        generarPistasAleatorias();
    }

    public void generarBotonesAeropuerto(int x, int y) {
        Button mapButton = createButton("Aeropuerto"); // Cambiar el texto según corresponda
        mapaJuego.add(mapButton, x, y);
        nodoGrafo aeropuerto = new nodoGrafo("Aeropuerto", x, y);
        AeropuertosPortaaviones.agregarNodo(aeropuerto);
    }

    public void generarBotonesPortaaviones(int x, int y) {
        Button mapButton = createButton("Portaaviones"); // Cambiar el texto según corresponda
        mapaJuego.add(mapButton, x, y);
        nodoGrafo portaaviones = new nodoGrafo("Portaaviones", x, y);
        AeropuertosPortaaviones.agregarNodo(portaaviones);
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefSize(70, 10);
        // Agregar funcionalidad de aeropuerto o portaaviones
        return button;
    }

    private void generarPistasAleatorias() {
        int numPistas = numAerosyPorta - 1;
        Canvas canvas = new Canvas(mapaJuego.getWidth(), mapaJuego.getHeight());
        canvas.setWidth(mapaJuego.getWidth());
        canvas.setHeight(mapaJuego.getHeight());
        mapaJuego.add(canvas, 0, 0);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < numPistas; i++) {
            int origenIndex = random.nextInt(numAerosyPorta);
            int destinoIndex = random.nextInt(numAerosyPorta);
            if (origenIndex != destinoIndex) {
                nodoGrafo origen = AeropuertosPortaaviones.getNodo(origenIndex);
                nodoGrafo destino = AeropuertosPortaaviones.getNodo(destinoIndex);
                double distancia = calcularDistancia(origen, destino);
                double costoAterrizaje = calcularCostoAterrizaje(destino);
                System.out.println("Pista " + (i + 1) + ": De " + origen.getNombre() + " a " + destino.getNombre()
                        + ", Distancia: " + distancia + ", Costo de aterrizaje en portaaviones: " + costoAterrizaje);
                gc.setStroke(Color.YELLOW); // Establecer el color de la línea
                gc.setLineWidth(2.0); // Establecer el grosor de la línea
                gc.strokeLine(origen.getCoordenadaX(), origen.getCoordenadaY(), destino.getCoordenadaX(), destino.getCoordenadaY());
            }
            
        }
    }

    private double calcularDistancia(nodoGrafo origen, nodoGrafo destino) {
        int x1 = origen.getCoordenadaX();
        int y1 = origen.getCoordenadaY();
        int x2 = destino.getCoordenadaX();
        int y2 = destino.getCoordenadaY();

        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private double calcularCostoAterrizaje(nodoGrafo destino) {
        if (destino.getNombre().equals("Portaaviones")) {
            // Si el destino es un portaaviones, se considera un costo de aterrizaje más alto
            return 1000.0;
        } else {
            // Si el destino es un aeropuerto, se considera un costo de aterrizaje normal
            return 500.0;
        }
    }

}