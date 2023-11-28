
package Model;

/**
 * @author JUAN RODRIGUEZ
 */
public class Vehicle {
    private int id;
    private String marca;
    private String modelo;
    private double año;
    private String tipo;
    private String disponible;
    

    // Constructor, getters y setters

    public Vehicle(int id, String marca, String modelo,double año, String tipo, String disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.año=año;
        this.tipo = tipo;
        this.disponible = disponible;
        
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }



    public double getAño() {
        return año;
    }

    public void setAño(double año) {
        this.año = año;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

