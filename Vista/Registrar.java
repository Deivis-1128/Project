package Vista;

import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
import Modelo.Do;
import Modelo.Empresas;
import Modelo.Unidad_negocios;
import Modelo.centros_costos;
import Modelo.dependencia;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author deivi
 */
public class Registrar extends javax.swing.JFrame {
    
    PreparedStatement ps = null;
    Calendar fecha = new GregorianCalendar();
    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    /**
     * Creates new form NewJFrame
     */
    public Registrar() {
        initComponents();
//------------------------------------------------------------------------------------------------
       setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setLocationRelativeTo(this);
        txt_cedulaDirecion.setVisible(false);
        txt_cedulaEmpresa.setVisible(false);
        jd_fecha_ing.setCalendar(fecha);
        jd_fecha_sali.setCalendar(fecha);
    Empresas Em = new Empresas();
        DefaultComboBoxModel modelEm = new DefaultComboBoxModel(Em.Mostrar_Empresas());
        combox_empresa.setModel(modelEm);
    }


//------------------------------------------------------------------------------------------
public void Limpiar(){
txt_nombre.setText("");
txt_apellido.setText("");
txt_cedula.setText("");
txt_correo.setText("");
txt_telefono_1.setText("");
txt_telefono_2.setText("");
txt_deprtamento.setText("");
txt_ciudad.setText("");
txt_carrera.setText("");
txt_calle.setText("");
txt_localida.setText("");
txt_barrio.setText("");
txt_codigopostal.setText("");
combox_empresa.setSelectedIndex(0);
combox_depen.setSelectedIndex(0);
combox_do.setSelectedIndex(0);
combox_ccost.setSelectedIndex(0);
combox_unegocio.setSelectedIndex(0);
combox_Contrato.setSelectedIndex(0);
combox_stadolaboral.setSelectedIndex(0);
txt_cargo.setText("");
txt_Njefe.setText("");
jd_fecha_ing.setToolTipText("");
jd_fecha_sali.setToolTipText("");





}
//---------------------------------------------------------------------------------------------------
    public static boolean validarnumeros(String datos) {
        
        return datos.matches("[0-9]*");
    }

//---------------------------------------------------------------------------------------------------
    public void IngrearPersonas() {
        Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
        
        String Sql = "INSERT INTO personas(Nombre,Apellido,Cedula,Telefono_1,Telefono_2,Correo_electronico) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_nombre.getText());
            ps.setString(2, txt_apellido.getText());
            ps.setString(3, txt_cedula.getText());
            ps.setString(4, txt_telefono_1.getText());
            ps.setString(5, txt_telefono_2.getText());
            ps.setString(6, txt_correo.getText());
            
            ps.execute();
            JOptionPane.showMessageDialog(rootPane, "Registro exitoso", "", 0, icon);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error El Campo Cedula Solo Admite Valor Numerico Sin Caracteres Especiales" + e.getMessage());
        }
        
    }
//---->>> Fin Metodo Registrar Personas.

//----------------------------------------------------------------------
//---->>>Metodo Insertar Direccion.
    public void Direcion() {
        String Sql = "Insert Into direcciones(departamento,Ciudad,Localidad,Carrera,Calle,Barrio,Codigo_postal,Cedula) Values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            
            ps.setString(1, txt_deprtamento.getText());
            ps.setString(2, txt_ciudad.getText());
            ps.setString(3, txt_localida.getText());
            ps.setString(4, txt_carrera.getText());
            ps.setString(5, txt_calle.getText());
            ps.setString(6, txt_barrio.getText());
            ps.setString(7, txt_codigopostal.getText());
            ps.setString(8, txt_cedulaEmpresa.getText());
            
            ps.execute();

            //JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error Direc " + e.getMessage());
            
        }
        
    }
//---->>>Fin MetodoDireccion.

//----------------------------------------------------------------------
//---->>>Inicio Metodo Insertar Empresas.
    public void Insertar_Datos_Empresas() {
        
        String Sql = " Insert Into datos_empresa(Empresa,Cargo,Tipo_contrato,Dependencia,Fecha_ingreso,Fecha_salida,Jefe_area,Estado,Cedula,Do,Centro_costo,Unidad_negocio) Values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        
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
            ps.setString(9, txt_cedulaEmpresa.getText());
            ps.setString(10, combox_do.getSelectedItem().toString());
            ps.setString(11, combox_ccost.getSelectedItem().toString());
            ps.setString(12, combox_unegocio.getSelectedItem().toString());
            
            ps.execute();
            //JOptionPane.showMessageDialog(null, "registro Exitoso");

        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Error de registro Empresa  ");
        }
        
    }

    //---->>>Fin Metodo Empresas.
//----------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Botones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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
        jLabel2 = new javax.swing.JLabel();
        combox_do = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        combox_ccost = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        combox_unegocio = new javax.swing.JComboBox<>();
        btn_guardar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_cedulaEmpresa = new javax.swing.JTextField();
        jPanel_2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txt_codigopostal = new javax.swing.JTextField();
        txt_deprtamento = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JTextField();
        txt_carrera = new javax.swing.JTextField();
        txt_calle = new javax.swing.JTextField();
        txt_localida = new javax.swing.JTextField();
        txt_barrio = new javax.swing.JTextField();
        txt_cedulaDirecion = new javax.swing.JTextField();
        jPanel_1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_telefono_1 = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_telefono_2 = new javax.swing.JTextField();
        jbl_logo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 580));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 580));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel_3.setOpaque(false);
        jPanel_3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Tipo de contrato:");
        jPanel_3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Cargo:");
        jPanel_3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, -1));
        jPanel_3.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 200, -1));

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
        combox_empresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combox_empresaKeyReleased(evt);
            }
        });
        jPanel_3.add(combox_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 310, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Fecha de ingreso:");
        jPanel_3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 130, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Fecha de Retiro:");
        jPanel_3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 120, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Empresa:");
        jPanel_3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre de Jefe del Area:");
        jPanel_3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 190, -1));

        jd_fecha_ing.setDateFormatString("dd/MM/yyyy");
        jPanel_3.add(jd_fecha_ing, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 140, -1));

        jd_fecha_sali.setDateFormatString("dd/MM/yyyy");
        jPanel_3.add(jd_fecha_sali, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 150, -1));

        combox_Contrato.setBackground(new java.awt.Color(42, 255, 0));
        combox_Contrato.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        combox_Contrato.setForeground(new java.awt.Color(255, 255, 255));
        combox_Contrato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Fijo", "Indefinido", "Obra o labor", "Practicante", " " }));
        jPanel_3.add(combox_Contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 190, -1));

        combox_stadolaboral.setBackground(new java.awt.Color(42, 255, 0));
        combox_stadolaboral.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        combox_stadolaboral.setForeground(new java.awt.Color(255, 255, 255));
        combox_stadolaboral.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione estado", "Activo", "Reingreso" }));
        combox_stadolaboral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_stadolaboralActionPerformed(evt);
            }
        });
        jPanel_3.add(combox_stadolaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 210, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Estado:");
        jPanel_3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));
        jPanel_3.add(txt_Njefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 220, -1));

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
        jPanel_3.add(combox_depen, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 270, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Dependencia:");
        jPanel_3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 100, -1));

        combox_do.setBackground(new java.awt.Color(42, 255, 0));
        combox_do.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_doItemStateChanged(evt);
            }
        });
        jPanel_3.add(combox_do, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 140, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("DO:");
        jPanel_3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 30, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Centro de costo:");
        jPanel_3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, -1));

        combox_ccost.setBackground(new java.awt.Color(42, 255, 0));
        combox_ccost.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_ccostItemStateChanged(evt);
            }
        });
        combox_ccost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_ccostActionPerformed(evt);
            }
        });
        jPanel_3.add(combox_ccost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 290, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Unidad de negocio:");
        jPanel_3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 130, -1));

        combox_unegocio.setBackground(new java.awt.Color(42, 255, 0));
        combox_unegocio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combox_unegocioItemStateChanged(evt);
            }
        });
        jPanel_3.add(combox_unegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 300, -1));

        btn_guardar.setBackground(new java.awt.Color(174, 187, 189));
        btn_guardar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_guardar.setForeground(new java.awt.Color(255, 255, 255));
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_guardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_guardarMouseExited(evt);
            }
        });
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel_3.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 130, -1));

        btn_cancelar.setBackground(new java.awt.Color(174, 187, 189));
        btn_cancelar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/polvo.png"))); // NOI18N
        btn_cancelar.setText("Limpiar");
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelarMouseEntered(evt);
            }
        });
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel_3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 130, -1));
        jPanel_3.add(txt_cedulaEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, 30, -1));

        jPanel1.add(jPanel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 995, 240));

        jPanel_2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Direccion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel_2.setOpaque(false);
        jPanel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Codigo postal:");
        jPanel_2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 75, 130, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Departamento:");
        jPanel_2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ciudad:");
        jPanel_2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 70, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Carrera:");
        jPanel_2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 70, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Localidad:");
        jPanel_2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 75, 90, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Calle:");
        jPanel_2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 75, 60, -1));

        jLabel31.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Barrio:");
        jPanel_2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 75, 60, -1));
        jPanel_2.add(txt_codigopostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 75, 100, -1));

        txt_deprtamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_deprtamentoActionPerformed(evt);
            }
        });
        jPanel_2.add(txt_deprtamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 170, -1));
        jPanel_2.add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 180, -1));
        jPanel_2.add(txt_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 40, 90, -1));
        jPanel_2.add(txt_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 75, 90, -1));
        jPanel_2.add(txt_localida, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 75, 170, -1));

        txt_barrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_barrioActionPerformed(evt);
            }
        });
        jPanel_2.add(txt_barrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, 180, -1));
        jPanel_2.add(txt_cedulaDirecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 20, 30, -1));

        jPanel1.add(jPanel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 995, 110));

        jPanel_1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 3, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel_1.setOpaque(false);
        jPanel_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel_1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel_1MouseExited(evt);
            }
        });
        jPanel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Nombre:");
        jPanel_1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Apellido:");
        jPanel_1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cedula:");
        jPanel_1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 70, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Telefono 1:");
        jPanel_1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Correo electronico:");
        jPanel_1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 140, 20));

        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 170, -1));

        txt_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_apellidoActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 250, -1));

        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyReleased(evt);
            }
        });
        jPanel_1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 180, -1));

        txt_telefono_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_1ActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_telefono_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 160, -1));
        jPanel_1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Telefono 2:");
        jPanel_1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 80, -1));

        txt_telefono_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_2ActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_telefono_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 160, -1));

        jPanel1.add(jPanel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 995, 150));

        jbl_logo1.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        jbl_logo1.setForeground(new java.awt.Color(102, 102, 102));
        jbl_logo1.setText("¡ Formulario de Registro !");
        jbl_logo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_logo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_logo1MouseExited(evt);
            }
        });
        jPanel1.add(jbl_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 530, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Frame 3.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_barrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_barrioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_barrioActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    private void txt_telefono_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono_1ActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
Limpiar();       


    }//GEN-LAST:event_btn_cancelarActionPerformed
//-------------------------------------------------------------------------------------------------

//-------------------------------------------------------------------------------------------------
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        IngrearPersonas();
        Direcion();
        Insertar_Datos_Empresas();
        

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_deprtamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_deprtamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deprtamentoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void txt_cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyReleased
        // TODO add your handling code here:
        txt_cedulaDirecion.setText(txt_cedula.getText());
        txt_cedulaEmpresa.setText(txt_cedula.getText());

    }//GEN-LAST:event_txt_cedulaKeyReleased

    private void combox_depenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combox_depenKeyReleased
        

    }//GEN-LAST:event_combox_depenKeyReleased

    private void combox_depenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_depenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_depenActionPerformed

    private void combox_depenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_depenItemStateChanged
//       // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dependencia dep = (dependencia) combox_depen.getSelectedItem();
            Do D = new Do();
            
            DefaultComboBoxModel modelD = new DefaultComboBoxModel(D.Mostrar_Do(dep.getId()));
            
            combox_do.setModel(modelD);
            
        }

    }//GEN-LAST:event_combox_depenItemStateChanged

    private void combox_empresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_empresaItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Empresas Em = (Empresas) combox_empresa.getSelectedItem();
            dependencia dep = new dependencia();
            
            DefaultComboBoxModel modeloDependencia = new DefaultComboBoxModel(dep.Mostrar_Dependencias(Em.getId()));
            
            combox_depen.setModel(modeloDependencia);
            
        }
        

    }//GEN-LAST:event_combox_empresaItemStateChanged

    private void combox_ccostItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_ccostItemStateChanged
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            centros_costos cen = (centros_costos) combox_ccost.getSelectedItem();
            Unidad_negocios U = new Unidad_negocios();
            
            DefaultComboBoxModel modelU = new DefaultComboBoxModel(U.Mostrar_Unidad_negocios(cen.getId()));
            
            combox_unegocio.setModel(modelU);
            
        }
        

    }//GEN-LAST:event_combox_ccostItemStateChanged

    private void combox_doItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_doItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Do D = (Do) combox_do.getSelectedItem();
            centros_costos C = new centros_costos();
            DefaultComboBoxModel modelU = new DefaultComboBoxModel(C.Mostrar_centros_costos(D.getId()));
            combox_ccost.setModel(modelU);
            
        }
    }//GEN-LAST:event_combox_doItemStateChanged

    private void combox_unegocioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combox_unegocioItemStateChanged
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            Unidad_negocios f = (Unidad_negocios) combox_unegocio.getSelectedItem();
            
        }
        

    }//GEN-LAST:event_combox_unegocioItemStateChanged

    private void combox_empresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_empresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_empresaActionPerformed

    private void combox_stadolaboralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_stadolaboralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_stadolaboralActionPerformed

    private void btn_cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelarMouseEntered

    private void btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseEntered
        // TODO add your handling code here:
        btn_guardar.setBackground(new Color(129, 133, 134));
    }//GEN-LAST:event_btn_guardarMouseEntered

    private void btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseExited
        // TODO add your handling code here:
        btn_guardar.setBackground(new Color(174, 187, 189));
    }//GEN-LAST:event_btn_guardarMouseExited

    private void txt_telefono_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono_2ActionPerformed

    private void jbl_logo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_logo1MouseEntered
        // TODO add your handling code here:
        jbl_logo1.setForeground(new Color(202, 235, 14));

    }//GEN-LAST:event_jbl_logo1MouseEntered

    private void jbl_logo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_logo1MouseExited
        // TODO add your handling code here:
        jbl_logo1.setForeground(new Color(60, 63, 65));
    }//GEN-LAST:event_jbl_logo1MouseExited

    private void jPanel_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseEntered
        // TODO add your handling code here:
        jPanel_1.setBackground(new Color(243, 255, 0));
    }//GEN-LAST:event_jPanel_1MouseEntered

    private void jPanel_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseExited
        // TODO add your handling code here:
        jPanel_1.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_jPanel_1MouseExited

    private void combox_empresaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combox_empresaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_combox_empresaKeyReleased

    private void combox_ccostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_ccostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_ccostActionPerformed

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
            java.util.logging.Logger.getLogger(Registrar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrar.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Botones;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_guardar;
    public javax.swing.JComboBox<String> combox_Contrato;
    public javax.swing.JComboBox<String> combox_ccost;
    public javax.swing.JComboBox<String> combox_depen;
    public javax.swing.JComboBox<String> combox_do;
    public javax.swing.JComboBox<String> combox_empresa;
    public javax.swing.JComboBox<String> combox_stadolaboral;
    public javax.swing.JComboBox<String> combox_unegocio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JPanel jPanel_2;
    public javax.swing.JPanel jPanel_3;
    public javax.swing.JLabel jbl_logo1;
    public com.toedter.calendar.JDateChooser jd_fecha_ing;
    public com.toedter.calendar.JDateChooser jd_fecha_sali;
    public javax.swing.JTextField txt_Njefe;
    public javax.swing.JTextField txt_apellido;
    public javax.swing.JTextField txt_barrio;
    public javax.swing.JTextField txt_calle;
    public javax.swing.JTextField txt_cargo;
    public javax.swing.JTextField txt_carrera;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_cedulaDirecion;
    public javax.swing.JTextField txt_cedulaEmpresa;
    public javax.swing.JTextField txt_ciudad;
    public javax.swing.JTextField txt_codigopostal;
    public javax.swing.JTextField txt_correo;
    public javax.swing.JTextField txt_deprtamento;
    public javax.swing.JTextField txt_localida;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_telefono_1;
    public javax.swing.JTextField txt_telefono_2;
    // End of variables declaration//GEN-END:variables
}
