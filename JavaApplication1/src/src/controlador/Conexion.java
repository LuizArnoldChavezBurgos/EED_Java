
package src.controlador;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/AgenciaTransporte","root","example");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public Connection getConnection() {
        return this.con;
    }
}
