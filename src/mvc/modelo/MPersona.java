/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import java.awt.Image;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Boriss
 */
public class MPersona extends Persona {

    ConexionPG con = new ConexionPG();

    public MPersona() {
    }

    public MPersona(String idpersona, String nombres, String apellidos, Date fechanacimiento, String telefono, String sexo, double sueldo, Integer cupo, Image foto) {
        super(idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto);
    }

    //create
    public boolean Crear() {
        /*
        con la fecha de nacimient y la foto
        INSERT INTO public.persona(
	idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);
         */
        String sqla = "INSERT INTO public.persona"
                + " (idpersona, nombres, apellidos, telefono, sexo, sueldo, cupo)"
                + " VALUES ('" + getIdpersona() + "', '" + getNombres() + "', '" + getApellidos() + "', '" + getTelefono() + "', '" + getSexo() + "', " + getSueldo() + ", " + getCupo() + ")";
        System.out.println(sqla);
        return con.accion(sqla);

    }

    //update
    public boolean Modificar(String Identificador) {
        /*
        con la fecha de nacmieno y la foto
        UPDATE public.persona
	SET idpersona=?, nombres=?, apellidos=?, fechanacimiento=?, telefono=?, sexo=?, sueldo=?, cupo=?, foto=?
	WHERE <condition>;
         */
        String sqla = "UPDATE public.persona "
                + "SET nombres='" + getNombres() + "', apellidos='" + getApellidos() + "', telefono='" + getTelefono() + "', sexo='" + getSexo() + "', sueldo=" + getSueldo() + ", cupo=" + getCupo() + ""
                + "WHERE idpersona= '" + Identificador + "'";
        System.out.println(sqla);
        return con.accion(sqla);

    }

    //read
    public List<Persona> listaPersonas() {
        String sql = "select idpersona,nombres,apellidos, "
                + "COALESCE(substring(cast(age(fechanacimiento) as character varying),1,2),'N/A'),"
                + "telefono,sexo,sueldo,cupo,foto from public.persona;";
        /*String sql = "SELECT * FROM public.persona";*/
        ResultSet rs = con.consulta(sql);
        List<Persona> lp = new ArrayList<>();
        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setEdad(rs.getString(4));
                //per.setEdad(rs.get);
                /*per.setFechanacimiento(rs.getDate("fechanacimiento"));*/
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));
                per.setFoto((Image) rs.getObject("foto"));
                lp.add(per);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    //delete
    public boolean Borrar(String Identificador) {
        String sqla = "DELETE FROM public.persona WHERE idpersona= '" + Identificador + "'";
        System.out.println(sqla);
        return con.accion(sqla);

    }
    
    //buscador

    public List<Persona> listaPersonas(String cadena) {
        String sql = "SELECT * FROM public.persona where";
        sql += " idpersona like '%" + cadena + "%' ";
        sql += " OR upper(nombres) like Upper('%" + cadena + "%') ";
        sql += " OR upper(apellidos) like Upper('%" + cadena + "%') ";

        ResultSet rs = con.consulta(sql);
        List<Persona> lp = new ArrayList<>();
        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setFechanacimiento(rs.getDate("fechanacimiento"));
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));
                per.setFoto((Image) rs.getObject("foto"));
                lp.add(per);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
