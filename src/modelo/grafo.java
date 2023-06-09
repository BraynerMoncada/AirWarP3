package modelo;

/**
 * Clase que representa un grafo.
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
public class grafo {
    private int numNodos;
    private nodoGrafo[] nodos;
    private int[][] matrizAdyacencia;
    public int length;

    /**
     * Constructor de la clase Grafo.
     *
     * @param numNodos Cantidad de nodos del grafo.
     */
    public grafo(int numNodos) {
        this.numNodos = numNodos;
        this.nodos = new nodoGrafo[numNodos];
        this.matrizAdyacencia = new int[numNodos][numNodos];

        // Inicializar la matriz de adyacencia con valores predeterminados (0 indica ausencia de arista)
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
    }

    

    /**
     * Obtiene el número de nodos del grafo.
     *
     * @return Número de nodos.
     */
    public int getNumNodos() {
        return numNodos;
    }

    /**
     * Obtiene un nodo específico del grafo.
     *
     * @param indice Índice del nodo.
     * @return Nodo correspondiente al índice especificado.
     */
    public nodoGrafo getNodo(int indice) {
        return nodos[indice];
    }

    /**
     * Establece un nodo en una posición específica del grafo.
     *
     * @param indice Índice del nodo.
     * @param nodo   Nodo a establecer.
     */
    public void setNodo(int indice, nodoGrafo nodo) {
        nodos[indice] = nodo;
    }

    /**
     * Obtiene el peso de una arista entre dos nodos del grafo.
     *
     * @param origen  Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @return Peso de la arista.
     */
    public int getPesoArista(int origen, int destino) {
        return matrizAdyacencia[origen][destino];
    }

    /**
     * Establece el peso de una arista entre dos nodos del grafo.
     *
     * @param origen  Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @param peso    Peso de la arista.
     */
    public void setPesoArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }
    
    /**
     * Agrega un nodo al grafo.
     *
     * @param nodo Nodo a agregar.
     */
    public void agregarNodo(nodoGrafo nodo) {
        // Buscar el siguiente índice disponible en el arreglo de nodos
        int indice = 0;
        while (indice < numNodos && nodos[indice] != null) {
            indice++;
        }
        
        if (indice < numNodos) {
            nodos[indice] = nodo;
        } else {
            // No hay más espacio disponible para agregar nodos
            // Puedes lanzar una excepción o mostrar un mensaje de error
        }
    }
    
    /**
     * Agrega una arista al grafo.
     *
     * @param origen  Índice del nodo de origen.
     * @param destino Índice del nodo de destino.
     * @param peso    Peso de la arista.
     */
    public void agregarArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
    }
}
