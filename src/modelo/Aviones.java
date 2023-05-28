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
    private String consumo;

    /**
     * Constructor de la clase Aviones
     * @param nombre nombre que tendra el avion
     * @param velocidad la velocidad que tendra el avion
     * @param fortaleza la fortaleza del avion, representada con barras
     * @param consumo el consumo del avion representado con simbolos + y -
     */
    public Aviones(String nombre, int velocidad, String fortaleza, String consumo) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.fortaleza = fortaleza;
        this.consumo = consumo;
    }
    
    /**
     * metodo para imprimir los aviones con sus respectivos atributos
     * @return un string que contiene los atributos del avion
     */
    @Override
    public String toString() {
        return "Aviones{" + "nombre=" + nombre + 
               "velocidad=" + velocidad + 
               "fortaleza=" + fortaleza +
               "consumo=" + consumo + '}';
    }

}