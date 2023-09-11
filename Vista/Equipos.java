package Vista;

import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;

import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author deivi
 */
public class Equipos extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    /**
     * Creates new form Equipos
     */
    public Equipos() {
        initComponents();
        this.setLocationRelativeTo(this);
        j_fecha2.setCalendar(fecha);
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());

        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
//--------------------------------------------------------------------------------------------

    public void Limpiar() {
        conbo_clas.setSelectedIndex(0);
        txt_marca.setText("");
        txt_modelo.setText("");
        txt_codigoml.setText("");
        txt_orden.setText("");
        txt_proveedor.setText("");
        txt_tarifa.setText("");
        txt_Contacto.setText("");
        txt_cpu.setText("");
        txt_ram.setText("");
        txt_almacenamiento.setText("");
        conbo_red1.setSelectedIndex(0);
    }

    //---------------------------------------------------------------------------------------
    public void Registrar_equipos() {
        Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));

        String Sql = "Insert Into recepcion_equipos (Clase,Marca,Modelo,Codigo,Orden_instalacion,Fecha_alta,Proveedor,Nombre_contacto,Cpu,Ram,Almacenamiento,Tarjeta_red,Tarifa)  Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);

            ps.setString(1, conbo_clas.getSelectedItem().toString());
            ps.setString(2, txt_marca.getText());
            ps.setString(3, txt_modelo.getText());
            ps.setString(4, txt_codigoml.getText());
            ps.setString(5, txt_orden.getText());
            ps.setString(6, ((JTextField) j_fecha2.getDateEditor().getUiComponent()).getText());
            ps.setString(7, txt_proveedor.getText());
            ps.setString(8, txt_Contacto.getText());
            ps.setString(9, txt_cpu.getText());
            ps.setString(10, txt_ram.getText());
            ps.setString(11, txt_almacenamiento.getText());
            ps.setString(12, conbo_red1.getSelectedItem().toString());
            ps.setString(13, txt_tarifa.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso", "Aviso", 0, icon);
        } catch (Exception e) {

        }

    }
//-------------------------------------------------------------------------------------------------------

    public void ValidarCajas() {

        if (conbo_clas.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione Una Clase De Equipo");
        }
        if (txt_marca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Espesificar Una Marca De Equipo");
        }
        if (txt_codigoml.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Asignar Un Codigo De Equipo");
        }
        if (txt_orden.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Asignar La Orden De Instalación Del Equipo");
        }

    }

    //---->>>Fin del Metodo Insertar.
    public void validarEquipos() {

        int resul = 0;

        String Codigo = txt_codigoml.getText();

        String SQL = "select * from recepcion_equipos where Codigo='" + Codigo + "'";

        try {
            java.sql.Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    JOptionPane.showMessageDialog(null, "El Equipo ya existe en la base de datos  " + txt_codigoml.getText());
                }

            } else {

            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_marca = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txt_codigoml = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_orden = new javax.swing.JTextField();
        j_fecha2 = new com.toedter.calendar.JDateChooser();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_tarifa = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txt_Contacto = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txt_almacenamiento = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_cpu = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_ram = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txt_proveedor = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        conbo_clas = new javax.swing.JComboBox<>();
        conbo_red1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Equipos");
        setMinimumSize(new java.awt.Dimension(830, 470));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(830, 470));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 255));
        jLabel24.setText("Clase:");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 59, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Clase:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, 59, -1));

        txt_marca.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_marca.setForeground(new java.awt.Color(0, 0, 0));
        txt_marca.setBorder(null);
        txt_marca.setOpaque(true);
        txt_marca.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_marca.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 220, 25));

        txt_modelo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_modelo.setForeground(new java.awt.Color(0, 0, 0));
        txt_modelo.setBorder(null);
        txt_modelo.setOpaque(true);
        txt_modelo.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_modelo.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 220, 25));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Modelo:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, -1));

        jLabel26.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 255));
        jLabel26.setText("Codigo:");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        txt_codigoml.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_codigoml.setForeground(new java.awt.Color(0, 0, 0));
        txt_codigoml.setBorder(null);
        txt_codigoml.setOpaque(true);
        txt_codigoml.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_codigoml.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_codigoml, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 130, 25));

        jLabel25.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 255));
        jLabel25.setText("Marca:");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, -1));

        jLabel27.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 255));
        jLabel27.setText("Orden de Instalacion:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 180, -1));

        txt_orden.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_orden.setForeground(new java.awt.Color(0, 0, 0));
        txt_orden.setBorder(null);
        txt_orden.setOpaque(true);
        txt_orden.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_orden.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 110, 25));

        j_fecha2.setForeground(new java.awt.Color(0, 0, 0));
        j_fecha2.setDateFormatString("dd/MM/yyyy");
        j_fecha2.setMinSelectableDate(null);
        jPanel3.add(j_fecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 140, -1));

        jLabel28.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 255));
        jLabel28.setText("fecha alta:");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 100, -1));

        jLabel29.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 255));
        jLabel29.setText("Tarifa:");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 60, -1));

        txt_tarifa.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_tarifa.setForeground(new java.awt.Color(0, 0, 0));
        txt_tarifa.setBorder(null);
        txt_tarifa.setOpaque(true);
        txt_tarifa.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_tarifa.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 130, 25));

        jLabel30.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText("Nombre Contacto:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 160, -1));

        txt_Contacto.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_Contacto.setForeground(new java.awt.Color(0, 0, 0));
        txt_Contacto.setBorder(null);
        txt_Contacto.setOpaque(true);
        txt_Contacto.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_Contacto.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_Contacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 220, 25));

        jLabel32.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 255));
        jLabel32.setText("Almacenamiento:");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 150, -1));

        txt_almacenamiento.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_almacenamiento.setForeground(new java.awt.Color(0, 0, 0));
        txt_almacenamiento.setBorder(null);
        txt_almacenamiento.setOpaque(true);
        txt_almacenamiento.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_almacenamiento.setSelectionColor(new java.awt.Color(0, 153, 255));
        txt_almacenamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_almacenamientoActionPerformed(evt);
            }
        });
        jPanel3.add(txt_almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 220, 25));

        jLabel33.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 255));
        jLabel33.setText("Cpu:");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 37, -1));

        txt_cpu.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_cpu.setForeground(new java.awt.Color(0, 0, 0));
        txt_cpu.setBorder(null);
        txt_cpu.setOpaque(true);
        txt_cpu.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_cpu.setSelectionColor(new java.awt.Color(0, 153, 255));
        txt_cpu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpuActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 220, 25));

        jLabel34.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setText("Memoria Ram:");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 120, -1));

        txt_ram.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_ram.setForeground(new java.awt.Color(0, 0, 0));
        txt_ram.setBorder(null);
        txt_ram.setOpaque(true);
        txt_ram.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_ram.setSelectionColor(new java.awt.Color(0, 153, 255));
        txt_ram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ramActionPerformed(evt);
            }
        });
        jPanel3.add(txt_ram, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 220, 25));

        jLabel35.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 255));
        jLabel35.setText("Proveedor:");
        jPanel3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 100, -1));

        txt_proveedor.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_proveedor.setForeground(new java.awt.Color(0, 0, 0));
        txt_proveedor.setBorder(null);
        txt_proveedor.setOpaque(true);
        txt_proveedor.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_proveedor.setSelectionColor(new java.awt.Color(0, 153, 255));
        jPanel3.add(txt_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 190, 25));

        jLabel36.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 255));
        jLabel36.setText("Tarjeta de Red:");
        jPanel3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 130, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Regitro De  Computadores");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Registrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/laptop_(black).png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        conbo_clas.setBackground(new java.awt.Color(51, 255, 255));
        conbo_clas.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        conbo_clas.setForeground(new java.awt.Color(0, 0, 0));
        conbo_clas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Laptop", "Desktop" }));
        conbo_clas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conbo_clasActionPerformed(evt);
            }
        });
        jPanel3.add(conbo_clas, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 170, -1));

        conbo_red1.setBackground(new java.awt.Color(51, 255, 255));
        conbo_red1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        conbo_red1.setForeground(new java.awt.Color(0, 0, 0));
        conbo_red1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ethernet", "Wi-Fi", "Ethernet y Wi-Fi" }));
        conbo_red1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conbo_red1ActionPerformed(evt);
            }
        });
        jPanel3.add(conbo_red1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 170, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_almacenamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_almacenamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_almacenamientoActionPerformed

    private void txt_cpuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpuActionPerformed

    private void txt_ramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ramActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        // Cerra();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ValidarCajas();
        validarEquipos();
        Registrar_equipos();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void conbo_clasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbo_clasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conbo_clasActionPerformed

    private void conbo_red1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbo_red1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conbo_red1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> conbo_clas;
    public javax.swing.JComboBox<String> conbo_red1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    public com.toedter.calendar.JDateChooser j_fecha2;
    public javax.swing.JTextField txt_Contacto;
    public javax.swing.JTextField txt_almacenamiento;
    public javax.swing.JTextField txt_codigoml;
    public javax.swing.JTextField txt_cpu;
    public javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_modelo;
    public javax.swing.JTextField txt_orden;
    public javax.swing.JTextField txt_proveedor;
    public javax.swing.JTextField txt_ram;
    public javax.swing.JTextField txt_tarifa;
    // End of variables declaration//GEN-END:variables
}
