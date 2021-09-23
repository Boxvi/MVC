/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.xml.ws.Holder;
import mvc.modelo.MPersona;
import mvc.modelo.Persona;
import mvc.vista.Vista;

/**
 *
 * @author Boriss
 */
public class CPersona {

    private MPersona modelo;
    private Vista vista;

    public CPersona(MPersona modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setVisible(true);
        vista.setTitle("Crud Basico");
        //vista.setLocationRelativeTo(null);
        cargaLista("");
    }

    //BOTONES
    public void iniciaControl() {

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                cargaLista(vista.getTxtBuscador().getText());
            }
        };

        vista.getTxtBuscador().addKeyListener(kl);
        //Crud
        vista.getBtnCrear().addActionListener(l -> cargaDialogo(1));
        vista.getBtnRefresacar().addActionListener(l -> cargaLista(""));
        vista.getBtnEditar().addActionListener(l -> cargaDialogo(2));
        vista.getBtnEliminar().addActionListener(l -> eliminarPersona());

        //dialog imagen
        vista.getBtnExaminar().addActionListener(l -> examinarFoto());
        vista.getBtnAceptar().addActionListener(l -> cmPersona());
        vista.getBtnCancelar().addActionListener(l -> cerrarDialogo());
    }

    //BUSCADOR
    private void cargaLista(String cadena) {

        vista.getTblPersona().setDefaultRenderer(Object.class, new ImagenTabla());
        vista.getTblPersona().setRowHeight(100);
        DefaultTableCellRenderer render = new DefaultTableCellRenderer();

        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPersona().getModel();
        tblModel.setNumRows(0);

        List<Persona> lista = modelo.listaPersonas(cadena);
        int ncols = tblModel.getColumnCount();

        Holder<Integer> i = new Holder<>(0);

        lista.stream().forEach(p -> {
            tblModel.addRow(new Object[ncols]);
            vista.getTblPersona().setValueAt(p.getIdpersona(), i.value, 0);
            vista.getTblPersona().setValueAt(p.getNombres(), i.value, 1);
            vista.getTblPersona().setValueAt(p.getApellidos(), i.value, 2);
            vista.getTblPersona().setValueAt(p.getEdad(), i.value, 3);
            vista.getTblPersona().setValueAt(p.getTelefono(), i.value, 4);
            vista.getTblPersona().setValueAt(p.getSexo(), i.value, 5);
            vista.getTblPersona().setValueAt(p.getSueldo(), i.value, 6);
            vista.getTblPersona().setValueAt(p.getCupo(), i.value, 7);

            Image img = p.getFoto();
            if (img != null) {
                Image nimg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(nimg);
                render.setIcon(icon);
                vista.getTblPersona().setValueAt(new JLabel(icon), i.value, 8);
            } else {
                vista.getTblPersona().setValueAt(null, i.value, 8);
            }

        });

        /*    String[] persona = {p.getIdpersona(), p.getNombres(), p.getApellidos(),
                p.getEdad(), p.getTelefono(), p.getSexo(),
                p.getSueldo() + "", p.getCupo().toString()};
            tblModel.addRow(persona);*/
    }

    //DIALOGO
    private void cargaDialogo(int origen) {
        switch (origen) {
            case 1:
                vista.getDlgPersona().setTitle("CREAR PERSONA");
                vista.getBtnAceptar().setText("CREAR");

                break;
            case 2:
                modificarPersona();
                vista.getDlgPersona().setTitle("EDITAR PERSONA");
                vista.getBtnAceptar().setText("MODIFICAR");

                break;
        }
        vista.getDlgPersona().setSize(590, 550);
        vista.getDlgPersona().setVisible(true);
        vista.getDlgPersona().setLocationRelativeTo(vista);
    }

    //FOTO
    private void examinarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            try {
                Image imagen = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(
                        vista.getLblImageC().getWidth(),
                        vista.getLblImageC().getHeight(),
                        Image.SCALE_DEFAULT);
                Icon icon = new ImageIcon(imagen);
                vista.getLblImageC().setIcon(icon);
                vista.getLblImageC().updateUI();
            } catch (IOException ex) {
                Logger.getLogger(CPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //create ans update
    private void cmPersona() {
        //create
        if (vista.getBtnAceptar().getText().equals("CREAR")) {
            Crear();
        }
        //update
        if (vista.getBtnAceptar().getText().equals("MODIFICAR")) {
            Modificar();

        }
    }

    //Create
    private void Crear() {

        MPersona persona = new MPersona();
        persona.setIdpersona(vista.getTxtID().getText());
        persona.setNombres(vista.getTxtNombres().getText());
        persona.setApellidos(vista.getTxtApellidos().getText());
        persona.setFechas(((JTextField) vista.getJdcFechanacimiento().getDateEditor().getUiComponent()).getText());
        persona.setTelefono(vista.getTxtTelefono().getText());
        persona.setSexo(vista.getJcbSexo().getSelectedItem().toString());
        persona.setSueldo(Double.parseDouble(vista.getTxtSueldo().getText()));
        persona.setCupo(Integer.parseInt(vista.getTxtCupo().getText()));

        ImageIcon ic = (ImageIcon) vista.getLblImageC().getIcon();
        persona.setFoto(ic.getImage());

        int resultado = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE LOS DATOS INGRESADOS SON CORRECTOS", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resultado == JOptionPane.YES_NO_OPTION) {
            if (persona.Crear()) {
                JOptionPane.showMessageDialog(vista, "SE LOGRO GRABAR EL DATO EN LA BDD");
                limpiarCampos();
              //  cargaLista();
            } else {
                JOptionPane.showMessageDialog(vista, "VALIENDO GASVER X¨D");
            }
        }
    }

    //read
    /* private void cargaLista() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPersona().getModel();
        tblModel.setNumRows(0);

        List<Persona> lista = modelo.listaPersonas();

        lista.stream().forEach(p -> {
            String[] persona = {p.getIdpersona(), p.getNombres(), p.getApellidos(),
                p.getEdad(), p.getTelefono(), p.getSexo(),
                p.getSueldo() + "", p.getCupo().toString()};
           // vista.getLblFoto().setIcon(persona[9]);
            tblModel.addRow(persona);
        });
    }*/
    //Update
    private void Modificar() {
        MPersona persona = new MPersona();
        //persona.setIdpersona(vista.getTxtID().getText());
        persona.setNombres(vista.getTxtNombres().getText());
        persona.setApellidos(vista.getTxtApellidos().getText());
        persona.setFechas(((JTextField) vista.getJdcFechanacimiento().getDateEditor().getUiComponent()).getText());
        persona.setTelefono(vista.getTxtTelefono().getText());
        persona.setSexo(vista.getJcbSexo().getSelectedItem().toString());
        persona.setSueldo(Double.parseDouble(vista.getTxtSueldo().getText()));
        persona.setCupo(Integer.parseInt(vista.getTxtCupo().getText()));

        ImageIcon ic = (ImageIcon) vista.getLblImageC().getIcon();
        persona.setFoto(ic.getImage());

        int resultado = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE LOS DATOS INGRESADOS SON CORRECTOS", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resultado == JOptionPane.YES_NO_OPTION) {
            if (persona.Modificar(vista.getTxtID().getText())) {
                JOptionPane.showMessageDialog(vista, "SE LOGRO GRABAR EL DATO EN LA BDD");
                limpiarCampos();
                //cargaLista();
            } else {
                JOptionPane.showMessageDialog(vista, "VALIENDO GASVER X¨D");
            }
        }
    }

    //delete
    //Metodo para eliminar a la persona seleccionada
    private void eliminarPersona() {
        DefaultTableModel tblPersonas = (DefaultTableModel) vista.getTblPersona().getModel();
        int fila = vista.getTblPersona().getSelectedRow();
        if (fila != -1) {
            String idPersona = tblPersonas.getValueAt(fila, 0).toString();
            MPersona persona = new MPersona();
            int resultado = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE DESEA BORRAR A ESTE DATO", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resultado == JOptionPane.YES_NO_OPTION) {
                if (persona.Borrar(idPersona)) {
                    JOptionPane.showMessageDialog(vista, "SE LOGRO ELIMINAR DE LA BDD");
                } else {
                    JOptionPane.showMessageDialog(vista, "VALIENDO GASVER X¨D");
                }
            }
        } else {
            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUNA PERSONA Y LUEGO EN ELIMINAR", "AVISO", 2);
        }
    }

    //seleccionar
    private void modificarPersona() {
        DefaultTableModel tblPersonas = (DefaultTableModel) vista.getTblPersona().getModel();
        int fila = vista.getTblPersona().getSelectedRow();
        if (fila != -1) {
            ///vista.getTxtID().setText(tblPersonas.getValueAt(fila, 0).toString());

            vista.getTxtID().setText(tblPersonas.getValueAt(fila, 0).toString());
            vista.getTxtNombres().setText(tblPersonas.getValueAt(fila, 1).toString());
            vista.getTxtApellidos().setText(tblPersonas.getValueAt(fila, 2).toString());
            //vista.getJdcFechanacimiento().setDateFormatString(tblPersonas.getValueAt(fila, 3).toString());

            // vista.getDtcFechaNacimiento().setDate(Date.valueOf(tblPersonas.getValueAt(fila, 3).toString()));
            vista.getTxtTelefono().setText(tblPersonas.getValueAt(fila, 4).toString());
            vista.getJcbSexo().setSelectedItem(tblPersonas.getValueAt(fila, 5));

            vista.getTxtSueldo().setText(tblPersonas.getValueAt(fila, 6).toString());
            vista.getTxtCupo().setText(tblPersonas.getValueAt(fila, 7).toString());
        } else {
            JOptionPane.showMessageDialog(vista, "DE PRIMERO CLICK ENCIMA EN ALGUNA PERSONA Y LUEGO EN EDITAR", "AVISO", 2);
        }

    }

    //CERRAR
    private void cerrarDialogo() {
        vista.getDlgPersona().dispose();
    }

    //LIMPIAR CAMPOS
    private void limpiarCampos() {
        vista.getTxtID().setText(null);
        vista.getTxtNombres().setText(null);
        vista.getTxtApellidos().setText(null);
        vista.getJdcFechanacimiento().setDate(null);
        vista.getTxtTelefono().setText(null);
        vista.getJcbSexo().setSelectedIndex(0);
        vista.getTxtSueldo().setText(null);
        vista.getTxtCupo().setText(null);
        vista.getLblImageC().setText(null);
    }

}
/*
    private String calcularEdad(String cadena) {
        String[] matriz = cadena.split("-");
        Calendar hoy = Calendar.getInstance();

        int anios = hoy.get(Calendar.YEAR) - Integer.parseInt(matriz[0]);
        int meses = hoy.get(Calendar.MONTH) - Integer.parseInt(matriz[1]);
        int dias = hoy.get(Calendar.DAY_OF_MONTH) - Integer.parseInt(matriz[2]);
        if (meses < 0 || (meses == 0 && dias < 0)) {
            anios = anios - 1;
        }
        return String.valueOf(anios);

    }
calcularEdad(p.getFechanacimiento().toString()),

        //persona.setEdad(fecha_nac);
        //persona.setFechanacimiento(vista.getJdcFechanacimiento().getDateEditor());

        // persona.setFoto(vista.getLblImageC().getBinayStream);
        //persona.setFoto(vista.getLblImageC().S);
 */
