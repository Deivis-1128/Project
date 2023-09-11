package Vista;

//---------------------------------------------------
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Actas extends javax.swing.JFrame {

    Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));
    Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Actas() {
        initComponents();
        setTitle("Detalle acta");
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setLocationRelativeTo(this);
        jd_fecha.setCalendar(fecha);
        nombre.setVisible(false);
        apellido.setVisible(false);
        GenerarID();
        btn_generar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")

    //--------------------------------------------------------------------------
    public void GuardarActa() {
        String Sql = "Insert Into detalle_actas (Cedula_e,Id_actas,Tipo_acta,Fecha,Nombre_t,Apellido_t,Cedula_t,Codigo_eqp,Observacion) Values(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedula_e.getText());
            ps.setString(2, txt_Serie.getText());
            ps.setString(4, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(5, nombre.getText());
            ps.setString(6, apellido.getText());
            ps.setString(7, txt_cedulaT.getText());
            ps.setString(8, txt_codigo.getText());
            ps.setString(9, txt_obserbacion.getText());

            if (combox_actas.getSelectedIndex() == 0) {
                combox_actas.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Seleccione un tipo de acta");
            } else {
                ps.setString(3, combox_actas.getSelectedItem().toString());
                combox_actas.setBackground(Color.GREEN);
            }

            ps.execute();

            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            btn_generar.setEnabled(true);
        } catch (Exception e) {
            validarEmpleado();
            validarTecnico();
            validarEquipos();
            JOptionPane.showMessageDialog(null, "El acta " + txt_Serie.getText() + " Que intentas registrar ya existe en la base de datos", "Alerta", 0, icono);

        }

    }
//------------------------------------------------------------------------------

    public void BuscarP() {

        String Sql = "Select Nombre, Apellido From personas Where Cedula=?; ";
        try {

            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedulaT.getText());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre.setText(rs.getString("Nombre"));
                apellido.setText(rs.getString("Apellido"));
            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario " + txt_cedulaT.getText() + " No existe en la base de datos", "", 0, icono);

        }

    }
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------
    public void CodigoNumerico() {
        Random rnd = new Random();
        String Abedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String Cadena = " ";
        int M = 0, Pos = 0, Num;
        while (M < 1) {
            Pos = (int) (rnd.nextDouble() * Abedario.length() - 1 + 0);
            Num = (int) (rnd.nextDouble() * 9999 + 1000);
            Cadena = Cadena + Abedario.charAt(Pos) + Num;
            Pos = (int) (rnd.nextDouble() * Abedario.length() - 1 + 0);
            Cadena = Cadena + Abedario.charAt(Pos);
            txt_Serie.setText(Cadena);
            Cadena = "";
            M++;
        }

    }
//------------------------------------------------------------------------------

    public void GenerarID() {
        Random rnd = new Random();
        //String Abedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String Cadena = " ";
        int M = 0, Pos = 0, Num;
        while (M < 1) {
            Pos = (int) (rnd.nextDouble() + 0 + 0);
            Num = (int) (rnd.nextDouble() * 99999999 + 1000);

            Cadena = Cadena + (Pos) + Num;
            //Pos = (int) (rnd.nextDouble() - 1 + 0);
            //Cadena = Cadena + (Pos);
            txt_Serie.setText(Cadena);
            Cadena = "";
            M++;
        }

    }
//------------------------------------------------------------------------------

    public void validarTecnico() {

        int resul = 0;
        String Cedula = txt_cedulaT.getText();

        String sql = "select * from personas where Cedula='" + Cedula + "' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    txt_cedulaT.setBackground(Color.GREEN);

                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + txt_cedulaT.getText() + " No existe en la base de datos", "", 0, icono);
                txt_cedulaT.setBackground(Color.red);
                btn_generar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void validarEmpleado() {

        int resul = 0;
        String Cedula = txt_cedula_e.getText();

        String sql = "select * from personas where Cedula='" + Cedula + "' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    txt_cedula_e.setBackground(Color.GREEN);

                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + txt_cedula_e.getText() + " No existe en la base de datos", "", 0, icono);
                txt_cedula_e.setBackground(Color.red);
                btn_generar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//-------------------------------------------------------------------------

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
                    txt_codigo.setBackground(Color.GREEN);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El Equipo " + txt_codigo.getText() + " No existe en la base de datos", "", 0, icono);
                txt_codigo.setBackground(Color.red);
                btn_generar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void GenerarReporte() {
        try {

            String path = "/src/Reportes/Empl.jrxml";
            
            //String parametro = JOptionPane.showInputDialog("Ingrese Nombre");
            
            //Map parametros = new HashMap();

           // parametros.put("Nombre", parametro);

            JasperDesign diseño = JRXmlLoader.load(path);

            JasperReport jr = JasperCompileManager.compileReport(diseño);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, com);

            JasperViewer.viewReport(jp);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Error " + ex.getMessage());
        }

    }

    //-----------------------------------------------------------------------------
    public void Limpiar() {

        txt_cedulaT.setText("");
        txt_codigo.setText("");
        txt_obserbacion.setText("");
        combox_actas.setSelectedIndex(0);
        btn_guardar.setEnabled(true);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_obserbacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_cedulaT = new javax.swing.JTextField();
        combox_actas = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txt_Serie = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_generar = new javax.swing.JButton();
        txt_cedula_e = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_obserbacion.setColumns(20);
        txt_obserbacion.setRows(5);
        txt_obserbacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txt_obserbacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 490, 150));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Observación:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 70, 120, -1));

        txt_cedulaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaTActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cedulaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 40, 140, -1));

        combox_actas.setBackground(new java.awt.Color(153, 153, 153));
        combox_actas.setForeground(new java.awt.Color(0, 0, 0));
        combox_actas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de acta", "ACTA DE ENTREGA DE EQUIPO", "ACTA DE DEVOLUCIÓN EQUIPO" }));
        combox_actas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_actasActionPerformed(evt);
            }
        });
        jPanel1.add(combox_actas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 230, -1));

        btn_eliminar.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/polvo.png"))); // NOI18N
        btn_eliminar.setText("Limpiar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 315, -1, -1));

        jd_fecha.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Codigo equipo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        txt_Serie.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        txt_Serie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_Serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 120, 22));

        jLabel7.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("C.c Empleado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 120, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Codigo acta:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 110, -1));

        nombre.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 10, 16));

        apellido.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 10, 16));

        btn_guardar.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 315, -1, -1));

        btn_generar.setBackground(new java.awt.Color(204, 204, 204));
        btn_generar.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        btn_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Adobe.png"))); // NOI18N
        btn_generar.setText("Generar Acta");
        btn_generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 315, -1, -1));

        txt_cedula_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedula_eActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cedula_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("C.c Tecnico:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedulaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaTActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        //Limpiar();
        //GenerarID();
        GenerarReporte();

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        BuscarP();
        GuardarActa();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void combox_actasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_actasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_actasActionPerformed

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        GenerarReporte();
    }//GEN-LAST:event_btn_generarActionPerformed

    private void txt_cedula_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedula_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_eActionPerformed

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
            java.util.logging.Logger.getLogger(Actas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellido;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_generar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JComboBox<String> combox_actas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JLabel nombre;
    public javax.swing.JLabel txt_Serie;
    public javax.swing.JTextField txt_cedulaT;
    public javax.swing.JTextField txt_cedula_e;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextArea txt_obserbacion;
    // End of variables declaration//GEN-END:variables
}
