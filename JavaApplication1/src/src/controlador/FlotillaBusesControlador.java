
package src.controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.modelo.Bus;
import src.modelo.FlotillaBuses;
import src.vista.ModuloFlotillaBuses;

public class FlotillaBusesControlador {
    public static ModuloFlotillaBuses ventana = new ModuloFlotillaBuses();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public FlotillaBusesControlador(){
        conectar = new Conexion();
    }
    
    public static void botonOperadorVolver(String lugar) {
        ocultar();
        if(lugar.compareTo("admin") == 0) {
            AdministradorControlador.mostrar();
        } else {
            OperadorControlador.mostrar();
        }
    }
    public void limpiarTabla(JTable tabla){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
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
    
    public void listarBuses(JTable tabla){
        this.modelo = (DefaultTableModel)tabla.getModel();
        ArrayList<Bus> datos = new ArrayList<>();
        
        String sql = "SELECT * FROM FlotillaBuses";
        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            
            Object[] obj = new Object[5];
            
            while(this.rs.next()){
                Bus b = new Bus();
                b.setPlaca(this.rs.getString(1));
                b.setTipo(this.rs.getString(2));
                b.setCapacidadPasajeros(this.rs.getInt(3));
                b.setColor(this.rs.getString(4));
                b.setEstado(this.rs.getString(5));
                
                datos.add(b);
            }
            
            for (int i = 0; i < datos.size(); i++) {
                obj[0] = datos.get(i).getPlaca();
                obj[1] = datos.get(i).getTipo();
                obj[2] = datos.get(i).getCapacidadPasajeros();
                obj[3] = datos.get(i).getColor();
                obj[4] = datos.get(i).getEstado();
                modelo.addRow(obj);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void agregar(JTextField placa_bus, JComboBox<String> toggle_tipo, JSpinner spiner_capacidad, JTextField color_bus, JComboBox<String> toggle_estado, JTable tabla){
        
        String sql = "INSERT INTO FlotillaBuses (Placa, Tipo, Capacidad, Color, Estado) VALUES (?,?,?,?,?)";
        
        String placa_txt = placa_bus.getText();
        String tipo_txt = (String) toggle_tipo.getSelectedItem();
        String capacidad_txt = Integer.toString((int) spiner_capacidad.getValue());
        String color_txt = color_bus.getText();
        String estado_txt = (String) toggle_estado.getSelectedItem();
        
        System.out.println(tipo_txt);
        
        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, placa_txt);
            this.ps.setString(2, tipo_txt);
            this.ps.setString(3, capacidad_txt);
            this.ps.setString(4, color_txt);
            this.ps.setString(5, estado_txt);
            this.ps.executeUpdate();
            
            JOptionPane.showMessageDialog(ventana, "Bus agregado con éxito");
        } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void editar(JTable tabla, JTextField placa_bus, JComboBox<String> toggle_tipo, JSpinner spiner_capacidad, JTextField color_bus, JComboBox<String> toggle_estado){
        int fila = tabla.getSelectedRow();

        if (fila == -1){
            JOptionPane.showMessageDialog(ventana, "Debe seleccionar una fila");
        } else {
            String placa_txt = tabla.getValueAt(fila, 0).toString();
            String tipo_txt = tabla.getValueAt(fila, 1).toString();
            String capacidad_txt = tabla.getValueAt(fila, 2).toString();
            String color_txt = tabla.getValueAt(fila, 3).toString();
            String estado_txt = tabla.getValueAt(fila, 4).toString();

            placa_bus.setText(placa_txt);
            toggle_tipo.setSelectedItem(tipo_txt);
            spiner_capacidad.setValue(Integer.parseInt(capacidad_txt));
            color_bus.setText(color_txt);
            toggle_estado.setSelectedItem(estado_txt);
        }
    }
    
    public void actualizar(JTable tabla, JTextField placa_bus, JComboBox<String> toggle_tipo, JSpinner spiner_capacidad, JTextField color_bus, JComboBox<String> toggle_estado){
        String sql = "UPDATE FlotillaBuses set Placa=?, Tipo=?, Capacidad=?, Color=?, Estado=? WHERE Placa=?";
        
        String placa_txt = placa_bus.getText();
        String tipo_txt = (String) toggle_tipo.getSelectedItem();
        String capacidad_txt = Integer.toString((int) spiner_capacidad.getValue());
        String color_txt = color_bus.getText();
        String estado_txt = (String) toggle_estado.getSelectedItem();

        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, placa_txt);
            this.ps.setString(2, tipo_txt);
            this.ps.setString(3, capacidad_txt);
            this.ps.setString(4, color_txt);
            this.ps.setString(5, estado_txt);
            this.ps.setString(6, placa_txt);
            this.ps.executeUpdate();

            JOptionPane.showMessageDialog(ventana, "Bus actualizado con éxito");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void eliminar(JTable tabla) {
        String sql = "DELETE FROM FlotillaBuses WHERE Placa=?";
        int fila = tabla.getSelectedRow();

        String placa_txt = tabla.getValueAt(fila, 0).toString();

        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, placa_txt);
            this.ps.executeUpdate();

            JOptionPane.showMessageDialog(ventana, "Bus eliminado con éxito");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void cargarCSV(File archivoCSV) throws SQLException {
        try {
            FileReader fr = new FileReader(archivoCSV);
            BufferedReader reader = new BufferedReader(fr);

            ArrayList<Bus> buses = new ArrayList<>();
            String line;
            boolean isFirstLine = true;

            try {
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    String[] row = line.split(",");

                    String placa = row[0];
                    String tipo = row[1];
                    int capacidad = Integer.parseInt(row[2]);
                    String color = row[3];
                    String estado = row[4];

                    buses.add(new Bus(placa, tipo, capacidad, color, estado));
                }
            } catch (IOException | NumberFormatException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            Object[] obj = new Object[5];

            String sql = "INSERT INTO FlotillaBuses (Placa, Tipo, Capacidad, Color, Estado) VALUES (?, ?, ?, ?, ?)";

            for (Bus bus : buses) {
                obj[0] = bus.getPlaca();
                obj[1] = bus.getTipo();
                obj[2] = bus.getCapacidadPasajeros();
                obj[3] = bus.getColor();
                obj[4] = bus.getEstado();

                this.con = this.conectar.getConnection();
                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, String.valueOf(obj[0]));
                this.ps.setString(2, String.valueOf(obj[1]));
                this.ps.setInt(3, (int) obj[2]);
                this.ps.setString(4, String.valueOf(obj[3]));
                this.ps.setString(5, String.valueOf(obj[4]));
                this.ps.executeUpdate();

            }

            JOptionPane.showMessageDialog(ventana, "Buses cargados con éxito");
        } catch (HeadlessException | FileNotFoundException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    private PdfPTable crearTablaPdf() {
        PdfPTable tabla = new PdfPTable(5);
        tabla.addCell("Placa_Buses");
        tabla.addCell("Tipo_Buses");
        tabla.addCell("Capacidad_Buses");
        tabla.addCell("Color_Buses");
        tabla.addCell("Estado_Buses");
        return tabla;
    }


    private void poblarTablaDesdeBaseDatos(PdfPTable tabla) throws SQLException {
        String sql = "SELECT * FROM FlotillaBuses";

        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            tabla.addCell(rs.getString(1));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
            tabla.addCell(rs.getString(4));
            tabla.addCell(rs.getString(5));
        }
    }
    
    public void imprimirPdf() {
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Buses.pdf";
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            PdfPTable tabla = crearTablaPdf();
            poblarTablaDesdeBaseDatos(tabla);

            documento.add(tabla);
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de Buses generado con éxito");
        } catch (DocumentException | HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos();
        }
    }

    private final Conexion conectar;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel modelo = new DefaultTableModel();
}