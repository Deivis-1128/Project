package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Empresas {

    private int Id;
    private String Nombre;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    

    public String toString() {
        return this.Nombre;
    }

    public Vector<Empresas> Mostrar_Empresas() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        Vector<Empresas> datos = new Vector<>();
        Empresas dat = null;
        try {

            String sql = "select * from Empresas";

            ps = com.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Empresas();    
            dat.setId(0);
            dat.setNombre("Seleccione Empresas");
            datos.add(dat);

            while (rs.next()) {
                dat = new Empresas();
                dat.setId(rs.getInt("idEmpresas"));
                dat.setNombre(rs.getString("Empresas"));
                datos.add(dat);
            }

            //rs.close();

        } catch (Exception e) {
            System.err.println("e");
        }
return datos;
    }

}
