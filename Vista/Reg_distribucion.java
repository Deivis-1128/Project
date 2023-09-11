package Vista;

import Mas_FRM.*;
import Vista.*;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Reg_distribucion extends javax.swing.JFrame {

    Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
    Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Reg_distribucion() {

        initComponents();
        txt_clase.setVisible(false);
        txt_marca.setVisible(false);
        txt_modelo.setVisible(false);
        txt_serial.setVisible(false);
        txt_host.setVisible(false);
        txt_nombre.setVisible(false);
        btn_guardar.setEnabled(false);
        jd_fecha.setCalendar(fecha);
        setIconImage(new ImageIcon(getClass().getResource("/Img/la-red.png")).getImage());
        setLocationRelativeTo(this);
    }

    //------------------------------------------------------------------------------------------------
    public void Agregar_distribucion() {
        String Sql = "Insert Into distribucion(Clase,Marca,Modelo,Codigo,Serial,Hostname,Usuario,Clave,Nombre,Cedula,Estado,Fecha,Codigo_acta) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
        Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

        String Clave = String.valueOf(txt_clave.getPassword());
        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_clase.getText());
            ps.setString(2, txt_marca.getText());
            ps.setString(3, txt_modelo.getText());
            ps.setString(4, txt_codigo.getText());
            ps.setString(5, txt_serial.getText());
            ps.setString(6, txt_host.getText());
            ps.setString(7, txt_usuario.getText());
            ps.setString(8, Clave);
            ps.setString(9, txt_nombre.getText());
            ps.setString(10, txt_cedula.getText());
            ps.setString(12, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(13, txt_Idactas.getText());
            
            if (combox_estado.getSelectedIndex()==0) {
                combox_estado.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Debe selecciona un tipo de estado");
            } else {
                 ps.setString(11, combox_estado.getSelectedItem().toString());
                 combox_estado.setBackground(Color.GREEN);
            }
            
            ps.execute();

            JOptionPane.showMessageDialog(null, "Registros Exitoso", "", 0, icon);

        } catch (Exception e) {
JOptionPane.showMessageDialog(null, "Error de registro"+ e.getMessage() );

        }

    }
//--------------------------------------------------------------------------------------------------------------------

    public void BuscarPersona() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from personas where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedula.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("Nombre"));
                txt_cedula.setText(rs.getString("Cedula"));

            } else {

            }

        } catch (Exception e) {

        }

    }
//---------------------------------------------------------------------------------------------------------------------

    public void validarPersonas() {

        int resul = 0;
        String Cedula = txt_cedula.getText();

        String sql = "select * from personas where Cedula='" + Cedula + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {

                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + txt_cedula.getText() + " No existe en la base de datos", "", 0, icono);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//-------------------------------------------------------------------------------------------------------------------

    public void BuscarSoftware() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from software_equipos where Codigo=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_codigo.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_serial.setText(rs.getString("Serial"));
                txt_host.setText(rs.getString("Hostname"));

            } else {

            }

        } catch (Exception e) {

        }

    }

    //--------------------------------------------------------------------------------------------------------------------
    public void validarSoftware() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String SQL = "select * from software_equipos where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    btn_guardar.setEnabled(true);
                  
                }

            } else {

                JOptionPane.showMessageDialog(null, "El Equipo " + txt_codigo.getText() + " No ha sido configurado\nVerifique en ¡software y configursciones!", "", 0, icono);

            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------------------------------------

    public void BuscarEquipos() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from recepcion_equipos where Codigo=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_codigo.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_clase.setText(rs.getString("Clase"));
                txt_marca.setText(rs.getString("Marca"));
                txt_modelo.setText(rs.getString("Modelo"));

            } else {

            }

        } catch (Exception e) {

        }

    }

//------------------------------------------------------------------------------------------------------------
    public void validarEquipos() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String SQL = "select * from recepcion_equipos where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {

                }

            } else {

                JOptionPane.showMessageDialog(null, "El Equipo " + txt_codigo.getText() + " No existe en la base de datos", "", 0, icono);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//--------------------------------------------------------------------------------------------------------------------

    public void validarDistribucion() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String Sql = "select * from distribucion where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    JOptionPane.showMessageDialog(null, "El equipo " + txt_codigo.getText() + " Ya esta asignado ha otro usuario\nPara hacer una nueva asignacion\nPrimero debe de eliminarlo de\n¡Distribución!", "Alerta", 0, icono);
                    btn_guardar.setEnabled(false);
                  
                }

            }

        } catch (SQLException ex) {

        }

    }
//--------------------------------------------------------------------------------------------------------------------

    public void Limpiar() {
        txt_clase.setText("");
        txt_marca.setText("");
        txt_modelo.setText("");
        txt_serial.setText("");
        txt_host.setText("");
        txt_nombre.setText("");
        txt_cedula.setText("");
        txt_codigo.setText("");
        txt_clave.setText("");
        txt_usuario.setText("");
        txt_Idactas.setText("");
        combox_estado.setSelectedIndex(0);
        btn_guardar.setEnabled(false);
    }
//-------------------------------------------------------------------------------------------------------------------
    public void validarId_act() {

        int resul = 0;

        String Codigo = txt_Idactas.getText();

        String SQL = "select * from detalle_actas where Id_actas='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    btn_guardar.setEnabled(true);
               
                }

            } else {

                JOptionPane.showMessageDialog(null, "El codigo de acta " + txt_Idactas.getText() + " Que intenta ingresar \nNo exixte en la base de datos", "", 0, icono);
                   btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_nombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_host = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_serial = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        combox_estado = new javax.swing.JComboBox<>();
        btn_guardar = new javax.swing.JButton();
        btn_Validar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        txt_clave = new javax.swing.JPasswordField();
        btn_limpiar = new javax.swing.JButton();
        txt_modelo = new javax.swing.JTextField();
        txt_clase = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_Idactas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/red-de-distribucion.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 255, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel2.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 10, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Usuario:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 80, -1));
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 160, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Cod-Acta:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, -1));
        jPanel2.add(txt_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 10, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Clave:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 60, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Codigo:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 70, -1));
        jPanel2.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 160, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Fecha:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 60, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Estado:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 70, -1));
        jPanel2.add(txt_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 10, -1));
        jPanel2.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, -1));

        combox_estado.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        combox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Activo" }));
        jPanel2.add(combox_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 160, -1));

        btn_guardar.setBackground(new java.awt.Color(204, 204, 204));
        btn_guardar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 132, -1));

        btn_Validar.setBackground(new java.awt.Color(204, 204, 204));
        btn_Validar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_Validar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/correccion.png"))); // NOI18N
        btn_Validar.setText("Validar");
        btn_Validar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ValidarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 132, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/red-de-distribucion.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jd_fecha.setDateFormatString("dd/MM/yyyy");
        jPanel2.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 160, -1));
        jPanel2.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 160, -1));

        btn_limpiar.setBackground(new java.awt.Color(204, 204, 204));
        btn_limpiar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 132, -1));
        jPanel2.add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 10, -1));
        jPanel2.add(txt_clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 10, -1));
        jPanel2.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 10, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setText("Distribución");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));
        jPanel2.add(txt_Idactas, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Cedula:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        Agregar_distribucion();
        Limpiar();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void btn_ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ValidarActionPerformed
        BuscarPersona();
        BuscarEquipos();
        BuscarSoftware();
        validarPersonas();
        validarEquipos();
        validarSoftware();
        validarDistribucion();
        validarId_act();

    }//GEN-LAST:event_btn_ValidarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("W".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reg_distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reg_distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reg_distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reg_distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reg_distribucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Validar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JComboBox<String> combox_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    public com.toedter.calendar.JDateChooser jd_fecha;
    public javax.swing.JTextField txt_Idactas;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_clase;
    public javax.swing.JPasswordField txt_clave;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_host;
    public javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_modelo;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_serial;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
