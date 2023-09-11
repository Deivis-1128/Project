package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class centros_costos {

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

    ////------------------------------  -----------------------------------------------------------
    public String toString() {
        return this.Nombre;
    }

    public Vector<centros_costos> Mostrar_centros_costos(Integer idDos) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        Vector<centros_costos> datos = new Vector<centros_costos>();
        centros_costos dat = null;

        try {

            String sql = "select * from centros_costos where idDos=" + idDos;

            ps = com.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new centros_costos();
            dat.setId(0);
            dat.setNombre("Seleccione Centro-costos");
            datos.add(dat);

            while (rs.next()) {
                dat = new centros_costos();
                dat.setId(rs.getInt("idCentros"));
                dat.setNombre(rs.getString("Centros_costos"));
                datos.add(dat);
            }

           // rs.close();

        } catch (Exception e) {
            System.err.println("e");
        }
        return datos;
    }

}
