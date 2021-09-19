/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        vista.setLocationRelativeTo(null);
        cargaLista();
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
        vista.getBtnRefresacar().addActionListener(l-> cargaLista());
        vista.getBtnEditar().addActionListener(l -> cargaDialogo(2));
        vista.getBtnEliminar().addActionListener(l-> eliminarPersona());

        //dialog imagen
        vista.getBtnExaminar().addActionListener(l -> examinarFoto());
        vista.getBtnAceptar().addActionListener(l -> cmPersona());
        vista.getBtnCancelar().addActionListener(l -> cerrarDialogo());
    }

    //BUSCADOR
    private void cargaLista(String cadena) {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPersona().getModel();
        tblModel.setNumRows(0);

        List<Persona> lista = modelo.listaPersonas(cadena);

        lista.stream().forEach(p -> {
            String[] persona = {p.getIdpersona(), p.getNombres(), p.getApellidos(),
                calcularEdad(p.getFechanacimiento().toString()), p.getTelefono(), p.getSexo(),
                p.getSueldo() + "", p.getCupo().toString()};
            tblModel.addRow(persona);
        });
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
                vista.getBtnAceptar().setText("MOFICIAR");

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
            //do {
            MPersona persona = new MPersona();
            persona.setIdpersona(vista.getTxtID().getText());
            persona.setNombres(vista.getTxtNombres().getText());
            persona.setApellidos(vista.getTxtApellidos().getText());
            persona.setTelefono(vista.getTxtTelefono().getText());
            persona.setSexo(vista.getJcbSexo().getSelectedItem().toString());
            persona.setSueldo(Double.parseDouble(vista.getTxtSueldo().getText()));
            persona.setCupo(Integer.parseInt(vista.getTxtCupo().getText()));

            int resultado = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE LOS DATOS INGRESADOS SON CORRECTOS", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resultado == JOptionPane.YES_NO_OPTION) {
                if (persona.Crear()) {
                    JOptionPane.showMessageDialog(vista, "SE LOGRO GRABAR EL DATO EN LA BDD");
                } else {
                    JOptionPane.showMessageDialog(vista, "VALIENDO GASVER X¨D");
                }
            }
        }
        //update
        if (vista.getBtnAceptar().getText().equals("MOFICIAR")) {

            MPersona persona = new MPersona();
            //persona.setIdpersona(vista.getTxtID().getText());
            persona.setNombres(vista.getTxtNombres().getText());
            persona.setApellidos(vista.getTxtApellidos().getText());
            persona.setTelefono(vista.getTxtTelefono().getText());
            persona.setSexo(vista.getJcbSexo().getSelectedItem().toString());
            persona.setSueldo(Double.parseDouble(vista.getTxtSueldo().getText()));
            persona.setCupo(Integer.parseInt(vista.getTxtCupo().getText()));
            int resultado = JOptionPane.showConfirmDialog(vista, "ESTA SEGURO QUE LOS DATOS INGRESADOS SON CORRECTOS", "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resultado == JOptionPane.YES_NO_OPTION) {
                if (persona.Modificar(vista.getTxtID().getText())) {
                    JOptionPane.showMessageDialog(vista, "SE LOGRO GRABAR EL DATO EN LA BDD");
                } else {
                    JOptionPane.showMessageDialog(vista, "VALIENDO GASVER X¨D");
                }
            }
        }
    }

    //read
    private void cargaLista() {
        DefaultTableModel tblModel;
        tblModel = (DefaultTableModel) vista.getTblPersona().getModel();
        tblModel.setNumRows(0);

        List<Persona> lista = modelo.listaPersonas();

        lista.stream().forEach(p -> {
            String[] persona = {p.getIdpersona(), p.getNombres(), p.getApellidos(),
                p.getEdad(), p.getTelefono(), p.getSexo(),
                p.getSueldo() + "", p.getCupo().toString()};
            tblModel.addRow(persona);
        });
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
            vista.getTxtID().setText(tblPersonas.getValueAt(fila, 0).toString());

            vista.getTxtID().setText(tblPersonas.getValueAt(fila, 0).toString());
            vista.getTxtNombres().setText(tblPersonas.getValueAt(fila, 1).toString());
            vista.getTxtApellidos().setText(tblPersonas.getValueAt(fila, 2).toString());
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
*/