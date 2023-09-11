package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class dependencia {

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

    public Vector<dependencia> Mostrar_Dependencias(Integer idEmpresas) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        Vector<dependencia> datos = new Vector<>();
        dependencia dat = null;
        try {

            String sql = "select * from dependencia where idEmpresas="+ idEmpresas;

            ps = com.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new dependencia();
            dat.setId(0);
            dat.setNombre("Seleccione Dependencia");
            datos.add(dat);

            while (rs.next()) {
                dat = new dependencia();
                dat.setId(rs.getInt("idDependencia"));
                dat.setNombre(rs.getString("Dependencia"));
                datos.add(dat);
            }

           // rs.close();

        } catch (Exception e) {
            System.err.println("e");
        }
return datos;
    }

}
