package Vista;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Datos_CentrosCostos extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Datos_CentrosCostos() {
        initComponents();
        MostrarDatos();
        setTitle("Centros de costos");
        setLocationRelativeTo(this);
setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());

tbl_costos.getColumnModel().getColumn(3).setPreferredWidth(5);

  }
    public void MostrarDatos() {
tbl_costos.getTableHeader().setBackground(new Color(0,0,0));
tbl_costos.getTableHeader().setForeground(new Color(255,255,255));
tbl_costos.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,13));


 String[] Titulos = {
            "Cedula", "Dependencia", "Centro de costo", "Do", "Unidad de negocio", "Empresa"};
        String[] Registros = new String[6];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);


        String Sql = "select * from datos_empresa";


        try {

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Cedula");
                Registros[1] = rs.getString("Dependencia");
                Registros[2] = rs.getString("Centro_costo");
                Registros[3] = rs.getString("Do");
                Registros[4] = rs.getString("Unidad_negocio");
                Registros[5] = rs.getString("Empresa");

                model.addRow(Registros);
            }

            tbl_costos.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al cargar los datos" + e.getMessage());
        }

    }
//---------------------------------------------------------------------------------------------------
     public void Buscar(String V) {
        String[] Titulos = {"Cedula","Empresa", "Dependencias", "Do", "Centros de costos", "Unidad de negocio"};
        String[] Registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM datos_empresa WHERE Do LIKE '%" + V + "%' or Cedula LIKE '%" + V + "%'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Cedula");
                Registros[1] = rs.getString("Empresa");
                Registros[2] = rs.getString("Dependencia");
                Registros[3] = rs.getString("Do");
                Registros[4] = rs.getString("Centro_costo");
                Registros[5] = rs.getString("Unidad_negocio");

                modelo.addRow(Registros);
            }

            tbl_costos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el registro con identificador");
        }

    }


//-------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_costos = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(100, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_costos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_costos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1050, 500));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_buscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 190, 25));

        btn_guardar.setBackground(new java.awt.Color(0, 0, 255));
        btn_guardar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setText("Buscar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Centros de costos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

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
        jPanel1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(86, 111, 225));
        jMenuBar1.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(255, 255, 0));
        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu-abierto.png"))); // NOI18N

        jMenuItem1.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/trabajo-en-equipo.png"))); // NOI18N
        jMenuItem1.setText("Datos Personales");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/planta-de-energia (1).png"))); // NOI18N
        jMenuItem3.setText("Datos Empresa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/mapa.png"))); // NOI18N
        jMenuItem4.setText("Direcciones");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Datos_personales P = new Datos_personales();
        P.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Datos_empresa E = new Datos_empresa();
        E.setVisible(true);
        dispose();        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Direccion D = new Direccion();
        D.setVisible(rootPaneCheckingEnabled);
        dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        MostrarDatos();     // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
       btn_menu.setForeground(new Color(255, 220, 0 ));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0,0,0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        Buscar(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyPressed

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
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datos_CentrosCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_CentrosCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_CentrosCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_CentrosCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_CentrosCostos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_menu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_costos;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
