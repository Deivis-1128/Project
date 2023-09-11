package Vista;

import Mas_FRM.Igresarpersonas;
import Modelo.Conexion_MySQL;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deivi
 */
public class Datos_personales extends javax.swing.JFrame {

    Conexion_MySQL CM = new Conexion_MySQL();
    Connection com = CM.getConexion();

    /**
     * Creates new form Datos
     */
    public Datos_personales() {
        initComponents();

        setIconImage(new ImageIcon(getClass().getResource("/Img/coding_html_programming.png")).getImage());
        setTitle("!Desarrollador Deivis!");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocation(0, 0);
        CargarDatrosPersonas();
        Calendar fecha = new GregorianCalendar();
        setLocationRelativeTo(this);

        Contar();
    }
//------------------------------------------------------------------------------------------------

    public void Contar() {
        for (int x = 0; x <= tbl_dts_personas.getRowCount(); x++) {
            jbl_contar.setText("" + x);
        }
    }

   public void SeleccionarFila() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/megafono.png"));

        int Fila = tbl_dts_personas.getSelectedRow();
        if (Fila >= 0) {
            txt_nombre.setText((String) tbl_dts_personas.getValueAt(Fila, 0).toString());
            txt_apellido.setText((String) tbl_dts_personas.getValueAt(Fila, 1).toString());
            txt_cedula.setText((String) tbl_dts_personas.getValueAt(Fila, 2).toString());
            txt_telefono_1.setText((String) tbl_dts_personas.getValueAt(Fila, 3).toString());
            txt_telefono_2.setText((String) tbl_dts_personas.getValueAt(Fila, 4).toString());
            txt_correo.setText((String) tbl_dts_personas.getValueAt(Fila, 5).toString());

        } else {
            JOptionPane.showMessageDialog(null, "por favor seleccionar fila", "", 0, icono);
        }
    }

//-----------------------------------------------------------------------------------------

    public DefaultTableModel BuscarNP(String C) {
        String [] Titulos= {"Nombre", "Apellido", "Cedula", "Telefono 1", "Telefon 2", "Correo electronico"};
        String [] Registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM personas WHERE  Cedula LIKE '%" + C + "%' or Nombre LIKE'%"+C+"%' or Cedula Like'%"+C+"%' or Apellido LIKE'%"+C+"%' ";

PreparedStatement pst=null;
ResultSet rs =null;
        try {
           pst=com.prepareStatement(Sql);
rs=pst.executeQuery();
            while (rs.next()) {
                Registros[0] = rs.getString("Nombre");
                Registros[1] = rs.getString("Apellido");
                Registros[2] = rs.getString("Cedula");
                Registros[3] = rs.getString("Telefono_1");
                Registros[4] = rs.getString("Telefono_2");
                Registros[5] = rs.getString("Correo_electronico");

                modelo.addRow(Registros);

            }

            tbl_dts_personas.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
        }
        return null;

    }
//--------------------------------------------------------------------------------------------

    public void BuscarNombre(String V) {
        String[] Titulos = {"Nombre", "Apellido", "Cedula", "Telefono 1", "Telefon 2", "Correo electronico"};
        String[] Registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "SELECT * FROM personas WHERE  Nombre LIKE '%" + V + "%' ";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Nombre");
                Registros[1] = rs.getString("Apellido");
                Registros[2] = rs.getString("Cedula");
                Registros[3] = rs.getString("Telefono_1");
                Registros[4] = rs.getString("Telefono_2");
                Registros[5] = rs.getString("Correo_electronico");

                modelo.addRow(Registros);

            }

            tbl_dts_personas.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
        }

    }

    //---------------------------------------------------------------------------------------------
    public void Modificar() {
        Icon icon = new ImageIcon(getClass().getResource("/Img/Save-as.png"));

        Icon icono = new ImageIcon(getClass().getResource("/Img/iWarning_24107.png"));

        int filaSeleccionada = tbl_dts_personas.getSelectedRow();
        String M = (String) tbl_dts_personas.getValueAt(filaSeleccionada, 2);

        String Sql = "UPDATE personas SET Nombre=?, Apellido=?, Cedula=?, Telefono_1=?, Telefono_2=?, Correo_electronico=? where Cedula=?";

        try {

            PreparedStatement ps = com.prepareStatement(Sql);
            ps.setString(1, txt_nombre.getText());
            ps.setString(2, txt_apellido.getText());
            ps.setString(3, txt_cedula.getText());
            ps.setString(4, txt_telefono_1.getText());
            ps.setString(5, txt_telefono_2.getText());
            ps.setString(6, txt_correo.getText());
            ps.setString(7, M);
            int E = ps.executeUpdate();
            if (E >= 0) {
                JOptionPane.showMessageDialog(null, "Datos Modificados", " ", 0, icon);
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro de Modificacion  ", " ", 0, icono);

        }
    }

    //---------------------------------------------------------------------------------------------
    public void Lipiar() {
        txt_nombre.setText("");
        txt_apellido.setText("");
        txt_cedula.setText("");
        txt_telefono_1.setText("");
        txt_telefono_2.setText("");
        txt_correo.setText("");

    }
    //------------------------------------------------

    public void Eliminar() {
        Icon icono = new ImageIcon(getClass().getResource("/Img/eliminar.png"));
        int filaSeleccionada = tbl_dts_personas.getSelectedRow();

        try {
            String SQL = "DELETE FROM personas WHERE Cedula=" + tbl_dts_personas.getValueAt(filaSeleccionada, 2);
            Statement st = com.createStatement();

            String Botones[] = {"Si", "No"};

            int eleccion = JOptionPane.showOptionDialog(this, "Desas Eliminar Este Registro", "Eliminar", 0, 0, icono, Botones, this);

            if (eleccion == JOptionPane.YES_OPTION) {

                int N = st.executeUpdate(SQL);

                JOptionPane.showMessageDialog(null, "Registro Eliminado", "", 0, icono);
            } else if (eleccion == JOptionPane.NO_OPTION) {
                System.err.println("Se cancelo el cierre");

            }
        } catch (Exception e) {
            System.err.println("e");
            JOptionPane.showMessageDialog(null, "Error de Eliminacion  " + e.getMessage());

        }

    }

//----------------------------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")

    public void CargarDatrosPersonas() {
        tbl_dts_personas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        tbl_dts_personas.getTableHeader().setOpaque(false);
        tbl_dts_personas.getTableHeader().setForeground(new Color(10, 3, 255));
        tbl_dts_personas.getTableHeader().setBackground(new Color(255, 244, 3));

        String[] Titulos = {"Nombre", "Apellido", "Cedula", "Telefono 1", "Telefon 2", "Correo electronico"};
        String[] Registros = new String[6];
        DefaultTableModel modelo = new DefaultTableModel(null, Titulos);
        String Sql = "Select* from personas";

        try {
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(Sql);

            while (rs.next()) {
                Registros[0] = rs.getString("Nombre");
                Registros[1] = rs.getString("Apellido");
                Registros[2] = rs.getString("Cedula");
                Registros[3] = rs.getString("Telefono_1");
                Registros[4] = rs.getString("Telefono_2");
                Registros[5] = rs.getString("Correo_electronico");

                modelo.addRow(Registros);

            }

            tbl_dts_personas.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Al Mostrar Datos " + e.getMessage());
        }

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dts_personas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_Actulizar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_menu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbl_contar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 760));
        setPreferredSize(new java.awt.Dimension(1500, 700));
        setResizable(false);
        setSize(new java.awt.Dimension(1500, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(8, 215, 218));
        jPanel3.setPreferredSize(new java.awt.Dimension(1500, 680));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_dts_personas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_dts_personas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_dts_personas);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 1460, 490));

        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 770, -1, -1));

        jLabel2.setText("jLabel1");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 120, -1, -1));

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
        jLabel17.setText("Nombre:");
        jPanel_1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 70, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel12.setText("Apellido:");
        jPanel_1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 70, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel13.setText("Cedula:");
        jPanel_1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 70, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel16.setText("Telefono 1:");
        jPanel_1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
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
        jPanel_1.add(txt_apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 250, -1));

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
        jPanel_1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 180, -1));

        txt_telefono_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_1ActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_telefono_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 160, -1));
        jPanel_1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 180, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel18.setText("Telefono 2:");
        jPanel_1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 80, -1));

        txt_telefono_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefono_2ActionPerformed(evt);
            }
        });
        jPanel_1.add(txt_telefono_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 160, -1));

        jPanel3.add(jPanel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 880, 140));

        btn_guardar.setBackground(new java.awt.Color(5, 241, 252));
        btn_guardar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
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
        jPanel3.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 115, 140, -1));

        btn_modificar.setBackground(new java.awt.Color(5, 241, 252));
        btn_modificar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
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
        jPanel3.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 115, -1, -1));

        btn_Actulizar.setBackground(new java.awt.Color(5, 241, 252));
        btn_Actulizar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        btn_Actulizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/systemsoftwareupdate.png"))); // NOI18N
        btn_Actulizar.setText("Actualizar");
        btn_Actulizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Actulizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ActulizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ActulizarMouseExited(evt);
            }
        });
        btn_Actulizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActulizarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_Actulizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 115, 150, -1));

        btn_eliminar.setBackground(new java.awt.Color(5, 241, 252));
        btn_eliminar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
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
        jPanel3.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 115, -1, -1));

        btn_menu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
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
        jPanel3.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/p.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 0, -1, 110));

        jLabel5.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel5.setText("Registros:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 650, 90, -1));

        jbl_contar.setFont(new java.awt.Font("Arial Black", 3, 18)); // NOI18N
        jPanel3.add(jbl_contar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 650, 100, 20));

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
        jPanel3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 10, 260, 30));

        jLabel4.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/lupa.png"))); // NOI18N
        jLabel4.setText("Buscar");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 14, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 688));

        jMenuBar1.setBackground(new java.awt.Color(0, 255, 0));
        jMenuBar1.setOpaque(true);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(112, 35));
        jMenuBar1.add(jMenu2);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menu-abierto.png"))); // NOI18N
        jMenu1.setContentAreaFilled(false);

        jMenuItem3.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/planta-de-energia (1).png"))); // NOI18N
        jMenuItem3.setText("Datos Empresa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

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

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anadir.png"))); // NOI18N

        jMenuItem2.setBackground(new java.awt.Color(0, 0, 204));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar-usuario.png"))); // NOI18N
        jMenuItem2.setText("Agregar Nuevo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agregar-usuario.png"))); // NOI18N
        jMenuItem1.setText("Agregar Datos Generales");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Registrar R = new Registrar();
        R.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:

        Datos_empresa E = new Datos_empresa();
        E.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_apellidoActionPerformed

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    private void txt_cedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_cedulaKeyReleased

    private void txt_telefono_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono_1ActionPerformed

    private void txt_telefono_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefono_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefono_2ActionPerformed

    private void jPanel_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel_1MouseEntered

    private void jPanel_1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel_1MouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel_1MouseExited

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        SeleccionarFila();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_ActulizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActulizarActionPerformed
        // TODO add your handling code here:
        CargarDatrosPersonas();

        Lipiar();

    }//GEN-LAST:event_btn_ActulizarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        Modificar();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        //Lipiar();
        Eliminar();

        CargarDatrosPersonas();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_menuActionPerformed
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_menuActionPerformed

    private void btn_menuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseEntered
        btn_menu.setForeground(new Color(224, 255, 0));
    }//GEN-LAST:event_btn_menuMouseEntered

    private void btn_menuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMouseExited
        btn_menu.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_btn_menuMouseExited

    private void btn_eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseEntered
        btn_eliminar.setBackground(new Color(252, 9, 5));

    }//GEN-LAST:event_btn_eliminarMouseEntered

    private void btn_eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMouseExited
        btn_eliminar.setBackground(new Color(5, 241, 252));

    }//GEN-LAST:event_btn_eliminarMouseExited

    private void btn_ActulizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ActulizarMouseEntered
        btn_Actulizar.setBackground(new Color(5, 252, 159));
    }//GEN-LAST:event_btn_ActulizarMouseEntered

    private void btn_ActulizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ActulizarMouseExited
        btn_Actulizar.setBackground(new Color(5, 241, 252));
    }//GEN-LAST:event_btn_ActulizarMouseExited

    private void btn_guardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseEntered
        btn_guardar.setBackground(new Color(5, 252, 159));

    }//GEN-LAST:event_btn_guardarMouseEntered

    private void btn_guardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_guardarMouseExited
        btn_guardar.setBackground(new Color(5, 241, 252));
    }//GEN-LAST:event_btn_guardarMouseExited

    private void btn_modificarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseExited
        btn_modificar.setBackground(new Color(5, 241, 252));
    }//GEN-LAST:event_btn_modificarMouseExited

    private void btn_modificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseEntered
        btn_modificar.setBackground(new Color(5, 252, 159));
    }//GEN-LAST:event_btn_modificarMouseEntered

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Menu_principal M = new Menu_principal();
        M.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed

    private void txt_buscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyPressed
       BuscarNP(txt_buscar.getText());
       
 
    }//GEN-LAST:event_txt_buscarKeyPressed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            Igresarpersonas Prs =new Igresarpersonas();
            Prs.setVisible(true);
        } catch (SQLException ex) {
          
        }
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void btn_Action(java.awt.event.ActionEvent event) {

    }

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
            java.util.logging.Logger.getLogger(Datos_personales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Datos_personales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Datos_personales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Datos_personales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Datos_personales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Actulizar;
    public javax.swing.JButton btn_eliminar;
    public javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_menu;
    public javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel jbl_contar;
    private javax.swing.JTable tbl_dts_personas;
    public javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_cedula;
    public javax.swing.JTextField txt_correo;
    public javax.swing.JTextField txt_nombre;
    public javax.swing.JTextField txt_telefono_1;
    public javax.swing.JTextField txt_telefono_2;
    // End of variables declaration//GEN-END:variables
}
