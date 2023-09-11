package Vista;

import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Buscar_Empresas extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    public Buscar_Empresas() {
        initComponents();
setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setTitle("Lissta de Empresas Por Do");
        setLocationRelativeTo(this);
        CargarDatos();
    }

    @SuppressWarnings("unchecked")
//-----------------------------------------------------------------------------------------------------------
    public void Buscar(String V) {
        String[] Titulos = {"Empresa", "Dependencias", "Do", "Centros de costos", "Unidad de negocio"};
        String[] Registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM centros WHERE Do LIKE '%" + V + "%' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Empresa");
                Registros[1] = rs.getString("Dependencia");
                Registros[2] = rs.getString("Do");
                Registros[3] = rs.getString("Centro_costo");
                Registros[4] = rs.getString("Unidad_negocio");

                modelo.addRow(Registros);
            }

            tbl_B.setModel(modelo);
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el registro con identificador");
        }

    }

//-------------------------------------------------------------------------------------------------------------
    public void CargarDatos() {
        tbl_B.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tbl_B.getTableHeader().setBackground(new Color(0, 0, 0));
        tbl_B.getTableHeader().setForeground(new Color(255, 255, 255));
        String[] Titulos = {"Empresa", "Dependencias", "Do", "Centros de costos", "Unidad de negocio"};
        String[] Registros = new String[5];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM centros";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {

                Registros[0] = rs.getString("Empresa");
                Registros[1] = rs.getString("Dependencia");
                Registros[2] = rs.getString("Do");
                Registros[3] = rs.getString("Centro_costo");
                Registros[4] = rs.getString("Unidad_negocio");

                modelo.addRow(Registros);
            }

            tbl_B.setModel(modelo);
             int[] anchos = {100, 80,5,100,100};
            for (int i = 0; i < tbl_B.getColumnCount(); i++) {
                tbl_B.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Mostrar Los Datos");
        }

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_B = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 330));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 350));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_B.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_B);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 50, 970, 280));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 150, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jLabel1.setText("Buscar");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 88, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultar Datos  Do");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Buscar_Empresas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Buscar_Empresas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Buscar_Empresas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Buscar_Empresas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_Empresas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbl_B;
    public javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
