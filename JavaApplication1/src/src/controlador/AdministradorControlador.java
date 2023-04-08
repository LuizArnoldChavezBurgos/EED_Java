
package src.controlador;

import src.vista.Administrador;

public class AdministradorControlador {
    public static Administrador ventana = new Administrador();
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
    
    public static void operacionesBuses() {
        ocultar();
        FlotillaBusesControlador.mostrar();
    }
    
    public static void operacionesDestinos() {
        ocultar();
        DestinoTuristicoControlador.mostrar();
    }
    
    public static void operacionesDestinosBuses() {
        ocultar();
        AsignacionBusesDestinosControlador.mostrar();
    }
}
