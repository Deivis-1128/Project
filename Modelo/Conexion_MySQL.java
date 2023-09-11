package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion_MySQL {
 String Driver = "com.mysql.cj.jdbc.Driver";
    String Url = "jdbc:mysql://Localhost:3306/java";
    String Usuario = "root";
    String Password = "23008606amy";
    
    
            
    Connection com = getConexion();

    public Connection getConexion() {

        try {
            try {
                Class.forName(Driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion_MySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            com = DriverManager.getConnection(Url, Usuario, Password);
               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Sin Conexion a la base de datos ");
        }
        return com;

    }

}
