
package src.controlador;

import src.vista.ModuloGeneracionTicket;

public class GeneracionTicketControlador {
    public static ModuloGeneracionTicket ventana = new ModuloGeneracionTicket();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
}
