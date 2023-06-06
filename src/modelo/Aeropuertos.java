package modelo;
/**
 * Clase encargada de crear los aeropuertos
 * @author Vidal Flores
 * @author Dylan Meza
 * @author Brayner Moncada
 */
class Aeropuertos {
    private String nombre;
    private int capacidadCombustible;

    public Aeropuertos(String nombre, int capacidadCombustible) {
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
