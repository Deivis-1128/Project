package Vista;

//---------------------------------------------------
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.sql.PreparedStatement;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class Act_dis extends javax.swing.JFrame {

    Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));
    Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Act_dis() {
        initComponents();
        setTitle("Detalle acta");
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setLocationRelativeTo(this);
        jd_fecha.setCalendar(fecha);
        nombre.setVisible(false);
        apellido.setVisible(false);
        GenerarID();
        btn_guardar.setEnabled(false);
        btn_generar.setEnabled(false);
        txt_clase.setVisible(false);
        txt_marca.setVisible(false);
        txt_modelo.setVisible(false);
        txt_serial.setVisible(false);
        txt_host.setVisible(false);
        
        
        txt_nombre.setVisible(false);
        Nombre_dis.setVisible(false);
    }

    @SuppressWarnings("unchecked")

//--------------------------------------------------------------------------
    public void GuardarActa_Entrega() {

        String Sql = "Insert Into detalle_actas (Cedula_e,Id_actas,Tipo_acta,Fecha,Nombre_t,Apellido_t,Cedula_t,Codigo_eqp,Observacion) Values(?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedula_e.getText());
            ps.setString(2, txt_Serie.getText());
            ps.setString(3, combox_actas.getSelectedItem().toString());
            ps.setString(4, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(5, nombre.getText());
            ps.setString(6, apellido.getText());
            ps.setString(7, txt_cedulaT.getText());
            ps.setString(8, txt_codigo.getText());
            ps.setString(9, txt_obserbacion.getText());

            ps.execute();
            Agregar_distribucion();

            JOptionPane.showMessageDialog(null, "Registro Exitoso Actas", "", 0, icon);
            btn_generar.setEnabled(true);
        } catch (SQLException ex) {
            validarEmpleado();
            validarTecnico();
            validarEquipos();
            JOptionPane.showMessageDialog(null, "El codigo de acta " + txt_Serie.getText() + " Ya existe en la base de datos\nCierre esta ventana y vuelva a abrirla\nPara generar otro codigo de acta", "Alerta", 0, icono);

        }

    }
     
//------------------------------------------------------------------------------

    public void GuardarActa_Devolucion() {

        String Sql = "Insert Into detalle_actas (Cedula_e,Id_actas,Tipo_acta,Fecha,Nombre_t,Apellido_t,Cedula_t,Codigo_eqp,Observacion) Values(?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedula_e.getText());
            ps.setString(2, txt_Serie.getText());
            ps.setString(3, combox_actas.getSelectedItem().toString());
            ps.setString(4, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(5, nombre.getText());
            ps.setString(6, apellido.getText());
            ps.setString(7, txt_cedulaT.getText());
            ps.setString(8, txt_codigo.getText());
            ps.setString(9, txt_obserbacion.getText());

            ps.execute();
            AgregarEstado();

            JOptionPane.showMessageDialog(null, "Registro Exitoso ", "", 0, icon);
            btn_generar.setEnabled(true);
        } catch (SQLException ex) {
            validarEmpleado();
            validarTecnico();
            validarEquipos();
            JOptionPane.showMessageDialog(null, "El codigo de acta " + txt_Serie.getText() + " Ya existe en la base de datos\nCierre esta ventana y vuelva a abrirla\nPara generar otro codigo de acta", "Alerta", 0, icono);

        }

    }
//------------------------------------------------------------------------------

    public void Agregar_distribucion() {
        String Sql = "Insert Into distribucion(Clase,Marca,Modelo,Codigo,Serial,Hostname,Usuario,Clave,Nombre,Cedula,Estado,Fecha,Codigo_acta) Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Icon icon = new ImageIcon(getClass().getResource("/Img/Accept.png"));
        Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

        String Clave = String.valueOf(txt_clave.getPassword());
        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_clase.getText());
            ps.setString(2, txt_marca.getText());
            ps.setString(3, txt_modelo.getText());
            ps.setString(4, txt_codigo.getText());
            ps.setString(5, txt_serial.getText());
            ps.setString(6, txt_host.getText());
            ps.setString(7, txt_usuario.getText());
            ps.setString(8, Clave);
            ps.setString(9, txt_nombre.getText());
            ps.setString(10, txt_cedula_e.getText());
            ps.setString(11, jbl_es.getText());
            ps.setString(12, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(13, txt_Serie.getText());
            ps.execute();

            // JOptionPane.showMessageDialog(null, "Registros Exitoso Distribucion", "", 0, icon);
        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "Error Distribucio" + e.getMessage());
        }

    }

//------------------------------------------------------------------------------
    public void AgregarEstado() {

        String Sql = "Insert Into estado_equipo (Codigo,Estatus,Cod_acta,Observaciones,Fecha_aviso) Values(?,?,?,?,?)";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_codigo.getText());
            ps.setString(2, jbl_es.getText());
            ps.setString(3, txt_Serie.getText());
            ps.setString(4, txt_obserbacion.getText());
            ps.setString(5, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.execute();

            // JOptionPane.showMessageDialog(null, "Registro Exitoso Estado", "", 0, icon);
            btn_generar.setEnabled(true);
        } catch (Exception e) {

            //JOptionPane.showMessageDialog(null, "Error estado" + e.getMessage());
        }

    }
//------------------------------------------------------------------------------

    public void BuscarTec() {

        String Sql = "Select Nombre, Apellido From personas Where Cedula=?; ";
        try {

            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedulaT.getText());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombre.setText(rs.getString("Nombre"));
                apellido.setText(rs.getString("Apellido"));
            } else {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El usuario " + txt_cedulaT.getText() + " No existe en la base de datos", "", 0, icono);

        }

    }
//------------------------------------------------------------------------------

    public void GenerarID() {
        Random rnd = new Random();
        //String Abedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String Cadena = " ";
        int M = 0, Pos = 0, Num;
        while (M < 1) {
            Pos = (int) (rnd.nextDouble() + 1);
            Num = (int) (rnd.nextDouble() * 99999999 + 1000);

            Cadena = Cadena + (Pos) + Num;
            //Pos = (int) (rnd.nextDouble() - 1 + 0);
            //Cadena = Cadena + (Pos);
            txt_Serie.setText(Cadena);
            Cadena = "";
            M++;
        }

    }
//------------------------------------------------------------------------------

    public void validarTecnico() {

        int resul = 0;
        String Cedula = txt_cedulaT.getText();

        String sql = "select * from personas where Cedula='" + Cedula + "' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    txt_cedulaT.setBackground(Color.GREEN);
                    btn_guardar.setEnabled(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + txt_cedulaT.getText() + " No existe en la base de datos", "", 0, icono);
                txt_cedulaT.setBackground(Color.red);
                btn_generar.setEnabled(false);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void validarEmpleado() {

        int resul = 0;
        String Cedula = txt_cedula_e.getText();

        String sql = "select * from personas where Cedula='" + Cedula + "' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    txt_cedula_e.setBackground(Color.GREEN);
                    btn_guardar.setEnabled(true);
                }

            } else {
                JOptionPane.showMessageDialog(null, "El usuario " + txt_cedula_e.getText() + " No existe en la base de datos", "", 0, icono);
                txt_cedula_e.setBackground(Color.red);
                btn_generar.setEnabled(false);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//-------------------------------------------------------------------------

    public void validarEquipos() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String SQL = "select * from recepcion_equipos where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    txt_codigo.setBackground(Color.GREEN);
                    btn_guardar.setEnabled(true);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El Equipo " + txt_codigo.getText() + " No existe en la base de datos", "", 0, icono);
                txt_codigo.setBackground(Color.red);
                btn_generar.setEnabled(false);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void BuscarEmpl() {

        String Sql = "select Nombre from personas where Cedula=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_cedula_e.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_nombre.setText(rs.getString("Nombre"));

            } else {

            }

        } catch (Exception e) {

        }

    }
//------------------------------------------------------------------------------

    public void BuscarSoftware() {

        String Sql = "select*from software_equipos where Codigo=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_codigo.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_serial.setText(rs.getString("Serial"));
                txt_host.setText(rs.getString("Hostname"));

            } else {

            }

        } catch (Exception e) {

        }

    }

    //--------------------------------------------------------------------------
    public void validarSoftware() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String SQL = "select * from software_equipos where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {

                resul = 1;

                if (resul == 1) {
                    btn_guardar.setEnabled(true);
                }

            } else {

                JOptionPane.showMessageDialog(null, "El Equipo " + txt_codigo.getText() + " No ha sido configurado\nVerifique en ¡software y configursciones!", "", 0, icono);
                btn_guardar.setEnabled(false);
            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void BuscarEquipos() {

        String Sql = "select*from recepcion_equipos where Codigo=? ";

        try {
            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_codigo.getText());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txt_clase.setText(rs.getString("Clase"));
                txt_marca.setText(rs.getString("Marca"));
                txt_modelo.setText(rs.getString("Modelo"));

            } else {

            }

        } catch (Exception e) {

        }

    }

//------------------------------------------------------------------------------
    public void validarDistribucion() {

        int resul = 0;

        String Codigo = txt_codigo.getText();

        String Sql = "select * from distribucion where Codigo='" + Codigo + "'";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            if (rs.next()) {
                Nombre_dis.setText(rs.getString("Nombre"));
                resul = 1;

                if (resul == 1) {
                    JOptionPane.showMessageDialog(null, "El equipo " + txt_codigo.getText() + " Ya esta asignado alusuario " + Nombre_dis.getText() + "\nPara hacer una nueva asignacion\nPrimero debe de eliminarlo de\n¡Distribución!", "Alerta", 0, icono);
                    btn_guardar.setEnabled(false);

                }

            }

        } catch (SQLException ex) {

        }

    }
//------------------------------------------------------------------------------

    public void Limpiar() {

        txt_cedulaT.setText("");
        txt_codigo.setText("");
        txt_obserbacion.setText("");
        combox_actas.setSelectedIndex(0);
        btn_guardar.setEnabled(true);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_obserbacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_cedulaT = new javax.swing.JTextField();
        combox_actas = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txt_Serie = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        btn_guardar = new javax.swing.JButton();
        btn_generar = new javax.swing.JButton();
        txt_cedula_e = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_clave = new javax.swing.JPasswordField();
        txt_usuario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btn_Validar = new javax.swing.JButton();
        txt_clase = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_host = new javax.swing.JTextField();
        txt_serial = new javax.swing.JTextField();
        txt_modelo = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        Nombre_dis = new javax.swing.JLabel();
        jbl_es = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_obserbacion.setColumns(20);
        txt_obserbacion.setRows(5);
        txt_obserbacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(txt_obserbacion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 490, 150));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setText("Observación:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));
        jPanel1.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 70, 120, -1));

        txt_cedulaT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaTActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cedulaT, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 40, 140, -1));

        combox_actas.setBackground(new java.awt.Color(0, 0, 255));
        combox_actas.setForeground(new java.awt.Color(255, 255, 255));
        combox_actas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de acta", "ACTA DE ENTREGA DE EQUIPO", "ACTA DE DEVOLUCIÓN EQUIPO" }));
        combox_actas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_actasActionPerformed(evt);
            }
        });
        jPanel1.add(combox_actas, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 220, -1));

        btn_eliminar.setBackground(new java.awt.Color(204, 204, 204));
        btn_eliminar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/polvo.png"))); // NOI18N
        btn_eliminar.setText("Limpiar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 230, 168, 35));

        jd_fecha.setDateFormatString("dd/MM/yyyy");
        jPanel1.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 140, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel5.setText("Codigo equipo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        txt_Serie.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        txt_Serie.setForeground(new java.awt.Color(255, 0, 51));
        txt_Serie.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_Serie, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 110, 22));

        jLabel7.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel7.setText("C.c Empleado:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 40, 120, -1));

        jLabel9.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel9.setText("Fecha:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 70, 60, -1));

        jLabel10.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel10.setText("Codigo acta:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 100, -1));

        nombre.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 10, 16));

        apellido.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        apellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 10, 16));

        btn_guardar.setBackground(new java.awt.Color(204, 204, 204));
        btn_guardar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 185, 168, 35));

        btn_generar.setBackground(new java.awt.Color(204, 204, 204));
        btn_generar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Adobe.png"))); // NOI18N
        btn_generar.setText("Generar Acta");
        btn_generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 275, 168, 35));

        txt_cedula_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedula_eActionPerformed(evt);
            }
        });
        jPanel1.add(txt_cedula_e, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 110, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel8.setText("C.c Tecnico:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        jLabel11.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel11.setText("Usuario:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, -1));

        jLabel12.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel12.setText("Clave:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 100, 60, -1));
        jPanel1.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 160, -1));
        jPanel1.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, -1));

        jLabel13.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel13.setText("Estado:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 70, -1));

        btn_Validar.setBackground(new java.awt.Color(204, 204, 204));
        btn_Validar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btn_Validar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/correccion.png"))); // NOI18N
        btn_Validar.setText("Validar");
        btn_Validar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ValidarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Validar, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 140, 168, 35));

        txt_clase.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 10, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 10, -1));

        txt_host.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 10, -1));

        txt_serial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_serial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 10, -1));

        txt_modelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 10, -1));

        txt_marca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 10, -1));
        jPanel1.add(Nombre_dis, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 10, 20));

        jbl_es.setForeground(new java.awt.Color(255, 255, 255));
        jbl_es.setOpaque(true);
        jPanel1.add(jbl_es, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 100, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cedulaTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaTActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        // Limpiar();
        //GenerarID();
       // GenerarReporte();
        JasperPrint jp = null;
        JasperViewer view = new JasperViewer(jp, false);
        view.setVisible(true);
        view.setTitle("Generara Acta");
        view.setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        view.setSize(612, 800);

    }//GEN-LAST:event_btn_eliminarActionPerformed
//------------------------------------------------------------------------------------
    public void GenerarReporte() {

        try {
            JasperReport reporte = null;
  
            String rutata=System.getProperty("user.di")+"/src/Reportes/Empl.jrxml" ;
            
            //String path = ("(user.)+/Reportes/Empl.jrxml");
            Map parametros = new HashMap();
            parametros.put("Nombre", txt_cedula_e.getText());
          //  reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            //JasperDesign diseño = JRXmlLoader.load(DC);
            //JasperReport jr = JasperCompileManager.compileReport(Js);

            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, com);

            JasperViewer view = new JasperViewer(jp, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
            view.setTitle("Generara Acta");
            view.setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
            view.setSize(612, 800);
            JOptionPane.showMessageDialog(rootPane, "Error ");

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(rootPane, "Error " + ex.getMessage());
            System.err.println("Error" + ex);
        }

    }

    //-----------------------------------------------------------------------------
    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (combox_actas.getSelectedItem() == "ACTA DE ENTREGA DE EQUIPO") {

            GuardarActa_Entrega();
        } else {

        }
        if (combox_actas.getSelectedItem() == "ACTA DE DEVOLUCIÓN EQUIPO") {
            GuardarActa_Devolucion();
        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void combox_actasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_actasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_actasActionPerformed

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
//        JasperPrint jp = null;
//        JasperViewer view = new JasperViewer(jp, false);
//        view.setVisible(true);
//        view.setTitle("Generara Acta");
//        view.setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
//        view.setSize(612, 800);
GenerarReporte();

    }//GEN-LAST:event_btn_generarActionPerformed

    private void txt_cedula_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedula_eActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedula_eActionPerformed

    private void btn_ValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ValidarActionPerformed
        if (combox_actas.getSelectedItem() == "ACTA DE DEVOLUCIÓN EQUIPO") {
            BuscarEmpl();
            BuscarTec();
            BuscarEquipos();
            BuscarSoftware();
            validarEmpleado();
            validarTecnico();
            validarEquipos();          
            jbl_es.setText("Stock");
            jbl_es.setBackground(Color.GREEN);

        }
        if (combox_actas.getSelectedIndex() == 0) {
            combox_actas.setBackground(Color.red);
            jbl_es.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Seleccione un tipo de acta", "Alerta", 0, icono);
        } else {
            combox_actas.setBackground(Color.GREEN);

            jbl_es.setBackground(Color.GREEN);
        }

        if (combox_actas.getSelectedItem() == "ACTA DE ENTREGA DE EQUIPO") {

            BuscarEmpl();
            BuscarTec();
            BuscarEquipos();
            BuscarSoftware();
            validarEmpleado();
            validarTecnico();
            validarEquipos();
            validarSoftware();
            validarDistribucion();
            jbl_es.setText("Activo");
            jbl_es.setBackground(Color.GREEN);
        } else {

        }

    }//GEN-LAST:event_btn_ValidarActionPerformed

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(Act_dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Act_dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Act_dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Act_dis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Act_dis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Nombre_dis;
    private javax.swing.JLabel apellido;
    public javax.swing.JButton btn_Validar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_generar;
    public javax.swing.JButton btn_guardar;
    public javax.swing.JComboBox<String> combox_actas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jbl_es;
    public com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JLabel nombre;
    public javax.swing.JLabel txt_Serie;
    public javax.swing.JTextField txt_cedulaT;
    public javax.swing.JTextField txt_cedula_e;
    public javax.swing.JTextField txt_clase;
    public javax.swing.JPasswordField txt_clave;
    public javax.swing.JTextField txt_codigo;
    public javax.swing.JTextField txt_host;
    public javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_modelo;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextArea txt_obserbacion;
    public javax.swing.JTextField txt_serial;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
