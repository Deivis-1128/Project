package Vista;

import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Distribucion extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    public Distribucion() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setLocationRelativeTo(this);
        Cargar_datos();
        Estillos();
        ContarRegistros();
    }

//--------------------------------------------------------------------------------------------------
    public void Estillos() {
        tbl_distribucion.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tbl_distribucion.getTableHeader().setOpaque(false);
        tbl_distribucion.getTableHeader().setForeground(new Color(0, 0, 0));
        tbl_distribucion.getTableHeader().setBackground(new Color(255, 255, 0));

    }
//----------------------------------------------------------------------------------------

    public void ContarRegistros() {
        for (int x = 0; x <= tbl_distribucion.getRowCount(); x++) {
            jbl_contar.setText("" + x);
        }
    }
//----------------------------------------------------------------------------------------

    public void Buscar(String V) {
        String[] Titulos = {"Clase", "Marca", "Modelo", "Codigo", "Serial", "Hostname", "Usuario", "Clave", "Nombre", "Cedula", "Estado", "Fecha-Asignacion", "Cod-Acta"};
        String[] Registros = new String[13];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM distribucion WHERE  Codigo LIKE '%" + V + "%' ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Registros[0] = rs.getString("Clase");
                Registros[1] = rs.getString("Marca");
                Registros[2] = rs.getString("Modelo");
                Registros[3] = rs.getString("Codigo");
                Registros[4] = rs.getString("Serial");
                Registros[5] = rs.getString("Hostname");
                Registros[6] = rs.getString("Usuario");
                Registros[7] = rs.getString("Clave");
                Registros[8] = rs.getString("Nombre");
                Registros[9] = rs.getString("Cedula");
                Registros[10] = rs.getString("Estado");
                Registros[11] = rs.getString("Fecha");
                Registros[12] = rs.getString("Codigo_acta");

                model.addRow(Registros);
            }

            tbl_distribucion.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el registro" + e.getMessage());
        }

    }

//--------------------------------------------------------------------------------------------
    public void Cargar_datos() {
        String[] Titulos = {"Clase", "Marca", "Modelo", "Codigo", "Serial", "Hostname", "Usuario", "Clave", "Nombre", "Cedula", "Estado", "Fecha-Asignacion", "Cod-Acta"};
        String[] Registros = new String[13];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);
        String Sql = "Select*From distribucion";

        try {

            try {
                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(Sql);

                while (rs.next()) {
                    Registros[0] = rs.getString("Clase");
                    Registros[1] = rs.getString("Marca");
                    Registros[2] = rs.getString("Modelo");
                    Registros[3] = rs.getString("Codigo");
                    Registros[4] = rs.getString("Serial");
                    Registros[5] = rs.getString("Hostname");
                    Registros[6] = rs.getString("Usuario");
                    Registros[7] = rs.getString("Clave");
                    Registros[8] = rs.getString("Nombre");
                    Registros[9] = rs.getString("Cedula");
                    Registros[10] = rs.getString("Estado");
                    Registros[11] = rs.getString("Fecha");
                    Registros[12] = rs.getString("Codigo_acta");

                    model.addRow(Registros);
                }

                tbl_distribucion.setModel(model);

                int[] anchos = {15, 40, 100, 20, 35, 50, 100, 40, 70, 30, 15, 35, 30};
                for (int i = 0; i < tbl_distribucion.getColumnCount(); i++) {
                    tbl_distribucion.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
            }

        } catch (Exception e) {
        }

    }
//----------------------------------------------------------------------------------------------------

    public void Eliminar() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/eliminar.png"));

        try {
            int filaSeleccionada = tbl_distribucion.getSelectedRow();
            String SQL = "delete from distribucion where Codigo=" + tbl_distribucion.getValueAt(filaSeleccionada, 3);
            Statement st = com.createStatement();

            String Botones[] = {"Si", "No"};
            int eleccion = JOptionPane.showOptionDialog(this, "Desas Eliminar Este Registro", "Eliminar", 0, 0, icono, Botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {

                st.executeUpdate(SQL);
                JOptionPane.showMessageDialog(null, "Registro Eliminado", "", 0, icono);
            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.err.println("Se cancelo el cierre");

            }
        } catch (Exception e) {
            System.err.println("e");

        }

    }
//----------------------------------------------------------------------------------------------------

    public void GenerarReporte() {

        try {

            JasperReport jr = JasperCompileManager.compileReport("src/Reportes/Acta.jrxml");
            Map parametro = new HashMap();
            parametro.put("cedula", parametro);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, com);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);

        } catch (Exception e) {
        }

    }

//----------------------------------------------------------------------------------------------------   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_eliminar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_distribucion = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        btn_menu = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jbl_contar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1500, 750));
        setResizable(false);

        btn_eliminar.setBackground(new java.awt.Color(133, 167, 172));
        btn_eliminar.setPreferredSize(new java.awt.Dimension(1500, 700));
        btn_eliminar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_distribucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_distribucion);

        btn_eliminar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1460, 600));

        jButton1.setBackground(new java.awt.Color(255, 247, 0));
        jButton1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        btn_eliminar.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, 37));

        btn_buscar.setBackground(new java.awt.Color(255, 247, 0));
        btn_buscar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscacar");
        btn_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        btn_eliminar.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 10, -1, 37));

        txt_buscar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        btn_eliminar.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(455, 10, 210, 37));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
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
        btn_eliminar.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, 37));

        btn_actualizar.setBackground(new java.awt.Color(102, 255, 0));
        btn_actualizar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        btn_eliminar.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 37));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel4.setText("Registros:");
        btn_eliminar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 650, 90, -1));

        jbl_contar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_contar.setForeground(new java.awt.Color(0, 0, 255));
        btn_eliminar.add(jbl_contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 650, 100, 25));

        jMenuBar1.setBackground(new java.awt.Color(0, 255, 0));
        jMenuBar1.setFocusable(false);
        jMenuBar1.setOpaque(true);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu-abierto.png"))); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Detalle Distribucion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anadir.png"))); // NOI18N

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/la-red.png"))); // NOI18N
        jMenuItem3.setText("Nueva  Distribución");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(255, 255, 0));
        jMenu3.setText("Distribución");
        jMenu3.setContentAreaFilled(false);
        jMenu3.setEnabled(false);
        jMenu3.setFocusable(false);
        jMenu3.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jMenu3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuBar1.add(jMenu3);

        jMenu4.setText("jMenu4");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Act_dis Ac = new Act_dis();
        Ac.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Eliminar();
        Cargar_datos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(224, 255, 0));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        Cargar_datos();
        ContarRegistros();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        Buscar(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
       Loging l=new Loging();
       l.setVisible(true);
               
    }//GEN-LAST:event_jMenu1ActionPerformed

    /**
     * / * @param args the command line arguments /
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
            java.util.logging.Logger.getLogger(Distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Distribucion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Distribucion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_actualizar;
    public javax.swing.JButton btn_buscar;
    private javax.swing.JPanel btn_eliminar;
    private javax.swing.JButton btn_menu;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jbl_contar;
    public javax.swing.JTable tbl_distribucion;
    public javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
