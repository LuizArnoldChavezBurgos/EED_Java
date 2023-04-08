
package src.controlador;

import src.vista.ModuloPrincipal;

public class PrincipalControlador {
    public static ModuloPrincipal ventana = new ModuloPrincipal();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public static void botonPrincipalAdministrador() {
        ocultar();
        AdministradorControlador.mostrar();
    }
    
    public static void botonPrincipalOperador() {
        ocultar();
        OperadorControlador.mostrar();
    }
}
