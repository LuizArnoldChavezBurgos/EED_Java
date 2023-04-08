package src.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.vista.ModuloCliente;
import src.modelo.Cliente;
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
import java.sql.SQLException;

public class ClienteControlador {
    public static ModuloCliente ventana = new ModuloCliente();
    public static void mostrar() { ventana.setVisible(true);}
    public static void ocultar() { ventana.setVisible(false);}
    
    public ClienteControlador(){
        conectar = new Conexion();
    }
    
    public static void botonoOperadorVolver(String lugar) {
        ocultar();
        if(lugar.compareTo("admin") == 0) {
            AdministradorControlador.mostrar();
        } else {
            OperadorControlador.mostrar();
        }
    }
    
    public void limpiarTabla(JTable tabla){
        DefaultTableModel modelo_1 = (DefaultTableModel) tabla.getModel();
         for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo_1.removeRow(i);
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
    
    public void listarClientes(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();

        String sql = "SELECT * FROM Clientes";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5)
                );
                modelo.addRow(new Object[]{
                        c.getCodigo(),
                        c.getNombreCompleto(),
                        c.getIdentificacion(),
                        c.getCorreoElectronico()
                });
            }
            tabla.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos();
        }
    }
    
    public void agregar(JTextField name, JTextField id, JTextField email, JTextField pass, JTable tabla){
        String sql = "INSERT INTO Clientes (Nombre, Identificacion, Contrasena, Correo) VALUES (?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name.getText());
            ps.setString(2, id.getText());
            ps.setString(3, email.getText());
            ps.setString(4, pass.getText());
            ps.executeUpdate();

            
            JOptionPane.showMessageDialog(ventana, "CLiente agregado con Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(ventana, e);
        } finally {
            cerrarRecursos();
        }
    }
    
    private void asignarValorFilaSeleccionada(JTable tabla, JTextField textField, int columnIndex) {
        textField.setText(tabla.getValueAt(tabla.getSelectedRow(), columnIndex).toString());
    }
    
    public void editar(JTable tabla,JTextField name, JTextField id, JTextField email,JTextField pass){
        int fila = tabla.getSelectedRow();
        
        if (fila == -1){
            JOptionPane.showMessageDialog(ventana, "Debe seleccioanr una fila");
        } else {
            asignarValorFilaSeleccionada(tabla, name, 1);
            asignarValorFilaSeleccionada(tabla, id, 2);
            asignarValorFilaSeleccionada(tabla, email, 3);
            pass.setText("");
        }
    }
    
    public void actualizar(JTable tabla, JTextField name, JTextField id, JTextField email, JTextField pass){
        String sql = "UPDATE Clientes SET Nombre=?, Identificacion=?, Contrasena=?, Correo=? WHERE Codigo=?";

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            return;
        }

        String cod_txt = tabla.getValueAt(fila, 0).toString();
        String pass_txt = pass.getText();

        if (pass_txt.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña está vacía");
            return;
        }

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, name.getText());
            ps.setString(2, id.getText());
            ps.setString(3, pass_txt);
            ps.setString(4, email.getText());
            ps.setString(5, cod_txt);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente actualizado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos();
        }
    }
    
    public void eliminar(JTable tabla) {
        String sql = "DELETE FROM Clientes WHERE Codigo=?";

        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
            return;
        }

        String cod_txt = tabla.getValueAt(fila, 0).toString();

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod_txt);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos();
        }
    }
    
    private PdfPTable crearTablaPdf() {
        PdfPTable tabla = new PdfPTable(4);
        tabla.addCell("codigo_cliente");
        tabla.addCell("nombre_completo");
        tabla.addCell("identificación");
        tabla.addCell("correo_electrónico");
        return tabla;
    }


    private void poblarTablaDesdeBaseDatos(PdfPTable tabla) throws SQLException {
        String sql = "SELECT * FROM Clientes";

        con = conectar.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            tabla.addCell(Integer.toString(rs.getInt(1)));
            tabla.addCell(rs.getString(2));
            tabla.addCell(rs.getString(3));
            tabla.addCell(rs.getString(5));
        }
    }
    
    public void imprimirPdf() {
        String ruta = System.getProperty("user.home") + "/Desktop/Reporte_Clientes.pdf";
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            PdfPTable tabla = crearTablaPdf();
            poblarTablaDesdeBaseDatos(tabla);

            documento.add(tabla);
            documento.close();

            JOptionPane.showMessageDialog(null, "Reporte de clientes generado con éxito");
        } catch (DocumentException | HeadlessException | FileNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            cerrarRecursos();
        }
    }
        
    public void cargarCSV(File archivoCSV) throws SQLException{
        try{
            FileReader fr = new FileReader(archivoCSV);
            BufferedReader reader = new BufferedReader(fr);
            
            ArrayList<Cliente> clientes = new ArrayList<>();
            String line;
            boolean isFirstLine = true;
            
            try{
                while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] row = line.split(",");
                
                int cod_cl = Integer.parseInt(row[0]);
                String name_cl = row[1];
                String id_cl = row[2];
                String pass_cl = row[3];
                String email_cl = row[4];
                
                clientes.add(new Cliente(cod_cl, name_cl, id_cl,pass_cl,email_cl));
            }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                try{
                    reader.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
            
            Object[] obj = new Object[5];
            
            String sql = "INSERT INTO Clientes (Codigo, Nombre, Identificacion, Contrasena, Correo) VALUES (?,?,?,?,?)";
            
            for (int i = 0; i < clientes.size(); i++) {
                obj[0] = clientes.get(i).getCodigo();
                obj[1] = clientes.get(i).getNombreCompleto();
                obj[2] = clientes.get(i).getIdentificacion();
                obj[3] = clientes.get(i).getContraseña();
                obj[4] = clientes.get(i).getCorreoElectronico();
                
                this.con = this.conectar.getConnection();
                this.ps = this.con.prepareStatement(sql);
                this.ps.setString(1, String.valueOf(obj[0]));
                this.ps.setString(2, String.valueOf(obj[1]));
                this.ps.setString(3, String.valueOf(obj[2]));
                this.ps.setString(4, String.valueOf(obj[3]));
                this.ps.setString(5, String.valueOf(obj[4]));
                this.ps.executeUpdate();
                
            }
            
            JOptionPane.showMessageDialog(ventana, "Clientes cargados con éxito");
        }catch(HeadlessException | FileNotFoundException  e){
            JOptionPane.showMessageDialog(ventana, e);
        }
    }
    
    private final Conexion conectar;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private DefaultTableModel modelo = new DefaultTableModel();
}
