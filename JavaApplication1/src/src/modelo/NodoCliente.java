
package src.modelo;

public class NodoCliente {
    private Cliente cliente;
    private NodoCliente izquierda;
    private NodoCliente derecha;

    public NodoCliente(Cliente cliente) {
        this.cliente = cliente;
        this.izquierda = null;
        this.derecha = null;
    }

    // Getters y setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public NodoCliente getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoCliente izquierda) {
        this.izquierda = izquierda;
    }

    public NodoCliente getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoCliente derecha) {
        this.derecha = derecha;
    }

    
}

