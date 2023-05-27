/**
 * Clase encargada de crear los aviones
 */
class Avion {
    private String tipo;
    private int velocidad;
    private int eficiencia;
    private int fortaleza;
    private String destino;
    //agregar ruta(puede ser en una lista)

    public Avion(String tipo, int velocidad, int eficiencia, int fortaleza) {
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.eficiencia = eficiencia;
        this.fortaleza = fortaleza;
        this.destino = null;

    }

    // Otros métodos y getters/setters

}