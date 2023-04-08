
package src.modelo;

public class FlotillaBuses {
    private NodoBus cabeza;

    public FlotillaBuses() {
        cabeza = null;
    }

    // Insertar un bus en la lista ordenada por placa
    public void insertarBus(Bus bus) {
        NodoBus nuevoNodo = new NodoBus(bus);

        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoBus actual = cabeza;
            NodoBus anterior = null;

            while (actual != null && bus.getPlaca().compareTo(actual.getBus().getPlaca()) > 0) {
                anterior = actual;
                actual = actual.getSiguiente();
            }

            if (anterior == null) {
                nuevoNodo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevoNodo);
                cabeza = nuevoNodo;
            } else {
                anterior.setSiguiente(nuevoNodo);
                nuevoNodo.setAnterior(anterior);
                nuevoNodo.setSiguiente(actual);

                if (actual != null) {
                    actual.setAnterior(nuevoNodo);
                }
            }
        }
    }

    // Buscar un bus por placa
    public Bus buscarBus(String placa) {
        NodoBus actual = cabeza;

        while (actual != null) {
            if (actual.getBus().getPlaca().equals(placa)) {
                return actual.getBus();
            }
            actual = actual.getSiguiente();
        }

        return null;
    }

    // Eliminar un bus por placa
    public void eliminarBus(String placa) {
        NodoBus actual = cabeza;

        while (actual != null && !actual.getBus().getPlaca().equals(placa)) {
            actual = actual.getSiguiente();
        }

        if (actual != null) {
            if (actual.getAnterior() != null) {
                actual.getAnterior().setSiguiente(actual.getSiguiente());
            } else {
                cabeza = actual.getSiguiente();
            }
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(actual.getAnterior());
            }
        }
    }
}
