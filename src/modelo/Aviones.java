package modelo;

/**
 * Clase que genera los distintos aviones
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class Aviones {
    
    /**
     * Atributos de la clase Aviones
     */
    private String nombre;
    private int velocidad;
    private String fortaleza;
    private String eficiencia;

    /**
     * Constructor de la clase Aviones
     * 
     * @param nombre nombre que tendra el avion
     * @param velocidad la velocidad que tendra el avion
     * @param fortaleza la fortaleza del avion, representada con barras
     * @param eficiencia el consumo del avion representado con simbolos + y -
     */
    public Aviones(String nombre, int velocidad, String fortaleza, String eficiencia) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.fortaleza = fortaleza;
        this.eficiencia = eficiencia;
    }

    /**
     * Metodo para obtener el nombre del avion
     * @return nombre del avion
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para obtener la eficiencia del avion
     * @return eficiencia del avion
     */
    public String getEficiencia(){
        return eficiencia;
    }
    
    /**
     * Metodo para obtener la velocidad del avion
     * @return velocidad del avion
     */
    public int getVelocidad(){
        return velocidad;
    }
    
    /**
     * metodo para imprimir los aviones con sus respectivos atributos
     * 
     * @return un string que contiene los atributos del avion
     */
    @Override
    public String toString() {
        return "Avion: " + nombre + "\n" +
               "velocidad: " + velocidad + "Km/h" + ". Fortaleza: " + fortaleza + ". Consumo: " + eficiencia;
    }

}