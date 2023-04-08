
package src.controlador;

import src.vista.Operador;

public class OperadorControlador {
    public static Operador ventana = new Operador();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public static void botonoOperadorVolver() {
        ocultar();
        PrincipalControlador.mostrar();
    }
    
    public static void operacionesClientes() {
        ocultar();
        ClienteControlador.mostrar();
    }
    
    public static void operacionesTicket() {
        ocultar();
        GeneracionTicketControlador.mostrar();
    }
}
