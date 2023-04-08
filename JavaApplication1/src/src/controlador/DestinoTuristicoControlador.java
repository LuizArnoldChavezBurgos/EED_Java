
package src.controlador;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.vista.ModuloDestinoTuristico;
import src.modelo.DestinoTuristico;

public class DestinoTuristicoControlador {
    public static ModuloDestinoTuristico ventana = new ModuloDestinoTuristico();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public DestinoTuristicoControlador(){
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
    
    public void listarDestinos(JTable tabla) {
        this.modelo = (DefaultTableModel) tabla.getModel();
        ArrayList<DestinoTuristico> datos = new ArrayList<>();

        String sql = "SELECT * FROM Destinos";
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

    public void agregar(JTextField name_des, JDateChooser date_chooser, JTextField costo_des, JComboBox<String> estado_des, JTextArea descri_des, JTable tabla) {
        String sql = "INSERT INTO Destinos (Nombre, Fecha_salida, Costo_persona, Estado, Descripcion) VALUES (?,?,?,?,?)";

        String nombre_txt = name_des.getText();
        java.util.Date fecha_salida_txt = date_chooser.getDate();
        String costo_persona_txt = costo_des.getText();
        String estado_txt = (String) estado_des.getSelectedItem();
        String descripcion_txt = descri_des.getText();

        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, nombre_txt);
            this.ps.setDate(2, new java.sql.Date(fecha_salida_txt.getTime())); // Convert java.util.Date to java.sql.Date
            this.ps.setBigDecimal(3, new BigDecimal(costo_persona_txt));
            this.ps.setString(4, estado_txt);
            this.ps.setString(5, descripcion_txt);
            this.ps.executeUpdate();

            JOptionPane.showMessageDialog(ventana, "Destino agregado con éxito");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void editar(JTable tabla, JTextField name_des, JDateChooser date_chooser, JTextField costo_des, JComboBox<String> estado_des, JTextArea descri_des) {
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(ventana, "Debe seleccionar un destino turístico en la tabla");
        } else {
            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            String nombre_txt = tabla.getValueAt(fila, 1).toString();
            String fecha_salida_txt = tabla.getValueAt(fila, 2).toString();
            String costo_persona_txt = tabla.getValueAt(fila, 3).toString();
            String estado_txt = tabla.getValueAt(fila, 4).toString();
            String descripcion_txt = tabla.getValueAt(fila, 5).toString();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                java.util.Date fecha_salida = sdf.parse(fecha_salida_txt);
                date_chooser.setDate(fecha_salida);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(ventana, e);
            }

            name_des.setText(nombre_txt);
            costo_des.setText(costo_persona_txt);
            estado_des.setSelectedItem(estado_txt);
            descri_des.setText(descripcion_txt);
        }
    }
    
    public void actualizar(JTable tabla, JTextField name_des, JDateChooser date_chooser, JTextField costo_des, JComboBox<String> estado_des, JTextArea descri_des) {
        
        String sql = "UPDATE Destinos SET Nombre=?, Fecha_salida=?, Costo_persona=?, Estado=?, Descripcion=? WHERE Codigo=?";
        
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            return;
        }
        
        int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
        String nombre_txt = name_des.getText();
        java.util.Date fecha_salida_txt = date_chooser.getDate();
        String costo_persona_txt = costo_des.getText();
        String estado_txt = (String) estado_des.getSelectedItem();
        String descripcion_txt = descri_des.getText();

        try {
            this.con = this.conectar.getConnection();
            this.ps = this.con.prepareStatement(sql);
            this.ps.setString(1, nombre_txt);
            this.ps.setDate(2, new java.sql.Date(fecha_salida_txt.getTime())); // Convert java.util.Date to java.sql.Date
            this.ps.setBigDecimal(3, new BigDecimal(costo_persona_txt));
            this.ps.setString(4, estado_txt);
            this.ps.setString(5, descripcion_txt);
            this.ps.setInt(6, id);
            this.ps.executeUpdate();

            JOptionPane.showMessageDialog(ventana, "Destino turístico actualizado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    public void elimimar(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        if (fila == -1){
          JOptionPane.showMessageDialog(ventana, "Debe seleccionar Destino Turistico");
        } else {
            String sql = "DELETE FROM Destinos WHERE Codigo=?";
            int id = Integer.parseInt(tabla.getValueAt(fila, 0).toString());
            
            try {
                this.con = this.conectar.getConnection();
                this.ps = this.con.prepareStatement(sql);
                this.ps.setInt(1, id);
                this.ps.executeUpdate();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(ventana, e);
            }
            
        }
    }
    
    public void cargarCSV(File archivoCSV) {
        try {
            FileReader fr = new FileReader(archivoCSV);
            BufferedReader reader = new BufferedReader(fr);

            ArrayList<DestinoTuristico> destinos = new ArrayList<>();
            String line;
            boolean isFirstLine = true;

            try {
                while ((line = reader.readLine()) != null) {
                    if (isFirstLine) {
                        isFirstLine = false;
                        continue;
                    }
                    String[] row = line.split(",");

                    int codigo = Integer.parseInt(row[0]);
                    String nombreLugar = row[1];
                    String fechaSalida = row[2];
                    double costoPorPersona = Double.parseDouble(row[3]);
                    String estado = row[4];
                    String descripcionGeneral = row[5];

                    destinos.add(new DestinoTuristico(codigo, nombreLugar, fechaSalida, costoPorPersona, estado, descripcionGeneral));
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

            String sql = "INSERT INTO Destinos (Codigo, Nombre, Fecha_salida, Costo_persona, Estado, Descripcion) VALUES (?, ?, ?, ?, ?, ?)";

            for (DestinoTuristico destino : destinos) {
                this.con = this.conectar.getConnection();
                this.ps = this.con.prepareStatement(sql);
                this.ps.setInt(1, destino.getCodigo());
                this.ps.setString(2, destino.getNombreLugar());
                this.ps.setString(3, destino.getFechaSalida());
                this.ps.setDouble(4, destino.getCostoPorPersona());
                this.ps.setString(5, destino.getEstado());
                this.ps.setString(6, destino.getDescripcionGeneral());
                this.ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(ventana, "Destinos turísticos cargados con éxito");
        } catch (HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    
    private PdfPTable crearTablaPdf() {
        PdfPTable tabla = new PdfPTable(6);
        tabla.addCell("Codigo_Destinos");
        tabla.addCell("Nombre_Destinos");
        tabla.addCell("Fecha_salida_Destinos");
        tabla.addCell("Costo_persona_Destinos");
        tabla.addCell("Estado_Destinos");
        tabla.addCell("Descripcion_Destinos");
        return tabla;
    }

    private void poblarTablaDesdeBaseDatos(PdfPTable tabla) throws SQLException {
        String sql = "SELECT * FROM Destinos";

        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            tabla.addCell(rs.getString(1));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
            tabla.addCell(rs.getString(4));
            tabla.addCell(rs.getString(5));
            tabla.addCell(rs.getString(6));
        }
    }

    public void imprimirPdf() {
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Destinos.pdf";
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            PdfPTable tabla = crearTablaPdf();
            poblarTablaDesdeBaseDatos(tabla);

            documento.add(tabla);
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de Destinos generado con éxito");
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
