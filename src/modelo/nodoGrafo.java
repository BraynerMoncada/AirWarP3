package modelo;

/**
 * Clase que representa un nodo en un grafo.
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class nodoGrafo {
    private String nombre;

    /**
     * Constructor de la clase NodoGrafo.
     *
     * @param nombre Nombre del nodo.
     */
    public nodoGrafo(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del nodo.
     *
     * @return Nombre del nodo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del nodo.
     *
     * @param nombre Nombre del nodo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
