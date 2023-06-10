package modelo;
/**
 * Clase que crea las rutas posibles
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
class Ruta {
    
    private String origen;
    private String destino;
    private int distancia;
    private int peso;

    /**
     * Contructor de la clase ruta
     * 
     * @param origen De donde se parte
     * @param destino Lugar de destino
     * @param distancia Distancia entre el origen y el destino
     * @param peso peso de la ruta
     */
    public Ruta(String origen, String destino, int distancia, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.peso = peso;
    }

}