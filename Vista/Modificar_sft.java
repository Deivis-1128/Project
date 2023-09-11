package Vista;

import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author deivi
 */
public class Modificar_sft extends javax.swing.JFrame {

    Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));
    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    public Modificar_sft() {
        // this.setContentPane(m);
        initComponents();
        setLocationRelativeTo(this);

        setTitle("Software y configuraciones");
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        Ocultar();
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }

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

//------------------------------------------------------------------------------
    public void Modificar() {
        Icon icon = new ImageIcon(getClass().getResource("/Img/Save-as.png"));

        String Sql = "UPDATE software_equipos SET Hostname=?,Serial=?,Codigo=?,Sistema_operativo=?,Office=?,Adobe_reader=?,Actualizacion_controladores=?,Cifrado_unida_bitlocker=?,One_driver=?,Configuracion_baan=?,Cofiguracion_impresora=?,Configracion_outlook=?,Java=?,Global_protec=?,Smart_view=?,Cliente_oracle=?,Software_especial=?,Damaware=? WHERE Codigo=?";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);

            ps.setString(1, txt_host.getText());
            ps.setString(2, txt_serial.getText());
            ps.setString(3, txt_cod.getText());
            ps.setString(4, combox_windows.getSelectedItem().toString());

            if (ch_offi.isSelected()) {
                ps.setString(5, ch_offi.getText());
            } else if (ch_offi.isShowing()) {

            }
            if (ch_offi1.isSelected()) {
                ps.setString(5, ch_offi1.getText());
            } else if (ch_offi1.isShowing()) {

            }
            //------------------
            if (ch_Adorender.isSelected()) {
                ps.setString(6, ch_Adorender.getText());
            } else if (ch_Adorender.isShowing()) {

            }
            if (ch_Adorender1.isSelected()) {
                ps.setString(6, ch_Adorender1.getText());
            } else if (ch_Adorender1.isShowing()) {

            }

            //-----------------   
            if (ch_Adriver.isSelected()) {
                ps.setString(7, ch_Adriver.getText());
            } else if (ch_Adriver.isShowing()) {

            }
            if (ch_Adriver1.isSelected()) {
                ps.setString(7, ch_Adriver1.getText());
            } else if (ch_Adriver1.isShowing()) {

            }
            //------------------ 
            if (ch_Bitdefender.isSelected()) {
                ps.setString(8, ch_Bitdefender.getText());
            } else if (ch_Bitdefender.isShowing()) {

            }
            if (ch_Bitdefender1.isSelected()) {
                ps.setString(8, ch_Bitdefender1.getText());
            } else if (ch_Bitdefender1.isShowing()) {

            }

            //-----------------------
            if (ch_oneDriver.isSelected()) {
                ps.setString(9, ch_oneDriver.getText());
            } else if (ch_oneDriver.isShowing()) {

            }
            if (ch_oneDriver1.isSelected()) {
                ps.setString(9, ch_oneDriver1.getText());
            } else if (ch_oneDriver1.isShowing()) {

            }

            //----------------------
            if (ch_baan.isSelected()) {
                ps.setString(10, ch_baan.getText());
            } else if (ch_baan.isShowing()) {

            }
            if (ch_baan1.isSelected()) {
                ps.setString(10, ch_baan1.getText());
            } else if (ch_baan1.isShowing()) {

            }

            //--------------------------
            if (ch_impresora.isSelected()) {
                ps.setString(11, ch_impresora.getText());
            } else if (ch_impresora.isShowing()) {

            }
            if (ch_impresora1.isSelected()) {
                ps.setString(11, ch_impresora1.getText());
            } else if (ch_impresora1.isShowing()) {

            }

            //-------------------------
            if (ch_outlook.isSelected()) {
                ps.setString(12, ch_outlook.getText());
            } else if (ch_outlook.isShowing()) {

            }

            if (ch_outlook1.isSelected()) {
                ps.setString(12, ch_outlook1.getText());
            } else if (ch_outlook1.isShowing()) {

            }

            //-------------------------
            if (ch_java.isSelected()) {
                ps.setString(13, ch_java.getText());
            } else if (ch_java.isShowing()) {

            }
            if (ch_java1.isSelected()) {
                ps.setString(13, ch_java1.getText());
            } else if (ch_java1.isShowing()) {

            }

            //-----------------------
            if (ch_Globa.isSelected()) {
                ps.setString(14, ch_Globa.getText());
            } else if (ch_Globa.isShowing()) {

            }
            if (ch_Globa1.isSelected()) {
                ps.setString(14, ch_Globa1.getText());
            } else if (ch_Globa1.isShowing()) {

            }

            //-----------------------
            if (ch_Smarwie.isSelected()) {
                ps.setString(15, ch_Smarwie.getText());
            } else if (ch_Smarwie.isShowing()) {

            }
            if (ch_Smarwie1.isSelected()) {
                ps.setString(15, ch_Smarwie1.getText());
            } else if (ch_Smarwie1.isShowing()) {

            }

            //--------------------------
            if (ch_oracle.isSelected()) {
                ps.setString(16, ch_oracle.getText());
            } else if (ch_oracle.isShowing()) {

            }
            if (ch_oracle1.isSelected()) {
                ps.setString(16, ch_oracle1.getText());
            } else if (ch_oracle1.isShowing()) {

            }

            //------------------------------
            if (ch_sft_espsif.isSelected()) {
                ps.setString(17, ch_sft_espsif.getText());
            } else if (ch_sft_espsif.isShowing()) {

            }
            if (ch_sft_espsif1.isSelected()) {
                ps.setString(17, ch_sft_espsif1.getText());
            } else if (ch_sft_espsif1.isShowing()) {

            }

            //--------------------------
            if (ch_Danwer.isSelected()) {
                ps.setString(18, ch_Danwer.getText());
            } else if (ch_Danwer.isShowing()) {

            }
            if (ch_Danwer1.isSelected()) {
                ps.setString(18, ch_Danwer1.getText());
            } else if (ch_Danwer1.isShowing()) {

            }

            ps.setString(19, txt_cod.getText());
            int E = ps.executeUpdate();
            if (E > 0) {
                JOptionPane.showMessageDialog(null, "Datos modificados satisfactoriamente");
                
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Errror de modificacion debe de seleccionar\nTodas las opciones Si-No ");
        }
    }
//------------------------------------------------------------------------------

    public void Buscar() {
        Icon icon = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

        String Sql = "Select*from software_equipos where Codigo=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                txt_host.setText(rs.getString("Hostname"));
                txt_serial.setText(rs.getString("Serial"));
                txt_cod.setText(rs.getString("Codigo"));
                combox_windows.setSelectedItem(rs.getString("Sistema_operativo"));

                if (l1.getText().equals("Si")) {
                    l1.setText(rs.getString("Office"));
                } else {
                    l1.setText(rs.getString("Office"));
                    jLabel3.setForeground(new Color(0, 255, 0));
                    l1.setBackground(new Color(0, 255, 0));
                }
                if (l1.getText().equals("No")) {
                    l1.setText(rs.getString("Office"));
                    jLabel3.setForeground(new Color(255, 0, 0));
                    l1.setBackground(new Color(255, 0, 0));
                }
                //--------------------------------------------------------------
                if (l2.getText().equals("Si")) {
                    l2.setText(rs.getString("Adobe_reader"));
                } else {
                    l2.setText(rs.getString("Adobe_reader"));
                    jLabel6.setForeground(new Color(0, 255, 0));
                    l2.setBackground(new Color(0, 255, 0));
                }
                if (l2.getText().equals("No")) {
                    l2.setText(rs.getString("Adobe_reader"));
                    jLabel6.setForeground(new Color(255, 0, 0));
                    l2.setBackground(new Color(255, 0, 0));
                }
                //--------------------------------------------------------------
                if (l3.getText().equals("Si")) {
                    l3.setText(rs.getString("Actualizacion_controladores"));
                } else {
                    l3.setText(rs.getString("Actualizacion_controladores"));
                    jLabel4.setForeground(new Color(0, 255, 0));
                    l3.setBackground(new Color(0, 255, 0));
                }
                if (l3.getText().equals("No")) {
                    l3.setText(rs.getString("Actualizacion_controladores"));
                    jLabel4.setForeground(new Color(255, 0, 0));
                    l3.setBackground(new Color(255, 0, 0));
                }
                //--------------------------------------------------------------
                if (l4.getText().equals("Si")) {
                    l4.setText(rs.getString("Cifrado_unida_bitlocker"));
                } else {
                    l4.setText(rs.getString("Cifrado_unida_bitlocker"));
                    jLabel9.setForeground(new Color(0, 255, 0));
                    l4.setBackground(new Color(0, 255, 0));
                }
                if (l4.getText().equals("No")) {
                    l4.setText(rs.getString("Cifrado_unida_bitlocker"));
                    jLabel9.setForeground(new Color(255, 0, 0));
                    l4.setBackground(new Color(255, 0, 0));
                }
                //--------------------------------------------------------------
                if (l5.getText().equals("Si")) {
                    l5.setText(rs.getString("One_driver"));
                } else {
                    l5.setText(rs.getString("One_driver"));
                    jLabel19.setForeground(new Color(0, 255, 0));
                    l5.setBackground(new Color(0, 255, 0));
                }
                if (l5.getText().equals("No")) {
                    l5.setText(rs.getString("One_driver"));
                    jLabel19.setForeground(new Color(255, 0, 0));
                    l5.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l6.getText().equals("Si")) {
                    l6.setText(rs.getString("Configuracion_baan"));
                } else {
                    l6.setText(rs.getString("Configuracion_baan"));
                    jLabel5.setForeground(new Color(0, 255, 0));
                    l6.setBackground(new Color(0, 255, 0));
                }
                if (l6.getText().equals("No")) {
                    l6.setText(rs.getString("Configuracion_baan"));
                    jLabel5.setForeground(new Color(255, 0, 0));
                    l6.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l7.getText().equals("Si")) {
                    l7.setText(rs.getString("Cofiguracion_impresora"));
                } else {
                    l7.setText(rs.getString("Cofiguracion_impresora"));
                    jLabel15.setForeground(new Color(0, 255, 0));
                    l7.setBackground(new Color(0, 255, 0));
                }
                if (l7.getText().equals("No")) {
                    l7.setText(rs.getString("Cofiguracion_impresora"));
                    jLabel15.setForeground(new Color(255, 0, 0));
                    l7.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l8.getText().equals("Si")) {
                    l8.setText(rs.getString("Configracion_outlook"));
                } else {
                    l8.setText(rs.getString("Configracion_outlook"));
                    jLabel13.setForeground(new Color(0, 255, 0));
                    l8.setBackground(new Color(0, 255, 0));
                }
                if (l8.getText().equals("No")) {
                    l8.setText(rs.getString("Configracion_outlook"));
                    jLabel13.setForeground(new Color(255, 0, 0));
                    l8.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l9.getText().equals("Si")) {
                    l9.setText(rs.getString("Java"));
                } else {
                    l9.setText(rs.getString("Java"));
                    jLabel14.setForeground(new Color(0, 255, 0));
                    l9.setBackground(new Color(0, 255, 0));
                }
                if (l9.getText().equals("No")) {
                    l9.setText(rs.getString("Java"));
                    jLabel14.setForeground(new Color(255, 0, 0));
                    l9.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l10.getText().equals("Si")) {
                    l10.setText(rs.getString("Global_protec"));
                } else {
                    l10.setText(rs.getString("Global_protec"));
                    jLabel1.setForeground(new Color(0, 255, 0));
                    l10.setBackground(new Color(0, 255, 0));
                }
                if (l10.getText().equals("No")) {
                    l10.setText(rs.getString("Global_protec"));
                    jLabel1.setForeground(new Color(255, 0, 0));
                    l10.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l11.getText().equals("Si")) {
                    l11.setText(rs.getString("Smart_view"));
                } else {
                    l11.setText(rs.getString("Smart_view"));
                    jLabel12.setForeground(new Color(0, 255, 0));
                    l11.setBackground(new Color(0, 255, 0));
                }
                if (l11.getText().equals("No")) {
                    l11.setText(rs.getString("Smart_view"));
                    jLabel12.setForeground(new Color(255, 0, 0));
                    l11.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l12.getText().equals("Si")) {
                    l12.setText(rs.getString("Cliente_oracle"));
                } else {
                    l12.setText(rs.getString("Cliente_oracle"));
                    jLabel11.setForeground(new Color(0, 255, 0));
                    l12.setBackground(new Color(0, 255, 0));
                }
                if (l12.getText().equals("No")) {
                    l12.setText(rs.getString("Cliente_oracle"));
                    jLabel11.setForeground(new Color(255, 0, 0));
                    l12.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l13.getText().equals("Si")) {
                    l13.setText(rs.getString("Software_especial"));
                } else {
                    l13.setText(rs.getString("Software_especial"));
                    jLabel10.setForeground(new Color(0, 255, 0));
                    l13.setBackground(new Color(0, 255, 0));
                }
                if (l13.getText().equals("No")) {
                    l13.setText(rs.getString("Software_especial"));
                    jLabel10.setForeground(new Color(255, 0, 0));
                    l13.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                if (l14.getText().equals("Si")) {
                    l14.setText(rs.getString("Damaware"));
                } else {
                    l14.setText(rs.getString("Damaware"));
                    jLabel7.setForeground(new Color(0, 255, 0));
                    l14.setBackground(new Color(0, 255, 0));
                }
                if (l14.getText().equals("No")) {
                    l14.setText(rs.getString("Damaware"));
                    jLabel7.setForeground(new Color(255, 0, 0));
                    l14.setBackground(new Color(255, 0, 0));
                }
                //---------------------------------------------------------------
                Mostrar();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El equipo no existe");
        }

    }

//---------------------------------------------------------------------------------------------
    public void validarEquipos() {

        int resul = 0;

        String Codigo = txt_cod.getText();

        String SQL = "select * from recepcion_equipos where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {

                }

            } else {

                JOptionPane.showMessageDialog(null, "El equipo " + txt_buscar.getText() + "\nNo existe en la base de datos", "Alerta", 0, icono);
            }

        } catch (SQLException ex) {

        }

    }
//-----------------------------------------------------------------------------------------------    

    public void Limpiar() {
        txt_cod.setText("");
        txt_serial.setText("");
        txt_host.setText("");
        combox_windows.setSelectedIndex(0);
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        buttonGroup3.clearSelection();
        buttonGroup4.clearSelection();
        buttonGroup5.clearSelection();
        buttonGroup6.clearSelection();
        buttonGroup7.clearSelection();
        buttonGroup8.clearSelection();
        buttonGroup9.clearSelection();
        buttonGroup10.clearSelection();
        buttonGroup11.clearSelection();
        buttonGroup12.clearSelection();
        buttonGroup13.clearSelection();
        buttonGroup14.clearSelection();
    }

//---------------------------------------------------------------------------------------------
    public void Ocultar() {
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);
        l9.setVisible(false);
        l10.setVisible(false);
        l11.setVisible(false);
        l12.setVisible(false);
        l13.setVisible(false);
        l14.setVisible(false);

    }
//---------------------------------------------------------------------------------------------

    public void Mostrar() {
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        l4.setVisible(true);
        l5.setVisible(true);
        l6.setVisible(true);
        l7.setVisible(true);
        l8.setVisible(true);
        l9.setVisible(true);
        l10.setVisible(true);
        l11.setVisible(true);
        l12.setVisible(true);
        l13.setVisible(true);
        l14.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        txt_serial = new javax.swing.JTextField();
        txt_host = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        ch_Globa = new javax.swing.JCheckBox();
        ch_offi = new javax.swing.JCheckBox();
        ch_Adriver = new javax.swing.JCheckBox();
        ch_baan = new javax.swing.JCheckBox();
        ch_Adorender = new javax.swing.JCheckBox();
        ch_Danwer = new javax.swing.JCheckBox();
        ch_Bitdefender = new javax.swing.JCheckBox();
        ch_sft_espsif = new javax.swing.JCheckBox();
        ch_Smarwie = new javax.swing.JCheckBox();
        ch_outlook = new javax.swing.JCheckBox();
        ch_java = new javax.swing.JCheckBox();
        ch_impresora = new javax.swing.JCheckBox();
        ch_oneDriver = new javax.swing.JCheckBox();
        ch_oracle = new javax.swing.JCheckBox();
        combox_windows = new javax.swing.JComboBox<>();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ch_Globa1 = new javax.swing.JCheckBox();
        ch_offi1 = new javax.swing.JCheckBox();
        ch_Adriver1 = new javax.swing.JCheckBox();
        ch_baan1 = new javax.swing.JCheckBox();
        ch_Adorender1 = new javax.swing.JCheckBox();
        ch_Danwer1 = new javax.swing.JCheckBox();
        ch_Bitdefender1 = new javax.swing.JCheckBox();
        ch_sft_espsif1 = new javax.swing.JCheckBox();
        ch_oracle1 = new javax.swing.JCheckBox();
        ch_Smarwie1 = new javax.swing.JCheckBox();
        ch_outlook1 = new javax.swing.JCheckBox();
        ch_java1 = new javax.swing.JCheckBox();
        ch_impresora1 = new javax.swing.JCheckBox();
        ch_oneDriver1 = new javax.swing.JCheckBox();
        l1 = new javax.swing.JLabel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        l5 = new javax.swing.JLabel();
        l6 = new javax.swing.JLabel();
        l7 = new javax.swing.JLabel();
        l8 = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        l10 = new javax.swing.JLabel();
        l11 = new javax.swing.JLabel();
        l12 = new javax.swing.JLabel();
        l13 = new javax.swing.JLabel();
        l14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuracion de Software");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion De Software", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 24), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Windows.png"))); // NOI18N
        jLabel2.setText("Windows");
        jPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 120, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setText("HostName:");
        jPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 100, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel16.setText("Codigo Equipo:");
        jPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 130, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel17.setText("Serial:");
        jPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 60, -1));

        txt_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codActionPerformed(evt);
            }
        });
        jPanel.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 200, -1));
        jPanel.add(txt_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 190, -1));
        jPanel.add(txt_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 150, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/software (1).png"))); // NOI18N
        jPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 210));

        btn_modificar.setBackground(new java.awt.Color(51, 51, 255));
        btn_modificar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(255, 255, 255));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save-as.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 400, -1, 35));

        ch_Globa.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ch_Globa);
        ch_Globa.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Globa.setText("Si");
        ch_Globa.setToolTipText("");
        ch_Globa.setContentAreaFilled(false);
        ch_Globa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Globa.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Globa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_GlobaActionPerformed(evt);
            }
        });
        jPanel.add(ch_Globa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 45, 30));

        ch_offi.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ch_offi);
        ch_offi.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_offi.setText("Si");
        ch_offi.setContentAreaFilled(false);
        ch_offi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_offi.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_offi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 45, 30));

        ch_Adriver.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ch_Adriver);
        ch_Adriver.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adriver.setText("Si");
        ch_Adriver.setContentAreaFilled(false);
        ch_Adriver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Adriver.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Adriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 45, 30));

        ch_baan.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ch_baan);
        ch_baan.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_baan.setText("Si");
        ch_baan.setContentAreaFilled(false);
        ch_baan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_baan.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_baan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 45, 30));

        ch_Adorender.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ch_Adorender);
        ch_Adorender.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adorender.setText("Si");
        ch_Adorender.setContentAreaFilled(false);
        ch_Adorender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Adorender.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Adorender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_AdorenderActionPerformed(evt);
            }
        });
        jPanel.add(ch_Adorender, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 45, 30));

        ch_Danwer.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ch_Danwer);
        ch_Danwer.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Danwer.setText("Si");
        ch_Danwer.setContentAreaFilled(false);
        ch_Danwer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Danwer.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Danwer, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 45, 30));

        ch_Bitdefender.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ch_Bitdefender);
        ch_Bitdefender.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Bitdefender.setText("Si");
        ch_Bitdefender.setContentAreaFilled(false);
        ch_Bitdefender.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Bitdefender.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Bitdefender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_BitdefenderActionPerformed(evt);
            }
        });
        jPanel.add(ch_Bitdefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 45, 30));

        ch_sft_espsif.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup8.add(ch_sft_espsif);
        ch_sft_espsif.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_sft_espsif.setText("Si");
        ch_sft_espsif.setContentAreaFilled(false);
        ch_sft_espsif.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_sft_espsif.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_sft_espsif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_sft_espsifActionPerformed(evt);
            }
        });
        jPanel.add(ch_sft_espsif, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 45, 30));

        ch_Smarwie.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(ch_Smarwie);
        ch_Smarwie.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Smarwie.setText("Si");
        ch_Smarwie.setContentAreaFilled(false);
        ch_Smarwie.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Smarwie.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Smarwie, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 45, 30));

        ch_outlook.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup11.add(ch_outlook);
        ch_outlook.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_outlook.setText("Si");
        ch_outlook.setContentAreaFilled(false);
        ch_outlook.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_outlook.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_outlook, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 45, 30));

        ch_java.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(ch_java);
        ch_java.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_java.setText("Si");
        ch_java.setContentAreaFilled(false);
        ch_java.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_java.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_java.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_javaActionPerformed(evt);
            }
        });
        jPanel.add(ch_java, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 45, 30));

        ch_impresora.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup13.add(ch_impresora);
        ch_impresora.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_impresora.setText("Si");
        ch_impresora.setContentAreaFilled(false);
        ch_impresora.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_impresora.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_impresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_impresoraActionPerformed(evt);
            }
        });
        jPanel.add(ch_impresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 45, 30));

        ch_oneDriver.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup14.add(ch_oneDriver);
        ch_oneDriver.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oneDriver.setText("Si");
        ch_oneDriver.setContentAreaFilled(false);
        ch_oneDriver.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_oneDriver.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_oneDriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 45, 30));

        ch_oracle.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup9.add(ch_oracle);
        ch_oracle.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oracle.setText("Si");
        ch_oracle.setContentAreaFilled(false);
        ch_oracle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_oracle.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_oracle, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 45, 30));

        combox_windows.setBackground(new java.awt.Color(102, 102, 255));
        combox_windows.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        combox_windows.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Versión", "Windows 10 Home.22H2", "Windows 10 Pro.22H2", "Windows 10 Enterprise.22H2", "Windows 11 Home.22H2", "Windows 11 Pro.22H2" }));
        combox_windows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_windowsActionPerformed(evt);
            }
        });
        jPanel.add(combox_windows, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 210, -1));

        txt_buscar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        txt_buscar.setForeground(new java.awt.Color(0, 0, 255));
        txt_buscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_buscar.setOpaque(true);
        jPanel.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 160, 35));

        btn_buscar.setBackground(new java.awt.Color(51, 51, 255));
        btn_buscar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 400, 120, 35));

        jLabel1.setBackground(new java.awt.Color(60, 249, 1));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Global.png"))); // NOI18N
        jLabel1.setText("Global Protec");
        jPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/office.png"))); // NOI18N
        jLabel3.setText("Office 365");
        jPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        jLabel4.setText("Actualizacion Driver");
        jPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Baan.png"))); // NOI18N
        jLabel5.setText("Baan");
        jPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 230, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Adobe.png"))); // NOI18N
        jLabel6.setText("Adobe");
        jPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Dameware.png"))); // NOI18N
        jLabel7.setText("Damware");
        jPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 310, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BitLocker.png"))); // NOI18N
        jLabel9.setText("BitLocker");
        jPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 350, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Softwaree.png"))); // NOI18N
        jLabel10.setText("Software espesifico");
        jPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 110, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Oracle.png"))); // NOI18N
        jLabel11.setText("Cliente Oracle");
        jPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 150, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SmarViw.png"))); // NOI18N
        jLabel12.setText("Smart View");
        jPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 190, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Outlook.png"))); // NOI18N
        jLabel13.setText("Config Correo Outlook");
        jPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 230, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/java.png"))); // NOI18N
        jLabel14.setText("Java");
        jPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 270, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/impresora.png"))); // NOI18N
        jLabel15.setText("Config Impresoras");
        jPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 310, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/OneDriver.png"))); // NOI18N
        jLabel19.setText("One Driver");
        jPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 350, -1, -1));

        ch_Globa1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ch_Globa1);
        ch_Globa1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Globa1.setText("No");
        ch_Globa1.setContentAreaFilled(false);
        ch_Globa1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Globa1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Globa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_Globa1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_Globa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 110, 50, 30));

        ch_offi1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(ch_offi1);
        ch_offi1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_offi1.setText("No");
        ch_offi1.setContentAreaFilled(false);
        ch_offi1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_offi1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_offi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 150, 50, 30));

        ch_Adriver1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(ch_Adriver1);
        ch_Adriver1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adriver1.setText("No");
        ch_Adriver1.setContentAreaFilled(false);
        ch_Adriver1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Adriver1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Adriver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 190, 50, 30));

        ch_baan1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup4.add(ch_baan1);
        ch_baan1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_baan1.setText("No");
        ch_baan1.setContentAreaFilled(false);
        ch_baan1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_baan1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_baan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 230, 50, 30));

        ch_Adorender1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup5.add(ch_Adorender1);
        ch_Adorender1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adorender1.setText("No");
        ch_Adorender1.setContentAreaFilled(false);
        ch_Adorender1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Adorender1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Adorender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_Adorender1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_Adorender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 270, 50, 30));

        ch_Danwer1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup6.add(ch_Danwer1);
        ch_Danwer1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Danwer1.setText("No");
        ch_Danwer1.setContentAreaFilled(false);
        ch_Danwer1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Danwer1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Danwer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 310, 50, 30));

        ch_Bitdefender1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup7.add(ch_Bitdefender1);
        ch_Bitdefender1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Bitdefender1.setText("No");
        ch_Bitdefender1.setContentAreaFilled(false);
        ch_Bitdefender1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Bitdefender1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_Bitdefender1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_Bitdefender1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_Bitdefender1, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 350, 50, 30));

        ch_sft_espsif1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup8.add(ch_sft_espsif1);
        ch_sft_espsif1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_sft_espsif1.setText("No");
        ch_sft_espsif1.setContentAreaFilled(false);
        ch_sft_espsif1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_sft_espsif1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_sft_espsif1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_sft_espsif1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_sft_espsif1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 110, 50, 30));

        ch_oracle1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup9.add(ch_oracle1);
        ch_oracle1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oracle1.setText("No");
        ch_oracle1.setContentAreaFilled(false);
        ch_oracle1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_oracle1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_oracle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 150, 50, 30));

        ch_Smarwie1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup10.add(ch_Smarwie1);
        ch_Smarwie1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Smarwie1.setText("No");
        ch_Smarwie1.setContentAreaFilled(false);
        ch_Smarwie1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_Smarwie1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_Smarwie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 190, 50, 30));

        ch_outlook1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup11.add(ch_outlook1);
        ch_outlook1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_outlook1.setText("No");
        ch_outlook1.setContentAreaFilled(false);
        ch_outlook1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_outlook1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_outlook1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 230, 50, 30));

        ch_java1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup12.add(ch_java1);
        ch_java1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_java1.setText("No");
        ch_java1.setContentAreaFilled(false);
        ch_java1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_java1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_java1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_java1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_java1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 270, 50, 30));

        ch_impresora1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup13.add(ch_impresora1);
        ch_impresora1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_impresora1.setText("No");
        ch_impresora1.setContentAreaFilled(false);
        ch_impresora1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_impresora1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        ch_impresora1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_impresora1ActionPerformed(evt);
            }
        });
        jPanel.add(ch_impresora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 310, 50, 30));

        ch_oneDriver1.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup14.add(ch_oneDriver1);
        ch_oneDriver1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oneDriver1.setText("No");
        ch_oneDriver1.setContentAreaFilled(false);
        ch_oneDriver1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ch_oneDriver1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel.add(ch_oneDriver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 350, 50, 30));

        l1.setBackground(new java.awt.Color(255, 255, 255));
        l1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l1.setForeground(new java.awt.Color(255, 255, 255));
        l1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l1.setOpaque(true);
        jPanel.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 30, 30));

        l2.setBackground(new java.awt.Color(255, 255, 255));
        l2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l2.setForeground(new java.awt.Color(255, 255, 255));
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l2.setOpaque(true);
        jPanel.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 30, 30));

        l3.setBackground(new java.awt.Color(255, 255, 255));
        l3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l3.setForeground(new java.awt.Color(255, 255, 255));
        l3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l3.setOpaque(true);
        jPanel.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 30, 30));

        l4.setBackground(new java.awt.Color(255, 255, 255));
        l4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l4.setForeground(new java.awt.Color(255, 255, 255));
        l4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l4.setOpaque(true);
        jPanel.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 30, 30));

        l5.setBackground(new java.awt.Color(255, 255, 255));
        l5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l5.setForeground(new java.awt.Color(255, 255, 255));
        l5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l5.setOpaque(true);
        jPanel.add(l5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 30, 30));

        l6.setBackground(new java.awt.Color(255, 255, 255));
        l6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l6.setForeground(new java.awt.Color(255, 255, 255));
        l6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l6.setOpaque(true);
        jPanel.add(l6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 30, 30));

        l7.setBackground(new java.awt.Color(255, 255, 255));
        l7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l7.setForeground(new java.awt.Color(255, 255, 255));
        l7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l7.setOpaque(true);
        jPanel.add(l7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, 30, 30));

        l8.setBackground(new java.awt.Color(255, 255, 255));
        l8.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l8.setForeground(new java.awt.Color(255, 255, 255));
        l8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l8.setOpaque(true);
        jPanel.add(l8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 410, 30, 30));

        l9.setBackground(new java.awt.Color(255, 255, 255));
        l9.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l9.setForeground(new java.awt.Color(255, 255, 255));
        l9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l9.setOpaque(true);
        jPanel.add(l9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 30, 30));

        l10.setBackground(new java.awt.Color(255, 255, 255));
        l10.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l10.setForeground(new java.awt.Color(255, 255, 255));
        l10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l10.setOpaque(true);
        jPanel.add(l10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 30, 30));

        l11.setBackground(new java.awt.Color(255, 255, 255));
        l11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l11.setForeground(new java.awt.Color(255, 255, 255));
        l11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l11.setOpaque(true);
        jPanel.add(l11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 30, 30));

        l12.setBackground(new java.awt.Color(255, 255, 255));
        l12.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l12.setForeground(new java.awt.Color(255, 255, 255));
        l12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l12.setOpaque(true);
        jPanel.add(l12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 30, 30));

        l13.setBackground(new java.awt.Color(255, 255, 255));
        l13.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l13.setForeground(new java.awt.Color(255, 255, 255));
        l13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l13.setOpaque(true);
        jPanel.add(l13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 30, 30));

        l14.setBackground(new java.awt.Color(255, 255, 255));
        l14.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        l14.setForeground(new java.awt.Color(255, 255, 255));
        l14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 204), 1, true));
        l14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        l14.setOpaque(true);
        jPanel.add(l14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

        Modificar();
        Limpiar();

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        // Cerra();
    }//GEN-LAST:event_formWindowClosing

    private void ch_GlobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_GlobaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_GlobaActionPerformed

    private void ch_AdorenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_AdorenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_AdorenderActionPerformed

    private void ch_impresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_impresoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_impresoraActionPerformed

    private void ch_sft_espsifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_sft_espsifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_sft_espsifActionPerformed

    private void ch_javaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_javaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_javaActionPerformed

    private void combox_windowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_windowsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_windowsActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        txt_cod.setEditable(false);
        txt_serial.setEditable(false);

        Buscar();
        validarEquipos();
        // Limpiar();


    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed

    }//GEN-LAST:event_txt_codActionPerformed

    private void ch_BitdefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_BitdefenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_BitdefenderActionPerformed

    private void ch_Globa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_Globa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_Globa1ActionPerformed

    private void ch_Adorender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_Adorender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_Adorender1ActionPerformed

    private void ch_Bitdefender1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_Bitdefender1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_Bitdefender1ActionPerformed

    private void ch_sft_espsif1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_sft_espsif1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_sft_espsif1ActionPerformed

    private void ch_java1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_java1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_java1ActionPerformed

    private void ch_impresora1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_impresora1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_impresora1ActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_sft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_sft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_sft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_sft.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Modificar_sft().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_modificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    public javax.swing.JCheckBox ch_Adorender;
    public javax.swing.JCheckBox ch_Adorender1;
    public javax.swing.JCheckBox ch_Adriver;
    public javax.swing.JCheckBox ch_Adriver1;
    public javax.swing.JCheckBox ch_Bitdefender;
    public javax.swing.JCheckBox ch_Bitdefender1;
    public javax.swing.JCheckBox ch_Danwer;
    public javax.swing.JCheckBox ch_Danwer1;
    public javax.swing.JCheckBox ch_Globa;
    public javax.swing.JCheckBox ch_Globa1;
    public javax.swing.JCheckBox ch_Smarwie;
    public javax.swing.JCheckBox ch_Smarwie1;
    public javax.swing.JCheckBox ch_baan;
    public javax.swing.JCheckBox ch_baan1;
    public javax.swing.JCheckBox ch_impresora;
    public javax.swing.JCheckBox ch_impresora1;
    public javax.swing.JCheckBox ch_java;
    public javax.swing.JCheckBox ch_java1;
    public javax.swing.JCheckBox ch_offi;
    public javax.swing.JCheckBox ch_offi1;
    public javax.swing.JCheckBox ch_oneDriver;
    public javax.swing.JCheckBox ch_oneDriver1;
    public javax.swing.JCheckBox ch_oracle;
    public javax.swing.JCheckBox ch_oracle1;
    public javax.swing.JCheckBox ch_outlook;
    public javax.swing.JCheckBox ch_outlook1;
    public javax.swing.JCheckBox ch_sft_espsif;
    public javax.swing.JCheckBox ch_sft_espsif1;
    public javax.swing.JComboBox<String> combox_windows;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l10;
    private javax.swing.JLabel l11;
    private javax.swing.JLabel l12;
    private javax.swing.JLabel l13;
    private javax.swing.JLabel l14;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l5;
    private javax.swing.JLabel l6;
    private javax.swing.JLabel l7;
    private javax.swing.JLabel l8;
    private javax.swing.JLabel l9;
    public javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_cod;
    public javax.swing.JTextField txt_host;
    public javax.swing.JTextField txt_serial;
    // End of variables declaration//GEN-END:variables

    class Vista extends JPanel {

        @Override
        public void paint(Graphics g) {

            super.paint(g);

            ImageIcon imagen = new ImageIcon(getClass().getResource("Frame 7.png"));
            g.drawImage(imagen.getImage(), 0, 0, this);
        }

    }
}
