
package src.modelo;

public class ArbolClientes {
    private NodoCliente raiz;

    public ArbolClientes() {
        raiz = null;
    }

    // Insertar un cliente en el árbol
    public void insertarCliente(Cliente cliente) {
        raiz = insertar(raiz, cliente);
    }

    private NodoCliente insertar(NodoCliente nodo, Cliente cliente) {
        if (nodo == null) {
            return new NodoCliente(cliente);
        }

        if (cliente.getCodigo() < nodo.getCliente().getCodigo()) {
            nodo.setIzquierda(insertar(nodo.getIzquierda(), cliente));
        } else if (cliente.getCodigo() > nodo.getCliente().getCodigo()) {
            nodo.setDerecha(insertar(nodo.getDerecha(), cliente));
        }

        return nodo;
    }

    // Buscar un cliente por código
    public Cliente buscarCliente(int codigo) {
        NodoCliente nodo = buscar(raiz, codigo);
        return nodo != null ? nodo.getCliente() : null;
    }

    private NodoCliente buscar(NodoCliente nodo, int codigo) {
        if (nodo == null || nodo.getCliente().getCodigo() == codigo) {
            return nodo;
        }

        if (codigo < nodo.getCliente().getCodigo()) {
            return buscar(nodo.getIzquierda(), codigo);
        }

        return buscar(nodo.getDerecha(), codigo);
    }

    // Eliminar un cliente por código
    public void eliminarCliente(int codigo) {
        raiz = eliminar(raiz, codigo);
    }

    private NodoCliente eliminar(NodoCliente nodo, int codigo) {
        if (nodo == null) {
            return nodo;
        }

        if (codigo < nodo.getCliente().getCodigo()) {
            nodo.setIzquierda(eliminar(nodo.getIzquierda(), codigo));
        } else if (codigo > nodo.getCliente().getCodigo()) {
            nodo.setDerecha(eliminar(nodo.getDerecha(), codigo));
        } else {
            // El nodo con el código dado se encuentra
            // Caso 1: Nodo con solo un hijo o sin hijos
            if (nodo.getIzquierda() == null) {
                return nodo.getDerecha();
            } else if (nodo.getDerecha() == null) {
                return nodo.getIzquierda();
            }

            // Caso 2: Nodo con dos hijos
            // Obtener el sucesor en orden (el nodo más pequeño en la subárbol derecha)
            nodo.setCliente(buscarSucesor(nodo.getDerecha()));

            // Eliminar el sucesor en orden
            nodo.setDerecha(eliminar(nodo.getDerecha(), nodo.getCliente().getCodigo()));
        }

        return nodo;
    }

    private Cliente buscarSucesor(NodoCliente nodo) {
        Cliente sucesor = nodo.getCliente();
        while (nodo.getIzquierda() != null) {
            sucesor = nodo.getIzquierda().getCliente();
            nodo = nodo.getIzquierda();
        }
        return sucesor;
    }
}
