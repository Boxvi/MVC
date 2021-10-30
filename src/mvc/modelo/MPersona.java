/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.modelo;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.postgresql.util.Base64;

/**
 *
 * @author Boriss
 */
public class MPersona extends Persona {

    ConexionPG con = new ConexionPG();

    public MPersona() {
    }

    /*public MPersona(String idpersona, String nombres, String apellidos, Date fechanacimiento, String telefono, String sexo, double sueldo, Integer cupo, Image foto) {
        super(idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto);
    }*/
    public MPersona(String idpersona, String nombres, String apellidos, String fechas, String telefono, String sexo, double sueldo, Integer cupo, Image foto) {
        super(idpersona, nombres, apellidos, fechas, telefono, sexo, sueldo, cupo, foto);

    }

    public boolean Crear() {
        String foto64 = null;
        try {

            BufferedImage img = imgBimage(getFoto());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);

        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sqla = "INSERT INTO public.persona"
                + " (idpersona, nombres, apellidos, fechanacimiento, telefono, sexo, sueldo, cupo, foto)"
                + " VALUES ('" + getIdpersona() + "', '" + getNombres() + "', '" + getApellidos()
                + "',to_date('" + getFechas() + "','yyyy-MM-dd') ,'" + getTelefono() + "', '" + getSexo()
                + "', " + getSueldo() + ", " + getCupo() + ",'" + foto64 + "')";

        return con.accion(sqla);
    }

    //update
    public boolean Modificar(String Identificador) {
        String foto64 = null;
        try {

            BufferedImage img = imgBimage(getFoto());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(img, "PNG", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);

        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
        }

        String sqla = "UPDATE public.persona "
                + "SET nombres='" + getNombres() + "', apellidos='" + getApellidos() + "',fechanacimiento= to_date('" + getFechas()
                + "','yyyy-MM-dd') , telefono='" + getTelefono() + "', sexo='" + getSexo() + "', sueldo=" + getSueldo()
                + ", cupo=" + getCupo() + ", foto= '" + foto64 + "'"
                + "WHERE idpersona= '" + Identificador + "'";
        //System.out.println(sqla);
        return con.accion(sqla);

    }

    //read
    public List<Persona> listaPersonas() {

        String sql = "select idpersona,nombres,apellidos, fechanacimiento,"
                + "COALESCE(substring(cast(age(fechanacimiento) as character varying),1,2),'N/A'),"//en otros gestores no funca
                + "telefono,sexo,sueldo,cupo,foto from public.persona";//mas facil la migracion usarar codigo

        /*String sql = "select idpersona,nombres,apellidos, "
                + "COALESCE(substring(cast(age(fechanacimiento) as character varying),1,2),'N/A'),"
                + "telefono,sexo,sueldo,cupo,foto from public.persona order by idpersona asc";*/
        //String sql = "SELECT * FROM public.persona";
        ResultSet rs = con.consulta(sql);
        List<Persona> lp = new ArrayList<>();
        try {
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setFechanacimiento(rs.getDate("fechanacimiento"));
                per.setEdad(rs.getString(5));
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));

                /*byte[] image = rs.getBytes("foto");
                if (image != null) {
                    per.setFoto(byteArrayToImage(rs.getBytes("foto")));
                }

                //per.setFoto
                /*
                byte[] bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        per.setFoto(obtenerImagen(bf));
                    } catch (IOException ex) {
                        per.setFoto(null);
                        Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    per.setFoto(null);
                }*/
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

        try {

            String sql = "select idpersona,nombres,apellidos, fechanacimiento,"
                    + "COALESCE(substring(cast(age(fechanacimiento) as character varying),1,2),'N/A'),"
                    + "telefono,sexo,sueldo,cupo,foto from public.persona where";
            sql += " idpersona like '%" + cadena + "%' ";
            sql += " OR upper(nombres) like Upper('%" + cadena + "%') ";
            sql += " OR upper(apellidos) like Upper('%" + cadena + "%') ";

            ResultSet rs = con.consulta(sql);
            List<Persona> lp = new ArrayList<>();

            byte[] bf;
            while (rs.next()) {
                Persona per = new Persona();
                per.setIdpersona(rs.getString("idpersona"));
                per.setNombres(rs.getString("nombres"));
                per.setApellidos(rs.getString("apellidos"));
                per.setFechanacimiento(rs.getDate("fechanacimiento"));
                per.setEdad(rs.getString(5));
                per.setTelefono(rs.getString("telefono"));
                per.setSexo(rs.getString("sexo"));
                per.setSueldo(rs.getDouble("sueldo"));
                per.setCupo(rs.getInt("cupo"));

                bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    per.setFoto(obtenerImage(bf)); //System.out.println(ex.getMessage());
                }
                lp.add(per);
            }
            rs.close();
            return lp;
        } catch (SQLException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private Image obtenerImage(byte[] bytes) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bais;
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(source);
        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);
        try {
            return reader.read(0, param);
        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private BufferedImage imgBimage(Image img) {

        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }
        BufferedImage bi = new BufferedImage(
                img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D bGR = bi.createGraphics();
        bGR.drawImage(img, 0, 0, null);
        bGR.dispose();
        return bi;
    }

}
//create
/*public boolean Crear() {
        byte[] imageByte = imageToByteArray(getFoto());
        
        //Files.readAllBytes(new File());

        /*String foto64 = null;
        BufferedImage img = imgBimage(getFoto());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(img, "jpg", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }


        //System.out.println(sqla);
        //return con.accion(sqla, getIdpersona(), getNombres(),getApellidos(),getFechas(),getTelefono(),getSexo(),getSueldo(), getCupo(), imageByte);
        return con.accion(sqla, getIdpersona(), imageByte);
        /*String foto64 = null;
        BufferedImage img = imgBimage(getFoto());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(img, "jpg", bos);
            byte[] imgb = bos.toByteArray();
            foto64 = Base64.encodeBytes(imgb);
        } catch (IOException ex) {
            Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        
          + "', " + getSueldo() + ", " + getCupo() + ",'" + imagenBytes + "')";
        }
        //byte[] imagenBytes = imageToByteArray(getFoto());


    }*/
 /*
    private Image obtenerImagen(byte[] bytes) throws IOException {

        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Iterator it = ImageIO.getImageReadersByFormatName("png");
        ImageReader reader = (ImageReader) it.next();
        Object source = bis;

        ImageInputStream iis = ImageIO.createImageInputStream(source);
        reader.setInput(iis, true);

        ImageReadParam param = reader.getDefaultReadParam();
        param.setSourceSubsampling(1, 1, 0, 0);

        return reader.read(0, param);

    }


                /*byte[] bf = rs.getBytes("foto");
                if (bf != null) {
                    bf = Base64.decode(bf, 0, bf.length);
                    try {
                        per.setFoto(obtenerImagen(bf));
                    } catch (IOException ex) {
                        per.setFoto(null);
                        Logger.getLogger(MPersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    per.setFoto(null);
                }


 */
 
/*private byte[] convertirImagen(Image img) {
        try {
            BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB); // (BufferedImage) imagea;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos); //formar_name al formato que se trasformo
            return baos.toByteArray();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;// no es buena practica
        }
    }

    private Image obtenerImagen(byte[] bytes) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            BufferedImage imageb = ImageIO.read(bis);
            return imageb;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    organiar que el codigo que esta bien 
 */
