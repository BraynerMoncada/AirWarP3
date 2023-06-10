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
    
    /**
     * Contructor de la clase Aeropuertos
     * @param nombre nombre del aeripuerto
     * @param capacidadCombustible capacidad que tiene el aeropuerto de entregar combustible
     */
    public Aeropuertos(String nombre, int capacidadCombustible) {
        this.nombre = nombre;
        this.capacidadCombustible = capacidadCombustible;
    }

    /**
     * Obtener el nombre
     * @return nombre del aeropuerto
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Metodo que le da nombre al aeropuerto
     * @param nombre nombre del aeripuerto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener la capacidad de combustible
     * @return capacidad de combustible 
     */
    public int getCapacidadCombustible() {
        return capacidadCombustible;
    }
    
    /**
     * Metodo que le da la cantidad de combustible que puede proporsionar el aeropuerto
     * @param capacidadCombustible capacidad de combustible
     */
    public void setCapacidadCombustible(int capacidadCombustible) {
        this.capacidadCombustible = capacidadCombustible;
    }
}
