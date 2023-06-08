package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modelo.Aviones;

/**
 * Control que utiliza un algoritmo Shell Sort para ordenar en pantalla los aviones y 
 *
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class AvionesBuscadorController implements Initializable {

    @FXML
    private Button F35LightningII;
    @FXML
    private Button F22Raptor;
    @FXML
    private Button EurofighterTyphoon;
    @FXML
    private Button SukhoiSu35;
    @FXML
    private Button FA18EFSuperHornet;
    @FXML
    private Button DassaultRafale;
    @FXML
    private Button BoeingF15EStrikeEagle;
    @FXML
    private Button Su30MKI;
    @FXML
    private Button SaabJAS39Gripen;
    @FXML
    private Button F16FightingFalcon;
    @FXML
    private TextField avionesSearch;
    @FXML
    private GridPane gridPane;
    
    // Generar aviones
    Aviones avion = new Aviones("F-35 Lightning II", 20, "+++", "--");
    Aviones avion1 = new Aviones("F-22 Raptor", 15, "++", "---");
    Aviones avion2 = new Aviones("Eurofighter Typhoon", 35, "+", "-");
    Aviones avion3 = new Aviones("Sukhoi Su-35", 18, "++", "---");
    Aviones avion4 = new Aviones("F/A-18E/F Super Hornet", 50, "+", "----");
    Aviones avion5 = new Aviones("Dassault Rafale", 10, "++++", "---");
    Aviones avion6 = new Aviones("Boeing F-15E Strike Eagle", 10, "++++", "---");
    Aviones avion7 = new Aviones("Su-30MKI", 10, "++++", "---");
    Aviones avion8 = new Aviones("Saab JAS 39 Gripen", 10, "++++", "---");
    Aviones avion9 = new Aviones("F-16 Fighting Falcon", 10, "++++", "---");
    
    private List<Button> buttonList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        buttonList = new ArrayList<>();
        buttonList.add(F35LightningII);
        buttonList.add(F22Raptor);
        buttonList.add(EurofighterTyphoon);
        buttonList.add(SukhoiSu35);
        buttonList.add(FA18EFSuperHornet);
        buttonList.add(DassaultRafale);
        buttonList.add(BoeingF15EStrikeEagle);
        buttonList.add(Su30MKI);
        buttonList.add(SaabJAS39Gripen);
        buttonList.add(F16FightingFalcon);

        textoBotones();

        avionesSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            ShellSort(newValue);
        });
    }    

    /**
     * Metodo que le pone texto a los botones
     */
    private void textoBotones() {
        F35LightningII.setText(avion.toString());
        F22Raptor.setText(avion1.toString());
        EurofighterTyphoon.setText(avion2.toString());
        SukhoiSu35.setText(avion3.toString());
        FA18EFSuperHornet.setText(avion4.toString());
        DassaultRafale.setText(avion5.toString());
        BoeingF15EStrikeEagle.setText(avion6.toString());
        Su30MKI.setText(avion7.toString());
        SaabJAS39Gripen.setText(avion8.toString());
        F16FightingFalcon.setText(avion9.toString());
    }

    /**
     * Metodo que ordena los botones
     * @param buscador Texto introducido en el TextField
     */
    private void ShellSort(String buscador) {
        for (int gap = buttonList.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < buttonList.size(); i++) {
                Button temp = buttonList.get(i);
                int j;
                for (j = i; j >= gap && compareButtons(buttonList.get(j - gap), temp, buscador) > 0; j -= gap) {
                    buttonList.set(j, buttonList.get(j - gap));
                }
                buttonList.set(j, temp);
            }
        }
        posicionBoton();
        desactivarBotones(buscador);
    }
    
    /**
     * Compara dos botones en función de su texto y la cadena de búsqueda.
     * 
     * @param button1 El primer botón a comparar.
     * @param button2 El segundo botón a comparar.
     * @param buscador Texto introducido en el TextField
     * @return Resultado de la comparacion del texto del boton1 y el boton2
     */
    private int compareButtons(Button button1, Button button2, String buscador) {
        String texto1 = button1.getText();
        String texto2 = button2.getText();
        return texto1.compareTo(texto2); //Comparar los textos
    }
    
    /**
     * Metodo que desactiva los botones que no coinciden con la busqueda
     * @param buscador Texto introducido en el TextField
     */
    private void desactivarBotones(String buscador) {
        for (Button boton : buttonList) {
            if (boton.getText().toLowerCase().contains(buscador.toLowerCase())) {
                boton.setDisable(false);
            } else {
                boton.setDisable(true);
            }
        }
    }
    
    /**
     * Metodo que mueve los botones de posicion
     */
    private void posicionBoton() {
        gridPane.getChildren().clear();
        int rowIndex = 0;
        for (Button button : buttonList) {
            if (!button.isDisabled()) {
                gridPane.add(button, 0, rowIndex);
                rowIndex++;
            }
        }
    }
    
}
