package modelo;

/**
 * Clase que representa un nodo en un grafo.
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class nodoGrafo {
    private String nombre;
    private int coordenadaX;
    private int coordenadaY;

    /**
     * Constructor de la clase NodoGrafo.
     *
     * @param nombre      Nombre del nodo.
     * @param coordenadaX Coordenada X del nodo.
     * @param coordenadaY Coordenada Y del nodo.
     */
    public nodoGrafo(String nombre, int coordenadaX, int coordenadaY) {
        this.nombre = nombre;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
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

    /**
     * Obtiene la coordenada X del nodo.
     *
     * @return Coordenada X del nodo.
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Establece la coordenada X del nodo.
     *
     * @param coordenadaX Coordenada X del nodo.
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * Obtiene la coordenada Y del nodo.
     *
     * @return Coordenada Y del nodo.
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Establece la coordenada Y del nodo.
     *
     * @param coordenadaY Coordenada Y del nodo.
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
}