



package Vista;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author deivi
 */
public class Menu_principal extends javax.swing.JFrame {

    /**
     * Creates new form Menu_principal
     */
    public Menu_principal() {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Sitema De Gestion Equipos");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());

    }

//--------------------------------------------------------------------------------------------------------------------------
    private void Cerra() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/coding_html_programming.png"));

        String Botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this, "!Estas Aun clic De Cerrar El Sistema¡", "Cerra", 0, 0, icono, Botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.err.println("Se cancelo el cierre");
        }
    }

//-------------------------------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_equipos = new javax.swing.JButton();
        btn_distribucion = new javax.swing.JButton();
        btn_categorias = new javax.swing.JButton();
        Btn_reportes = new javax.swing.JButton();
        Btn_user_admin = new javax.swing.JButton();
        Btn_actas = new javax.swing.JButton();
        Btn_inventario = new javax.swing.JButton();
        LBL = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Btn_enpleados = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(148, 153, 163));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_equipos.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_equipos.setForeground(new java.awt.Color(255, 255, 255));
        btn_equipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ordenador.png"))); // NOI18N
        btn_equipos.setText("Equipos");
        btn_equipos.setAlignmentY(5.0F);
        btn_equipos.setBorder(null);
        btn_equipos.setContentAreaFilled(false);
        btn_equipos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_equipos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_equipos.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_equipos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_equipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_equiposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_equiposMouseExited(evt);
            }
        });
        btn_equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equiposActionPerformed(evt);
            }
        });
        jPanel1.add(btn_equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 85, -1, -1));

        btn_distribucion.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_distribucion.setForeground(new java.awt.Color(255, 255, 255));
        btn_distribucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/red-de-distribucion.png"))); // NOI18N
        btn_distribucion.setText("Distribución");
        btn_distribucion.setAlignmentY(5.0F);
        btn_distribucion.setBorder(null);
        btn_distribucion.setContentAreaFilled(false);
        btn_distribucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_distribucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_distribucion.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_distribucion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_distribucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_distribucionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_distribucionMouseExited(evt);
            }
        });
        btn_distribucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_distribucionActionPerformed(evt);
            }
        });
        jPanel1.add(btn_distribucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 85, -1, -1));

        btn_categorias.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_categorias.setForeground(new java.awt.Color(255, 255, 255));
        btn_categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/consulta.png"))); // NOI18N
        btn_categorias.setText("Consutar");
        btn_categorias.setAlignmentY(5.0F);
        btn_categorias.setBorder(null);
        btn_categorias.setContentAreaFilled(false);
        btn_categorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_categorias.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_categorias.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btn_categorias.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btn_categorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_categoriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_categoriasMouseExited(evt);
            }
        });
        btn_categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriasActionPerformed(evt);
            }
        });
        jPanel1.add(btn_categorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 85, -1, -1));

        Btn_reportes.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Btn_reportes.setForeground(new java.awt.Color(255, 255, 255));
        Btn_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/grafico.png"))); // NOI18N
        Btn_reportes.setText("Reportes");
        Btn_reportes.setAlignmentY(5.0F);
        Btn_reportes.setBorder(null);
        Btn_reportes.setContentAreaFilled(false);
        Btn_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_reportes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_reportes.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Btn_reportes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Btn_reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_reportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_reportesMouseExited(evt);
            }
        });
        jPanel1.add(Btn_reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 395, -1, -1));

        Btn_user_admin.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Btn_user_admin.setForeground(new java.awt.Color(255, 255, 255));
        Btn_user_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ordenador-portatil (1).png"))); // NOI18N
        Btn_user_admin.setText("Equipos en Stock");
        Btn_user_admin.setAlignmentY(5.0F);
        Btn_user_admin.setBorder(null);
        Btn_user_admin.setContentAreaFilled(false);
        Btn_user_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_user_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_user_admin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Btn_user_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Btn_user_admin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_user_adminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_user_adminMouseExited(evt);
            }
        });
        Btn_user_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_user_adminActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_user_admin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 395, -1, -1));

        Btn_actas.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Btn_actas.setForeground(new java.awt.Color(255, 255, 255));
        Btn_actas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/literatura.png"))); // NOI18N
        Btn_actas.setText("Actas");
        Btn_actas.setAlignmentY(5.0F);
        Btn_actas.setBorder(null);
        Btn_actas.setContentAreaFilled(false);
        Btn_actas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_actas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_actas.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Btn_actas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Btn_actas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_actasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_actasMouseExited(evt);
            }
        });
        Btn_actas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_actasActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_actas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 395, -1, -1));

        Btn_inventario.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Btn_inventario.setForeground(new java.awt.Color(255, 255, 255));
        Btn_inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/reembolso.png"))); // NOI18N
        Btn_inventario.setText("Devoluciones");
        Btn_inventario.setAlignmentY(5.0F);
        Btn_inventario.setBorder(null);
        Btn_inventario.setContentAreaFilled(false);
        Btn_inventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_inventario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_inventario.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        Btn_inventario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Btn_inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_inventarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_inventarioMouseExited(evt);
            }
        });
        Btn_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_inventarioActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 395, -1, -1));

        LBL.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        LBL.setForeground(new java.awt.Color(255, 255, 255));
        LBL.setText("Menú Principal");
        LBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LBLMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LBLMouseExited(evt);
            }
        });
        jPanel1.add(LBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 220, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 609));

        Btn_enpleados.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        Btn_enpleados.setForeground(new java.awt.Color(255, 255, 255));
        Btn_enpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/calidad.png"))); // NOI18N
        Btn_enpleados.setText("Información");
        Btn_enpleados.setBorder(null);
        Btn_enpleados.setContentAreaFilled(false);
        Btn_enpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Btn_enpleados.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_enpleados.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Btn_enpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Btn_enpleadosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Btn_enpleadosMouseExited(evt);
            }
        });
        Btn_enpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_enpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(Btn_enpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/blogs-PP-tendencias-10.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_equiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equiposActionPerformed
        // TODO add your handling code here:
        Datos_equipos D = new Datos_equipos();
        D.setVisible(true);

    }//GEN-LAST:event_btn_equiposActionPerformed

    private void Btn_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_inventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_inventarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Cerra();
    }//GEN-LAST:event_formWindowClosing

    private void btn_categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriasActionPerformed
        Buscar_empleado C = new Buscar_empleado();
        C.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_categoriasActionPerformed

    private void Btn_user_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_user_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_user_adminActionPerformed

    private void LBLMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBLMouseEntered
        LBL.setForeground(new Color(5, 177, 252));
    }//GEN-LAST:event_LBLMouseEntered

    private void LBLMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBLMouseExited
        LBL.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_LBLMouseExited

    private void btn_distribucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_distribucionActionPerformed
        Distribucion D = new Distribucion();
        D.setVisible(true);
        dispose();

    }//GEN-LAST:event_btn_distribucionActionPerformed

    private void Btn_enpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_enpleadosMouseEntered
        Btn_enpleados.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_Btn_enpleadosMouseEntered

    private void Btn_enpleadosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_enpleadosMouseExited
        Btn_enpleados.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_Btn_enpleadosMouseExited

    private void btn_equiposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_equiposMouseEntered
        btn_equipos.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_btn_equiposMouseEntered

    private void btn_equiposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_equiposMouseExited
        btn_equipos.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_equiposMouseExited

    private void btn_distribucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_distribucionMouseEntered
        btn_distribucion.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_btn_distribucionMouseEntered

    private void btn_distribucionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_distribucionMouseExited
        btn_distribucion.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_distribucionMouseExited

    private void btn_categoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_categoriasMouseEntered
        btn_categorias.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_btn_categoriasMouseEntered

    private void btn_categoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_categoriasMouseExited
        btn_categorias.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_categoriasMouseExited

    private void Btn_inventarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_inventarioMouseEntered
        Btn_inventario.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_Btn_inventarioMouseEntered

    private void Btn_inventarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_inventarioMouseExited
        Btn_inventario.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_Btn_inventarioMouseExited

    private void Btn_actasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actasMouseEntered
        Btn_actas.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_Btn_actasMouseEntered

    private void Btn_actasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_actasMouseExited
        Btn_actas.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_Btn_actasMouseExited

    private void Btn_user_adminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_user_adminMouseEntered
        Btn_user_admin.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_Btn_user_adminMouseEntered

    private void Btn_user_adminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_user_adminMouseExited
        Btn_user_admin.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_Btn_user_adminMouseExited

    private void Btn_reportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reportesMouseEntered
        Btn_reportes.setForeground(new Color(255, 251, 0));
    }//GEN-LAST:event_Btn_reportesMouseEntered

    private void Btn_reportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btn_reportesMouseExited
        Btn_reportes.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_Btn_reportesMouseExited

    private void Btn_enpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_enpleadosActionPerformed
        Datos_personales D = new Datos_personales();
        D.setVisible(true);
        dispose();
    }//GEN-LAST:event_Btn_enpleadosActionPerformed

    private void Btn_actasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_actasActionPerformed
      Detalle_acta DT=new Detalle_acta();
      DT.setVisible(true);
      dispose();
              
    }//GEN-LAST:event_Btn_actasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Btn_actas;
    private javax.swing.JButton Btn_enpleados;
    public javax.swing.JButton Btn_inventario;
    public javax.swing.JButton Btn_reportes;
    public javax.swing.JButton Btn_user_admin;
    private javax.swing.JLabel LBL;
    private javax.swing.JButton btn_categorias;
    private javax.swing.JButton btn_distribucion;
    private javax.swing.JButton btn_equipos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
