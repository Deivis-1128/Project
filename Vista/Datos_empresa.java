package Vista;

import Modelo.Conexion_MySQL;
import Modelo.Do;
import Modelo.Empresas;
import Modelo.Unidad_negocios;
import Modelo.centros_costos;
import Modelo.dependencia;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class Datos_empresa extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Datos_empresa() {
        initComponents();
       setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());

        this.setLocationRelativeTo(this);
        setTitle("Deivis Davila");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        jPanelEm.setSize(1920, 850);
        MostrarDatos();

        jd_fecha_ing.setCalendar(fecha);
        jd_fecha_sali.setCalendar(fecha);

        Empresas Em = new Empresas();
        DefaultComboBoxModel modelEm = new DefaultComboBoxModel(Em.Mostrar_Empresas());
        combox_empresa.setModel(modelEm);

    }

//--------------------------------------------------------------------------------------------------------------------------
    public void MostrarDatos() {
        String[] Titulos = {"Empresa", "Cargo", "TP-Contrato", "Dependencia", "Fecha-Inicio", "Fecha-Fin", "Jefe-area", "Estado", "Empleado"};
        String[] Registros = new String[9];
        DefaultTableModel model = new DefaultTableModel(null, Titulos);
        String Sql = "select * from datos_empresa";
        try {

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Empresa");
                Registros[1] = rs.getString("Cargo");
                Registros[2] = rs.getString("Tipo_contrato");
                Registros[3] = rs.getString("Dependencia");
                Registros[4] = rs.getString("Fecha_ingreso");
                Registros[5] = rs.getString("Fecha_salida");
                Registros[6] = rs.getString("Jefe_area");
                Registros[7] = rs.getString("Estado");
                Registros[8] = rs.getString("Cedula");

                model.addRow(Registros);
            }

            tbl_empresas.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al cargar los datos" + e.getMessage());
        }

    }
    //---->>>Fin Metodo Mostrar Datos.
//-------------------------------------------------------------------------------------------------------

    public void SeleccionarFila() {
        int Fila = tbl_empresas.getSelectedRow();
        if (Fila >= 0) {
            combox_empresa.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 0).toString());
            txt_cargo.setText((String) tbl_empresas.getValueAt(Fila, 1).toString());
            combox_Contrato.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 2).toString());
            combox_depen.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 3).toString());
            jd_fecha_ing.setDateFormatString(tbl_empresas.getValueAt(Fila, 4).toString());
            jd_fecha_sali.setDateFormatString(tbl_empresas.getValueAt(Fila, 5).toString());
            txt_Njefe.setText((String) tbl_empresas.getValueAt(Fila, 6).toString());
            combox_stadolaboral.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 7));
            txt_cedulaEm.setText((String) tbl_empresas.getValueAt(Fila, 8));
            combox_do.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 9).toString());
            combox_ccost.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 10).toString());
            combox_unegocio.setSelectedItem((String) tbl_empresas.getValueAt(Fila, 11).toString());
        } else {
            JOptionPane.showMessageDialog(null, "por favor seleccionar fila");
        }
    }

//-------------------------------------------------------------------------------------------------
    public void BuscarPersonas() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();
        int Fila = tbl_empresas.getSelectedRow();
        String Sql = "select*from personas where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jlb_nombre.setText(rs.getString("Nombre"));
                jlb_apellido.setText(rs.getString("Apellido"));
                jlb_cedula1.setText(rs.getString("Cedula"));
                jlb_telefono_1.setText(rs.getString("Telefono_1"));
                jlb_telefono_2.setText(rs.getString("Telefono_2"));
                jlb_correo.setText(rs.getString("Correo_electronico"));

            } else {
                JOptionPane.showMessageDialog(null, "El Usuario No Existe");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "El Usuario No Existe" + e.getMessage());
        }

    }

//---------------------------------------------------------------------------------------------------------
    public void Modificar() {
        int filaSeleccionada = tbl_empresas.getSelectedRow();
        String M = (String) tbl_empresas.getValueAt(filaSeleccionada, 7);
        String Sql = " Update datos_empresa Set Empresa=?,Cargo=?,Tipo_contrato=?,Dependencia=?,Fecha_ingreso=?,Fecha_salida=?,Jefe_area=?,Estado=?,Cedula=?,Do=?,Centro_costo=?,Unidad_negocio=? Where Cedula=?) ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, combox_empresa.getSelectedItem().toString());
            ps.setString(2, txt_cargo.getText());
            ps.setString(3, combox_Contrato.getSelectedItem().toString());
            ps.setString(4, combox_depen.getSelectedItem().toString());
            ps.setString(5, ((JTextField) jd_fecha_ing.getDateEditor().getUiComponent()).getText());
            ps.setString(6, ((JTextField) jd_fecha_sali.getDateEditor().getUiComponent()).getText());
            ps.setString(7, txt_Njefe.getText());

            ps.setString(8, combox_stadolaboral.getSelectedItem().toString());
            ps.setString(9, txt_cedulaEm.getText());
            ps.setString(10, combox_do.getSelectedItem().toString());
            ps.setString(11, combox_ccost.getSelectedItem().toString());
            ps.setString(12, combox_unegocio.getSelectedItem().toString());
            ps.setString(13, M);
            int E = ps.executeUpdate();
            if (E >= 0) {
                JOptionPane.showMessageDialog(null, "registro Modificado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de edicción " + e.getMessage());
        }

    }

//------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelEm = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_empresas = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jh = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlb_nombre = new javax.swing.JLabel();
        jlb_apellido = new javax.swing.JLabel();
        jlb_correo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlb_cedula1 = new javax.swing.JLabel();
        jlb_telefono_1 = new javax.swing.JLabel();
        jPanel_3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_cargo = new javax.swing.JTextField();
        combox_empresa = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jd_fecha_ing = new com.toedter.calendar.JDateChooser();
        jd_fecha_sali = new com.toedter.calendar.JDateChooser();
        combox_Contrato = new javax.swing.JComboBox<>();
        combox_stadolaboral = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_Njefe = new javax.swing.JTextField();
        combox_depen = new javax.swing.JComboBox<>();
        combox_do = new javax.swing.JComboBox<>();
        combox_ccost = new javax.swing.JComboBox<>();
        combox_unegocio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        ntn_limpiar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_buscar = new javax.swing.JTextField();
        txt_cedulaEm = new javax.swing.JTextField();
        jh1 = new javax.swing.JLabel();
        jlb_telefono_2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 760));
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEm.setBackground(new java.awt.Color(204, 204, 204));
        jPanelEm.setMinimumSize(new java.awt.Dimension(1500, 760));
        jPanelEm.setPreferredSize(new java.awt.Dimension(1500, 760));
        jPanelEm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_empresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_empresas);

        jPanelEm.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 1470, 450));

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nombre:");
        jPanelEm.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 695, 70, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Correo electronico:");
        jPanelEm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 695, 140, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Apellido:");
        jPanelEm.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 695, 70, -1));

        jh.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jh.setForeground(new java.awt.Color(0, 0, 0));
        jh.setText("Telefono 1:");
        jPanelEm.add(jh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 695, 80, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cedula:");
        jPanelEm.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 695, 60, -1));

        jlb_nombre.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_nombre.setForeground(new java.awt.Color(0, 0, 255));
        jlb_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jlb_nombreKeyReleased(evt);
            }
        });
        jPanelEm.add(jlb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 695, 170, 20));

        jlb_apellido.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_apellido.setForeground(new java.awt.Color(0, 0, 255));
        jPanelEm.add(jlb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 695, 180, 20));

        jlb_correo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_correo.setForeground(new java.awt.Color(0, 0, 255));
        jPanelEm.add(jlb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 695, 190, 20));

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("0");
        jPanelEm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1515, 310, 10, -1));

        jlb_cedula1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_cedula1.setForeground(new java.awt.Color(0, 0, 255));
        jPanelEm.add(jlb_cedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 695, 120, 20));

        jlb_telefono_1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_telefono_1.setForeground(new java.awt.Color(0, 0, 255));
        jPanelEm.add(jlb_telefono_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 695, 130, 20));

        jPanel_3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel_3.setOpaque(false);
        jPanel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Tipo de contrato:");
        jPanel_3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 130, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Cargo:");
        jPanel_3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 50, 20));
        jPanel_3.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 200, -1));

        combox_empresa.setBackground(new java.awt.Color(42, 255, 0));
        combox_empresa.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        combox_empresa.setForeground(new java.awt.Color(0, 0, 0));
        combox_empresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_empresaItemStateChanged(evt);
            }
        });
        combox_empresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_empresaActionPerformed(evt);
            }
        });
        jPanel_3.add(combox_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Fecha de ingreso:");
        jPanel_3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 130, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Fecha de salida:");
        jPanel_3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 120, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Empresa:");
        jPanel_3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre de Jefe del Area:");
        jPanel_3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 190, -1));

        jd_fecha_ing.setDateFormatString("dd/MM/yyyy");
        jPanel_3.add(jd_fecha_ing, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 140, -1));

        jd_fecha_sali.setDateFormatString("dd/MM/yyyy");
        jPanel_3.add(jd_fecha_sali, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 150, -1));

        combox_Contrato.setBackground(new java.awt.Color(42, 255, 0));
        combox_Contrato.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        combox_Contrato.setForeground(new java.awt.Color(255, 255, 255));
        combox_Contrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Fijo", "Indefinido", "Obra o labor", "Practicante", " " }));
        jPanel_3.add(combox_Contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, -1));

        combox_stadolaboral.setBackground(new java.awt.Color(42, 255, 0));
        combox_stadolaboral.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        combox_stadolaboral.setForeground(new java.awt.Color(255, 255, 255));
        combox_stadolaboral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione estado", "Activo", "Retirado", "Reingreso" }));
        combox_stadolaboral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_stadolaboralActionPerformed(evt);
            }
        });
        jPanel_3.add(combox_stadolaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 210, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Estado:");
        jPanel_3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));
        jPanel_3.add(txt_Njefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 220, -1));

        combox_depen.setBackground(new java.awt.Color(42, 255, 0));
        combox_depen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_depenItemStateChanged(evt);
            }
        });
        combox_depen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_depenActionPerformed(evt);
            }
        });
        combox_depen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combox_depenKeyReleased(evt);
            }
        });
        jPanel_3.add(combox_depen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 200, -1));

        combox_do.setBackground(new java.awt.Color(42, 255, 0));
        combox_do.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_doItemStateChanged(evt);
            }
        });
        jPanel_3.add(combox_do, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 120, -1));

        combox_ccost.setBackground(new java.awt.Color(42, 255, 0));
        combox_ccost.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_ccostItemStateChanged(evt);
            }
        });
        jPanel_3.add(combox_ccost, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 230, -1));

        combox_unegocio.setBackground(new java.awt.Color(42, 255, 0));
        combox_unegocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_unegocioItemStateChanged(evt);
            }
        });
        jPanel_3.add(combox_unegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 250, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Dependencia:");
        jPanel_3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 100, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("DO:");
        jPanel_3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 37, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Centro de costo:");
        jPanel_3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 120, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Unidad de negocio:");
        jPanel_3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 170, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Actualizar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel_3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, -1, -1));

        jButton5.setBackground(new java.awt.Color(0, 0, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Modificar");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel_3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 100, -1));

        ntn_limpiar1.setBackground(new java.awt.Color(0, 0, 255));
        ntn_limpiar1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ntn_limpiar1.setForeground(new java.awt.Color(255, 255, 255));
        ntn_limpiar1.setText("Limpiar");
        ntn_limpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ntn_limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntn_limpiar1ActionPerformed(evt);
            }
        });
        jPanel_3.add(ntn_limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 90, -1));

        jButton1.setBackground(new java.awt.Color(102, 255, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        txt_buscar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        txt_buscar.setForeground(new java.awt.Color(0, 0, 0));
        jPanel_3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 270, 30));
        jPanel_3.add(txt_cedulaEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 170, 140, -1));

        jPanelEm.add(jPanel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1170, 210));

        jh1.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jh1.setForeground(new java.awt.Color(0, 0, 0));
        jh1.setText("Telefono 2:");
        jPanelEm.add(jh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 695, 80, 20));

        jlb_telefono_2.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_telefono_2.setForeground(new java.awt.Color(0, 0, 255));
        jPanelEm.add(jlb_telefono_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 695, 130, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/planta.png"))); // NOI18N
        jPanelEm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 50, -1, 190));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_menu.setForeground(new java.awt.Color(0, 0, 0));
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
        jPanelEm.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, -1, -1));

        getContentPane().add(jPanelEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 760));

        jMenuBar1.setBackground(new java.awt.Color(51, 255, 0));
        jMenuBar1.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        jMenuBar1.setOpaque(true);

        jMenu1.setBackground(new java.awt.Color(255, 255, 0));
        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
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

        jMenuItem5.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cadena-de-valor (1).png"))); // NOI18N
        jMenuItem5.setText("Centros de costos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//SeleccionarFila();

        BuscarPersonas();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        Direccion D = new Direccion();
        D.setVisible(rootPaneCheckingEnabled);
        dispose();

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:

        Datos_CentrosCostos cos = new Datos_CentrosCostos();
        cos.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MostrarDatos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void ntn_limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntn_limpiar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ntn_limpiar1ActionPerformed

    private void combox_empresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_empresaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Empresas Em = (Empresas) combox_empresa.getSelectedItem();
            dependencia dep = new dependencia();

            DefaultComboBoxModel modeloDependencia = new DefaultComboBoxModel(dep.Mostrar_Dependencias(Em.getId()));

            combox_depen.setModel(modeloDependencia);

        }

    }//GEN-LAST:event_combox_empresaItemStateChanged

    private void combox_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_empresaActionPerformed

    private void combox_stadolaboralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_stadolaboralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_stadolaboralActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Datos_personales P = new Datos_personales();
        P.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();

    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(224, 255, 0));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void jlb_nombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlb_nombreKeyReleased

    }//GEN-LAST:event_jlb_nombreKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Modificar();
        SeleccionarFila();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void combox_depenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_depenItemStateChanged
        //       // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dependencia dep = (dependencia) combox_depen.getSelectedItem();
            Do D = new Do();

            DefaultComboBoxModel modelD = new DefaultComboBoxModel(D.Mostrar_Do(dep.getId()));

            combox_do.setModel(modelD);

        }
    }//GEN-LAST:event_combox_depenItemStateChanged

    private void combox_depenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_depenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_depenActionPerformed

    private void combox_depenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combox_depenKeyReleased

    }//GEN-LAST:event_combox_depenKeyReleased

    private void combox_doItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_doItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Do D = (Do) combox_do.getSelectedItem();
            centros_costos C = new centros_costos();
            DefaultComboBoxModel modelU = new DefaultComboBoxModel(C.Mostrar_centros_costos(D.getId()));
            combox_ccost.setModel(modelU);

        }
    }//GEN-LAST:event_combox_doItemStateChanged

    private void combox_ccostItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_ccostItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            centros_costos cen = (centros_costos) combox_ccost.getSelectedItem();
            Unidad_negocios U = new Unidad_negocios();

            DefaultComboBoxModel modelU = new DefaultComboBoxModel(U.Mostrar_Unidad_negocios(cen.getId()));

            combox_unegocio.setModel(modelU);

        }

    }//GEN-LAST:event_combox_ccostItemStateChanged

    private void combox_unegocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_unegocioItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Unidad_negocios f = (Unidad_negocios) combox_unegocio.getSelectedItem();

        }

    }//GEN-LAST:event_combox_unegocioItemStateChanged

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
            java.util.logging.Logger.getLogger(Datos_empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_empresa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_empresa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_menu;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> combox_Contrato;
    public javax.swing.JComboBox<String> combox_ccost;
    public javax.swing.JComboBox<String> combox_depen;
    public javax.swing.JComboBox<String> combox_do;
    public javax.swing.JComboBox<String> combox_empresa;
    public javax.swing.JComboBox<String> combox_stadolaboral;
    public javax.swing.JComboBox<String> combox_unegocio;
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel20;
    public javax.swing.JLabel jLabel21;
    public javax.swing.JLabel jLabel22;
    public javax.swing.JLabel jLabel23;
    public javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel32;
    public javax.swing.JLabel jLabel33;
    public javax.swing.JLabel jLabel34;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JPanel jPanelEm;
    public javax.swing.JPanel jPanel_3;
    private javax.swing.JScrollPane jScrollPane1;
    public com.toedter.calendar.JDateChooser jd_fecha_ing;
    public com.toedter.calendar.JDateChooser jd_fecha_sali;
    private javax.swing.JLabel jh;
    private javax.swing.JLabel jh1;
    public javax.swing.JLabel jlb_apellido;
    public javax.swing.JLabel jlb_cedula1;
    public javax.swing.JLabel jlb_correo;
    public javax.swing.JLabel jlb_nombre;
    public javax.swing.JLabel jlb_telefono_1;
    public javax.swing.JLabel jlb_telefono_2;
    public javax.swing.JButton ntn_limpiar1;
    private javax.swing.JTable tbl_empresas;
    public javax.swing.JTextField txt_Njefe;
    public javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_cargo;
    public javax.swing.JTextField txt_cedulaEm;
    // End of variables declaration//GEN-END:variables
}
