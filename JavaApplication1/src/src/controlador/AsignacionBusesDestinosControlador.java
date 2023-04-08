
package src.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static src.controlador.DestinoTuristicoControlador.ocultar;
import static src.controlador.DestinoTuristicoControlador.ventana;
import src.modelo.DestinoTuristico;
import src.vista.ModuloAsignacionBusesDestinos;

public class AsignacionBusesDestinosControlador {
    public static ModuloAsignacionBusesDestinos ventana = new ModuloAsignacionBusesDestinos();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public static void botonOperadorVolver(String lugar) {
        ocultar();
        if(lugar.compareTo("admin") == 0) {
            AdministradorControlador.mostrar();
        } else {
            OperadorControlador.mostrar();
        }
    }
    
    private void cerrarRecursos() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public AsignacionBusesDestinosControlador(){
        conectar = new Conexion();
    }
    
    public void listarDestinos(JTable tabla) {
        this.modelo = (DefaultTableModel) tabla.getModel();
        ArrayList<DestinoTuristico> datos = new ArrayList<>();

        String sql = "SELECT * FROM AsigBusDestino";
        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            Object[] obj = new Object[6];

            while (this.rs.next()) {

                DestinoTuristico d = new DestinoTuristico(
                    this.rs.getInt(1),
                    this.rs.getString(2),
                    this.rs.getString(3),
                    this.rs.getDouble(4),
                    this.rs.getString(5),
                    this.rs.getString(6)
                );

                datos.add(d);
            }
            
            for (int i = 0; i < datos.size(); i++) {
                obj[0] = datos.get(i).getCodigo();
                obj[1] = datos.get(i).getNombreLugar();
                obj[2] = datos.get(i).getFechaSalida();
                obj[3] = datos.get(i).getCostoPorPersona();
                obj[4] = datos.get(i).getEstado();
                obj[5] = datos.get(i).getDescripcionGeneral();
                modelo.addRow(obj);
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    
    private final Conexion conectar;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel modelo = new DefaultTableModel();
}
