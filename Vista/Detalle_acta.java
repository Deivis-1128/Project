package Vista;

import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amy_v
 */
public class Detalle_acta extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    public Detalle_acta() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setTitle("Actas");
        setLocationRelativeTo(this);
        MostrarDatos();
        ContarRegistros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dts_acts = new javax.swing.JTable();
        btn_Agregar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_Actulizar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jbl_contar = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_dts_acts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_dts_acts);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, 1060, 340));

        btn_Agregar.setFont(new java.awt.Font("Arial Black", 2, 13)); // NOI18N
        btn_Agregar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anadir.png"))); // NOI18N
        btn_Agregar.setText("Agregar acta");
        btn_Agregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Agregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 8, 180, 35));

        btn_eliminar.setFont(new java.awt.Font("Arial Black", 2, 13)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 8, 140, 35));

        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jLabel1.setText("Buscar");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 12, 90, -1));

        txt_buscar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        txt_buscar.setForeground(new java.awt.Color(0, 0, 0));
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 8, 160, 35));

        btn_Actulizar1.setFont(new java.awt.Font("Arial Black", 2, 13)); // NOI18N
        btn_Actulizar1.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actulizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        btn_Actulizar1.setText("Actualizar");
        btn_Actulizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Actulizar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Actulizar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 8, 150, 35));

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registros:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 12, 90, 25));

        jbl_contar.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jbl_contar.setForeground(new java.awt.Color(0, 0, 255));
        jbl_contar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jbl_contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 12, 40, 25));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cohete.png"))); // NOI18N
        btn_menu.setText("Ir a Menú ");
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
        jPanel1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 8, 150, 35));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarActionPerformed
        Act_dis Ac = new Act_dis();
        Ac.setVisible(true);
       

    }//GEN-LAST:event_btn_AgregarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        Eliminar();
          MostrarDatos();
         ContarRegistros();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_Actulizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Actulizar1ActionPerformed
        MostrarDatos();
         ContarRegistros();
    }//GEN-LAST:event_btn_Actulizar1ActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        BuscarNP(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyPressed

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

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed
//------------------------------------------------------------------------------

    public void MostrarDatos() {
        tbl_dts_acts.getTableHeader().setBackground(new Color(0, 0, 0));
        tbl_dts_acts.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_dts_acts.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));

        String[] Titulos = {"Cedula-Emp",
            "ID-Acta", "Tipo-Acta", "Fecha", "Nombre-Tec", "Apellido-Tec", "Cedula-Tec", "Codigo-Eq", "Observacion"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);

        String Sql = "select * from detalle_actas";

        try {

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Cedula_e");
                Registros[1] = rs.getString("Id_actas");
                Registros[2] = rs.getString("Tipo_acta");
                Registros[3] = rs.getString("Fecha");
                Registros[4] = rs.getString("Nombre_t");
                Registros[5] = rs.getString("Apellido_t");
                Registros[6] = rs.getString("Cedula_t");
                Registros[7] = rs.getString("Codigo_eqp");
                Registros[8] = rs.getString("Observacion");

                model.addRow(Registros);
            }

            tbl_dts_acts.setModel(model);

            int[] anchos = {5, 5, 100, 10, 50, 50, 10, 5, 100};
            for (int i = 0; i < tbl_dts_acts.getColumnCount(); i++) {
                tbl_dts_acts.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al cargar los datos" + e.getMessage());
        }

    }
//------------------------------------------------------------------------------    

 public void Eliminar() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/eliminar.png"));

        try {
            int filaSeleccionada = tbl_dts_acts.getSelectedRow();
            String SQL = "delete from detalle_actas where Id_actas=" + tbl_dts_acts.getValueAt(filaSeleccionada, 1);
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
            JOptionPane.showMessageDialog(rootPane,"Erro "+ e.getMessage());

        }

    }
//------------------------------------------------------------------------------  

    public DefaultTableModel BuscarNP(String C) {
        String[] Titulos = {"Cedula-Emp",
            "ID-Acta", "Tipo-Acta", "Fecha", "Nombre-Tec", "Apellido-Tec", "Cedula-Tec", "Codigo-Eq", "Observacion"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM detalle_actas WHERE  Id_actas LIKE '%" + C + "%' or Nombre_t LIKE'%" + C + "%' or Cedula_e Like'%" + C + "%' or Cedula_t LIKE'%" + C + "%' or Codigo_eqp LIKE'%" + C + "%'  or Fecha LIKE'%" + C + "%' ";

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = com.prepareStatement(Sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Registros[0] = rs.getString("Cedula_e");
                Registros[1] = rs.getString("Id_actas");
                Registros[2] = rs.getString("Tipo_acta");
                Registros[3] = rs.getString("Fecha");
                Registros[4] = rs.getString("Nombre_t");
                Registros[5] = rs.getString("Apellido_t");
                Registros[6] = rs.getString("Cedula_t");
                Registros[7] = rs.getString("Codigo_eqp");
                Registros[8] = rs.getString("Observacion");

                model.addRow(Registros);

            }

            tbl_dts_acts.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
        }
        return null;

    }

    
    //----------------------------------------------------------------------------------------

    public void ContarRegistros() {
        for (int x = 0; x <= tbl_dts_acts.getRowCount(); x++) {
            jbl_contar.setText("" + x);
        }
    }
//----------------------------------------------------------------------------------------
//------------------------------------------------------------------------------
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
            java.util.logging.Logger.getLogger(Detalle_acta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Detalle_acta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Detalle_acta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Detalle_acta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Detalle_acta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actulizar1;
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_menu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jbl_contar;
    public javax.swing.JTable tbl_dts_acts;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
