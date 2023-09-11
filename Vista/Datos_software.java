package Vista;

import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Datos_software extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
//----------------------------------------------------------------------------------------

    public Datos_software() {
        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        this.setLocationRelativeTo(this);
        Estillos();
        Contar();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

//-------------------------------------------------------------------------------------------------------------------
    public void Estillos() {
        tbl_soft.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tbl_soft.getTableHeader().setOpaque(false);
        tbl_soft.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_soft.getTableHeader().setBackground(new Color(0, 0, 255));

        setTitle("Configuraciones");

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        CargarDatos();

    }

//---------------------------------------------------------------------------------------------------------------------------
    private void Cerra() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/codificacion.png"));

        String Botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desea Cerra esta Ventana", "Cerra", 0, 0, icono, Botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.err.println("Se cancelo el cierre");
        }
    }

//------------------------------------------------------------------------------------------
    public void CargarDatos() {
        String[] Titulos = {"Hostname", "Serial", "Codigo", "Sistema oprerativo", "Office", "Adobe", "Actualizacion_driver", "Cifrado_unida_bitlocker", "One_driver", "Baan", "Cofiguracion_impresora", "Outlook", "Java", "Global_protec", "Smart_view", "Cliente_oracle", "Software_especial", "Damaware"};
        String[] Registros = new String[18];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "Select* from software_equipos";

        try {

            try {
                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(Sql);

                while (rs.next()) {
                    Registros[0] = rs.getString("Hostname");
                    Registros[1] = rs.getString("Serial");
                    Registros[2] = rs.getString("Codigo");
                    Registros[3] = rs.getString("Sistema_operativo");
                    Registros[4] = rs.getString("Office");
                    Registros[5] = rs.getString("Adobe_reader");
                    Registros[6] = rs.getString("Actualizacion_controladores");
                    Registros[7] = rs.getString("Cifrado_unida_bitlocker");
                    Registros[8] = rs.getString("One_driver");
                    Registros[9] = rs.getString("Configuracion_baan");
                    Registros[10] = rs.getString("Cofiguracion_impresora");
                    Registros[11] = rs.getString("Configracion_outlook");
                    Registros[12] = rs.getString("Java");
                    Registros[13] = rs.getString("Global_protec");
                    Registros[14] = rs.getString("Smart_view");
                    Registros[15] = rs.getString("Cliente_oracle");
                    Registros[16] = rs.getString("Software_especial");
                    Registros[17] = rs.getString("Damaware");

                    modelo.addRow(Registros);
                }

                tbl_soft.setModel(modelo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
            }

        } catch (Exception e) {
        }

    }

    //-----------------------------------------------------------------------------------------
    public void Encabezados() {

        tbl_soft.setBackground(new Color(0, 255, 66
        ));
        tbl_soft.setForeground(new Color(0, 147, 255
        ));

    }
//-----------------------------------------------------------------------------------------------

    public void Buscar(String V) {
        String[] Titulos = {"Hostname", "Serial", "Codigo", "Sistema oprerativo", "Office", "Adobe", "Actualizacion_driver", "Cifrado_unida_bitlocker", "One_driver", "Baan", "Cofiguracion_impresora", "Outlook", "Java", "Global_protec", "Smart_view", "Cliente_oracle", "Software_especial", "Damaware"};
        String[] Registros = new String[18];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM software_equipos WHERE  Codigo LIKE '%" + V + "%' ";

        try {

            try {
                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(Sql);

                while (rs.next()) {
                    Registros[0] = rs.getString("Hostname");
                    Registros[1] = rs.getString("Serial");
                    Registros[2] = rs.getString("Codigo");
                    Registros[3] = rs.getString("Sistema_operativo");
                    Registros[4] = rs.getString("Office");
                    Registros[5] = rs.getString("Adobe_reader");
                    Registros[6] = rs.getString("Actualizacion_controladores");
                    Registros[7] = rs.getString("Cifrado_unida_bitlocker");
                    Registros[8] = rs.getString("One_driver");
                    Registros[9] = rs.getString("Configuracion_baan");
                    Registros[10] = rs.getString("Cofiguracion_impresora");
                    Registros[11] = rs.getString("Configracion_outlook");
                    Registros[12] = rs.getString("Java");
                    Registros[13] = rs.getString("Global_protec");
                    Registros[14] = rs.getString("Smart_view");
                    Registros[15] = rs.getString("Cliente_oracle");
                    Registros[16] = rs.getString("Software_especial");
                    Registros[17] = rs.getString("Damaware");

                    modelo.addRow(Registros);
                }

                tbl_soft.setModel(modelo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
            }

        } catch (Exception e) {
        }

    }

//--------------------------------------------------------------------------------------------
    public void Contar() {
        for (int x = 0; x <= tbl_soft.getRowCount(); x++) {
            Jbl_contar.setText("" + x);
        }
    }

//----------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btn_Modificar = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        btn_Actualizar1 = new javax.swing.JButton();
        btn_Actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Jbl_contar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_soft = new javax.swing.JTable();
        Barra = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 760));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(223, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 205, 230, 28));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/software (1).png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, -1, 230));

        btn_Modificar.setBackground(new java.awt.Color(0, 155, 255));
        btn_Modificar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_Modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Modificar.setText("Actualizar");
        btn_Modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 205, 110, 28));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(0, 0, 255));
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cohete.png"))); // NOI18N
        btn_menu.setText("Ir a Menú Principal");
        btn_menu.setContentAreaFilled(false);
        btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_menu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_menuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_menuMouseExited(evt);
            }
        });
        btn_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_menuActionPerformed(evt);
            }
        });
        jPanel1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, -1, 35));

        btn_Actualizar1.setBackground(new java.awt.Color(0, 155, 255));
        btn_Actualizar1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_Actualizar1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Actualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        btn_Actualizar1.setText("Buscar");
        btn_Actualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btn_Actualizar1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_Actualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actualizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Actualizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 205, 110, 28));

        btn_Actualizar.setBackground(new java.awt.Color(0, 155, 255));
        btn_Actualizar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_Actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Actualizar.setText("Modificar");
        btn_Actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 205, 110, 28));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/desarrollo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 240));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/rpa.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 2, 70)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Configiuraciones");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 120));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Registros:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 650, 90, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 50, 0));
        jLabel5.setText("Total Equipos Configurados:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 390, -1));

        Jbl_contar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Jbl_contar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(Jbl_contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 650, 50, 22));

        tbl_soft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_soft);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1460, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 740));

        Barra.setBackground(new java.awt.Color(0, 255, 0));
        Barra.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(102, 102, 102));
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu-abierto.png"))); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ordenador-portatil.png"))); // NOI18N
        jMenuItem2.setText("Equipos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        Barra.add(jMenu1);

        setJMenuBar(Barra);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Datos_equipos E = new Datos_equipos();
        E.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowClosing

    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        CargarDatos();
        Contar();
    }//GEN-LAST:event_btn_ModificarActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();

    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_Actualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actualizar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Actualizar1ActionPerformed

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        Modificar_sft M = new Modificar_sft();
        M.setVisible(true);
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(11, 245, 0));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0,0,255));
    }//GEN-LAST:event_btn_menuMouseExited

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Buscar(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

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
                    UIManager.getFont(info.equals(info.getClass()));
                    ///UIManager.put("Table.cellRenderer",new Color(191,98,4));

                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datos_software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_software().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuBar Barra;
    private javax.swing.JLabel Jbl_contar;
    public javax.swing.JButton btn_Actualizar;
    public javax.swing.JButton btn_Actualizar1;
    public javax.swing.JButton btn_Modificar;
    private javax.swing.JButton btn_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_soft;
    public javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
