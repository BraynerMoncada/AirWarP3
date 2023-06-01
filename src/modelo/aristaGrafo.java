package modelo;

/**
 * Clase que representa una arista en un grafo.
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class aristaGrafo {
    private int origen;
    private int destino;
    private int peso;

    /**
     * Constructor de la clase AristaGrafo.
     *
     * @param origen  Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @param peso    Peso de la arista.
     */
    public aristaGrafo(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    /**
     * Obtiene el índice del nodo de origen de la arista.
     *
     * @return Índice del nodo de origen.
     */
    public int getOrigen() {
        return origen;
    }

    /**
     * Obtiene el índice del nodo de destino de la arista.
     *
     * @return Índice del nodo de destino.
     */
    public int getDestino() {
        return destino;
    }

    /**
     * Obtiene el peso de la arista.
     *
     * @return Peso de la arista.
     */
    public int getPeso() {
        return peso;
    }
}

