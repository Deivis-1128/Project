
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Unidad_negocios {
    private int Id;
    private String Nombre;

///-------------------------------------------------------------------------------------------

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

    public Vector<Unidad_negocios> Mostrar_Unidad_negocios(Integer idCentros) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        Vector<Unidad_negocios> datos = new Vector<Unidad_negocios>();
        Unidad_negocios dat = null;

        try {

            String sql = "SELECT * FROM unidad_negocios where idCentros="+ idCentros;

            ps = com.prepareStatement(sql);
            rs = ps.executeQuery();

            dat = new Unidad_negocios();
            dat.setId(0);
            dat.setNombre("Seleccione Und_negocio");
            datos.add(dat);

            while (rs.next()) {
                dat = new Unidad_negocios();
                dat.setId(rs.getInt("idUnidad"));
                dat.setNombre(rs.getString("unidad_negocios"));
                datos.add(dat);
            }

           // rs.close();

        } catch (Exception e) {
            System.err.println("e");
        }
return datos;
    }
    
}
