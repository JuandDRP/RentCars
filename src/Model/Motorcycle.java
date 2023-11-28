
package Model;

/*
 * @author Krsna Gutierrez
 */
public class Motorcycle extends Vehicle {
    private double cilindraje;
    private int capacidad;
    private double precio_dia;

    public Motorcycle(double cilindraje, int capacidad, double precio_dia, int id, String marca, String modelo, double año, String tipo, String disponible) {
        super(id, marca, modelo, año, tipo, disponible);
        this.cilindraje = cilindraje;
        this.capacidad = capacidad;
        this.precio_dia = precio_dia;
    }

    public double getPrecio_dia() {
        return precio_dia;
    }

    public void setPrecio_dia(double precio_dia) {
        this.precio_dia = precio_dia;
    }
    


    public double getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(double cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    
}
