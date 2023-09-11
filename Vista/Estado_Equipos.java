package Vista;

import Modelo.Conexion_MySQL;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deivi
 */
public class Estado_Equipos extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    public Estado_Equipos() {
        initComponents();
        setTitle("Estado Equipos");
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setLocationRelativeTo(this);

        datos();
        ContarRegistro();
    }
//-----------------------------------------------------------------------------------------------

    public void ContarRegistro() {
        for (int x = 0; x <= tbl_estado.getRowCount(); x++) {
            jbl_contar.setText("" + x);
        }
    }

//------------------------------------------------------------------------------------------------
    public void datos() {
        tbl_estado.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbl_estado.getTableHeader().setOpaque(false);
        tbl_estado.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_estado.getTableHeader().setBackground(new Color(0, 0, 0));
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            tbl_estado.setModel(modelo);
            PreparedStatement ps = null;
            ResultSet rs = null;
            String Sql = "SELECT * FROM estado_equipo;";
            ps = com.prepareStatement(Sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadcolumna = rsMd.getColumnCount();
            modelo.addColumn("Codigo");
            modelo.addColumn("Estado");
            modelo.addColumn("Cod_acta");
            modelo.addColumn("Observaciónes");
            modelo.addColumn("Fecha Aviso");

            int Columna = rsMd.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[cantidadcolumna];
                for (int i = 0; i < cantidadcolumna; i++) {

                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            int[] anchos = {50, 50, 100, 200, 50};
            for (int i = 0; i < tbl_estado.getColumnCount(); i++) {
                tbl_estado.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

        } catch (SQLException e) {
            JOptionPane.showInternalMessageDialog(null, "Error Al Cargar Datos  " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_estado = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jbl_contar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(243, 243, 243));
        jPanel1.setPreferredSize(new java.awt.Dimension(1106, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_estado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Estado", "Cod_Acta", "Observacion", "Fecha Aviso"
            }
        ));
        jScrollPane1.setViewportView(tbl_estado);
        if (tbl_estado.getColumnModel().getColumnCount() > 0) {
            tbl_estado.getColumnModel().getColumn(0).setResizable(false);
            tbl_estado.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_estado.getColumnModel().getColumn(1).setResizable(false);
            tbl_estado.getColumnModel().getColumn(1).setPreferredWidth(50);
            tbl_estado.getColumnModel().getColumn(2).setResizable(false);
            tbl_estado.getColumnModel().getColumn(2).setPreferredWidth(170);
            tbl_estado.getColumnModel().getColumn(3).setResizable(false);
            tbl_estado.getColumnModel().getColumn(3).setPreferredWidth(220);
            tbl_estado.getColumnModel().getColumn(4).setResizable(false);
            tbl_estado.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, 310));

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Registros:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 315, 90, 25));

        jbl_contar.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jbl_contar.setForeground(new java.awt.Color(0, 0, 255));
        jbl_contar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jbl_contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(623, 315, 50, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Estado_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estado_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estado_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estado_Equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estado_Equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jbl_contar;
    public javax.swing.JTable tbl_estado;
    // End of variables declaration//GEN-END:variables
}
