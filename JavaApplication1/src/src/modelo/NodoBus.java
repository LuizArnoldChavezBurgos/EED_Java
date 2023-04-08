
package src.modelo;

public class NodoBus {
    private Bus bus;
    private NodoBus anterior;
    private NodoBus siguiente;

    public NodoBus(Bus bus) {
        this.bus = bus;
        this.anterior = null;
        this.siguiente = null;
    }

    // Getters y setters

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public NodoBus getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoBus anterior) {
        this.anterior = anterior;
    }

    public NodoBus getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBus siguiente) {
        this.siguiente = siguiente;
    }
    
}

