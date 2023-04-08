
package src.modelo;

public class Bus {
    private String placa;
    private String tipo;
    private int capacidadPasajeros;
    private String color;
    private String estado;

    public Bus(String placa, String tipo, int capacidadPasajeros, String color, String estado) {
        this.placa = placa;
        this.tipo = tipo;
        this.capacidadPasajeros = capacidadPasajeros;
        this.color = color;
        this.estado = estado;
    }
    
    public Bus() {
    }

    // Getters y setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


