/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc;

import mvc.controlador.CPersona;
import mvc.modelo.MPersona;
import mvc.vista.Vista;

/**
 *
 * @author Boriss
 */
public class ModeloVistaControlador1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        MPersona modelo = new MPersona();
        Vista vista = new Vista();
        
        CPersona control = new CPersona(modelo, vista);
       
        control.iniciaControl();
        
    }
    
}
