import java.util.Arrays;
import modelo.grafo;

/**
 * Implementación del algoritmo de Dijkstra para encontrar el camino más corto
 * en un grafo ponderado.
 * @author Brayner Moncada
 * @author Vidal FLores
 * @author Dylan Mesa
 */
public class AlgoritmoDijkstra {

    /**
     * Encuentra el camino más corto desde un nodo de origen a todos los demás nodos
     * en un grafo ponderado.
     *
     * @param graph     Grafo ponderado representado como una instancia de la clase 'grafo'.
     * @param startNode Nodo de origen.
     * @return Un arreglo con los costos mínimos desde el nodo de origen a todos los demás nodos.
     */
    public static int[] dijkstra(grafo graph, int startNode) {
        int numNodes = graph.getNumNodos();
        int[] distances = new int[numNodes];
        boolean[] visited = new boolean[numNodes];

        // Inicializar las distancias como infinito y el nodo de origen como 0
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[startNode] = 0;

        // Iterar hasta que se visiten todos los nodos
        for (int i = 0; i < numNodes - 1; i++) {
            int minNode = findMinDistanceNode(distances, visited);
            visited[minNode] = true;

            // Actualizar las distancias de los nodos adyacentes al nodo actual
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && graph.getPesoArista(minNode, j) != 0 && distances[minNode] != Integer.MAX_VALUE
                        && distances[minNode] + graph.getPesoArista(minNode, j) < distances[j]) {
                    distances[j] = distances[minNode] + graph.getPesoArista(minNode, j);
                }
            }
        }

        return distances;
    }

    /**
     * Encuentra el nodo no visitado con la distancia mínima.
     *
     * @param distances Arreglo de distancias.
     * @param visited   Arreglo que indica si un nodo ha sido visitado o no.
     * @return El nodo no visitado con la distancia mínima.
     */
    private static int findMinDistanceNode(int[] distances, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minNode = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minNode = i;
            }
        }

        return minNode;
    }
}
