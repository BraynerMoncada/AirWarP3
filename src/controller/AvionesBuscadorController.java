package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    Aviones avion = new Aviones("F-35 Lightning II", 1900, "Alta", "----");
    Aviones avion1 = new Aviones("F-22 Raptor", 2410, "Media/Baja", "--");
    Aviones avion2 = new Aviones("Eurofighter Typhoon", 2495, "Baja", "+++");
    Aviones avion3 = new Aviones("Sukhoi Su-35", 2770, "Baja", "+++");
    Aviones avion4 = new Aviones("F/A-18E/F Super Hornet", 1950, "Media/Alta", "++");
    Aviones avion5 = new Aviones("Dassault Rafale", 1800, "Alta", "---");
    Aviones avion6 = new Aviones("Boeing F-15E Strike Eagle", 3017, "Baja", "++++");
    Aviones avion7 = new Aviones("Su-30MKI", 2120, "Media/Alta", "--");
    Aviones avion8 = new Aviones("Saab JAS 39 Gripen", 2470, "Media", "+");
    Aviones avion9 = new Aviones("F-16 Fighting Falcon", 2315, "Media", "-");
    
    private List<Button> buttonList;
    @FXML
    private Button busquedaBtn;
    @FXML
    private Button shellBtn;
    @FXML
    private Button insertionBtn;
    
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
        
        gridPane.setDisable(true);
        textoBotones();

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
                for (j = i; j >= gap && compareButtonsShell(buttonList.get(j - gap), temp, buscador) > 0; j -= gap) {
                    buttonList.set(j, buttonList.get(j - gap));
                }
                buttonList.set(j, temp);
            }
        }
        posicionBoton();
        desactivarBotones(buscador, "shell");
    }
    
     /**
     * Método que implementa el algoritmo de ordenamiento por inserción para buscar la velocidad.
     * @param buscador Texto introducido en el TextField.
     */
    private void insertionSort(String buscador) {
        for (int i = 1; i < buttonList.size(); i++) {
            Button temp = buttonList.get(i);
            int j = i - 1;
            while (j >= 0 && compareButtonsInsertion(buttonList.get(j), temp, buscador) > 0) {
                buttonList.set(j + 1, buttonList.get(j));
                j--;
            }
            buttonList.set(j + 1, temp);
        }
        posicionBoton();
        desactivarBotones(buscador, "insertion");
    }
    
    /**
    * Aplica el algoritmo de búsqueda para encontrar el nombre de los aviones.
    *
    * @param buscador Texto introducido en el TextField.
    */
   private void buscaqueda(String buscador) {
       for (int gap = buttonList.size() / 2; gap > 0; gap /= 2) {
           for (int i = gap; i < buttonList.size(); i++) {
               Button temp = buttonList.get(i);
               int j;
               for (j = i; j >= gap && compareButtonsBusqueda(buttonList.get(j - gap), temp, buscador) > 0; j -= gap) {
                   buttonList.set(j, buttonList.get(j - gap));
               }
               buttonList.set(j, temp);
           }
       }
       posicionBoton();
       desactivarBotones(buscador, "busqueda");
    }

    /**
     * Compara dos botones en función de su texto y la cadena de búsqueda.
     * 
     * @param button1 El primer botón a comparar.
     * @param button2 El segundo botón a comparar.
     * @param buscador Texto introducido en el TextField
     * @return Resultado de la comparacion del texto del boton1 y el boton2
     */
    private int compareButtonsShell(Button button1, Button button2, String buscador) {
        String texto1 = getEficienciaAvion(button1);
        String texto2 = getEficienciaAvion(button2);
        return texto1.compareTo(texto2);
    }
    
    /**
     * Compara dos botones en función de su texto y la cadena de búsqueda.
     * 
     * @param button1 El primer botón a comparar.
     * @param button2 El segundo botón a comparar.
     * @param buscador Texto introducido en el TextField
     * @return Resultado de la comparacion del texto del boton1 y el boton2
     */
    private int compareButtonsInsertion(Button button1, Button button2, String buscador) {
        Integer texto1 = getVelocidadAvion(button1);
        Integer texto2 = getVelocidadAvion(button2);
        return texto1.compareTo(texto2);
    }
    
    /**
     * Compara dos botones en función de su texto y la cadena de búsqueda.
     * 
     * @param button1 El primer botón a comparar.
     * @param button2 El segundo botón a comparar.
     * @param buscador Texto introducido en el TextField
     * @return Resultado de la comparacion del texto del boton1 y el boton2
     */
    private int compareButtonsBusqueda(Button button1, Button button2, String buscador) {
        String texto1 = getNombreAvion(button1);
        String texto2 = getNombreAvion(button2);
        return texto1.compareTo(texto2);
    }

    /**
     * Metodo que busca la eficiencia del Avion
     * 
     * @param button boton del que se sacan los datos
     * @return eficiencia del avion
     */
    private String getEficienciaAvion(Button button) {
        String text = button.getText();
        if (text.equals(avion.toString())) {
            return avion.getEficiencia();
        } else if (text.equals(avion1.toString())) {
            return avion1.getEficiencia();
        } else if (text.equals(avion2.toString())) {
            return avion2.getEficiencia();
        } else if (text.equals(avion3.toString())) {
            return avion3.getEficiencia();
        } else if (text.equals(avion4.toString())) {
            return avion4.getEficiencia();
        } else if (text.equals(avion5.toString())) {
            return avion5.getEficiencia();
        } else if (text.equals(avion6.toString())) {
            return avion6.getEficiencia();
        } else if (text.equals(avion7.toString())) {
            return avion7.getEficiencia();
        } else if (text.equals(avion8.toString())) {
            return avion8.getEficiencia();
        } else if (text.equals(avion9.toString())) {
            return avion9.getEficiencia();
        }
        return null;
    }
    
    /**
     * Metodo que busca el nombre del Avion
     * 
     * @param button boton del que se sacan los datos
     * @return nombre del avion
     */
    private String getNombreAvion(Button button) {
        String text = button.getText();
        if (text.equals(avion.toString())) {
            return avion.getNombre();
        } else if (text.equals(avion1.toString())) {
            return avion1.getNombre();
        } else if (text.equals(avion2.toString())) {
            return avion2.getNombre();
        } else if (text.equals(avion3.toString())) {
            return avion3.getNombre();
        } else if (text.equals(avion4.toString())) {
            return avion4.getNombre();
        } else if (text.equals(avion5.toString())) {
            return avion5.getNombre();
        } else if (text.equals(avion6.toString())) {
            return avion6.getNombre();
        } else if (text.equals(avion7.toString())) {
            return avion7.getNombre();
        } else if (text.equals(avion8.toString())) {
            return avion8.getNombre();
        } else if (text.equals(avion9.toString())) {
            return avion9.getNombre();
        }
        return null;
    }
    
    /**
     * Metodo que busca la velocidad del Avion
     * 
     * @param button boton del que se sacan los datos
     * @return velocidad del avion
     */
    private int getVelocidadAvion(Button button) {
        String text = button.getText();
        if (text.equals(avion.toString())) {
            return avion.getVelocidad();
        } else if (text.equals(avion1.toString())) {
            return avion1.getVelocidad();
        } else if (text.equals(avion2.toString())) {
            return avion2.getVelocidad();
        } else if (text.equals(avion3.toString())) {
            return avion3.getVelocidad();
        } else if (text.equals(avion4.toString())) {
            return avion4.getVelocidad();
        } else if (text.equals(avion5.toString())) {
            return avion5.getVelocidad();
        } else if (text.equals(avion6.toString())) {
            return avion6.getVelocidad();
        } else if (text.equals(avion7.toString())) {
            return avion7.getVelocidad();
        } else if (text.equals(avion8.toString())) {
            return avion8.getVelocidad();
        } else if (text.equals(avion9.toString())) {
            return avion9.getVelocidad();
        } else {
            return 0;
        }
}
    
    /**
     * Metodo que desactiva los botones que no coinciden con la busqueda
     * @param buscador Texto introducido en el TextField
     * @param algoritmo String del nombre del algoritmo que usara
     */
    private void desactivarBotones(String buscador, String algoritmo) {
        if(algoritmo == "shell"){
            for (Button boton : buttonList) {
                String eficienciaAvion = getEficienciaAvion(boton);
                if (eficienciaAvion.toLowerCase().contains(buscador.toLowerCase())) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        }else if(algoritmo == "busqueda"){
            for (Button boton : buttonList) {
                String nombreAvion = getNombreAvion(boton);
                if (nombreAvion.toLowerCase().contains(buscador.toLowerCase())) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
            }
        }else if(algoritmo == "insertion"){
            for (Button boton : buttonList) {
                int velocidadAvion = getVelocidadAvion(boton);
                if (String.valueOf(velocidadAvion).toLowerCase().contains(buscador.toLowerCase())) {
                    boton.setDisable(false);
                } else {
                    boton.setDisable(true);
                }
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

    /**
     * Accion del boton de busqueda
     * @param event al hacer click
     */
    @FXML
    private void busqueda(ActionEvent event) {
        busquedaBtn.setDisable(true);
        gridPane.setDisable(false);
        shellBtn.setDisable(false);
        insertionBtn.setDisable(false);
        avionesSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            buscaqueda(newValue);
        });
    }

    /**
     * Accion del boton de shell
     * @param event al hacer click
     */
    @FXML
    private void shellSort(ActionEvent event) {
        busquedaBtn.setDisable(false);
        gridPane.setDisable(false);
        shellBtn.setDisable(true);
        insertionBtn.setDisable(false);
        avionesSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            ShellSort(newValue);
        });
    }

    /**
     * Accion del boton de insertion
     * @param event al hacer click
     */
    @FXML
    private void insertionSort(ActionEvent event) {
        busquedaBtn.setDisable(false);
        gridPane.setDisable(false);
        shellBtn.setDisable(false);
        insertionBtn.setDisable(true);
        avionesSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            insertionSort(newValue);
        });
    }
    
}
