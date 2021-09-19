/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.controlador;

import mvc.modelo.MPersona;
import mvc.vista.VPrincipal;
import mvc.vista.Vista;

/**
 *
 * @author Boxvi
 */
public class CPrincipal {
    private VPrincipal vista;

    public CPrincipal(VPrincipal vista) {
        this.vista = vista;
        vista.setVisible(true);
    }
    
    public void inicaControl(){
        vista.getMantePersonas().addActionListener(l -> mantPersonas());
        vista.getTlbManPersonas().addActionListener(l -> mantPersonas());
    }
    
    
    public void mantPersonas(){
        MPersona m = new MPersona();
        Vista v  = new Vista();
        vista.getPrincipal().add(v);
        CPersona c = new CPersona(m, v);
        c.iniciaControl();
    }
    
}
