package Vista;

import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
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
public class Software extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

    public Software() {
        // this.setContentPane(m);
        initComponents();
        setLocationRelativeTo(this);

        setTitle("Software y configuraciones");
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
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

//-------------------------------------------------------------------------------------------------
    public void IsertarSoftware() {
        String Sql = "Insert Into software_equipos(Hostname,Serial,Codigo,Sistema_operativo,Office,Adobe_reader,Actualizacion_controladores,Cifrado_unida_bitlocker,One_driver,Configuracion_baan,Cofiguracion_impresora,Configracion_outlook,Java,Global_protec,Smart_view,Cliente_oracle,Software_especial,Damaware)   Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int resul = 0;
        String seleccion = "Si";
        String eleccion = "NO";
        try {
            PreparedStatement ps = com.prepareStatement(Sql);

            ps.setString(1, txt_host.getText());
            ps.setString(2, txt_serial.getText());
            ps.setString(3, txt_cod.getText());
            ps.setString(4, combox_windows.getSelectedItem().toString());
            if (ch_offi.isSelected()) {
                ps.setString(5, seleccion);
            } else {
                ps.setString(5, eleccion);
            }
            if (ch_Adorender.isSelected()) {
                ps.setString(6, seleccion);
            } else {
                ps.setString(6, eleccion);
            }
            if (ch_Adriver.isSelected()) {
                ps.setString(7, seleccion);
            } else {
                ps.setString(7, eleccion);
            }
            if (ch_Bitdefender.isSelected()) {
                ps.setString(8, seleccion);
            } else {
                ps.setString(8, eleccion);
            }
            if (ch_oneDriver.isSelected()) {
                ps.setString(9, seleccion);
            } else {
                ps.setString(9, eleccion);
            }
            if (ch_baan.isSelected()) {
                ps.setString(10, seleccion);
            } else {
                ps.setString(10, eleccion);
            }
            if (ch_impresora.isSelected()) {
                ps.setString(11, seleccion);
            } else {
                ps.setString(11, eleccion);
            }
            if (ch_outlook.isSelected()) {
                ps.setString(12, seleccion);
            } else {
                ps.setString(12, eleccion);
            }
            if (ch_java.isSelected()) {
                ps.setString(13, seleccion);
            } else {
                ps.setString(13, eleccion);
            }
            if (ch_Globa.isSelected()) {
                ps.setString(14, seleccion);
            } else {
                ps.setString(14, eleccion);
            }
            if (ch_Smarwie.isSelected()) {
                ps.setString(15, seleccion);
            } else {
                ps.setString(15, eleccion);
            }
            if (ch_oracle.isSelected()) {
                ps.setString(16, seleccion);
            } else {
                ps.setString(16, eleccion);
            }
            if (ch_sft_espsif.isSelected()) {
                ps.setString(17, seleccion);
            } else {
                ps.setString(17, eleccion);
            }
            if (ch_Danwer.isSelected()) {
                ps.setString(18, seleccion);
            } else {
                ps.setString(18, eleccion);
            }

            ps.execute();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (Exception e) {
             validarSerial();
            validarSoftware();
            validarEquipos();
            Limpiar();
            
        }

    }

//-------------------------------------------------------------------------------------------------
   

//----------------------------------------------------------------------------------------------
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

                JOptionPane.showMessageDialog(null, "El equipo " + txt_cod.getText() + "\nNo existe en la base de datos", "Alerta", 0, icono);
            }

        } catch (SQLException ex) {

        }

    }
//----------------------------------------------------------------------------------------------

    public void validarSoftware() {

        int resul = 0;

        String Codigo = txt_cod.getText();
        

        String SQL = "select * from software_equipos where Codigo='" + Codigo + "' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
JOptionPane.showMessageDialog(null, "Error El Equipo Que Estas Ingresando\n          Ya Esta Configurado", "", 0, icono);
                
                }

            } 

        } catch (SQLException ex) {

        }

    }
//---------------------------------------------------------------------------------------------
     public void validarSerial() {

        int resul = 0;

        String Serial = txt_serial.getText();
        String Codigo = txt_cod.getText();
      String SQL = "select * from software_equipos where Codigo='" + Codigo + "' or '"+Serial+"' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
JOptionPane.showMessageDialog(null, "El serial que Estas Ingresando\nYa esta asignsdo a otro equipo","Alerta", 0, icono);
                }

            } 

        } catch (SQLException ex) {

        }

    }
    //-----------------------------------------------------------------------------------------

    public void Limpiar() {
        txt_cod.setText("");
        txt_serial.setText("");
        txt_host.setText("");
        combox_windows.setSelectedIndex(0);
        ch_offi.setSelected(false);
        ch_Adorender.setSelected(false);
        ch_Adriver.setSelected(false);
        ch_Bitdefender.setSelected(false);
        ch_oneDriver.setSelected(false);
        ch_baan.setSelected(false);
        ch_impresora.setSelected(false);
        ch_outlook.setSelected(false);
        ch_java.setSelected(false);
        ch_Globa.setSelected(false);
        ch_Smarwie.setSelected(false);
        ch_oracle.setSelected(false);
        ch_sft_espsif.setSelected(false);
        ch_Danwer.setSelected(false);

    }

//---------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        txt_serial = new javax.swing.JTextField();
        txt_host = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        combox_windows = new javax.swing.JComboBox<>();
        btn_limpiar = new javax.swing.JButton();
        ch_Globa = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        ch_offi = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        ch_Adriver = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        ch_baan = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        ch_Adorender = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        ch_Danwer = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        ch_Bitdefender = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ch_impresora = new javax.swing.JCheckBox();
        ch_oneDriver = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ch_java = new javax.swing.JCheckBox();
        ch_outlook = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        ch_Smarwie = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        ch_oracle = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        ch_sft_espsif = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuracion de Software");
        setResizable(false);
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuracion De Software", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 24), new java.awt.Color(51, 51, 255))); // NOI18N
        jPanel.setPreferredSize(new java.awt.Dimension(880, 406));
        jPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Windows.png"))); // NOI18N
        jLabel2.setText("Windows");
        jPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 110, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setText("HostName:");
        jPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 100, -1));

        jLabel16.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel16.setText("Codigo Equipo:");
        jPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 130, -1));

        jLabel17.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel17.setText("Serial:");
        jPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 60, -1));

        txt_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codActionPerformed(evt);
            }
        });
        jPanel.add(txt_cod, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 160, -1));
        jPanel.add(txt_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 180, -1));
        jPanel.add(txt_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 140, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/software (1).png"))); // NOI18N
        jPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        btn_guardar.setBackground(new java.awt.Color(51, 51, 255));
        btn_guardar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 140, -1));

        combox_windows.setBackground(new java.awt.Color(102, 102, 255));
        combox_windows.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        combox_windows.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una Versión", "Windows 10 Home.22H2", "Windows 10 Pro.22H2", "Windows 10 Enterprise.22H2", "Windows 11 Home.22H2", "Windows 11 Pro.22H2" }));
        combox_windows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_windowsActionPerformed(evt);
            }
        });
        jPanel.add(combox_windows, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 210, -1));

        btn_limpiar.setBackground(new java.awt.Color(51, 51, 255));
        btn_limpiar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/polvo.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, -1));

        ch_Globa.setBackground(new java.awt.Color(255, 255, 255));
        ch_Globa.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Globa.setContentAreaFilled(false);
        ch_Globa.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_Globa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_GlobaActionPerformed(evt);
            }
        });
        jPanel.add(ch_Globa, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 110, 60, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Global.png"))); // NOI18N
        jLabel1.setText("Global Protec");
        jPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        ch_offi.setBackground(new java.awt.Color(255, 255, 255));
        ch_offi.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_offi.setContentAreaFilled(false);
        ch_offi.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_offi, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 150, 60, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/office.png"))); // NOI18N
        jLabel3.setText("Office 365");
        jPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        ch_Adriver.setBackground(new java.awt.Color(255, 255, 255));
        ch_Adriver.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adriver.setContentAreaFilled(false);
        ch_Adriver.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_Adriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 190, 60, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        jLabel4.setText("Actualizacion Driver");
        jPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        ch_baan.setBackground(new java.awt.Color(255, 255, 255));
        ch_baan.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_baan.setContentAreaFilled(false);
        ch_baan.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_baan, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 230, 60, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Baan.png"))); // NOI18N
        jLabel5.setText("Baan");
        jPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, -1, -1));

        ch_Adorender.setBackground(new java.awt.Color(255, 255, 255));
        ch_Adorender.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Adorender.setContentAreaFilled(false);
        ch_Adorender.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_Adorender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_AdorenderActionPerformed(evt);
            }
        });
        jPanel.add(ch_Adorender, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 270, 60, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Adobe.png"))); // NOI18N
        jLabel6.setText("Adobe");
        jPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        ch_Danwer.setBackground(new java.awt.Color(255, 255, 255));
        ch_Danwer.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Danwer.setContentAreaFilled(false);
        ch_Danwer.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_Danwer, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 310, 60, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Dameware.png"))); // NOI18N
        jLabel7.setText("Damware");
        jPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        ch_Bitdefender.setBackground(new java.awt.Color(255, 255, 255));
        ch_Bitdefender.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Bitdefender.setContentAreaFilled(false);
        ch_Bitdefender.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_Bitdefender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_BitdefenderActionPerformed(evt);
            }
        });
        jPanel.add(ch_Bitdefender, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 350, 60, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BitLocker.png"))); // NOI18N
        jLabel9.setText("BitLocker");
        jPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/OneDriver.png"))); // NOI18N
        jLabel19.setText("One Driver");
        jPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, -1, -1));

        ch_impresora.setBackground(new java.awt.Color(255, 255, 255));
        ch_impresora.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_impresora.setContentAreaFilled(false);
        ch_impresora.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_impresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_impresoraActionPerformed(evt);
            }
        });
        jPanel.add(ch_impresora, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 310, 60, 30));

        ch_oneDriver.setBackground(new java.awt.Color(255, 255, 255));
        ch_oneDriver.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oneDriver.setContentAreaFilled(false);
        ch_oneDriver.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_oneDriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 350, 60, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/impresora.png"))); // NOI18N
        jLabel15.setText("Config Impresoras");
        jPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/java.png"))); // NOI18N
        jLabel14.setText("Java");
        jPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, -1, -1));

        ch_java.setBackground(new java.awt.Color(255, 255, 255));
        ch_java.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_java.setContentAreaFilled(false);
        ch_java.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_java.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_javaActionPerformed(evt);
            }
        });
        jPanel.add(ch_java, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 270, 60, 30));

        ch_outlook.setBackground(new java.awt.Color(255, 255, 255));
        ch_outlook.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_outlook.setContentAreaFilled(false);
        ch_outlook.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_outlook, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 230, 60, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Outlook.png"))); // NOI18N
        jLabel13.setText("Config Correo Outlook");
        jPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, -1, -1));

        ch_Smarwie.setBackground(new java.awt.Color(255, 255, 255));
        ch_Smarwie.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_Smarwie.setContentAreaFilled(false);
        ch_Smarwie.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_Smarwie, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 190, 60, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/SmarViw.png"))); // NOI18N
        jLabel12.setText("Smart View");
        jPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        ch_oracle.setBackground(new java.awt.Color(255, 255, 255));
        ch_oracle.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_oracle.setContentAreaFilled(false);
        ch_oracle.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel.add(ch_oracle, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 150, 60, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Oracle.png"))); // NOI18N
        jLabel11.setText("Cliente Oracle");
        jPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, -1, -1));

        ch_sft_espsif.setBackground(new java.awt.Color(255, 255, 255));
        ch_sft_espsif.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        ch_sft_espsif.setContentAreaFilled(false);
        ch_sft_espsif.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ch_sft_espsif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ch_sft_espsifActionPerformed(evt);
            }
        });
        jPanel.add(ch_sft_espsif, new org.netbeans.lib.awtextra.AbsoluteConstraints(645, 110, 60, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Softwaree.png"))); // NOI18N
        jLabel10.setText("Software espesifico");
        jPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        IsertarSoftware();

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }//GEN-LAST:event_formWindowClosing

    private void combox_windowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_windowsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_windowsActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codActionPerformed

    }//GEN-LAST:event_txt_codActionPerformed

    private void ch_GlobaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_GlobaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_GlobaActionPerformed

    private void ch_AdorenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_AdorenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_AdorenderActionPerformed

    private void ch_BitdefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_BitdefenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_BitdefenderActionPerformed

    private void ch_impresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_impresoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_impresoraActionPerformed

    private void ch_javaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_javaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_javaActionPerformed

    private void ch_sft_espsifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ch_sft_espsifActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ch_sft_espsifActionPerformed

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_formInputMethodTextChanged

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
            java.util.logging.Logger.getLogger(Software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Software.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Software().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_guardar;
    public javax.swing.JButton btn_limpiar;
    public javax.swing.JCheckBox ch_Adorender;
    public javax.swing.JCheckBox ch_Adriver;
    public javax.swing.JCheckBox ch_Bitdefender;
    public javax.swing.JCheckBox ch_Danwer;
    public javax.swing.JCheckBox ch_Globa;
    public javax.swing.JCheckBox ch_Smarwie;
    public javax.swing.JCheckBox ch_baan;
    public javax.swing.JCheckBox ch_impresora;
    public javax.swing.JCheckBox ch_java;
    public javax.swing.JCheckBox ch_offi;
    public javax.swing.JCheckBox ch_oneDriver;
    public javax.swing.JCheckBox ch_oracle;
    public javax.swing.JCheckBox ch_outlook;
    public javax.swing.JCheckBox ch_sft_espsif;
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
