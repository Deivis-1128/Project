package Vista;

import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class Datos_equipos extends javax.swing.JFrame {
int colum;

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();
    Calendar fecha = new GregorianCalendar();

    public Datos_equipos() {
        initComponents();
        CargarDatos_tbl1();
        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        this.setLocationRelativeTo(this);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Ocultar();
        ContarRegistros();

        jd_fecha.setCalendar(fecha);
        setTitle("Recepción De Equipos");


    }
//-------------------------------------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------------------------------------
    public void Veliminar() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/eliminar.png"));

        String Botones[] = {"Si", "No"};
        int eleccion = JOptionPane.showOptionDialog(this, "Desas Eliminar Este Registro", "Eliminar", 0, 0, icono, Botones, this);

        if (eleccion == JOptionPane.YES_OPTION) {

        } else if (eleccion == JOptionPane.NO_OPTION) {
            System.err.println("Se cancelo el cierre");
        }
    }

    //---->>>Metodo Cerrar.
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
    //---->>>Fin Metodo Cerrar.
//------------------------------------------------------------------------------------------

    public void OcultarLogo() {
        jbl_logo1.setVisible(false);

    }
//-------------------------------------------------------------------------------------------

    public void CargarLogo() {

        jbl_logo1.setVisible(true);
    }

//------------------------------------------------------------------------------------------
//---->>>Metodo Mostrar.
    public void Mostrar() {
        conbo_cls.setVisible(true);
        txt_marc.setVisible(true);
        txt_mdlo.setVisible(true);
        txt_codg.setVisible(true);
        txt_ordenInst.setVisible(true);
        jd_fecha.setVisible(true);
        txt_prove.setVisible(true);
        txt_Ncontac.setVisible(true);
        txt_CPU.setVisible(true);
        txt_Mran.setVisible(true);
        txt_almacenamiento.setVisible(true);
        conbo_red1.setVisible(true);
        txt_tarifa.setVisible(true);
//--------------------------------------------------------------------------------------
        jbl_clase.setVisible(true);
        jbl_marca.setVisible(true);
        jbl_modelo.setVisible(true);
        jbl_codigo.setVisible(true);
        jbl_orden.setVisible(true);
        jbl_fecha.setVisible(true);
        jbl_provedor.setVisible(true);
        jbl_ncontacto.setVisible(true);
        jbl_cpu.setVisible(true);
        jbl_memoria.setVisible(true);
        jbl_almacena.setVisible(true);
        jbl_tarjeta.setVisible(true);
        jbl_tarifa.setVisible(true);

    }
//---->>>Fin Metodo Mostrar.
//--------------------------------------------------------------------------------------

//---->>>Metodo Ocutar
    public void Ocultar() {
        conbo_cls.setVisible(false);
        txt_marc.setVisible(false);
        txt_mdlo.setVisible(false);
        txt_codg.setVisible(false);
        txt_ordenInst.setVisible(false);
        jd_fecha.setVisible(false);
        txt_prove.setVisible(false);
        txt_Ncontac.setVisible(false);
        txt_CPU.setVisible(false);
        txt_Mran.setVisible(false);
        txt_almacenamiento.setVisible(false);
        conbo_red1.setVisible(false);
        txt_tarifa.setVisible(false);
//----------------------------------
        jbl_clase.setVisible(false);
        jbl_marca.setVisible(false);
        jbl_modelo.setVisible(false);
        jbl_codigo.setVisible(false);
        jbl_orden.setVisible(false);
        jbl_fecha.setVisible(false);
        jbl_provedor.setVisible(false);
        jbl_ncontacto.setVisible(false);
        jbl_cpu.setVisible(false);
        jbl_memoria.setVisible(false);
        jbl_almacena.setVisible(false);
        jbl_tarjeta.setVisible(false);
        jbl_tarifa.setVisible(false);

    }
//---->>>Fin Metodo Ocultar
private  void alineacionColumnaCentrada(JTable tbl, int colum) {
    DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
    cellRender.setHorizontalAlignment(SwingConstants.CENTER);
    tbl.getColumnModel().getColumn(colum).setCellRenderer(cellRender);       
}

   public void CargarDatos_tbl1() {


        tbl_dts_equipos_1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        tbl_dts_equipos_1.getTableHeader().setOpaque(false);
        tbl_dts_equipos_1.getTableHeader().setForeground(new Color(255, 255, 255));
        tbl_dts_equipos_1.getTableHeader().setBackground(new Color(0, 0, 0));
        String[] Titulos = {"Clase", "Marca", "Modelo", "Placa ML", "orden instalacion", "Fecha", "Proveedor", "Nombre Contacto", "Cpu", "Ram", "Almacenamiento", "Tarjeta Red", "Tarifa"};
        String[] Registros = new String[13];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "Select* from recepcion_equipos";

        try {

            try {
                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(Sql);

                while (rs.next()) {
                    Registros[0] = rs.getString("Clase");
                    Registros[1] = rs.getString("Marca");
                    Registros[2] = rs.getString("Modelo");
                    Registros[3] = rs.getString("Codigo");
                    Registros[4] = rs.getString("orden_instalacion");
                    Registros[5] = rs.getString("Fecha_alta");
                    Registros[6] = rs.getString("Proveedor");
                    Registros[7] = rs.getString("Nombre_contacto");
                    Registros[8] = rs.getString("Cpu");
                    Registros[9] = rs.getString("Ram");
                    Registros[10] = rs.getString("Almacenamiento");
                    Registros[11] = rs.getString("Tarjeta_red");
                    Registros[12] = rs.getString("Tarifa");

                    modelo.addRow(Registros);
                }

                tbl_dts_equipos_1.setModel(modelo);
int[] anchos = {30, 40, 100,20,70,55,50,100,70,20,70,40,30};
            for (int i = 0; i < tbl_dts_equipos_1.getColumnCount(); i++) {
                tbl_dts_equipos_1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
            }

        } catch (Exception e) {
        }

    }


//------------------------------------------------------------------------------------------

    public void Modificar() {

        int filaSeleccionada = tbl_dts_equipos_1.getSelectedRow();
        String s = (String) tbl_dts_equipos_1.getValueAt(filaSeleccionada, 3);

        String Sql = "UPDATE recepcion_equipos SET Clase=?,Marca=?,Modelo=?,Codigo=?,Orden_instalacion=?, Fecha_alta=?,Proveedor=?,Nombre_contacto=?,Cpu=?,Ram=?,Almacenamiento=?,Tarjeta_red=?,Tarifa=? where Codigo=?";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);

            ps.setString(1, conbo_cls.getSelectedItem().toString());
            ps.setString(2, txt_marc.getText());
            ps.setString(3, txt_mdlo.getText());
            ps.setString(4, txt_codg.getText());
            ps.setString(5, txt_ordenInst.getText());
            ps.setString(6, ((JTextField) jd_fecha.getDateEditor().getUiComponent()).getText());
            ps.setString(7, txt_prove.getText());
            ps.setString(8, txt_Ncontac.getText());
            ps.setString(9, txt_CPU.getText());
            ps.setString(10, txt_Mran.getText());
            ps.setString(11, txt_almacenamiento.getText());
            ps.setString(12, conbo_red1.getSelectedItem().toString());
            ps.setString(13, txt_tarifa.getText());
            ps.setString(14, s);

            int E = ps.executeUpdate();
            if (E >= 0) {
                JOptionPane.showMessageDialog(null, "Datos Modificados");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de Modificacion  ");
        }
    }

   
//------------------------------------------------------------------------------------------2
    public void SeleccionarFila() {
 Icon icono = new ImageIcon(getClass().getResource("/Img/megafono.png"));
        int fila = tbl_dts_equipos_1.getSelectedRow();
        if (fila >= 0) {
            conbo_cls.setSelectedItem((String) tbl_dts_equipos_1.getValueAt(fila, 0).toString());
            txt_marc.setText((String) tbl_dts_equipos_1.getValueAt(fila, 1).toString());
            txt_mdlo.setText((String) tbl_dts_equipos_1.getValueAt(fila, 2).toString());
            txt_codg.setText((String) tbl_dts_equipos_1.getValueAt(fila, 3).toString());
            txt_ordenInst.setText((String) tbl_dts_equipos_1.getValueAt(fila, 4).toString());
            jd_fecha.setDateFormatString(tbl_dts_equipos_1.getValueAt(fila, 5).toString());
            txt_prove.setText((String) tbl_dts_equipos_1.getValueAt(fila, 6).toString());
            txt_Ncontac.setText((String) tbl_dts_equipos_1.getValueAt(fila, 7).toString());
            txt_CPU.setText((String) tbl_dts_equipos_1.getValueAt(fila, 8).toString());
            txt_Mran.setText((String) tbl_dts_equipos_1.getValueAt(fila, 9).toString());
            txt_almacenamiento.setText((String) tbl_dts_equipos_1.getValueAt(fila, 10).toString());
            conbo_red1.setSelectedItem((String) tbl_dts_equipos_1.getValueAt(fila, 11).toString());
            txt_tarifa.setText((String) tbl_dts_equipos_1.getValueAt(fila, 12).toString());
            Mostrar();
            OcultarLogo();

        } else {
             JOptionPane.showMessageDialog(null, "por favor seleccionar fila", "", 0, icono);
        }
    }


//--------------------------------------------------------------------------------------------------------

    public void SeleccionaF() {
        int fila = tbl_dts_equipos_1.getSelectedRow();
        if (fila >= 0) {
            conbo_cls.setSelectedItem((String) tbl_dts_equipos_1.getValueAt(fila, 0).toString());
            txt_marc.setText((String) tbl_dts_equipos_1.getValueAt(fila, 1).toString());
            txt_mdlo.setText((String) tbl_dts_equipos_1.getValueAt(fila, 2).toString());
            txt_codg.setText((String) tbl_dts_equipos_1.getValueAt(fila, 3).toString());
            txt_ordenInst.setText((String) tbl_dts_equipos_1.getValueAt(fila, 4).toString());
            jd_fecha.setDateFormatString(tbl_dts_equipos_1.getValueAt(fila, 5).toString());
            txt_prove.setText((String) tbl_dts_equipos_1.getValueAt(fila, 6).toString());
            txt_Ncontac.setText((String) tbl_dts_equipos_1.getValueAt(fila, 7).toString());
            txt_CPU.setText((String) tbl_dts_equipos_1.getValueAt(fila, 8).toString());
            txt_Mran.setText((String) tbl_dts_equipos_1.getValueAt(fila, 9).toString());
            txt_almacenamiento.setText((String) tbl_dts_equipos_1.getValueAt(fila, 10).toString());
            conbo_red1.setSelectedItem((String) tbl_dts_equipos_1.getValueAt(fila, 11).toString());
            txt_tarifa.setText((String) tbl_dts_equipos_1.getValueAt(fila, 12).toString());

        } else {
            JOptionPane.showMessageDialog(null, "por favor seleccione una fila");

        }
    }

  
//------------------------------------------------------------------------------------------------

    public void Eliminar() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/eliminar.png"));

        try {
            int filaSeleccionada = tbl_dts_equipos_1.getSelectedRow();
            String SQL = "delete from recepcion_equipos where Codigo=" + tbl_dts_equipos_1.getValueAt(filaSeleccionada, 3);
            Statement st = com.createStatement();

            String Botones[] = {"Si", "No"};
            int eleccion = JOptionPane.showOptionDialog(this, "Desas Eliminar Este Registro", "Eliminar", 0, 0, icono, Botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {

                st.executeUpdate(SQL);
                JOptionPane.showMessageDialog(null, "Registro Eliminado", "", 0, icono);
            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.err.println("Se cancelo el cierre");

            }
        } catch (Exception e) {
            System.err.println("e");

        }

    }


//------------------------------------------------------------------------------------------------

    public void Buscar(String V) {
        String[] Titulos = {"Clase", "Marca", "Modelo", "Placa", "orden instalacion", "Fecha", "Proveedor", "Nombre Contacto", "Cpu", "Ram", "Almacenamiento", "Tarjeta Red", "Tarifa"};
        String[] Registros = new String[13];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM recepcion_equipos WHERE  Codigo LIKE '%" + V + "%' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Clase");
                Registros[1] = rs.getString("Marca");
                Registros[2] = rs.getString("Modelo");
                Registros[3] = rs.getString("Codigo");
                Registros[4] = rs.getString("orden_instalacion");
                Registros[5] = rs.getString("Fecha_alta");
                Registros[6] = rs.getString("Proveedor");
                Registros[7] = rs.getString("Nombre_contacto");
                Registros[8] = rs.getString("Cpu");
                Registros[9] = rs.getString("Ram");
                Registros[10] = rs.getString("Almacenamiento");
                Registros[11] = rs.getString("Tarjeta_red");
                Registros[12] = rs.getString("Tarifa");

                modelo.addRow(Registros);
            }

            tbl_dts_equipos_1.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el registro con identificador");
        }

    }


  
//-----------------------------------------------------------------------------------------------------
   
    public void ContarRegistros() {

        int fila = tbl_dts_equipos_1.getRowCount();
        jbl_registro.setText("  " + fila);

    }


//------------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dts_equipos_1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_actualizar = new javax.swing.JButton();
        jbl_clase = new javax.swing.JLabel();
        jbl_marca = new javax.swing.JLabel();
        jbl_modelo = new javax.swing.JLabel();
        jbl_codigo = new javax.swing.JLabel();
        jbl_orden = new javax.swing.JLabel();
        jbl_fecha = new javax.swing.JLabel();
        jbl_provedor = new javax.swing.JLabel();
        jbl_ncontacto = new javax.swing.JLabel();
        jbl_memoria = new javax.swing.JLabel();
        jbl_almacena = new javax.swing.JLabel();
        jbl_tarjeta = new javax.swing.JLabel();
        txt_almacenamiento = new javax.swing.JTextField();
        txt_marc = new javax.swing.JTextField();
        txt_mdlo = new javax.swing.JTextField();
        txt_codg = new javax.swing.JTextField();
        txt_ordenInst = new javax.swing.JTextField();
        txt_prove = new javax.swing.JTextField();
        txt_Ncontac = new javax.swing.JTextField();
        txt_CPU = new javax.swing.JTextField();
        txt_Mran = new javax.swing.JTextField();
        jd_fecha = new com.toedter.calendar.JDateChooser();
        btn_modificar = new javax.swing.JButton();
        conbo_cls = new javax.swing.JComboBox<>();
        btn_eliminar = new javax.swing.JButton();
        btn_gcambios = new javax.swing.JButton();
        conbo_red1 = new javax.swing.JComboBox<>();
        jbl_cpu = new javax.swing.JLabel();
        jbl_registro = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbl_logo1 = new javax.swing.JLabel();
        jbl_tarifa = new javax.swing.JLabel();
        txt_tarifa = new javax.swing.JTextField();
        btn_menu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Mp = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1500, 667));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_dts_equipos_1.setBackground(new java.awt.Color(255, 255, 255));
        tbl_dts_equipos_1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        tbl_dts_equipos_1.setForeground(new java.awt.Color(0, 0, 0));
        tbl_dts_equipos_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_dts_equipos_1.setAlignmentX(10.0F);
        tbl_dts_equipos_1.setGridColor(new java.awt.Color(128, 128, 128));
        tbl_dts_equipos_1.setRowHeight(25);
        tbl_dts_equipos_1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        tbl_dts_equipos_1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tbl_dts_equipos_1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 230, 1480, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pantalla.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 40, -1, 130));

        txt_buscar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txt_buscar.setForeground(new java.awt.Color(0, 0, 0));
        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 270, 30));

        btn_actualizar.setBackground(new java.awt.Color(2, 222, 252));
        btn_actualizar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        btn_actualizar.setText("Actualizar");
        btn_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_actualizarMouseExited(evt);
            }
        });
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 185, 160, -1));

        jbl_clase.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_clase.setForeground(new java.awt.Color(0, 0, 0));
        jbl_clase.setText("Clase:");
        jPanel1.add(jbl_clase, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 59, -1));

        jbl_marca.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_marca.setForeground(new java.awt.Color(0, 0, 0));
        jbl_marca.setText("Marca:");
        jPanel1.add(jbl_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, -1));

        jbl_modelo.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_modelo.setForeground(new java.awt.Color(0, 0, 0));
        jbl_modelo.setText("Modelo:");
        jPanel1.add(jbl_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, -1));

        jbl_codigo.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_codigo.setForeground(new java.awt.Color(0, 0, 0));
        jbl_codigo.setText("Codigo:");
        jPanel1.add(jbl_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, -1));

        jbl_orden.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_orden.setForeground(new java.awt.Color(0, 0, 0));
        jbl_orden.setText("Orden de Instalacion:");
        jPanel1.add(jbl_orden, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, -1));

        jbl_fecha.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_fecha.setForeground(new java.awt.Color(0, 0, 0));
        jbl_fecha.setText("fecha alta:");
        jPanel1.add(jbl_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 100, -1));

        jbl_provedor.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_provedor.setForeground(new java.awt.Color(0, 0, 0));
        jbl_provedor.setText("Proveedor:");
        jPanel1.add(jbl_provedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 100, -1));

        jbl_ncontacto.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_ncontacto.setForeground(new java.awt.Color(0, 0, 0));
        jbl_ncontacto.setText("Nombre Contacto:");
        jPanel1.add(jbl_ncontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 160, -1));

        jbl_memoria.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_memoria.setForeground(new java.awt.Color(0, 0, 0));
        jbl_memoria.setText("Memoria Ram:");
        jPanel1.add(jbl_memoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 120, -1));

        jbl_almacena.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_almacena.setForeground(new java.awt.Color(0, 0, 0));
        jbl_almacena.setText("Almacenamiento:");
        jPanel1.add(jbl_almacena, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 150, -1));

        jbl_tarjeta.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_tarjeta.setForeground(new java.awt.Color(0, 0, 0));
        jbl_tarjeta.setText("Tarjeta de Red:");
        jPanel1.add(jbl_tarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 130, -1));
        jPanel1.add(txt_almacenamiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 180, -1));
        jPanel1.add(txt_marc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 160, -1));
        jPanel1.add(txt_mdlo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, -1));

        txt_codg.setEditable(false);
        jPanel1.add(txt_codg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 160, -1));
        jPanel1.add(txt_ordenInst, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 150, -1));
        jPanel1.add(txt_prove, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 190, -1));
        jPanel1.add(txt_Ncontac, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 190, -1));
        jPanel1.add(txt_CPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 160, -1));
        jPanel1.add(txt_Mran, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 150, -1));

        jd_fecha.setForeground(new java.awt.Color(0, 0, 0));
        jd_fecha.setDateFormatString("dd/MM/yyyy");
        jd_fecha.setMinSelectableDate(null);
        jPanel1.add(jd_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 140, -1));

        btn_modificar.setBackground(new java.awt.Color(2, 222, 252));
        btn_modificar.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 0, 0));
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save-as.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_modificarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_modificarMouseExited(evt);
            }
        });
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 185, -1, -1));

        conbo_cls.setBackground(new java.awt.Color(204, 255, 0));
        conbo_cls.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        conbo_cls.setForeground(new java.awt.Color(0, 0, 0));
        conbo_cls.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Laptop", "Desktop" }));
        conbo_cls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conbo_clsActionPerformed(evt);
            }
        });
        jPanel1.add(conbo_cls, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 170, -1));

        btn_eliminar.setBackground(new java.awt.Color(2, 222, 252));
        btn_eliminar.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_eliminar.setForeground(new java.awt.Color(0, 0, 0));
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btn_eliminar.setText("Eliminar");
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_eliminarMouseExited(evt);
            }
        });
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 185, -1, -1));

        btn_gcambios.setBackground(new java.awt.Color(2, 222, 252));
        btn_gcambios.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        btn_gcambios.setForeground(new java.awt.Color(0, 0, 0));
        btn_gcambios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Save.png"))); // NOI18N
        btn_gcambios.setText("Guardar ");
        btn_gcambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_gcambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_gcambiosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_gcambiosMouseExited(evt);
            }
        });
        btn_gcambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_gcambiosActionPerformed(evt);
            }
        });
        jPanel1.add(btn_gcambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 185, 150, -1));

        conbo_red1.setBackground(new java.awt.Color(204, 255, 0));
        conbo_red1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        conbo_red1.setForeground(new java.awt.Color(0, 0, 0));
        conbo_red1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Ethernet", "Wi-Fi", "Ethernet  y Wi-Fi" }));
        conbo_red1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conbo_red1ActionPerformed(evt);
            }
        });
        jPanel1.add(conbo_red1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 170, -1));

        jbl_cpu.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_cpu.setForeground(new java.awt.Color(0, 0, 0));
        jbl_cpu.setText("Cpu:");
        jPanel1.add(jbl_cpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 37, -1));

        jbl_registro.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        jbl_registro.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jbl_registro, new org.netbeans.lib.awtextra.AbsoluteConstraints(1395, 675, 80, 20));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Total Equipos Registrados:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 675, 230, 20));

        jbl_logo1.setFont(new java.awt.Font("Arial Black", 2, 120)); // NOI18N
        jbl_logo1.setForeground(new java.awt.Color(255, 0, 0));
        jbl_logo1.setText("Bd.Sistema");
        jbl_logo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbl_logo1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbl_logo1MouseExited(evt);
            }
        });
        jPanel1.add(jbl_logo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, 170));

        jbl_tarifa.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jbl_tarifa.setForeground(new java.awt.Color(0, 0, 0));
        jbl_tarifa.setText("Tarifa:");
        jPanel1.add(jbl_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 60, -1));
        jPanel1.add(txt_tarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 130, -1));

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
        jPanel1.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ordenador.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 40, -1, -1));

        btn_buscar.setBackground(new java.awt.Color(255, 255, 51));
        btn_buscar.setFont(new java.awt.Font("Arial Black", 3, 12)); // NOI18N
        btn_buscar.setForeground(new java.awt.Color(0, 0, 0));
        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.setAlignmentY(0.0F);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_buscar.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 110, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Frame 5.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 700));

        Mp.setBackground(new java.awt.Color(0, 255, 0));
        Mp.setOpaque(true);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu-abierto.png"))); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/software.png"))); // NOI18N
        jMenuItem2.setText("Software y configuraciones");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/en-stock.png"))); // NOI18N
        jMenuItem4.setText("Estado Equipos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        Mp.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anadir.png"))); // NOI18N

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ordenador-portatil.png"))); // NOI18N
        jMenuItem1.setText("Nuevo Registro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/software.png"))); // NOI18N
        jMenuItem3.setText("Nueva Software");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        Mp.add(jMenu2);

        setJMenuBar(Mp);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Equipos E = new Equipos();
        E.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Datos_software S = new Datos_software();
        S.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        CargarDatos_tbl1();
        Ocultar();
        CargarLogo();
        ContarRegistros();


    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        // Cerra();
    }//GEN-LAST:event_formWindowClosing

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:

        SeleccionarFila();


    }//GEN-LAST:event_btn_modificarActionPerformed

    private void conbo_clsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbo_clsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conbo_clsActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        SeleccionaF();
        Eliminar();
        CargarDatos_tbl1();


    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_gcambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_gcambiosActionPerformed
        // TODO add your handling code here:
        Modificar();


    }//GEN-LAST:event_btn_gcambiosActionPerformed

    private void conbo_red1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conbo_red1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conbo_red1ActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        // TODO add your handling code here:
        Buscar(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseEntered
        // TODO add your handling code here:
        btn_modificar.setBackground(new Color(0, 255, 205));
    }//GEN-LAST:event_btn_modificarMouseEntered

    private void btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseExited
        // TODO add your handling code here:
        btn_modificar.setBackground(new Color(2, 222, 252));
    }//GEN-LAST:event_btn_modificarMouseExited

    private void btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseEntered
        // TODO add your handling code here:
        btn_eliminar.setBackground(new Color(255, 1, 1));
    }//GEN-LAST:event_btn_eliminarMouseEntered

    private void btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseExited
        // TODO add your handling code here:
        btn_eliminar.setBackground(new Color(2, 222, 252));
    }//GEN-LAST:event_btn_eliminarMouseExited

    private void btn_gcambiosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gcambiosMouseEntered
        // TODO add your handling code here:
        btn_gcambios.setBackground(new Color(0, 255, 205));
    }//GEN-LAST:event_btn_gcambiosMouseEntered

    private void btn_gcambiosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_gcambiosMouseExited
        // TODO add your handling code here:
        btn_gcambios.setBackground(new Color(2, 222, 252));
    }//GEN-LAST:event_btn_gcambiosMouseExited

    private void btn_actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseEntered
        // TODO add your handling code here:
        btn_actualizar.setBackground(new Color(1, 255, 4));
    }//GEN-LAST:event_btn_actualizarMouseEntered

    private void btn_actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_actualizarMouseExited
        // TODO add your handling code here:
        btn_actualizar.setBackground(new Color(2, 222, 252));
    }//GEN-LAST:event_btn_actualizarMouseExited

    private void jbl_logo1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_logo1MouseEntered
        
        jbl_logo1.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_jbl_logo1MouseEntered

    private void jbl_logo1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbl_logo1MouseExited
        // TODO add your handling code here:
        jbl_logo1.setForeground(new Color(255, 0, 0));
    }//GEN-LAST:event_jbl_logo1MouseExited

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();


    }//GEN-LAST:event_btn_menuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Software S = new Software();
        S.setVisible(true);


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(224, 255, 0));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed


    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       Estado_Equipos ES=new Estado_Equipos();
ES.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
                    // UIManager.put("nimbusBlueGrey",new Color(169,176,190));
                    break;
                }

            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Datos_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_equipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_equipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Mp;
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_gcambios;
    private javax.swing.JButton btn_menu;
    public javax.swing.JButton btn_modificar;
    public javax.swing.JComboBox<String> conbo_cls;
    public javax.swing.JComboBox<String> conbo_red1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jbl_almacena;
    public javax.swing.JLabel jbl_clase;
    public javax.swing.JLabel jbl_codigo;
    public javax.swing.JLabel jbl_cpu;
    public javax.swing.JLabel jbl_fecha;
    private javax.swing.JLabel jbl_logo1;
    public javax.swing.JLabel jbl_marca;
    public javax.swing.JLabel jbl_memoria;
    public javax.swing.JLabel jbl_modelo;
    public javax.swing.JLabel jbl_ncontacto;
    public javax.swing.JLabel jbl_orden;
    public javax.swing.JLabel jbl_provedor;
    public javax.swing.JLabel jbl_registro;
    private javax.swing.JLabel jbl_tarifa;
    public javax.swing.JLabel jbl_tarjeta;
    public com.toedter.calendar.JDateChooser jd_fecha;
    private javax.swing.JTable tbl_dts_equipos_1;
    public javax.swing.JTextField txt_CPU;
    public javax.swing.JTextField txt_Mran;
    public javax.swing.JTextField txt_Ncontac;
    public javax.swing.JTextField txt_almacenamiento;
    private javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_codg;
    public javax.swing.JTextField txt_marc;
    public javax.swing.JTextField txt_mdlo;
    public javax.swing.JTextField txt_ordenInst;
    public javax.swing.JTextField txt_prove;
    public javax.swing.JTextField txt_tarifa;
    // End of variables declaration//GEN-END:variables
     private javax.swing.JTextField txtField;

}
