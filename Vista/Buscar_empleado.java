package Vista;

import Modelo.Conexion_MySQL;
import java.sql.Blob;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Buscar_empleado extends javax.swing.JFrame {

    static int Contador = 0;
    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Buscar_empleado() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        this.setLocationRelativeTo(this);
        //txt_buscar.setBackground(new java.awt.Color(0, 0, 0, 0));
        tbl_dts_persona.setVisible(false);
        tbl_direccion.setVisible(false);
        tbl_empresas.setVisible(false);
        tbl_cCostos.setVisible(false);
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        CambiarIcono();

    }
//-------------------------------------------------------------------------------------------------------

    public void CambiarIcono() {
        int Velocidad = 1;
        int VmiliSegundo = Velocidad * 1000;
        Timer timer;
        TimerTask ejecutar;

        ejecutar = new TimerTask() {
            @Override
            public void run() {
                Icon icono;
                switch (Contador) {
                    case 0:
                        Contador = 1;
                        icono = new ImageIcon(getClass().getResource("/Img/codigo.png"));
                        jbl_icono.setIcon(icono);

                        break;
                    case 1:
                        Contador = 2;
                        icono = new ImageIcon(getClass().getResource("/Img/desarrollo.png"));
                        jbl_icono.setIcon(icono);

                }

            }

        };

    }
//-------------------------------------------------------------------------------------------------------

    public void Actualizar() {

        this.jlb_nombre.setText("");
        this.jlb_apellido.setText("");
        this.jlb_cedula.setText("");
        this.jlb_telefono_1.setText("");
        this.jlb_telefono_2.setText("");
        this.jlb_correo.setText("");
        jbl_foto.setIcon(null);
        jbl_D.setIcon(null);
        jbl_Z.setIcon(null);
//-------------------------------------------------
        this.jbl_empresa.setText("");
        this.jbl_cargo.setText("");
        this.jbl_tipocontrato.setText("");
        this.jbl_dependencia.setText("");
        this.jbl_fingreso.setText("");
        this.jbl_fsalida.setText("");
        this.jbl_Jarea.setText("");
        this.jbl_stlaboral.setText("");
//-------------------------------------------------
        this.jlb_depatamento.setText("");
        this.jlb_ciudad.setText("");
        this.jlb_localidad.setText("");
        this.jlb_carrera.setText("");
        this.jlb_calle.setText("");
        this.jlb_barrio.setText("");
        this.jlb_codigopostal.setText("");

//-------------------------------------------------
        this.jbl_CenCos.setText("");
        this.jbl_deo.setText("");
        this.jbl_unidadnegocio.setText("");
        this.jbl_clase1a.setText("");
        this.jbl_marca1a.setText("");
        this.jbl_modelo1a.setText("");
        this.jbl_codigo1a.setText("");
        this.jbl_serial1a.setText("");
        this.jbl_Hostname1a.setText("");

    }

//--------------------------------------------------------------------------------------------------------
    public void BuscarPersonas() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from personas where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jlb_nombre.setText(rs.getString("Nombre"));
                jlb_apellido.setText(rs.getString("Apellido"));
                jlb_cedula.setText(rs.getString("Cedula"));
                jlb_telefono_1.setText(rs.getString("Telefono_1"));
                jlb_telefono_2.setText(rs.getString("Telefono_2"));
                jlb_correo.setText(rs.getString("Correo_electronico"));

                Blob Fotos = rs.getBlob("Foto");
                byte[] recupera_F = Fotos.getBytes(1, (int) Fotos.length());
                BufferedImage img_F = ImageIO.read(new ByteArrayInputStream(recupera_F));
                Image image_F = img_F.getScaledInstance(jbl_foto.getWidth(), jbl_foto.getHeight(), Image.SCALE_SMOOTH);
                jbl_foto.setIcon(new ImageIcon(image_F));

                Blob D = rs.getBlob("Indice_derecho");
                byte[] recuperaD = D.getBytes(1, (int) D.length());
                BufferedImage imgD = ImageIO.read(new ByteArrayInputStream(recuperaD));
                Image imageD = imgD.getScaledInstance(jbl_D.getWidth(), jbl_D.getHeight(), Image.SCALE_SMOOTH);
                jbl_D.setIcon(new ImageIcon(imageD));

                Blob Z = rs.getBlob("Indice_izquierdo");
                byte[] recuperaZ = Z.getBytes(1, (int) Z.length());
                BufferedImage imgZ = ImageIO.read(new ByteArrayInputStream(recuperaZ));
                Image imageZ = imgZ.getScaledInstance(jbl_Z.getWidth(), jbl_Z.getHeight(), Image.SCALE_SMOOTH);
                jbl_Z.setIcon(new ImageIcon(imageZ));

            } else {
                JOptionPane.showMessageDialog(null, "El Ususrio No Existe");
            }

        } catch (Exception e) {

        }

    }

//-------------------------------------------------------------------------------------------------
    public void BuscarEmpresas() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from datos_empresa where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jbl_empresa.setText(rs.getString("Empresa"));
                jbl_cargo.setText(rs.getString("Cargo"));
                jbl_tipocontrato.setText(rs.getString("Tipo_contrato"));
                jbl_dependencia.setText(rs.getString("Dependencia"));
                jbl_fingreso.setText(rs.getString("Fecha_ingreso"));
                jbl_fsalida.setText(rs.getString("Fecha_salida"));
                jbl_Jarea.setText(rs.getString("Jefe_area"));
                jbl_stlaboral.setText(rs.getString("Estado"));
                jbl_CenCos.setText(rs.getString("Centro_costo"));
                jbl_deo.setText(rs.getString("Do"));
                jbl_unidadnegocio.setText(rs.getString("Unidad_negocio"));

            } else {
                //JOptionPane.showMessageDialog(null, "Usuario sin datos de empresa");
            }

        } catch (Exception e) {

        }

    }

//-------------------------------------------------------------------------------------------------
    public void BuscarDireccion() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();

        String Sql = "select*from direcciones where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                jlb_depatamento.setText(rs.getString("departamento"));
                jlb_ciudad.setText(rs.getString("Ciudad"));
                jlb_localidad.setText(rs.getString("Localidad"));
                jlb_carrera.setText(rs.getString("Carrera"));
                jlb_calle.setText(rs.getString("Calle"));
                jlb_barrio.setText(rs.getString("Barrio"));
                jlb_codigopostal.setText(rs.getString("Codigo_postal"));

            } else {
                //JOptionPane.showMessageDialog(null, "Usuario Sin Direccion");
            }

        } catch (Exception e) {

        }

    }

//----------------------------------------------------------------------------------------------
    public void BuscarDistribucion() {
        Conexion_MySQL CM = new Conexion_MySQL();
        Connection com = CM.getConexion();
        String Sql = "Select Clase,Marca,Modelo,Codigo,Serial,Hostname From distribucion Where Cedula=?";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_buscar.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jbl_clase1a.setText(rs.getString("Clase"));

                jbl_marca1a.setText(rs.getString("Marca"));

                jbl_modelo1a.setText(rs.getString("Modelo"));

                jbl_codigo1a.setText(rs.getString("Codigo"));

                jbl_serial1a.setText(rs.getString("Serial"));

                jbl_Hostname1a.setText(rs.getString("Hostname"));

            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Esta Pernona No Tiene Asignado Ningun Equipo " + e.getMessage());
        }

    }
//----------------------------------------------------------------------------------------------

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jMenu1 = new javax.swing.JMenu();
        jPanel_1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jlb_nombre = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jbl_stlaboral = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlb_cedula = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlb_telefono_1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlb_telefono_2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlb_correo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jlb_apellido = new javax.swing.JLabel();
        jbl_deo = new javax.swing.JLabel();
        jbl_dependencia = new javax.swing.JLabel();
        jbl_unidadnegocio = new javax.swing.JLabel();
        jbl_CenCos = new javax.swing.JLabel();
        jbl_empresa = new javax.swing.JLabel();
        jbl_fingreso = new javax.swing.JLabel();
        jbl_Jarea = new javax.swing.JLabel();
        jbl_modelo1a = new javax.swing.JLabel();
        jbl_fsalida = new javax.swing.JLabel();
        jbl_cargo = new javax.swing.JLabel();
        jbl_tipocontrato = new javax.swing.JLabel();
        jlb_depatamento = new javax.swing.JLabel();
        jlb_ciudad = new javax.swing.JLabel();
        jlb_carrera = new javax.swing.JLabel();
        jlb_calle = new javax.swing.JLabel();
        jlb_localidad = new javax.swing.JLabel();
        jlb_barrio = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        ntn_limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_empresas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dts_persona = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_direccion = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_cCostos = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlb_codigopostal = new javax.swing.JLabel();
        jbl_Hostname1a = new javax.swing.JLabel();
        jbl_serial1a = new javax.swing.JLabel();
        jbl_codigo1a = new javax.swing.JLabel();
        jbl_clase1a = new javax.swing.JLabel();
        jbl_marca1a = new javax.swing.JLabel();
        jbl_icono = new javax.swing.JLabel();
        ntn_limpiar1 = new javax.swing.JButton();
        jbl_foto = new javax.swing.JLabel();
        jbl_D = new javax.swing.JLabel();
        jbl_Z = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel_1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel_1.setPreferredSize(new java.awt.Dimension(1186, 632));
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
        jLabel17.setForeground(new java.awt.Color(4, 4, 5));
        jLabel17.setText("Nombre:");
        jPanel_1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, -1));

        jlb_nombre.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_nombre.setForeground(new java.awt.Color(244, 68, 7));
        jlb_nombre.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jlb_nombreComponentShown(evt);
            }
        });
        jPanel_1.add(jlb_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 250, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(4, 4, 5));
        jLabel12.setText("Apellido:");
        jPanel_1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, -1));

        jbl_stlaboral.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_stlaboral.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_stlaboral, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 110, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(4, 4, 5));
        jLabel13.setText("Cedula:");
        jPanel_1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, -1));

        jlb_cedula.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_cedula.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 130, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(4, 4, 5));
        jLabel14.setText("Telefono 1:");
        jPanel_1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 90, -1));

        jlb_telefono_1.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_telefono_1.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_telefono_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 140, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(4, 4, 5));
        jLabel16.setText(" Telefono 2:");
        jPanel_1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 90, -1));

        jlb_telefono_2.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_telefono_2.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_telefono_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 140, 20));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(4, 4, 5));
        jLabel19.setText("Correo electronico:");
        jPanel_1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 20));

        jlb_correo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_correo.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 230, 20));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(4, 4, 5));
        jLabel32.setText("DO:");
        jPanel_1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 37, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(4, 4, 5));
        jLabel33.setText("Marca:");
        jPanel_1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 50, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(4, 4, 5));
        jLabel34.setText("Unidad de negocio:");
        jPanel_1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 130, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 4, 5));
        jLabel2.setText("Centro de costo:");
        jPanel_1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 110, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(4, 4, 5));
        jLabel5.setText("Departamento:");
        jPanel_1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 130, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(4, 4, 5));
        jLabel6.setText("Ciudad:");
        jPanel_1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 70, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(4, 4, 5));
        jLabel7.setText("Carrera:");
        jPanel_1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 70, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(4, 4, 5));
        jLabel9.setText("Calle:");
        jPanel_1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, 60, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(4, 4, 5));
        jLabel8.setText("Localidad:");
        jPanel_1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 90, -1));

        jLabel31.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(4, 4, 5));
        jLabel31.setText("Barrio:");
        jPanel_1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 60, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(4, 4, 5));
        jLabel10.setText("Codigo postal:");
        jPanel_1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 490, 130, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(4, 4, 5));
        jLabel25.setText("Empresa:");
        jPanel_1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(4, 4, 5));
        jLabel22.setText("Fecha de ingreso:");
        jPanel_1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 130, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(4, 4, 5));
        jLabel35.setText("Nombre de Jefe del Area:");
        jPanel_1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(4, 4, 5));
        jLabel20.setText("Tipo de contrato:");
        jPanel_1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(4, 4, 5));
        jLabel23.setText("Fecha de salida:");
        jPanel_1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 120, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(4, 4, 5));
        jLabel21.setText("Cargo:");
        jPanel_1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(4, 4, 5));
        jLabel30.setText("Estado laboral:");
        jPanel_1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        jlb_apellido.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_apellido.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 260, 20));

        jbl_deo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_deo.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_deo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 70, 20));

        jbl_dependencia.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_dependencia.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_dependencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 340, 20));

        jbl_unidadnegocio.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_unidadnegocio.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_unidadnegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 350, 20));

        jbl_CenCos.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_CenCos.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_CenCos, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 390, 20));

        jbl_empresa.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_empresa.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_empresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 350, 20));

        jbl_fingreso.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_fingreso.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_fingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 100, 20));

        jbl_Jarea.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_Jarea.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_Jarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 210, 20));

        jbl_modelo1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_modelo1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_modelo1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_modelo1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_modelo1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_modelo1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 190, 20));

        jbl_fsalida.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_fsalida.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_fsalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 110, 20));

        jbl_cargo.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_cargo.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 290, 20));

        jbl_tipocontrato.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_tipocontrato.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jbl_tipocontrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 210, 20));

        jlb_depatamento.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_depatamento.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_depatamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 310, 170, 20));

        jlb_ciudad.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_ciudad.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 200, 20));

        jlb_carrera.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_carrera.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 120, 20));

        jlb_calle.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_calle.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, 140, 20));

        jlb_localidad.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_localidad.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_localidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 370, 200, 20));

        jlb_barrio.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_barrio.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_barrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 230, 20));

        txt_buscar.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        txt_buscar.setBorder(null);
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
        jPanel_1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 200, 30));

        btn_buscar.setBackground(new java.awt.Color(2, 250, 70));
        btn_buscar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setAlignmentY(0.0F);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_buscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_buscarMouseExited(evt);
            }
        });
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel_1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 110, 30));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/hospedaje.png"))); // NOI18N
        jPanel_1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, -1, 130));

        ntn_limpiar.setBackground(new java.awt.Color(51, 255, 0));
        ntn_limpiar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ntn_limpiar.setForeground(new java.awt.Color(255, 255, 255));
        ntn_limpiar.setText("Actualizar");
        ntn_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ntn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntn_limpiarActionPerformed(evt);
            }
        });
        jPanel_1.add(ntn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 110, 30));

        tbl_empresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_empresas);

        jPanel_1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 680, 0, 20));

        tbl_dts_persona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_dts_persona.setGridColor(new java.awt.Color(255, 255, 0));
        tbl_dts_persona.setOpaque(false);
        tbl_dts_persona.setPreferredSize(new java.awt.Dimension(80, 80));
        jScrollPane2.setViewportView(tbl_dts_persona);

        jPanel_1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 680, 0, 20));

        tbl_direccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tbl_direccion);

        jPanel_1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 680, 0, 20));

        tbl_cCostos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tbl_cCostos);

        jPanel_1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 680, 0, 20));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(4, 4, 5));
        jLabel36.setText("Modelo:");
        jPanel_1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 70, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(4, 4, 5));
        jLabel38.setText("Dependencia:");
        jPanel_1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(4, 4, 5));
        jLabel39.setText("Codigo Equipo:");
        jPanel_1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 110, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(4, 4, 5));
        jLabel40.setText("Clase:");
        jPanel_1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 50, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(4, 4, 5));
        jLabel41.setText("Hostname:");
        jPanel_1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 550, 80, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(4, 4, 5));
        jLabel42.setText("Serial:");
        jPanel_1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 50, -1));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cohete.png"))); // NOI18N
        btn_menu.setText("Ir a Menú Principal");
        btn_menu.setContentAreaFilled(false);
        btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_menu.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
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
        jPanel_1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, -1, 32));

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar Datos ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel_1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 35));

        jlb_codigopostal.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jlb_codigopostal.setForeground(new java.awt.Color(244, 68, 7));
        jPanel_1.add(jlb_codigopostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 490, 160, 20));

        jbl_Hostname1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_Hostname1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_Hostname1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_Hostname1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_Hostname1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_Hostname1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 160, 20));

        jbl_serial1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_serial1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_serial1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_serial1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_serial1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_serial1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, 160, 20));

        jbl_codigo1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_codigo1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_codigo1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_codigo1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_codigo1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_codigo1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, 120, 20));

        jbl_clase1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_clase1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_clase1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_clase1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_clase1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_clase1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 160, 20));

        jbl_marca1a.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_marca1a.setForeground(new java.awt.Color(244, 68, 7));
        jbl_marca1a.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jbl_marca1a.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbl_marca1a.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel_1.add(jbl_marca1a, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 570, 160, 20));

        jbl_icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/codigo.png"))); // NOI18N
        jPanel_1.add(jbl_icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 306, -1, 200));

        ntn_limpiar1.setBackground(new java.awt.Color(51, 255, 0));
        ntn_limpiar1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        ntn_limpiar1.setForeground(new java.awt.Color(255, 255, 255));
        ntn_limpiar1.setText("Lista Empresas");
        ntn_limpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ntn_limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ntn_limpiar1ActionPerformed(evt);
            }
        });
        jPanel_1.add(ntn_limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 40, 140, 30));

        jbl_foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_1.add(jbl_foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 150, 200));

        jbl_D.setAutoscrolls(true);
        jbl_D.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_1.add(jbl_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 80, 120));

        jbl_Z.setAutoscrolls(true);
        jbl_Z.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel_1.add(jbl_Z, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 80, 120));

        jLabel11.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel11.setText("Foto");
        jPanel_1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 290, -1, -1));

        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel15.setText("Indice Izquierdo");
        jPanel_1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel18.setText("Indice Derecho");
        jPanel_1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 110, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void ntn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntn_limpiarActionPerformed
        // TODO add your handling code here:

        Actualizar();

    }//GEN-LAST:event_ntn_limpiarActionPerformed

    private void jlb_nombreComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jlb_nombreComponentShown
        // TODO add your handling code here:

    }//GEN-LAST:event_jlb_nombreComponentShown

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        BuscarPersonas();
        BuscarDireccion();
        BuscarEmpresas();
        BuscarDistribucion();


    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jPanel_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseEntered
        // TODO add your handling code here:
        // jPanel_1.setBackground(new Color(2, 250, 70));
    }//GEN-LAST:event_jPanel_1MouseEntered

    private void jPanel_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseExited
        //jPanel_1.setBackground(new Color(0, 204, 255));        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel_1MouseExited

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(0, 255, 19));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BuscarPersonas();
            BuscarDireccion();
            BuscarEmpresas();
            BuscarDistribucion();
        }
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void btn_buscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseEntered
        jPanel_1.setBackground(new Color(2, 250, 70));
        btn_buscar.setBackground(new Color(0, 204, 255));
        btn_buscar.setForeground(new Color(90, 252, 3));
    }//GEN-LAST:event_btn_buscarMouseEntered

    private void btn_buscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buscarMouseExited
        jPanel_1.setBackground(new Color(0, 204, 255));
        btn_buscar.setBackground(new Color(2, 250, 70));
        btn_buscar.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_btn_buscarMouseExited

    private void ntn_limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ntn_limpiar1ActionPerformed
        Buscar_Empresas BE = new Buscar_Empresas();
        BE.setVisible(true);

    }//GEN-LAST:event_ntn_limpiar1ActionPerformed

    /**
     * ,.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Buscar_empleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_menu;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel jbl_CenCos;
    public javax.swing.JLabel jbl_D;
    public javax.swing.JLabel jbl_Hostname1a;
    public javax.swing.JLabel jbl_Jarea;
    public javax.swing.JLabel jbl_Z;
    public javax.swing.JLabel jbl_cargo;
    public javax.swing.JLabel jbl_clase1a;
    public javax.swing.JLabel jbl_codigo1a;
    public javax.swing.JLabel jbl_deo;
    public javax.swing.JLabel jbl_dependencia;
    public javax.swing.JLabel jbl_empresa;
    public javax.swing.JLabel jbl_fingreso;
    public javax.swing.JLabel jbl_foto;
    public javax.swing.JLabel jbl_fsalida;
    public javax.swing.JLabel jbl_icono;
    public javax.swing.JLabel jbl_marca1a;
    public javax.swing.JLabel jbl_modelo1a;
    public javax.swing.JLabel jbl_serial1a;
    public javax.swing.JLabel jbl_stlaboral;
    public javax.swing.JLabel jbl_tipocontrato;
    public javax.swing.JLabel jbl_unidadnegocio;
    public javax.swing.JLabel jlb_apellido;
    public javax.swing.JLabel jlb_barrio;
    public javax.swing.JLabel jlb_calle;
    public javax.swing.JLabel jlb_carrera;
    public javax.swing.JLabel jlb_cedula;
    public javax.swing.JLabel jlb_ciudad;
    public javax.swing.JLabel jlb_codigopostal;
    public javax.swing.JLabel jlb_correo;
    public javax.swing.JLabel jlb_depatamento;
    public javax.swing.JLabel jlb_localidad;
    public javax.swing.JLabel jlb_nombre;
    public javax.swing.JLabel jlb_telefono_1;
    public javax.swing.JLabel jlb_telefono_2;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JButton ntn_limpiar;
    private javax.swing.JButton ntn_limpiar1;
    public javax.swing.JTable tbl_cCostos;
    public javax.swing.JTable tbl_direccion;
    public javax.swing.JTable tbl_dts_persona;
    public javax.swing.JTable tbl_empresas;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables
}
