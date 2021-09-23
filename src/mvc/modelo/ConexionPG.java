/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Boriss
 */
public class ConexionPG {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    private String cadenaConexion = "jdbc:postgresql://localhost:5432/persona";
    private String usuarioPG = "postgres";
    private String contrasenia = "1";

    public ConexionPG() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con = DriverManager.getConnection(cadenaConexion, usuarioPG, contrasenia);
            //JOptionPane.showMessageDialog(null, "conectamos a la bd");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet consulta(String sqlc) {
        System.out.println(sqlc);

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sqlc);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean accion(String sqla) {
        System.out.println(sqla);

        try {
            st = con.createStatement();
            boolean rb = st.execute(sqla);
            st.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

}

   /* public boolean accion(String sqla, Object... p) {
        /*String sqla = "INSERT INTO public.persona"
                + " (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto)"
                + " VALUES ('" + getIdpersona() + "', '" + getNombres() + "', '" + getApellidos()
                + "',to_date('" + getFechas() + "','yyyy-MM-dd') ,'" + getTelefono() + "', '" + getSexo()
                + "', " + getSueldo() + ", " + getCupo() + ",'" + imageByte. + "')";

        try {
            PreparedStatement ps = getCon().prepareStatement(sqla);
            ps.setString(1, p[0].toString());
            /*ps.setString(2, p[1].toString());
            ps.setString(3, p[2].toString());
            ps.setString(4, p[3].toString());
            ps.setString(5, p[4].toString());
            ps.setString(6, p[5].toString());
           ps.setDouble(7, (double) p[6]);
            ps.setInt(8, (int) p[7]);
            ps.setBytes(2, (byte[]) p[1]);
            
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionPG.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }*/