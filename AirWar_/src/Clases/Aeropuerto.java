/**
 * Clase encargada de crear los aeropuertos
 */
class Aeropuerto {
    private String nombre;
    private int capacidadCombustible;

    public Aeropuerto(String nombre, int capacidadCombustible) {
        this.nombre = nombre;
        this.capacidadCombustible = capacidadCombustible;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para capacidadCombustible
    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }

    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }

    // Otros métodos

}
