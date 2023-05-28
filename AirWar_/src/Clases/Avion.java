/**
 * Clase encargada de crear los aviones
 */
class Avion {
    private String tipo;
    private int velocidad;
    private int eficiencia;
    private int fortaleza;
    private String destino;

    public Avion(String tipo, int velocidad, int eficiencia, int fortaleza) {
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.eficiencia = eficiencia;
        this.fortaleza = fortaleza;
        this.destino = null;
    }

    // Getter y Setter para velocidad
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    // Getter y Setter para eficiencia
    public int getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    // Getter y Setter para fortaleza
    public int getFortaleza() {
        return fortaleza;
    }

    public void setFortaleza(int fortaleza) {
        this.fortaleza = fortaleza;
    }

    // Getter y Setter para destino
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Otros métodos

}
